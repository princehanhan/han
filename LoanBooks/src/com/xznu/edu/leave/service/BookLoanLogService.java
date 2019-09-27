package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.utils.Pager;

public interface BookLoanLogService extends BaseService<BookLoanLog> {

    Pager<BookLoanLog> pagers(Integer id);

    Pager<BookLoanLog> getBookList(Integer id, Integer goodsId);
}
