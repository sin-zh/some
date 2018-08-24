package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSellerMapper;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbSellerExample;
import com.pinyougou.result.ResultPage;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private TbSellerMapper sellerMapper;

    @Override
    public void add(TbSeller seller) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(seller.getPassword());
        seller.setPassword(password);
        seller.setStatus("0");
        seller.setCreateTime(new Date());
        sellerMapper.insert(seller);
    }

    @Override
    public ResultPage<TbSeller> showPageList(int page, int size, TbSeller seller) {
        PageHelper.startPage(page,size);
        TbSellerExample sellerExample=new TbSellerExample();
        if (seller!=null){
            TbSellerExample.Criteria criteria = sellerExample.createCriteria();
            if (seller.getName()!=null&&seller.getName().trim().length()>0){
                criteria.andNameLike("%"+seller.getName()+"%");
            }
            if (seller.getNickName()!=null&&seller.getNickName().trim().length()>0){
                criteria.andNickNameLike("%"+seller.getNickName()+"%");
            }
            if(seller.getStatus()!=null&&seller.getStatus().trim().length()>0){
                criteria.andStatusEqualTo(seller.getStatus());
            }
        }
        Page<TbSeller> pages= (Page<TbSeller>) sellerMapper.selectByExample(sellerExample);
        return new ResultPage<TbSeller>(pages.getTotal(),pages.getResult());
    }

    @Override
    public TbSeller findByid(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateStatusByid(String id, String status) {
        TbSeller seller = sellerMapper.selectByPrimaryKey(id);
        seller.setStatus(status);
        sellerMapper.updateByPrimaryKey(seller);
    }
}
