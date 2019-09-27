package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface BookLoanDao extends BaseDao<BookLoan> {

    Pager<BookLoan> pagers(BookLoan bookLoan);

    Pager<BookLoan> pagersls(BookLoan bean);

    List<BookLoan> getList();
}
