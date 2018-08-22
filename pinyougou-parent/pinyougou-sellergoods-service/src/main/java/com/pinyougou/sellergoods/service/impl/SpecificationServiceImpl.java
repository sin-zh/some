package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;


import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojovo.SpecificationWithSpecificationOptions;
import com.pinyougou.result.ResultPage;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationExample.Criteria;

/**
 * 服务实现层
 *
 * @author Administrator
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;

    @Override
    public ResultPage<TbSpecification> showPageList(TbSpecification specification, int page, int size) {
        PageHelper.startPage(page, size);
        TbSpecificationExample example = new TbSpecificationExample();
        if (specification != null) {
            if (specification.getSpecName() != null && specification.getSpecName().trim().length() > 0) {
                Criteria criteria = example.createCriteria();
                criteria.andSpecNameLike("%" + specification.getSpecName() + "%");
            }
        }
        Page<TbSpecification> pages = (Page<TbSpecification>) specificationMapper.selectByExample(example);
        return new ResultPage<>(pages.getTotal(), pages.getResult());
    }

    /**
     * 保存Specification和SpecificationOptions
     * @param specificationWithSpecificationOptions
     */
    @Override
    public void insertSpecificationWithSpecificationOptions(SpecificationWithSpecificationOptions specificationWithSpecificationOptions) {
        TbSpecification specification = specificationWithSpecificationOptions.getSpecification();
        specificationMapper.insert(specification);
        for (TbSpecificationOption specificationOption:specificationWithSpecificationOptions.getSpecificationOptions()){
            specificationOption.setSpecId(specificationWithSpecificationOptions.getSpecification().getId());
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public SpecificationWithSpecificationOptions findSpecificationWithSpecificationOptionsByid(Long specificationId) {
        TbSpecification specification = specificationMapper.selectByPrimaryKey(specificationId);
        TbSpecificationOptionExample specificationOptionExample=new TbSpecificationOptionExample();
        specificationOptionExample.createCriteria().andSpecIdEqualTo(specificationId);
        List<TbSpecificationOption> specificationOptions = specificationOptionMapper.selectByExample(specificationOptionExample);
        return new SpecificationWithSpecificationOptions(specification,specificationOptions);
    }

    @Override
    public void updateSpecificationWithSpecificationOptions(SpecificationWithSpecificationOptions specificationWithSpecificationOptions) {
        TbSpecification specification = specificationWithSpecificationOptions.getSpecification();
        specificationMapper.updateByPrimaryKey(specification);
        //删除原options
        TbSpecificationOptionExample specificationOptionExample=new TbSpecificationOptionExample();
        specificationOptionExample.createCriteria().andSpecIdEqualTo(specification.getId());
        specificationOptionMapper.deleteByExample(specificationOptionExample);
        //新增
        for (TbSpecificationOption specificationOption:specificationWithSpecificationOptions.getSpecificationOptions()){
            specificationOption.setSpecId(specification.getId());
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public void deleteSpecificationWithSpecificationOptionsByids(Long[] ids) {
        for (Long id:ids){
            specificationMapper.deleteByPrimaryKey(id);
            TbSpecificationOptionExample specificationOptionExample=new TbSpecificationOptionExample();
            specificationOptionExample.createCriteria().andSpecIdEqualTo(id);
            specificationOptionMapper.deleteByExample(specificationOptionExample);
        }
    }

    @Override
    public List<Map> specificationListForTypeTemplate() {
        return specificationMapper.specificationListForTypeTemplate();
    }
}
