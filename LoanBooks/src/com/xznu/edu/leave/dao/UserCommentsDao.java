package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.UserComments;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface UserCommentsDao extends BaseDao<UserComments> {

    Pager<UserComments> pagers(UserComments bookLoan);

    List<UserComments> getList();

    Pager<UserComments> getpjList(UserComments bean);
}
