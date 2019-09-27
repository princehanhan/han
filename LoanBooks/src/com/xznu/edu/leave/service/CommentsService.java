package com.xznu.edu.leave.service;

import com.xznu.edu.leave.model.Comments;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.utils.Pager;

public interface CommentsService extends BaseService<Comments> {

    Pager<Comments> pagers(Integer id);

}
