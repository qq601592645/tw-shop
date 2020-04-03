package com.tw.service;

import com.tw.helper.Page;
import com.tw.mapper.GoodsGalleryMapper;
import com.tw.mapper.GoodsMapper;
import com.tw.model.Goods;
import com.tw.model.GoodsCriteria;
import com.tw.model.GoodsGallery;
import com.tw.model.GoodsGalleryCriteria;
import com.tw.view.GoodsSearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by aisiA on 2019/4/8.
 * 商品服务类
 */
@Component
public class ApiGoodsGalleryService {
    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;

    //根据查询条件分页
    public List<GoodsGallery> selectGoodsGalleryList(String goodsId){
        GoodsGalleryCriteria goodsGalleryCriteria=new GoodsGalleryCriteria();
        goodsGalleryCriteria.or().andGoodsIdEqualTo(goodsId);
        return goodsGalleryMapper.selectByExample(goodsGalleryCriteria);
    }


}
