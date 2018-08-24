package com.pinyougou.shop.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.result.Result;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;


    @RequestMapping("/add")
    public Result add(@RequestBody TbSeller seller){
        try {
            sellerService.add(seller);
            return new Result(true,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"fail");
        }
    }
}
