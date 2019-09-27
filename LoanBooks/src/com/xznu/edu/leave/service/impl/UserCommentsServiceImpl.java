package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.BookLoanDao;
import com.xznu.edu.leave.dao.UserCommentsDao;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.model.UserComments;
import com.xznu.edu.leave.service.BookLoanService;
import com.xznu.edu.leave.service.UserCommentsService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentsServiceImpl extends BaseServiceImpl<UserComments> implements UserCommentsService {
	@Autowired
     private UserCommentsDao dao;

    @Override
    public Pager<UserComments> pagers(UserComments bookLoan) {
        return dao.pagers(bookLoan);
    }

    @Override
    public List<UserComments> getList() {
        return dao.getList();
    }

    @Override
    public Pager<UserComments> getpjList(UserComments bean) {
        return dao.getpjList(bean);
    }
}
