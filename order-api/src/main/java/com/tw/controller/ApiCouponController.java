package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.service.CouponService;
import com.tw.view.CouponView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/5/24.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/coupon", produces = "application/json; charset=utf-8")
@Api(value = "优惠卷接口", description = "优惠卷接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiCouponController {

    @Autowired
    private CouponService couponService;
    @ResponseBody
    @RequestMapping(value = "/listByGoods", method = RequestMethod.POST)
    @ApiOperation(value = "获得购物车列表")

    public ResponseObject<?> index(@ApiParam(required = true, value = "登录凭证") @RequestParam(required = true)String userId

    ){
       List<CouponView> list= couponService.selectCouponViewList(userId);
        return AppResultBuilder.success(list);
    }
}
