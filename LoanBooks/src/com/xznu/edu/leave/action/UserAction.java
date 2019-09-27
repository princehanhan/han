package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.Role;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.RoleService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UUIDUtils;
import com.xznu.edu.leave.utils.UserUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    private User user;
    private Integer userId;
    private Map<String, Object> map = new HashMap();
    private File file;
    private String fileFileName;
    private String fileContentType;
    public String zp1;


    /**
     * list
     *
     * @return
     */
    public String list() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<User> pagers = null;
        if (user1.getRole().getEnName().equals("admin")) {
            pagers = userService.getList(user);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("enName", user1.getRole().getEnName());
            ActionContext.getContext().put("bean", user);
        } else {
            pagers = userService.getList(user1);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("enName", user1.getRole().getEnName());
            ActionContext.getContext().put("bean", user1);
        }
        return SUCCESS;
    }


    /**
     * 跳转add
     *
     * @return
     */
    public String add() {
        Pager<Role> pagers = roleService.pagers();
        ActionContext.getContext().put("pagers", pagers);
        return SUCCESS;
    }

    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        User bean = userService.findById(userId);
        Pager<Role> pagers = roleService.pagers();
        ActionContext.getContext().put("bean", bean);
        ActionContext.getContext().put("pagers", pagers);
        return SUCCESS;
    }

    /**
     * 查询修改
     *
     * @return
     */
    public String edits() {
        User bean = UserUtils.getUser();
        if (bean == null || bean.getId() == null) {
            ActionContext.getContext().put("url", "login_login.do");
            return "redirect";
        } else {
            ActionContext.getContext().put("url", "user_edit.do?userId=" + bean.getId());
        }
        return "redirect";
    }
    /**
     * 审核
     *
     * @return
     */
    public void updateSh() throws IOException {
        user.setIsSh(1);
        userService.updates(user);
        map.put("flag", true);
        map.put("url", "user_list.do");
        JsonUtils.toJson(map);
    }

    public void updatejy() throws IOException {
        User user1 = userService.findById(user.getId());
        user1.setIsJy(user1.getIsJy() == 0 ? 1 : 0);
        userService.updates(user1);
        map.put("flag", true);
        map.put("url", "user_list.do");
        JsonUtils.toJson(map);
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

    public void updates() throws IOException {
        if (user != null) {
            userService.updates(user);
            User users = userService.findById(user.getId());
            ActionContext.getContext().getSession().put("user", users);
            map.put("flag", true);
            JsonUtils.toJson(map);
        }
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
            user.setIsJy(0);
            userService.save(user);
            map.put("flag", true);
            map.put("url", "login_login.do");
            JsonUtils.toJson(map);
        }
    }

    /**
     * vip用户注册
     *
     * @throws IOException
     */
    public void websave() throws IOException {
        ActionContext ac = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
        String root = request.getRealPath("/upload");
        if (user != null) {
            User user1 = userService.getUsers(user);
            if (user1 != null) {
                map.put("flag", false);
                map.put("url", "shopping_zhuce.do");
                map.put("msg", "登录名已被使用");
                JsonUtils.toJson(map);
            } else {
                if (file != null) {
                    InputStream is = new FileInputStream(file);
                    String f = UUIDUtils.create();
                    OutputStream os = new FileOutputStream(new File(root, f));
                    byte[] buffer = new byte[500];
                    int length = 0;
                    while (-1 != (length = is.read(buffer, 0, buffer.length))) {
                        os.write(buffer);
                    }
                    os.close();
                    is.close();
                    user.setRz("\\upload\\" + f);
                }
                user.setIsDelete(0);
                user.setTime(new Date());
                userService.save(user);
                map.put("flag", true);
                map.put("url", "shopping_login.do");
                JsonUtils.toJson(map);
            }
        }
    }


    public void delete() throws IOException {
        User user1 = userService.findById(userId);
        user1.setIsDelete(1);
        userService.update(user1);
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getZp1() {
        return zp1;
    }

    public void setZp1(String zp1) {
        this.zp1 = zp1;
    }
}
