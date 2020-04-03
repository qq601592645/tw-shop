package com.tw.service;

import com.tw.mapper.AttributeMapper;
import com.tw.mapper.GoodsAttributeMapper;
import com.tw.model.*;
import com.tw.view.GoodsAttributeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aisiA on 2019/4/18.
 */
@Component
public class ApiAttributeService {
    @Autowired
    private AttributeMapper attributeMapper;
    @Autowired
    private GoodsAttributeMapper goodsAttributeMapper;

    public List<GoodsAttributeView> selectGoodsAttributeView(String goodsId){

        List<GoodsAttributeView>l=new ArrayList<GoodsAttributeView>();
        GoodsAttributeCriteria goodsAttributeCriteria=new GoodsAttributeCriteria();
        GoodsAttributeCriteria.Criteria criteria1= goodsAttributeCriteria.createCriteria();
        criteria1.andGoodsIdEqualTo(goodsId);
        List<GoodsAttribute> list=goodsAttributeMapper.selectByExample(goodsAttributeCriteria);
        if(list.size()>0&&list!=null){
            for (GoodsAttribute goodsAttribute : list) {
                GoodsAttributeView goodsAttributeView=new GoodsAttributeView();
                Attribute attribute=attributeMapper.selectByPrimaryKey(goodsAttribute.getId());
                if(attribute!=null){
                    goodsAttributeView.setName(attribute.getName());
                    goodsAttributeView.setSort_order(attribute.getSortOrder());
                    goodsAttributeView.setInput_type(attribute.getInputType());
                }
                goodsAttributeView.setId(goodsAttribute.getId());
                goodsAttributeView.setValue(goodsAttribute.getValue());
                l.add(goodsAttributeView);
            }
        }
        return l;

    }
}
