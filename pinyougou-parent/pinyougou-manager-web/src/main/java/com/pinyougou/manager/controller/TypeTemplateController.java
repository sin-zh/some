package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbTypeTemplate;
import com.pinyougou.result.Result;
import com.pinyougou.result.ResultPage;
import com.pinyougou.sellergoods.service.TypeTemplateService;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {



    @Reference
    private TypeTemplateService templateService;

    @RequestMapping("/showPageList")
    public ResultPage<TbTypeTemplate> showPageList(@RequestBody TbTypeTemplate typeTemplate, int page, int size) {
        return templateService.showPageList(typeTemplate, page, size);
    }

    @RequestMapping("/findByid")
    public TbTypeTemplate findByid(Long id) {
        return templateService.findByid(id);
    }

    @RequestMapping("/save")
    public Result save(@RequestBody TbTypeTemplate typeTemplate){
        try {
            templateService.save(typeTemplate);
            return new Result(true,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"try again");
        }

    }
}
