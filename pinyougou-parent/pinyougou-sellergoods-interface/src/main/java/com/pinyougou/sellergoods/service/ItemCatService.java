package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.pojo.TbSeller;

import java.util.List;

public interface ItemCatService {

    List<TbItemCat> findByParentId(Long id);

    TbItemCat findByid(Long id);

    void insert(TbItemCat itemCat);

    void update(TbItemCat itemCat);
}
