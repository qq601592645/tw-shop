package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.common.exception.BaseException;
import com.tw.helper.Page;
import com.tw.model.Cart;
import com.tw.model.Coupon;
import com.tw.service.CartService;
import com.tw.service.CouponService;
import com.tw.view.GoodsView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/5/13.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/cart", produces = "application/json; charset=utf-8")
@Api(value = "购物车接口", description = "购物车接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiCartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CouponService couponService;


    @ResponseBody
         @RequestMapping(value = "/index", method = RequestMethod.POST)
         @ApiOperation(value = "获得购物车列表")

         public ResponseObject<?> index(@ApiParam(required = true, value = "登录凭证") @RequestParam(required = true)String userId

    ){
        Map<String,Object> list=cartService.selectCartList(userId);
        return AppResultBuilder.success(list);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation(value = "获得购物车列表")

    public ResponseObject<?> add(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId
                                 ,@ApiParam(required = true, value = "skuId") @RequestParam(required = true)String productId,
                                 @ApiParam(required = true, value = "数量") @RequestParam(required = true)Integer number,
                                 @ApiParam(required = true, value = "商品ID") @RequestParam(required = true)String goodsId,
                                 @ApiParam(required = true, value = "添加方式") @RequestParam(required = true)Integer way

    ){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("skuId",productId);
        map.add("goodsId",goodsId);
       GoodsView goodsView= restTemplate.postForObject("http://goods-api/api/goods/selectGoodsDetail", map, GoodsView.class);
        try {
            cartService.insertCart(goodsView, userId,number,way);

        } catch (BaseException e) {
            return e.buildResponseObject();
        }
        Map<String,Object> list=cartService.selectCartList(userId);
        return AppResultBuilder.success(list);
    }


    @ResponseBody
    @RequestMapping(value = "/checked", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")

    public ResponseObject<?> checked(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId
            ,@ApiParam(required = true, value = "skuId") @RequestParam(required = true)String cartIds,
                                 @ApiParam(required = true, value = "数量") @RequestParam(required = true)Integer isChecked

    ){
        cartService.checkCartList(userId, cartIds, isChecked);
        Map<String,Object> map=cartService.selectCartList(userId);
        return AppResultBuilder.success(map);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")

    public ResponseObject<?> update(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId
            ,@ApiParam(required = true, value = "skuId") @RequestParam(required = true)Integer cartId,
                                     @ApiParam(required = true, value = "数量") @RequestParam(required = true)Integer number

    ){
        cartService.updateCart(cartId, number);
        //Map<String,Object> map=cartService.selectCartList(userId);
        return AppResultBuilder.successNoData();
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")

    public ResponseObject<?> delete(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId
            ,@ApiParam(required = true, value = "skuId") @RequestParam(required = true)String cartIds

    ){
        cartService.deleteCartList(cartIds);
        Map<String,Object> map=cartService.selectCartList(userId);
        return AppResultBuilder.success(map);
    }

    @ResponseBody
    @RequestMapping(value = "/goodscount", method = RequestMethod.POST)
         @ApiOperation(value = "选取购物车商品")

         public ResponseObject<?> goodscount(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId

    ){
        Map<String,Object> map=cartService.selectCartList(userId);
        return AppResultBuilder.success(map);
    }

    @ResponseBody
    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")

    public ResponseObject<?> checkout(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId,
                                      @ApiParam(required = true, value = "优惠卷") @RequestParam(required = true)Integer couponId,
                                      @ApiParam(required = true, value = "购买方式") @RequestParam(required = true)String buyType

    ){
        Map<String,Object>map= null;
        try {
            Coupon coupon=null;
            if(couponId!=null&&couponId!=0) {
                 coupon = couponService.selectCouponInfo(couponId);
            }
            map = cartService.checkOut(userId,coupon,buyType);
        } catch (BaseException e) {
            return e.buildResponseObject();
        }
        return AppResultBuilder.success(map);
    }
}
