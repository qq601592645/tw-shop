package com.tw.service;

import com.tw.common.base.ResultCode;
import com.tw.common.exception.BaseException;
import com.tw.helper.Page;
import com.tw.mapper.*;
import com.tw.model.*;
import com.tw.utils.Utils;
import com.tw.view.AddressView;
import com.tw.view.GoodsView;
import com.tw.view.OrderView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by aisiA on 2019/5/28.
 */
@Component
public class OrderService {
    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserCouponMapper userCouponMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Transactional
    public Order submit(String userId,Coupon coupon,String buyType,Integer addressId) throws BaseException {

        Map<String, Object> resultObj = new HashMap();
        CartCriteria cartCriteria=new CartCriteria();
        List<Cart> list=null;
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
        MultiValueMap<String, Integer> map = new LinkedMultiValueMap<>();
        map.add("addressId",addressId);;
        AddressView addressView= restTemplate.postForObject("http://crm-api/api/address/getAddress", map, AddressView.class);
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

        BigDecimal orderTotalPrice=checkedGoodsAmount.subtract(new BigDecimal(10));
        BigDecimal actualPrice = orderTotalPrice.subtract(couponPrice);
        Order order=new Order();
        order.setOrderSn(Utils.getOrderIdByUUId());
        order.setCouponPrice(couponPrice);
        order.setActualPrice(actualPrice);
        order.setAddress(addressView.getDetailInfo());
        order.setCity(addressView.getCityName());
        order.setAddTime(new Date());
        order.setCountry(addressView.getCountyName());
        order.setFreightPrice(10);
        order.setOrderPrice(orderTotalPrice);
        if(coupon!=null){
            order.setCouponPrice(coupon.getTypeMoney());
            order.setCouponId(coupon.getId());
        }

        order.setOrderStatus(100);
        order.setUserId(userId);
        order.setGoodsPrice(checkedGoodsAmount);
        order.setPayStatus(0);

                        orderMapper.insert(order);
        if(list!=null&&list.size()>0){
            for (Cart cart : list) {
                OrderGoods orderGoods=new OrderGoods();
                orderGoods.setOrderId(order.getOrderSn());
                orderGoods.setGoodsName(cart.getGoodsName());
                orderGoods.setGoodsId(cart.getGoodsId());
                orderGoods.setProductId(cart.getSkuId());
                orderGoods.setNumber(cart.getNumber());
                orderGoodsMapper.insert(orderGoods);
            }
        }
        return order;
    }
public Page<OrderView>selectOrderListByPage(String userId,Integer orderStatus,Integer pageNo,Integer pageSize){
    Page<OrderView> page=new Page<OrderView>(pageNo,pageSize);
    OrderCriteria orderCriteria=new OrderCriteria();
    OrderCriteria.Criteria criteria=orderCriteria.createCriteria();
    criteria.andUserIdEqualTo(userId);
    if(!StringUtils.isEmpty(orderStatus)) {
        criteria.andOrderStatusEqualTo(orderStatus);
    }
    List<Order> order=orderMapper.selectByExampleWithRowbounds(orderCriteria,page.createRowBounds());
    long count=orderMapper.countByExample(orderCriteria);
    List<OrderView>li=new ArrayList<OrderView>();
    if(order!=null) {
        for (Order order1 : order) {
            OrderView orderView = new OrderView();
            orderView.setOrderSn(order1.getOrderSn());
            orderView.setOrderStatus(order1.getOrderStatus());
            OrderGoodsCriteria orderGoodsCriteria=new OrderGoodsCriteria();
            orderGoodsCriteria.or().andOrderIdEqualTo(order1.getOrderSn());
            List<OrderGoods> list=orderGoodsMapper.selectByExample(orderGoodsCriteria);
            orderView.setList(list);
            orderView.setGoodsCount(list.size());
            orderView.setActualPrice(order1.getActualPrice());
            li.add(orderView);
        }

    }
    page.setResultList(li);
    page.setTotalCount(count);
    return page;
}

    public OrderView selectOrderDetail(String userId,Integer id){
        Order order=orderMapper.selectByPrimaryKey(id);
        OrderView orderView = new OrderView();
        if(order!=null) {
                orderView.setOrderSn(order.getOrderSn());
                orderView.setOrderStatus(order.getOrderStatus());
                OrderGoodsCriteria orderGoodsCriteria=new OrderGoodsCriteria();
                orderGoodsCriteria.or().andOrderIdEqualTo(order.getOrderSn());
                List<OrderGoods> list=orderGoodsMapper.selectByExample(orderGoodsCriteria);
                orderView.setList(list);
                orderView.setGoodsCount(list.size());
                orderView.setActualPrice(order.getActualPrice());
            }
        return orderView;
    }


}
