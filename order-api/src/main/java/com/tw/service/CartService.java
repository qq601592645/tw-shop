package com.tw.service;

import com.tw.common.base.ResultCode;
import com.tw.common.exception.BaseException;
import com.tw.helper.Page;
import com.tw.mapper.CartMapper;
import com.tw.mapper.OrderGoodsMapper;
import com.tw.mapper.OrderMapper;
import com.tw.model.Cart;
import com.tw.model.CartCriteria;
import com.tw.model.Coupon;
import com.tw.model.Order;
import com.tw.view.AddressView;
import com.tw.view.GoodsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/5/22.
 */
@Component
public class CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private RestTemplate restTemplate;

    public Map<String,Object> selectCartList(String userId){
        Map<String,Object> map=new HashMap<>();
        Page<Cart>page=new Page<>(1,20);
        CartCriteria cartCriteria=new CartCriteria();
        cartCriteria.or().andUserIdEqualTo(userId);
        List<Cart> list=cartMapper.selectByExampleWithRowbounds(cartCriteria, page.createRowBounds());
        BigDecimal goodsAmount=new BigDecimal(0);
        if(list!=null&&list.size()>0){
            for (Cart cart : list) {
                goodsAmount=goodsAmount.add(cart.getLabelPrice().multiply(new BigDecimal(cart.getNumber())));
            }
        }
        long goodsCount=cartMapper.countByExample(cartCriteria);
        CartCriteria cartCriteria1=new CartCriteria();
        cartCriteria1.or().andUserIdEqualTo(userId).andCheckedEqualTo(1);
        long checkedGoodsCount=cartMapper.countByExample(cartCriteria1);
        List<Cart> checkList=cartMapper.selectByExampleWithRowbounds(cartCriteria1, page.createRowBounds());
        BigDecimal checkedGoodsAmount=new BigDecimal(0);
        if(checkList!=null&&checkList.size()>0){
            for (Cart cart : checkList) {
                checkedGoodsAmount=checkedGoodsAmount.add(cart.getLabelPrice().multiply(new BigDecimal(cart.getNumber())));
            }
        }
        map.put("cartList",list);
        Map<String, Object> cartTotal = new HashMap();
        cartTotal.put("goodsCount",goodsCount );
        cartTotal.put("goodsAmount", goodsAmount);
        cartTotal.put("checkedGoodsCount", checkedGoodsCount);
        cartTotal.put("checkedGoodsAmount", checkedGoodsAmount);
        map.put("cartTotal",cartTotal);
        return map;

    }
    public void insertCart(GoodsView goodsView,String userId,Integer number,Integer way) throws BaseException {
        if(goodsView==null){
            throw new BaseException(ResultCode.GOODS_NOT_EXIST);
        }
        CartCriteria cartCriteria=new CartCriteria();
        cartCriteria.or().andUserIdEqualTo(userId).andGoodsIdEqualTo(goodsView.getGoodsId()).andSkuIdEqualTo(goodsView.getSkuId());
        List<Cart>list=cartMapper.selectByExample(cartCriteria);
        if(list.size()>0&&list!=null){
            Cart cart = new Cart();
            cart.setCartId(list.get(0).getCartId());
            cart.setNumber(list.get(0).getNumber()+number);
            cartMapper.updateByPrimaryKeySelective(cart);
        }else {
            Cart cart = new Cart();
            cart.setGoodsName(goodsView.getGoodsName());
            cart.setGoodsId(goodsView.getGoodsId());
            cart.setSkuValueText(goodsView.getSkuValueText());
            cart.setMarketPrice(goodsView.getMarketPrice());
            cart.setSkuId(goodsView.getSkuId());
            cart.setGoodsImgUrl(goodsView.getGoodsImgUrl());
            cart.setUserId(userId);
            cart.setNumber(number);
            cart.setLabelPrice(goodsView.getLabelPrice());
            cart.setChecked(0);
            cart.setWay(way);
            cartMapper.insert(cart);
        }
    }

    public void checkCartList(String userId,String cartIds,Integer isCheck) {
        String[] str = cartIds.split(",");
        if (str.length > 0) {
            for (String s : str) {
                Cart c = new Cart();
                c.setCartId(Integer.valueOf(s));
                c.setChecked(isCheck);
                cartMapper.updateByPrimaryKeySelective(c);
            }
        }
    }
    public void deleteCartList(String cartIds) {
        String[] str = cartIds.split(",");
        if (str.length > 0) {
            for (String s : str) {
                cartMapper.deleteByPrimaryKey(Integer.valueOf(s));
            }
        }
    }
    public void updateCart(Integer cartId,Integer number) {
                Cart c=new Cart();
                c.setCartId(cartId);
                c.setNumber(number);
                cartMapper.updateByPrimaryKeySelective(c);

    }

    public Map<String,Object> checkOut(String userId,Coupon coupon,String buyType) throws BaseException {

        Map<String, Object> resultObj = new HashMap();
        CartCriteria cartCriteria=new CartCriteria();
        List<Cart>list=null;
        if(buyType.equals("cart")) {
            cartCriteria.or().andUserIdEqualTo(userId).andCheckedEqualTo(1);
            ;
            list = cartMapper.selectByExample(cartCriteria);
        }else {
            cartCriteria.or().andUserIdEqualTo(userId).andWayEqualTo(1);
            list = cartMapper.selectByExample(cartCriteria);
        }
        for (Cart cart : list) {
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("skuId",cart.getSkuId());
            map.add("goodsId",cart.getGoodsId());
            GoodsView goodsView= restTemplate.postForObject("http://goods-api/api/goods/selectGoodsDetail", map, GoodsView.class);
            if(cart.getNumber()>goodsView.getStorageNum()){
                throw new BaseException(ResultCode.GOODS_STOCK_NOT_ENOUGH);
            }
        }
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("userId",userId);;
        AddressView addressView= restTemplate.postForObject("http://crm-api/api/address/getAddressList", map, AddressView.class);
        resultObj.put("checkedAddress", addressView);
        BigDecimal checkedGoodsAmount=new BigDecimal(0);
        if(list!=null&&list.size()>0){
            for (Cart cart : list) {
                checkedGoodsAmount=checkedGoodsAmount.add(cart.getLabelPrice().multiply(new BigDecimal(cart.getNumber())));
            }
        }
        BigDecimal couponPrice=new BigDecimal(0);
        if(coupon!=null) {
            if (coupon.getMinGoodsAmount().compareTo(checkedGoodsAmount) > 1) {
                throw new BaseException(ResultCode.COUPON_NOT_ENOUGH);
            }
            couponPrice=couponPrice.add(coupon.getTypeMoney());
        }

        resultObj.put("checkedGoodsList",list);
        resultObj.put("goodsTotalPrice", checkedGoodsAmount);
        BigDecimal orderTotalPrice=checkedGoodsAmount.subtract(new BigDecimal(10));
        resultObj.put("orderTotalPrice",orderTotalPrice);
        BigDecimal actualPrice = orderTotalPrice.subtract(couponPrice);
        resultObj.put("actualPrice",actualPrice);
        resultObj.put("couponPrice",couponPrice);
        resultObj.put("freightPrice",10);

        return resultObj;
    }
}
