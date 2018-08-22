package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.result.ResultPage;

import java.util.List;
import java.util.Map;

public interface BrandService {

     ResultPage<TbBrand> showPageList(int page,int size,TbBrand brand);

    void insert(TbBrand brand);
    void update(TbBrand brand);
    TbBrand findById(Long id);
    void delete(Long[] ids);
    List<Map> brandListForTypeTemplate();
}
