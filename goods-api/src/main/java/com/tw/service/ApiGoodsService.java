package com.tw.service;

import com.tw.helper.Page;
import com.tw.mapper.GoodsMapper;
import com.tw.model.Goods;
import com.tw.model.GoodsCriteria;
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
public class ApiGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    //根据查询条件分页
    public Page<Goods> selectGoodsListByPage(GoodsSearchView searchView){
        Page page=new Page(searchView.getPageNo(),searchView.getPageSize());
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        GoodsCriteria.Criteria criteria1=goodsCriteria.createCriteria();
        GoodsCriteria.Criteria criteria2=goodsCriteria.createCriteria();
        GoodsCriteria.Criteria criteria3=goodsCriteria.createCriteria();
        if(!StringUtils.isEmpty(searchView.getKey())){
            criteria1.andGoodsNameLike("%"+searchView.getKey()+"%");
            criteria2.andGoodsCodeLike("%" + searchView.getKey() + "%");
            criteria3.andGoodsIdLike("%" + searchView.getKey() + "%");
        }
        if(!StringUtils.isEmpty(searchView.getHot())){
            criteria1.andHotStatusEqualTo(searchView.getHot());
            criteria2.andHotStatusEqualTo(searchView.getHot());
            criteria3.andHotStatusEqualTo(searchView.getHot());
        }
        List<Goods>list=goodsMapper.selectByExampleWithRowbounds(goodsCriteria,page.createRowBounds());
        long count=goodsMapper.countByExample(goodsCriteria);
        page.setResultList(list);
        page.setTotalCount(count);
        return page;
    }

    //根据查询条件总数
    public long countGoodsListBySearch(GoodsSearchView searchView){
        GoodsCriteria goodsCriteria=new GoodsCriteria();
        GoodsCriteria.Criteria criteria1=goodsCriteria.createCriteria();
        GoodsCriteria.Criteria criteria2=goodsCriteria.createCriteria();
        GoodsCriteria.Criteria criteria3=goodsCriteria.createCriteria();
        if(!StringUtils.isEmpty(searchView.getKey())){
            criteria1.andGoodsNameLike("%"+searchView.getKey()+"%");
            criteria2.andGoodsCodeLike("%" + searchView.getKey() + "%");
            criteria3.andGoodsIdLike("%" + searchView.getKey() + "%");
        }
        if(!StringUtils.isEmpty(searchView.getHot())){
            criteria1.andHotStatusEqualTo(searchView.getHot());
            criteria2.andHotStatusEqualTo(searchView.getHot());
            criteria3.andHotStatusEqualTo(searchView.getHot());
        }
        if(!StringUtils.isEmpty(searchView.getOnlineStatus())){
            criteria1.andOnlineStatusEqualTo(searchView.getOnlineStatus());
            criteria2.andOnlineStatusEqualTo(searchView.getOnlineStatus());
            criteria3.andOnlineStatusEqualTo(searchView.getOnlineStatus());
        }
        long count=goodsMapper.countByExample(goodsCriteria);
        return count;
    }

    //根据商品Id查询详情
    public Goods selectGoodsById(String id ){
        return goodsMapper.selectByPrimaryKey(id);
    }
}
