package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.helper.Page;
import com.tw.model.Brand;
import com.tw.model.Goods;
import com.tw.service.ApiBrandService;
import com.tw.service.ApiGoodsService;
import com.tw.view.BrandSearchView;
import com.tw.view.GoodsSearchView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tw on 2019/4/8.
 * 首页展示
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/index", produces = "application/json; charset=utf-8")
@Api(value = "首页接口", description = "前端首页接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiIndexController {
    private final static Logger logger = LoggerFactory.getLogger(ApiIndexController.class);

    @Autowired
    private ApiGoodsService apiGoodsService;

    @Autowired
    protected ApiBrandService apiBrandService;

    @ResponseBody
    @RequestMapping(value = "/serviceGoods", method = RequestMethod.POST)
    @ApiOperation(value = "服务性商品信息")

    public ResponseObject<?> serviceGoods(   @ApiParam(required = true, value = "页码") @RequestParam(required = true) Integer pageNo,
                                      @ApiParam(required = true, value = "页面大小") @RequestParam(required = true) Integer pageSize



    ){
        GoodsSearchView goodsSearchView=new GoodsSearchView();
        goodsSearchView.setPageNo(pageNo);
        goodsSearchView.setPageSize(pageSize);
        Page<Goods> page=apiGoodsService.selectGoodsListByPage(goodsSearchView);
        return AppResultBuilder.success(page);
    }

    @ResponseBody
    @RequestMapping(value = "/brand", method = RequestMethod.POST)
    @ApiOperation(value = "制造商")

    public ResponseObject<?> brand(



    ){
        BrandSearchView brandSearchView=new BrandSearchView();
        brandSearchView.setPageNo(1);
        brandSearchView.setPageSize(10);
        Page<Brand> page=apiBrandService.selectBrandListByPage(brandSearchView);
        return AppResultBuilder.success(page);
    }

    @ResponseBody
    @RequestMapping(value = "/newGoods", method = RequestMethod.POST)
    @ApiOperation(value = "热门商品信息")

    public ResponseObject<?> newGoods(

    ){
        GoodsSearchView goodsSearchView=new GoodsSearchView();
        goodsSearchView.setPageNo(1);
        goodsSearchView.setPageSize(10);
        goodsSearchView.setHot("1");
        Page<Goods> page=apiGoodsService.selectGoodsListByPage(goodsSearchView);
        return AppResultBuilder.success(page);
    }

}
