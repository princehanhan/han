package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface BookLoanService extends BaseService<BookLoan> {

    Pager<BookLoan> pagers(BookLoan bookLoan);

    Pager<BookLoan> pagersls(BookLoan bookLoan);

    List<BookLoan> getList();
}
