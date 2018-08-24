package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.result.Result;
import com.pinyougou.result.ResultPage;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference
    private SellerService sellerService;

    @RequestMapping("/showPageList")
    public ResultPage<TbSeller> showPageList(@RequestBody TbSeller seller,int page,int size){
        return sellerService.showPageList(page,size,seller);
    }

    @RequestMapping("/findByid")
    public TbSeller findByid(String id){
        return sellerService.findByid(id);
    }

    @RequestMapping("/updateStatusByid")
    public Result updateStatusByid(String id,String status){
        try {
            sellerService.updateStatusByid(id,status);
            return new Result(true,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"fail");
        }
    }
}
