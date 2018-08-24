package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.result.ResultPage;

public interface SellerService {

    void add(TbSeller seller);

    ResultPage<TbSeller> showPageList(int page,int size,TbSeller seller);

    TbSeller findByid(String id);

    void updateStatusByid(String id,String status);
}
