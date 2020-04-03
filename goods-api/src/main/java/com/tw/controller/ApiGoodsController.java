package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.helper.Page;
import com.tw.model.Goods;
import com.tw.model.GoodsGallery;
import com.tw.model.GoodsSku;
import com.tw.model.GoodsSkuCompose;
import com.tw.service.ApiAttributeService;
import com.tw.service.ApiGoodsGalleryService;
import com.tw.service.ApiGoodsService;
import com.tw.service.ApiGoodsSkuService;
import com.tw.view.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/4/17.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/goods", produces = "application/json; charset=utf-8")
@Api(value = "分类接口", description = "分类接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiGoodsController {

    private final static Logger logger = LoggerFactory.getLogger(ApiGoodsController.class);

    @Autowired
    private ApiGoodsService apiGoodsService;

    @Autowired
    private ApiGoodsGalleryService apiGoodsGalleryService;
    @Autowired
    private ApiAttributeService apiAttributeService;
    @Autowired
    private ApiGoodsSkuService apiGoodsSkuService;

    @ResponseBody
    @RequestMapping(value = "/count", method = RequestMethod.POST)
    @ApiOperation(value = "总数")

    public ResponseObject<?> count(
    ){
        GoodsSearchView goodsSearchView=new GoodsSearchView();
        goodsSearchView.setOnlineStatus("1");
       long count=apiGoodsService.countGoodsListBySearch(goodsSearchView);
        Map<String, Object> resultObj = new HashMap();
        resultObj.put("goodsCount", count);
        return AppResultBuilder.success(resultObj);
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ApiOperation(value = "详情")

    public ResponseObject<?> detail( @ApiParam(required = true, value = "ID") @RequestParam(required = true) String id
    ){
        Goods info=apiGoodsService.selectGoodsById(id);
        List<GoodsGallery> gallery=apiGoodsGalleryService.selectGoodsGalleryList(id);
        List<GoodsAttributeView> attribute=apiAttributeService.selectGoodsAttributeView(id);
        List<SkuView> specificationList=apiGoodsSkuService.selectSkuViewList(id);
        List<GoodsSku> productList=apiGoodsSkuService.selectGoodsSkuList(id);
        Map<String, Object> resultObj = new HashMap();
        resultObj.put("info", info);
        resultObj.put("gallery", gallery);
        resultObj.put("attribute", attribute);
        resultObj.put("specificationList", specificationList);
        resultObj.put("productList", productList);
        return AppResultBuilder.success(resultObj);
    }


    @ResponseBody
    @RequestMapping(value = "/selectGoodsDetail", method = RequestMethod.POST)
    @ApiOperation(value = "根据sku查询商品信息")

    public  GoodsView selectGoodsDetail( @ApiParam(required = true, value = "goodsId") @RequestParam(required = true) String goodsId,
                                                @ApiParam(required = true, value = "skuId") @RequestParam(required = true) String skuId
    ){
        GoodsView goodsView=new GoodsView();
        Goods info=apiGoodsService.selectGoodsById(goodsId);
        GoodsSku productInfo=apiGoodsSkuService.selectGoodsSkuById(skuId);
    if(info!=null){
        goodsView.setGoodsCode(info.getGoodsCode());
        goodsView.setGoodsId(info.getGoodsId());
        goodsView.setGoodsImgUrl(info.getGoodsImg());
        goodsView.setGoodsName(info.getGoodsName());
        goodsView.setLabelPrice(info.getLabelPrice());
        goodsView.setMarketPrice(info.getMarketPrice());
        goodsView.setStorageNum(info.getStorageNum());
    }
        if(productInfo!=null){
            goodsView.setSkuId(productInfo.getSkuId());
            goodsView.setSkuValueText(productInfo.getSkuName());
        }
        return goodsView;
    }




}
