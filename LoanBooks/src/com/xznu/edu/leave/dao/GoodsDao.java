package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.utils.Pager;

public interface GoodsDao extends BaseDao<Goods> {

    Pager<Goods> getList(Goods bean);
    Pager<Goods> getList2(Goods bean);

    Goods findById(Integer id);


}
