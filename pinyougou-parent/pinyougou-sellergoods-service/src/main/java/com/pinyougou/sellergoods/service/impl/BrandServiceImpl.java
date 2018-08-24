package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.result.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbBrandMapper;

import com.pinyougou.sellergoods.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper brandMapper;


    @Override
    public ResultPage<TbBrand> showPageList(int page, int size, TbBrand brand) {
        //interface拦截器
        PageHelper.startPage(page, size);
        TbBrandExample example = new TbBrandExample();
        if (brand != null) {
            TbBrandExample.Criteria criteria = example.createCriteria();
            if (brand.getName() != null && brand.getName().trim().length() > 0) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (brand.getFirstChar() != null && brand.getFirstChar().trim().length() == 1) {
                criteria.andFirstCharEqualTo(brand.getFirstChar());
            }
        }
        example.createCriteria();
        Page<TbBrand> pages = (Page<TbBrand>) brandMapper.selectByExample(example);
        ResultPage<TbBrand> resultPage = new ResultPage(pages.getTotal(), pages.getResult());
        return resultPage;
    }

    @Override
    public void insert(TbBrand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(TbBrand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public TbBrand findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids){
            brandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Map> brandListForTypeTemplate() {
        return brandMapper.brandListForTypeTemplate();
    }


}
