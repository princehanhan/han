package com.xznu.edu.leave.action;
/**
 * 和登陆有关的都在这里
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.*;
import com.xznu.edu.leave.service.BookLoanLogService;
import com.xznu.edu.leave.service.BookLoanService;
import com.xznu.edu.leave.service.GoodsService;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller("bookloanlogAction")
@Scope("prototype")
public class BookLoanLogAction extends ActionSupport implements ModelDriven<BookLoanLog> {
    @Autowired
    private BookLoanLogService service;
    private BookLoanLog bookLoanLog;

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
            Pager<BookLoanLog> pagers = service.pagers(user1.getRole().getEnName().equals("admin") ? null : user1.getId());
            ActionContext.getContext().put("pagers", pagers);
        }
        return SUCCESS;
    }

    @Override
    public BookLoanLog getModel() {
        if (bookLoanLog == null) {
            bookLoanLog = new BookLoanLog();
        }
        return bookLoanLog;
    }
}
