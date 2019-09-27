package com.xznu.edu.leave.dao;

import com.xznu.edu.leave.base.dao.BaseDao;
import com.xznu.edu.leave.model.Comments;
import com.xznu.edu.leave.utils.Pager;

public interface CommentsDao extends BaseDao<Comments> {

    Pager<Comments> pagers(Integer id);

}
