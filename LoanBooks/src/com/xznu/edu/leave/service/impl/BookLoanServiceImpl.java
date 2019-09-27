package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.BookLoanDao;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.service.BookLoanService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanServiceImpl extends BaseServiceImpl<BookLoan> implements BookLoanService {
	@Autowired
     private BookLoanDao dao;

    @Override
    public Pager<BookLoan> pagers(BookLoan bookLoan) {
        return dao.pagers(bookLoan);
    }

    @Override
    public Pager<BookLoan> pagersls(BookLoan bookLoan) {
        return dao.pagersls(bookLoan);
    }

    @Override
    public List<BookLoan> getList() {
        return dao.getList();
    }

}
