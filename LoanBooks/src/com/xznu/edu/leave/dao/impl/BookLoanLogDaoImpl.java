package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.BookLoanDao;
import com.xznu.edu.leave.dao.BookLoanLogDao;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookLoanLogDaoImpl extends BaseDaoImpl<BookLoanLog> implements BookLoanLogDao {


    @Override
    public Pager<BookLoanLog> pagers(Integer bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from BookLoanLog where isDelete = 0");
        if (bean != null && !"".equals(bean)) {
            sb.append(" and goods.user.id = :id");
            alias.put("id", bean);
        }
        return findByAlias(sb.toString(), alias);
    }

    @Override
    public Pager<BookLoanLog> getBookList(Integer bean, Integer goodsId) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from BookLoanLog where isDelete = 0");
        if (bean != null && !"".equals(bean)) {
            sb.append(" and jyUser.id = :id and goods.id = :goodsId");
            alias.put("id", bean);
            alias.put("goodsId", goodsId);
        }
        return findByAlias(sb.toString(), alias);
    }
}
