package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.utils.Pager;

public interface ItemTypeSecondaryService extends BaseService<ItemTypeSecondary> {

    Pager<ItemTypeSecondary> getList(ItemTypeSecondary bean);

    ItemTypeSecondary findById(Integer id);
}
