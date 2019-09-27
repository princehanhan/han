package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.GoodsDao;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.utils.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {

    @Override
    public Pager<Goods> getList(Goods bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from Goods where isDelete = 0 and isJy = 0 and isSj = 0 and isSh = 1");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
            if (bean.getItemTypeSecondary() != null && !"".equals(bean.getItemTypeSecondary())) {
                if (bean.getItemTypeSecondary().getId() != null && !"".equals(bean.getItemTypeSecondary().getId())) {
                    sb.append(" and itemTypeSecondary.id = :itemTypeSecondary");
                    alias.put("itemTypeSecondary", bean.getItemTypeSecondary().getId());
                }
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public Pager<Goods> getList2(Goods bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from Goods where isDelete = 0 and isSj = 0");
        if (bean != null) {
            if (bean.getName() != null && !"".equals(bean.getName())) {
                sb.append(" and name like :name");
                alias.put("name", "%" + bean.getName().trim() + "%");
            }
            if (bean.getUser() != null && !"".equals(bean.getUser())) {
                sb.append(" and user.id = :userId");
                alias.put("userId", bean.getUser().getId());
            }
            if (bean.getItemTypeSecondary() != null && !"".equals(bean.getItemTypeSecondary())) {
                if (bean.getItemTypeSecondary().getId() != null && !"".equals(bean.getItemTypeSecondary().getId())) {
                    sb.append(" and itemTypeSecondary.id = :itemTypeSecondary");
                    alias.put("itemTypeSecondary", bean.getItemTypeSecondary().getId());
                }
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public Goods findById(Integer id) {
        StringBuilder sb = new StringBuilder();
        sb.append("from Goods where isDelete = 0 and id = :id");
        Query query = getSession().createQuery(sb.toString());
        query.setParameter("id", id);
        return (Goods) query.uniqueResult();
    }
}
