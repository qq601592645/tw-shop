package com.tw.service;

import com.google.common.collect.Sets;
import com.tw.mapper.GoodsSkuComposeMapper;
import com.tw.mapper.GoodsSkuKeyMapper;
import com.tw.mapper.GoodsSkuMapper;
import com.tw.mapper.GoodsSkuValueMapper;
import com.tw.model.*;
import com.tw.view.SkuComposeView;
import com.tw.view.SkuView;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by aisiA on 2019/4/18.
 */
@Component
public class ApiGoodsSkuService {
    @Autowired
    private GoodsSkuMapper goodsSkuMapper;
    @Autowired
    private GoodsSkuComposeMapper goodsSkuComposeMapper;
    @Autowired
    private GoodsSkuKeyMapper goodsSkuKeyMapper;
    @Autowired
    private GoodsSkuValueMapper goodsSkuValueMapper;

    public List<SkuView> selectSkuViewList(String goodsId){
        GoodsSkuKeyCriteria goodsSkuKeyCriteria=new GoodsSkuKeyCriteria();
        goodsSkuKeyCriteria.or().andGoodsIdEqualTo(goodsId);
        List<GoodsSkuKey> list=goodsSkuKeyMapper.selectByExample(goodsSkuKeyCriteria);
        List<SkuView>skuViewList=new ArrayList<SkuView>();
        if(list.size()>0&&list!=null){
            for (GoodsSkuKey goodsSkuKey : list) {
                SkuView skuView=new SkuView();
                skuView.setKeyId(goodsSkuKey.getKeyId());
                skuView.setKeyName(goodsSkuKey.getKeyName());
                GoodsSkuValueCriteria goodsSkuValueCriteria=new GoodsSkuValueCriteria();
                goodsSkuValueCriteria.or().andKeyIdEqualTo(goodsSkuKey.getKeyId());
                List<GoodsSkuValue>li=goodsSkuValueMapper.selectByExample(goodsSkuValueCriteria);
                List<GoodsSkuValue> skuValuelist=new ArrayList<GoodsSkuValue>();
                for (GoodsSkuValue goodsSkuValue : li) {
                    GoodsSkuComposeCriteria goodsSkuComposeCriteria=new GoodsSkuComposeCriteria();
                    goodsSkuComposeCriteria.or().andSkuKeyIdEqualTo(goodsSkuKey.getKeyId()).andSkuValueIdEqualTo(goodsSkuValue.getValueId());
                    List<GoodsSkuCompose> l=goodsSkuComposeMapper.selectByExample(goodsSkuComposeCriteria);
                    if(l.size()>0&&l!=null){
                        skuValuelist.add(goodsSkuValue);
                    }
                }
                skuView.setList(skuValuelist);
                skuViewList.add(skuView);
            }
        }
        return skuViewList;
    }

    public List<String> selectGoodsSkuComposeList(String goodsId,List<SkuComposeView> skuComposeViewList){
        String skuStr="";
//        for (SkuComposeView skuComposeView : skuComposeViewList) {
//            skuStr=skuStr+(skuComposeView.getSkuValueId());
//        }
        for (int i = 0; i < skuComposeViewList.size(); i++) {
            skuStr=skuStr+skuComposeViewList.get(i).getSkuValueId();
            if((i + 1) != skuComposeViewList.size()) {
                skuStr=skuStr+(",");
            }
        }
        List<String> li=new ArrayList<String>();
        //List<List<ArrayList<String>>> resultList = new ArrayList<>();
        GoodsSkuCriteria goodsSkuCriteria=new GoodsSkuCriteria();
        GoodsSkuCriteria.Criteria criteria=goodsSkuCriteria.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        List<GoodsSku> list=goodsSkuMapper.selectByExample(goodsSkuCriteria);
        if(list!=null&&list.size()>0) {
            for (GoodsSku goodsSku : list) {
                GoodsSkuComposeCriteria goodsSkuComposeCriteria = new GoodsSkuComposeCriteria();
                GoodsSkuComposeCriteria.Criteria criteria1 = goodsSkuComposeCriteria.createCriteria();
                criteria1.andGoodsIdEqualTo(goodsId).andSkuIdEqualTo(goodsSku.getSkuId());
                List<GoodsSkuCompose> l = goodsSkuComposeMapper.selectByExample(goodsSkuComposeCriteria);
                ArrayList<String> child = new ArrayList<String>();
                List<ArrayList<String>> result = new ArrayList<>();
                ArrayList<String> lists = new ArrayList<>();
                if (l != null && l.size() > 0) {
                    for (GoodsSkuCompose goodsSkuCompose : l) {
                        lists.add(goodsSkuCompose.getSkuValueId());
                    }
                    getSubList(lists, 0, child, result);
                    result.add(lists);
                }

                for (ArrayList<String> strings : result) {
                    String str="";
                    for (int i = 0; i < strings.size(); i++) {
                        str=str+strings.get(i);
                        if((i + 1) != strings.size()) {
                            str=str+(",");
                        }
                    }
                    if(str.contains(skuStr)&&!str.equals(skuStr)){
                        if(!li.contains(str)) {
                            li.add(str);
                        }
                    }
                }
            }
        }
        return li;
    }
    public void getSubList(List<String> resourses, int nonius, ArrayList<String> childs, List<ArrayList<String>> results) {
        for (int i = nonius; i < resourses.size(); i++) {
            // 去掉自己本身
            if (childs.size() < resourses.size() - 1) {
                // 将数据源中的每个元素分别拿出来
                childs.add(resourses.get(i));
                // 将每个元素的集合作为元素放入结果集合
                results.add(new ArrayList<String>(childs));
                // 递归向后移动
                getSubList(resourses, i + 1, childs, results);
                // 移除
                childs.remove(childs.size() - 1);
            }
        }
    }

    public List<GoodsSku> selectGoodsSkuList(String goodsId){
        GoodsSkuCriteria goodsSkuCriteria=new GoodsSkuCriteria();
        GoodsSkuCriteria.Criteria criteria=goodsSkuCriteria.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        List<GoodsSku> l= goodsSkuMapper.selectByExample(goodsSkuCriteria);
        return l;
    }
    public GoodsSku selectGoodsSkuById(String skuId){
        GoodsSku l= goodsSkuMapper.selectByPrimaryKey(skuId);
        return l;
    }
}
