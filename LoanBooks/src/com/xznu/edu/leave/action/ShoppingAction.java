package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.GoodsService;
import com.xznu.edu.leave.service.ItemTypeSecondaryService;
import com.xznu.edu.leave.service.ItemTypeService;
import com.xznu.edu.leave.service.UserService;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Date;

@Controller("shoppingAction")
@Scope("prototype")
public class ShoppingAction extends ActionSupport implements ModelDriven<Goods> {

    @Autowired
    private GoodsService service;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemTypeSecondaryService itemTypeSecondaryService;
    @Autowired
    private ItemTypeService itemTypeService;
    private Goods goods;
    private String names;
    private String pass;
    private Integer counts;
    private Double je;

    /**
     * list
     *
     * @return
     */
    public String list() throws IOException {
        Pager<Goods> pagers = service.getList(goods);
        ActionContext.getContext().put("pagers", pagers);
        Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
        Pager<ItemType> itemType = itemTypeService.getList(null);
        ActionContext.getContext().put("itemTypelist", itemTypelist);
        ActionContext.getContext().put("itemType", itemType);
        ActionContext.getContext().put("bean", goods);
        ActionContext.getContext().put("user", UserUtils.getUser());
        if (UserUtils.getUser() != null){
            ActionContext.getContext().put("realName", UserUtils.getUser().getRealName());
        }
        return SUCCESS;
    }


    /**
     * 跳转add
     *
     * @return
     */
    public String add() {
        Pager<ItemTypeSecondary> pagers = itemTypeSecondaryService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        return SUCCESS;
    }


    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
        Goods bean = service.findById(goods.getId());
        Pager<ItemTypeSecondary> pagers = itemTypeSecondaryService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        ActionContext.getContext().put("bean", bean);
        return SUCCESS;
    }

    /**
     * 点击详情查看详情并借阅
     *
     * @return
     */
    public String edits() {
        Goods bean = service.findById(goods.getId());
        Pager<ItemTypeSecondary> pagers = itemTypeSecondaryService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        ActionContext.getContext().put("bean", bean);
        return SUCCESS;
    }

    /**
     * 详情
     *
     * @return
     */
    public String detail() {
        Goods bean = service.findById(goods.getId());
        Pager<ItemTypeSecondary> pagers = itemTypeSecondaryService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        ActionContext.getContext().put("bean", bean);
        return SUCCESS;
    }

    public String index() throws IOException {
        User user = new User();
        user.setName(names);
        user.setPass(pass);
        JSONObject jsonObject = new JSONObject();
        User user1 = userService.getUser(user);
        if (user1 != null){
            ActionContext.getContext().getSession().put("user", user1);
            jsonObject.put("flag", true);
            jsonObject.put("url", "shopping_list.do");
            jsonObject.put("msg", "登陆成功");
            JsonUtils.jsonObject(jsonObject);
        } else {
            jsonObject.put("flag", true);
            jsonObject.put("url", "shopping_login.do");
            jsonObject.put("msg", "用户名或密码错误");
            JsonUtils.jsonObject(jsonObject);
        }
        return null;
    }

    //登陆页面
    public String login() {
        return SUCCESS;
    }

    /**
     * 注册
     * @return
     */
    public String zhuce() {
        return SUCCESS;
    }


    /**
     * 更新
     *
     * @return
     */
    public String update() throws IOException {
        return "redirect";
    }

    /**
     * 保存
     *
     * @return
     */
    public String save() throws IOException {
        return "redirect";
    }

    public void delete() throws IOException {
        goods.setIsDelete(1);
        service.updates(goods);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        jsonObject.put("url", "goods_list.do");
        JsonUtils.jsonObject(jsonObject);
    }

    @Override
    public Goods getModel() {
        if (goods == null) {
            goods = new Goods();
        }
        return goods;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Double getJe() {
        return je;
    }

    public void setJe(Double je) {
        this.je = je;
    }
}
