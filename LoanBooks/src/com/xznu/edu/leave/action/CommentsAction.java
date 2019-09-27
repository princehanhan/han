package com.xznu.edu.leave.action;
/**
 * 和登陆有关的都在这里
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.*;
import com.xznu.edu.leave.service.*;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.format.Parser;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller("commentsAction")
@Scope("prototype")
public class CommentsAction extends ActionSupport implements ModelDriven<Comments> {
    @Autowired
    private CommentsService service;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserCommentsService userCommentsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReplyCommentsService replyCommentsService;
    @Autowired
    private BookLoanLogService bookLoanLogService;
    private Comments comments;
    private Integer goodsId;
    private Integer commentsId;
    private String nrs;
    private Integer pfs;

    /**
     * list
     *
     * @return
     */
    public void list() throws IOException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        List<ReplyComments> pagers2;
        User user = UserUtils.getUser();
        if (goodsId != null) {
            List<Comments> pagers = service.pagers(goodsId).getDatas();
            for (Comments list : pagers) {
                pagers2 = replyCommentsService.pagers(list.getId()).getDatas();
                jsonArray.addAll(pagers2);
            }
            if (user != null) {
                List<BookLoanLog> listBook = bookLoanLogService.getBookList(user.getId(), goodsId).getDatas();
                if (listBook.size() > 0) {
                    jsonObject.put("user", true);
                } else {
                    jsonObject.put("user", false);
                }
            } else {
                jsonObject.put("user", false);
            }
            jsonObject.put("list", pagers);
            jsonObject.put("reply", jsonArray);
            JsonUtils.jsonObject(jsonObject);
        }

    }

    /**
     * 发表评论
     *
     * @return
     */
    public void save() throws IOException {
        User user = UserUtils.getUser();
        if (goodsId != null) {
            Goods goods = goodsService.findById(goodsId);
            ActionContext ac = ActionContext.getContext();
            HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
            String nr = request.getParameter("nr");
            nr = new String(nr.getBytes("iso8859-1"), "UTF-8");
            if (comments != null) {
                comments.setTime(new Date());
                comments.setIsDelete(0);
                comments.setJyUser(user);
                comments.setNr(nr);
                comments.setGoods(goods);
                comments.setUser(goods.getUser());
                service.save(comments);
                if (pfs != null){
                    UserComments userComments = new UserComments();
                    userComments.setGoods(goods);
                    userComments.setJyUser(user);
                    userComments.setUser(goods.getUser());
                    userComments.setJypf(pfs);
                    userComments.setSspf(0);
                    userComments.setIsYp(1);
                    userCommentsService.save(userComments);
                }
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("flag", true);
                jsonObject.put("bean", comments);
                JsonUtils.jsonObject(jsonObject);
            }
        }
    }

    /**
     * 回复
     *
     * @return
     */
    public void saves() throws IOException {
        User user = UserUtils.getUser();
        if (commentsId != null) {
            Comments comments = service.findById(commentsId);
            ReplyComments replyComments = new ReplyComments();
            if (nrs != null && !nrs.equals("")){
                replyComments.setNr(new String(nrs.getBytes("iso8859-1"), "UTF-8"));
            }
            replyComments.setUser(user);
            replyComments.setComments(comments);
            replyComments.setIsDelete(0);
            replyComments.setTime(new Date());
            replyCommentsService.save(replyComments);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flag", true);
            jsonObject.put("username", user.getRealName());
            JsonUtils.jsonObject(jsonObject);
        }
    }


    @Override
    public Comments getModel() {
        if (comments == null) {
            comments = new Comments();
        }
        return comments;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public String getNrs() {
        return nrs;
    }

    public void setNrs(String nrs) {
        this.nrs = nrs;
    }

    public Integer getPfs() {
        return pfs;
    }

    public void setPfs(Integer pfs) {
        this.pfs = pfs;
    }
}
