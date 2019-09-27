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
import java.util.Date;
import java.util.List;

@Controller("usercommentsAction")
@Scope("prototype")
public class UserCommentsAction extends ActionSupport implements ModelDriven<UserComments> {
    @Autowired
    private UserCommentsService userCommentsService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private ReplyCommentsService replyCommentsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemTypeSecondaryService itemTypeSecondaryService;
    private UserComments userComments;
    private Integer commentsId;
    private String nrs;
    private Integer pfs;
    /**
     * 待所属商品人评价
     * @throws IOException
     */
    public String list() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<UserComments> pagers = userCommentsService.getpjList(userComments);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", userComments);
            return SUCCESS;
    }

    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
       UserComments userComments1 = userCommentsService.findById(userComments.getId());
        Goods bean = goodsService.findById(userComments1.getGoods().getId());
        Pager<ItemTypeSecondary> pagers = itemTypeSecondaryService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        ActionContext.getContext().put("bean", bean);
        ActionContext.getContext().put("userCommentsId", userComments1.getId());
        ActionContext.getContext().put("goodsId", userComments1.getGoods().getId());
        return SUCCESS;
    }

    /**
     * 回复
     *
     * @return
     */
    public void saves() throws IOException {
        User user = UserUtils.getUser();
        if (commentsId != null) {
            Comments comments = commentsService.findById(commentsId);
            ReplyComments replyComments = new ReplyComments();
            if (nrs != null && !nrs.equals("")){
                replyComments.setNr(new String(nrs.getBytes("iso8859-1"), "UTF-8"));
            }
            replyComments.setUser(user);
            replyComments.setComments(comments);
            replyComments.setIsDelete(0);
            replyComments.setTime(new Date());
            replyCommentsService.save(replyComments);
            if (userComments != null){
               userComments = userCommentsService.findById(userComments.getId());
                userComments.setIsYp(2);
                userComments.setSspf(pfs);
                userCommentsService.update(userComments);
                User user1 = userComments.getUser(); //商品所属人
                user1.setPjcs(user1.getPjcs() + 1);
                user1.setPf((user1.getPf() + userComments.getSspf())/user1.getPjcs());
                userService.update(user1);
                User user2 = userComments.getJyUser(); //借阅人
                user2.setPjcs(user2.getPjcs() + 1);
                user2.setPf((user2.getPf() + userComments.getJypf())/user2.getPjcs());
                userService.update(user2);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("flag", true);
            jsonObject.put("username", user.getRealName());
            JsonUtils.jsonObject(jsonObject);
        }
    }

    @Override
    public UserComments getModel() {
        if (userComments == null) {
            userComments = new UserComments();
        }
        return userComments;
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
