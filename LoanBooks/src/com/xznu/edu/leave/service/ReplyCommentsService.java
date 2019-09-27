package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.utils.Pager;

public interface ReplyCommentsService extends BaseService<ReplyComments> {

    Pager<ReplyComments> pagers(Integer id);

}
