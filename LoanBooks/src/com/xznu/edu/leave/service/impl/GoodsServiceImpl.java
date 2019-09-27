package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.GoodsDao;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.service.GoodsService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
	@Autowired
     private GoodsDao dao;

    @Override
    public Pager<Goods> getList(Goods bean){
        return dao.getList(bean);}

    @Override
    public Pager<Goods> getList2(Goods bean){
        return dao.getList2(bean);}

    @Override
    public Goods findById(Integer id) {
        return dao.findById(id);
    }

}
