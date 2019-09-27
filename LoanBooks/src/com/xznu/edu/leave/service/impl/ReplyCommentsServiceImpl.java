package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.BookLoanLogDao;
import com.xznu.edu.leave.dao.ReplyCommentsDao;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.service.BookLoanLogService;
import com.xznu.edu.leave.service.ReplyCommentsService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyCommentsServiceImpl extends BaseServiceImpl<ReplyComments> implements ReplyCommentsService {
	@Autowired
     private ReplyCommentsDao dao;

    @Override
    public Pager<ReplyComments> pagers(Integer id) {
        return dao.pagers(id);
    }

}
