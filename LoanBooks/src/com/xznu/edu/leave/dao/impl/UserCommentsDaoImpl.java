package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.UserCommentsDao;
import com.xznu.edu.leave.model.UserComments;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserCommentsDaoImpl extends BaseDaoImpl<UserComments> implements UserCommentsDao {


    @Override
    public Pager<UserComments> pagers(UserComments bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from UserComments where 1=1");
        if (bean != null) {
            if (bean.getJyUser() != null && !"".equals(bean.getJyUser())) {
                sb.append(" and jyUser.id = :id");
                alias.put("id", bean.getJyUser().getId());
            }
            if (bean.getGoods() != null && !"".equals(bean.getGoods())) {
                if (bean.getGoods().getUser() != null && !bean.getGoods().getUser().equals("")) {
                    sb.append(" and user.id = :id");
                    alias.put("id", bean.getGoods().getUser().getId());
                }
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public List<UserComments> getList() {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from UserComments where 1=1");
        List<UserComments> list = findByAlias(sb.toString(), alias).getDatas();
        return list;
    }

    @Override
    public Pager<UserComments> getpjList(UserComments bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from UserComments where isYp <> 0");
        if (bean != null) {
            if (bean.getJyUser() != null && !"".equals(bean.getJyUser())) {
                sb.append(" and jyUser.realName like :jyUser");
                alias.put("jyUser", "%" + bean.getJyUser().getRealName() + "%");
            }
            if (bean.getGoods() != null && !"".equals(bean.getGoods())) {
                if (bean.getGoods().getName() != null && !"".equals(bean.getGoods().getName())) {
                    sb.append(" and goods.name like :name");
                    alias.put("name", "%" + bean.getGoods().getName() + "%");
                }
                if (bean.getGoods().getItemTypeSecondary() != null && !"".equals(bean.getGoods().getItemTypeSecondary())) {
                    if (bean.getGoods().getItemTypeSecondary().getId() != null && !"".equals(bean.getGoods().getItemTypeSecondary().getId())) {
                        sb.append(" and goods.itemTypeSecondary.id = :itemTypeSecondary");
                        alias.put("itemTypeSecondary", bean.getGoods().getItemTypeSecondary().getId());
                    }
                }
            }

        }
        return findByAlias(sb.toString(), alias);
    }
}
