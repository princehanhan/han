package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.utils.Pager;

public interface ItemTypeSecondaryDao extends BaseDao<ItemTypeSecondary> {

    Pager<ItemTypeSecondary> getList(ItemTypeSecondary bean);

    ItemTypeSecondary findById(Integer id);


}
