package com.xznu.edu.leave.dao.impl;

import com.xznu.edu.leave.base.dao.impl.BaseDaoImpl;
import com.xznu.edu.leave.dao.BookLoanLogDao;
import com.xznu.edu.leave.dao.ReplyCommentsDao;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.utils.Pager;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ReplyCommentsDaoImpl extends BaseDaoImpl<ReplyComments> implements ReplyCommentsDao {


    @Override
    public Pager<ReplyComments> pagers(Integer bean) {
        Map<String, Object> alias = new HashMap<String, Object>();
        StringBuffer sb = new StringBuffer();
        sb.append("from ReplyComments where isDelete = 0");
        if (bean != null && !"".equals(bean)) {
            sb.append(" and comments.id = :id order by time desc");
            alias.put("id", bean);
        }
        return findByAlias(sb.toString(), alias);
    }
}
