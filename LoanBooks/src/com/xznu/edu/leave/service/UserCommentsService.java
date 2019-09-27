package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.UserComments;
import com.xznu.edu.leave.utils.Pager;

import java.util.List;

public interface UserCommentsService extends BaseService<UserComments> {

    Pager<UserComments> pagers(UserComments bookLoan);

    List<UserComments> getList();

    Pager<UserComments> getpjList(UserComments bean);
}
