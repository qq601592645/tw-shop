package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.helper.Page;
import com.tw.model.Category;
import com.tw.model.Goods;
import com.tw.service.ApiCategoryService;
import com.tw.view.CategorySearchView;
import com.tw.view.GoodsSearchView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/4/17.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/catalog", produces = "application/json; charset=utf-8")
@Api(value = "分类接口", description = "分类接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiCatalogController {
    @Autowired
    private ApiCategoryService apiCategoryService;

    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ApiOperation(value = "栏目")

    public ResponseObject<?> serviceGoods(
    ){
        Map<String, Object> resultObj = new HashMap();
        CategorySearchView categorySearchView=new CategorySearchView();
        categorySearchView.setParentId(0);
        List<Category> data=apiCategoryService.selectCategoryList(categorySearchView);
        resultObj.put("categoryList", data);

        if(data.size()>0&&data!=null) {
            if (null != data.get(0).getId()) {
                categorySearchView.setParentId(data.get(0).getId());
                List<Category> currentCategory = apiCategoryService.selectCategoryList(categorySearchView);
                resultObj.put("currentCategory", data.get(0));
                resultObj.put("currentSubCategory",currentCategory);
            }
        }
        return AppResultBuilder.success(resultObj);
    }

    @ResponseBody
    @RequestMapping(value = "/current", method = RequestMethod.POST)
    @ApiOperation(value = "根据分类查询栏目")

    public ResponseObject<?> current( @ApiParam(required = true, value = "ID") @RequestParam(required = true) Integer id
    ){
        Map<String, Object> resultObj = new HashMap();
        CategorySearchView categorySearchView=new CategorySearchView();
        categorySearchView.setParentId(0);
        Category data=apiCategoryService.selectCategory(id);
        resultObj.put("categoryList", data);
                categorySearchView.setParentId(data.getId());
                List<Category> currentCategory = apiCategoryService.selectCategoryList(categorySearchView);
                resultObj.put("currentCategory", data);
                resultObj.put("currentSubCategory",currentCategory);
        return AppResultBuilder.success(resultObj);
    }

}
