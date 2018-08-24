package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbItemCatMapper;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbItemCatExample;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper itemCatMapper;

    @Override
    public List<TbItemCat> findByParentId(Long id) {
        TbItemCatExample example = new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(id);
        return itemCatMapper.selectByExample(example);
    }

    @Override
    public TbItemCat findByid(Long id) {
        return itemCatMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(TbItemCat itemCat) {
        itemCatMapper.insert(itemCat);
    }

    @Override
    public void update(TbItemCat itemCat) {
        itemCatMapper.updateByPrimaryKey(itemCat);
    }
}
