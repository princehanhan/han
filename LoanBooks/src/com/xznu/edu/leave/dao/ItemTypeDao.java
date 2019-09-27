package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.utils.Pager;

public interface ItemTypeDao extends BaseDao<ItemType> {

    Pager<ItemType> getList(ItemType bean);

    ItemType findById(Integer id);


}
