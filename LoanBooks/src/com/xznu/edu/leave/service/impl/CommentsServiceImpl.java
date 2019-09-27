package com.xznu.edu.leave.service.impl;

import com.xznu.edu.leave.dao.CommentsDao;
import com.xznu.edu.leave.dao.ReplyCommentsDao;
import com.xznu.edu.leave.model.Comments;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.service.CommentsService;
import com.xznu.edu.leave.service.ReplyCommentsService;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsServiceImpl extends BaseServiceImpl<Comments> implements CommentsService {
	@Autowired
     private CommentsDao dao;

    @Override
    public Pager<Comments> pagers(Integer id) {
        return dao.pagers(id);
    }

}
