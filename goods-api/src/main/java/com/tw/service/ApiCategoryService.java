package com.tw.service;

import com.tw.mapper.CategoryMapper;
import com.tw.model.Category;
import com.tw.model.CategoryCriteria;
import com.tw.view.CategorySearchView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by aisiA on 2019/4/17.
 */
@Component
public class ApiCategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category>selectCategoryList(CategorySearchView categorySearchView){
        CategoryCriteria categoryCriteria=new CategoryCriteria();
        CategoryCriteria.Criteria criteria1=categoryCriteria.createCriteria();
        CategoryCriteria.Criteria criteria2=categoryCriteria.createCriteria();

        if(!StringUtils.isEmpty(categorySearchView.getKey())){
            criteria1.andNameLike("%" + categorySearchView.getKey()+"%");
            criteria2.andKeywordsLike("%" + categorySearchView.getKey() + "%");
        }

        if(!StringUtils.isEmpty(categorySearchView.getParentId())){
            criteria1.andParentIdEqualTo(categorySearchView.getParentId());
            criteria2.andParentIdEqualTo(categorySearchView.getParentId());
        }
        return categoryMapper.selectByExample(categoryCriteria);
    }

    public Category selectCategory(Integer id){
        return categoryMapper.selectByPrimaryKey(id);
    }

}
