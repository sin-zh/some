package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbTypeTemplateMapper;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.pojo.TbTypeTemplateExample;
import com.pinyougou.result.ResultPage;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    @Override
    public ResultPage<TbTypeTemplate> showPageList(TbTypeTemplate typeTemplate, int page, int size) {
        PageHelper.startPage(page, size);
        TbTypeTemplateExample typeTemplateExample = new TbTypeTemplateExample();
        if (typeTemplate != null && typeTemplate.getName() != null && typeTemplate.getName().trim().length() > 0) {
            typeTemplateExample.createCriteria().andNameLike("%" + typeTemplate.getName() + "%");

        }
        Page<TbTypeTemplate> pages = (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(typeTemplateExample);
        return new ResultPage<TbTypeTemplate>(pages.getTotal(), pages.getResult());
    }

    @Override
    public TbTypeTemplate findByid(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(TbTypeTemplate typeTemplate ) {
        if (typeTemplate.getId()==null){
            typeTemplateMapper.insert(typeTemplate);
        }else {
            typeTemplateMapper.updateByPrimaryKey(typeTemplate);
        }
    }
}
