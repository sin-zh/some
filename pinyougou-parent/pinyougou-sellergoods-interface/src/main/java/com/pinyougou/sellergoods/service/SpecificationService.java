package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojovo.SpecificationWithSpecificationOptions;
import com.pinyougou.result.ResultPage;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 *
 * @author Administrator
 */
public interface SpecificationService {

    ResultPage<TbSpecification> showPageList(TbSpecification specification, int page, int size);

    void insertSpecificationWithSpecificationOptions(SpecificationWithSpecificationOptions specificationWithSpecificationOptions);

    SpecificationWithSpecificationOptions findSpecificationWithSpecificationOptionsByid(Long specificationId);

    void updateSpecificationWithSpecificationOptions(SpecificationWithSpecificationOptions specificationWithSpecificationOptions);

    void deleteSpecificationWithSpecificationOptionsByids(Long[] ids);

    List<Map> specificationListForTypeTemplate();
}
