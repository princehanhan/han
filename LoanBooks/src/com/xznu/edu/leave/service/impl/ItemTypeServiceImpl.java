package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.GoodsDao;
import com.xznu.edu.leave.dao.ItemTypeDao;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.service.GoodsService;
import com.xznu.edu.leave.service.ItemTypeService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServiceImpl extends BaseServiceImpl<ItemType> implements ItemTypeService {
	@Autowired
     private ItemTypeDao dao;

    @Override
    public Pager<ItemType> getList(ItemType bean){
        return dao.getList(bean);}

    @Override
    public ItemType findById(Integer id) {
        return dao.findById(id);
    }

}
