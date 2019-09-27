package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.Role;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.ItemTypeService;
import com.xznu.edu.leave.service.RoleService;
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
import java.util.HashMap;
import java.util.Map;

@Controller("itemtypeAction")
@Scope("prototype")
public class ItemTypeAction extends ActionSupport implements ModelDriven<ItemType> {

    @Autowired
    private ItemTypeService service;
    private ItemType itemType;


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
        }
        Pager<ItemType> pagers = null;
        if (user1.getRole().getEnName().equals("admin")) {
            pagers = service.getList(itemType);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", itemType);
            return SUCCESS;
        } else if (user1.getRole().getEnName().equals("system")) {
            pagers = service.getList(itemType);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("bean", itemType);
            return SUCCESS;
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

    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
        ItemType bean = service.findById(itemType.getId());
        ActionContext.getContext().put("bean", bean);
        return SUCCESS;
    }

    /**
     * 更新
     *
     * @return
     */
    public void update() throws IOException {
        service.updates(itemType);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        jsonObject.put("message", "更新成功");
        JsonUtils.jsonObject(jsonObject);
    }

    /**
     * 保存
     *
     * @return
     */
    public void save() throws IOException {
        service.save(itemType);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        JsonUtils.jsonObject(jsonObject);
    }

    public void delete() throws IOException {
       itemType.setIsDelete(1);
        service.updates(itemType);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        jsonObject.put("url", "itemtype_list.do");
        JsonUtils.jsonObject(jsonObject);
    }

    @Override
    public ItemType getModel() {
        if (itemType == null) {
            itemType = new ItemType();
        }
        return itemType;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }
}
