package com.tw.service;

import com.tw.helper.Page;
import com.tw.mapper.BrandMapper;
import com.tw.model.Brand;
import com.tw.model.BrandCriteria;
import com.tw.view.BrandSearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by aisiA on 2019/4/16.
 * 品牌服务类
 */
@Component
public class ApiBrandService {

    @Autowired
    private BrandMapper brandMapper;

    //根据查询条件分页
    public Page<Brand> selectBrandListByPage(BrandSearchView brandSearchView){
        Page page=new Page(brandSearchView.getPageNo(),brandSearchView.getPageSize());
        BrandCriteria brandCriteria=new BrandCriteria();
        BrandCriteria.Criteria criteria1=brandCriteria.createCriteria();
        if(!StringUtils.isEmpty(brandSearchView.getKey())){
            criteria1.andNameLike("%" + brandSearchView.getKey() + "%");
        }
        if(!StringUtils.isEmpty(brandSearchView.getKey())){
            criteria1.andNameLike("%" + brandSearchView.getKey() + "%");
        }
        List<Brand> list=brandMapper.selectByExampleWithRowbounds(brandCriteria,page.createRowBounds());
        long count=brandMapper.countByExample(brandCriteria);
        page.setResultList(list);
        page.setTotalCount(count);
        return page;
    }
}
