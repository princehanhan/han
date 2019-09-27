package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.ItemTypeDao;
import com.xznu.edu.leave.dao.ItemTypeSecondaryDao;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemTypeSecondaryDaoImpl extends BaseDaoImpl<ItemTypeSecondary> implements ItemTypeSecondaryDao {

    @Override
    public Pager<ItemTypeSecondary> getList(ItemTypeSecondary bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from ItemTypeSecondary where isDelete = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public ItemTypeSecondary findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from ItemTypeSecondary where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (ItemTypeSecondary) query.uniqueResult();
    }
}
