package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.utils.Pager;

public interface GoodsService extends BaseService<Goods> {

    Pager<Goods> getList(Goods bean);
    Pager<Goods> getList2(Goods bean);

    Goods findById(Integer id);
}
