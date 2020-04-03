package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.common.exception.BaseException;
import com.tw.helper.Page;
import com.tw.model.Coupon;
import com.tw.model.Order;
import com.tw.service.CouponService;
import com.tw.service.OrderService;
import com.tw.view.OrderView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aisiA on 2019/5/27.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/order", produces = "application/json; charset=utf-8")
@Api(value = "订单接口", description = "订单接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CouponService couponService;
    @ResponseBody
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")
    public ResponseObject<?> submit(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId,
                                      @ApiParam(required = true, value = "优惠卷") @RequestParam(required = true)Integer couponId,
                                      @ApiParam(required = true, value = "购买方式") @RequestParam(required = true)String buyType,
                                      @ApiParam(required = true, value = "地址ID") @RequestParam(required = true)Integer addressId){
        Coupon coupon=null;
        if(couponId!=null&&couponId!=0) {
            coupon = couponService.selectCouponInfo(couponId);
        }
        try {
            Order order=orderService.submit(userId, coupon, buyType, addressId);
            return AppResultBuilder.success(order);
        } catch (BaseException e) {
            return e.buildResponseObject();
        }



    }


    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")
    public ResponseObject<?> list(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId,
                                    @ApiParam(required = true, value = "订单状态") @RequestParam(required = true)Integer orderStatus,
                                    @ApiParam(required = true, value = "页码") @RequestParam(required = true) Integer pageNo,
                                    @ApiParam(required = true, value = "页面大小") @RequestParam(required = true) Integer pageSize){
        Page<OrderView> order=orderService.selectOrderListByPage(userId, orderStatus, pageNo, pageSize);
        return AppResultBuilder.success(order);

    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ApiOperation(value = "选取购物车商品")
    public ResponseObject<?> detail(@ApiParam(required = true, value = "用户ID") @RequestParam(required = true)String userId,
                                  @ApiParam(required = true, value = "订单ID") @RequestParam(required = true)Integer id){
        OrderView order=orderService.selectOrderDetail(userId,id);
        return AppResultBuilder.success(order);

    }

}
