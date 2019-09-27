package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.utils.Pager;

public interface ItemTypeService extends BaseService<ItemType> {

    Pager<ItemType> getList(ItemType bean);

    ItemType findById(Integer id);
}
