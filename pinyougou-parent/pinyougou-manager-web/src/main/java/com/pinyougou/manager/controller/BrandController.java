package com.pinyougou.manager.controller;

import java.util.List;

import com.pinyougou.result.Result;
import com.pinyougou.result.ResultPage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/showPageList")
    public ResultPage<TbBrand> showPageList(@RequestBody TbBrand brand, int page, int size) {
        return brandService.showPageList(page, size, brand);
    }

    @RequestMapping("/insert")
    public void insert(@RequestBody TbBrand brand) {
        brandService.insert(brand);
    }

    @RequestMapping("/findById")
    public TbBrand findById(Long id) {
        return brandService.findById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody TbBrand brand) {
        brandService.update(brand);
    }

    @RequestMapping("/delete")
    public void delete(Long[] ids) {
        brandService.delete(ids);
    }
}
