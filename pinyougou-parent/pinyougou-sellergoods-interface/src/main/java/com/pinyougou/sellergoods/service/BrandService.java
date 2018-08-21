package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.result.ResultPage;

public interface BrandService {

     ResultPage<TbBrand> showPageList(int page,int size,TbBrand brand);

    void insert(TbBrand brand);
    void update(TbBrand brand);
    TbBrand findById(Long id);
    void delete(Long[] ids);
}
