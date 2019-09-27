package com.xznu.edu.leave.action;
/**
 * 和登陆有关的都在这里
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.model.BookLoanLog;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.model.User;
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

@Controller("bookloanAction")
@Scope("prototype")
public class BookLoanAction extends ActionSupport implements ModelDriven<BookLoan> {
    @Autowired
    private BookLoanService service;
    @Autowired
    private BookLoanLogService bookLoanLogService;
    @Autowired
    private GoodsService goodsService;
    private BookLoan bookLoan;

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
            BookLoan bookLoan = new BookLoan();
            bookLoan.setJyUser(user1);
            Pager<BookLoan> pagers = service.pagers(bookLoan);
            ActionContext.getContext().put("pagers", pagers);
        }
        return SUCCESS;
    }

    /**
     * list
     *
     * @return
     */
    public String listls() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        } else {
            BookLoan bookLoan = new BookLoan();
            bookLoan.setJyUser(user1);
            Pager<BookLoan> pagers = service.pagersls(bookLoan);
            ActionContext.getContext().put("pagers", pagers);
        }
        return SUCCESS;
    }

    /**
     * 借阅并保存log
     */
    public void loansave() throws IOException {
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        if (user == null){
            jsonObject.put("flag", false);
            JsonUtils.jsonObject(jsonObject);
        }
        if (bookLoan != null){
            bookLoan = service.findById(bookLoan.getId());
            BookLoanLog bookLoanLog = new BookLoanLog();
            bookLoanLog.setGoods(bookLoan.getGoods());
            bookLoanLog.setJyUser(bookLoan.getJyUser());
            bookLoanLog.setTime(new Date());
            bookLoanLog.setIsDelete(0);
            bookLoanLogService.save(bookLoanLog);
            List<BookLoan> list = service.getList();
            for(BookLoan l : list){
                if (l.getJyUser().getId() != bookLoan.getJyUser().getId()){
                    l.setIsDelete(1);
                    l.setIsYj(2);
                    service.update(l);
                }
            }
            bookLoan.setIsYj(1);
            bookLoan.setIsDelete(1);
            service.update(bookLoan);
            Goods goods = bookLoan.getGoods();
            goods.setIsJy(1);
            goods.setIsSj(1);
            goods.setCount(goods.getCount() + 1);
            goodsService.updates(bookLoan.getGoods());
            jsonObject.put("flag", true);
            jsonObject.put("url", "goods_bookloanlist.do");
            JsonUtils.jsonObject(jsonObject);
        }
    }

    @Override
    public BookLoan getModel() {
        if (bookLoan == null) {
            bookLoan = new BookLoan();
        }
        return bookLoan;
    }
}
