package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.result.ResultPage;

public interface TypeTemplateService {
    ResultPage<TbTypeTemplate> showPageList(TbTypeTemplate typeTemplate,int page,int size);

    TbTypeTemplate findByid(Long id);

    void save(TbTypeTemplate typeTemplate);
}
