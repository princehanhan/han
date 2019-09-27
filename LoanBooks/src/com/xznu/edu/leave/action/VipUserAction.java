package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.*;
import com.xznu.edu.leave.service.*;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.*;

@Controller("vipuserAction")
@Scope("prototype")
public class VipUserAction extends ActionSupport implements ModelDriven<User> {
    @Autowired
    private UserService userService;
    private User user;
    private Integer userId;
    private Map<String, Object> map = new HashMap();
    private String idList;

    public String vipuser() {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
        } else {
            ActionContext.getContext().put("bean", user1);
        }
        return SUCCESS;
    }

    public String password(){
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
        } else {
            ActionContext.getContext().put("bean", user1);
        }
        return SUCCESS;
    }

    public String passwordupdate() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null){
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        } else {
            if (user != null){
                userService.updates(user);
                user = userService.findById(user.getId());
                ActionContext.getContext().put("bean", user);
                ActionContext.getContext().getSession().put("user", user);
                map.put("flag", true);
                JsonUtils.toJson(map);
            }
        }
       return null;
    }
    /**
     * 跳转add
     *
     * @return
     */
    public String add() {
        return SUCCESS;
    }

    public String card() {
        return SUCCESS;
    }

    public String pass() {
        List<String> listId = null;
        if (idList != null || idList.equals("")){
            String [] list = idList.split(",");
            listId = Arrays.asList(list);
        }
        ActionContext.getContext().getSession().put("idList", listId);
        return SUCCESS;
    }



    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
        return SUCCESS;
    }

    /**
     * 更新
     *
     * @return
     */
    public String update() throws IOException {
        if (user.getPass().equals("")) {
            user.setPass(null);
        }
        userService.updates(user);
        map.put("flag", true);
        map.put("url", "user_list.do");
        JsonUtils.toJson(map);
        return SUCCESS;
    }

    /**
     * 保存
     *
     * @return
     */
    public void save() throws IOException {
        if (userService.getUser(user) != null) {
            map.put("flag", false);
            map.put("url", "login_login.do");
            JsonUtils.toJson(map);
        } else {
            user.setTime(new Date());
            userService.save(user);
            map.put("flag", true);
            map.put("url", "login_login.do");
            JsonUtils.toJson(map);
        }
    }

    public void delete() throws IOException {
        User user1 = userService.findById(userId);
        user1.setIsDelete(1);
        userService.updates(user1);
        map.put("flag", true);
        map.put("url", "user_list.do");
        JsonUtils.toJson(map);
    }

    @Override
    public User getModel() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

}
