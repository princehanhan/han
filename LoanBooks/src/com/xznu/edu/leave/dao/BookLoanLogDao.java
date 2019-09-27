package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.utils.Pager;

public interface BookLoanLogDao extends BaseDao<BookLoanLog> {

    Pager<BookLoanLog> pagers(Integer id);

    Pager<BookLoanLog> getBookList(Integer bean, Integer goodsId);
}
