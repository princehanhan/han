package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.utils.Pager;

public interface ReplyCommentsDao extends BaseDao<ReplyComments> {

    Pager<ReplyComments> pagers(Integer id);

}
