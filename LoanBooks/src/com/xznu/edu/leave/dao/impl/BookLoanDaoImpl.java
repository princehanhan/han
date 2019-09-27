package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.BookLoanDao;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookLoanDaoImpl extends BaseDaoImpl<BookLoan> implements BookLoanDao {


    @Override
    public Pager<BookLoan> pagers(BookLoan bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from BookLoan where 1=1");
        if (bean != null) {
            if (bean.getJyUser() != null && !"".equals(bean.getJyUser())) {
                sb.append(" and jyUser.id = :id");
                alias.put("id", bean.getJyUser().getId());
            }
            if (bean.getGoods() != null && !"".equals(bean.getGoods())) {
                if (bean.getGoods().getUser() != null && !bean.getGoods().getUser().equals("")) {
                    sb.append(" and goods.user.id = :id");
                    alias.put("id", bean.getGoods().getUser().getId());
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

    @Override
    public Pager<BookLoan> pagersls(BookLoan bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from BookLoan where isYj = 3");
        if (bean != null) {
            if (bean.getJyUser() != null && !"".equals(bean.getJyUser())) {
                sb.append(" and jyUser.id = :id");
                alias.put("id", bean.getJyUser().getId());
            }
            if (bean.getGoods() != null && !"".equals(bean.getGoods())) {
                if (bean.getGoods().getUser() != null && !bean.getGoods().getUser().equals("")) {
                    sb.append(" and goods.user.id = :id");
                    alias.put("id", bean.getGoods().getUser().getId());
                }
                if (bean.getGoods().getItemTypeSecondary() != null && !"".equals(bean.getGoods().getItemTypeSecondary())) {
                    sb.append(" and goods.itemTypeSecondary.id = :itemTypeSecondaryId");
                    alias.put("itemTypeSecondaryId", bean.getGoods().getItemTypeSecondary().getId());
                }
            }
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public List<BookLoan> getList() {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from BookLoan where isDelete = 0 and isYj = 0");
        List<BookLoan> list = findByAlias(sb.toString(),alias).getDatas();
        return list;
    }
}
