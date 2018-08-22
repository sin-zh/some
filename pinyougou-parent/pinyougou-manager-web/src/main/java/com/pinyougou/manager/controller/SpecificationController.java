package com.pinyougou.manager.controller;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojovo.SpecificationWithSpecificationOptions;
import com.pinyougou.result.ResultPage;
import com.pinyougou.sellergoods.service.SpecificationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;

import java.util.List;
import java.util.Map;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/specification")
public class SpecificationController {

    @Reference
    private SpecificationService specificationService;


    @RequestMapping("/showPageList")
    public ResultPage<TbSpecification> showPageList(@RequestBody TbSpecification specification, int page, int size) {
        return specificationService.showPageList(specification, page, size);
    }

    @RequestMapping("/insertSpecificationWithSpecificationOptions")
    public void insertSpecificationWithSpecificationOptions(@RequestBody SpecificationWithSpecificationOptions specificationWithSpecificationOptions) {
        specificationService.insertSpecificationWithSpecificationOptions(specificationWithSpecificationOptions);
    }

    @RequestMapping("/findByid")
    public SpecificationWithSpecificationOptions findByid(Long id) {
        return specificationService.findSpecificationWithSpecificationOptionsByid(id);
    }

    @RequestMapping("/updateSpecificationWithSpecificationOptions")
    public void deleteSpecificationWithSpecificationOptions(@RequestBody SpecificationWithSpecificationOptions specificationWithSpecificationOptions) {
        specificationService.updateSpecificationWithSpecificationOptions(specificationWithSpecificationOptions);
    }

    @RequestMapping("/deleteSpecificationWithSpecificationOptionsByids")
    public void deleteSpecificationWithSpecificationOptionsByids(Long[] ids) {
          specificationService.deleteSpecificationWithSpecificationOptionsByids(ids);
    }

    @RequestMapping("/specificationListForTypeTemplate")
    public List<Map> specificationListForTypeTemplate(){
        return specificationService.specificationListForTypeTemplate();
    }
}
