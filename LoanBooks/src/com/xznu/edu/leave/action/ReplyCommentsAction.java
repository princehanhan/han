package com.xznu.edu.leave.action;
/**
 * 和登陆有关的都在这里
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.model.ReplyComments;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.BookLoanLogService;
import com.xznu.edu.leave.service.ReplyCommentsService;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller("replyAction")
@Scope("prototype")
public class ReplyCommentsAction extends ActionSupport implements ModelDriven<ReplyComments> {
    @Autowired
    private ReplyCommentsService service;
    private ReplyComments replyComments;

    /**
     * list
     *
     * @return
     */
    public String list() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        } else {
            Pager<ReplyComments> pagers = service.pagers(user1.getId());
            ActionContext.getContext().put("pagers", pagers);
        }
        return SUCCESS;
    }

    @Override
    public ReplyComments getModel() {
        if (replyComments == null) {
            replyComments = new ReplyComments();
        }
        return replyComments;
    }
}
