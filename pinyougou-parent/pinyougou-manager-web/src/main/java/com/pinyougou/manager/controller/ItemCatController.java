package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbItemCat;
import com.pinyougou.result.Result;
import com.pinyougou.sellergoods.service.ItemCatService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    @RequestMapping("/findByParentId")
    public List<TbItemCat> findByParentId(Long parentId) {
        return itemCatService.findByParentId(parentId);
    }

    @RequestMapping("/findByid")
    public TbItemCat findByid(Long id) {
        return itemCatService.findByid(id);
    }

    @RequestMapping("/insert")
    public Result insert(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.insert(itemCat);
            return new Result(true,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"fail");
        }
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbItemCat itemCat) {
        try {
            itemCatService.update(itemCat);
            return new Result(true,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"fail");
        }
    }
}
