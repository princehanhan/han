package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.BookLoanDao;
import com.xznu.edu.leave.dao.BookLoanLogDao;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.service.BookLoanLogService;
import com.xznu.edu.leave.service.BookLoanService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookLoanLogServiceImpl extends BaseServiceImpl<BookLoanLog> implements BookLoanLogService {
	@Autowired
     private BookLoanLogDao dao;

    @Override
    public Pager<BookLoanLog> pagers(Integer id) {
        return dao.pagers(id);
    }

    @Override
    public Pager<BookLoanLog> getBookList(Integer id, Integer goodsId) {
        return dao.getBookList(id, goodsId);
    }
}
