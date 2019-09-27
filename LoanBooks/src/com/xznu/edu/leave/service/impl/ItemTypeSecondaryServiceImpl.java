package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.ItemTypeDao;
import com.xznu.edu.leave.dao.ItemTypeSecondaryDao;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.service.ItemTypeSecondaryService;
import com.xznu.edu.leave.service.ItemTypeService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeSecondaryServiceImpl extends BaseServiceImpl<ItemTypeSecondary> implements ItemTypeSecondaryService {
	@Autowired
     private ItemTypeSecondaryDao dao;

    @Override
    public Pager<ItemTypeSecondary> getList(ItemTypeSecondary bean){
        return dao.getList(bean);}

    @Override
    public ItemTypeSecondary findById(Integer id) {
        return dao.findById(id);
    }

}
