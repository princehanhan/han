package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.ItemType;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.ItemTypeSecondaryService;
import com.xznu.edu.leave.service.ItemTypeService;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UserUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller("itemtypesecondaryAction")
@Scope("prototype")
public class ItemTypeSecondaryAction extends ActionSupport implements ModelDriven<ItemTypeSecondary> {

    @Autowired
    private ItemTypeSecondaryService service;
    private ItemTypeSecondary itemTypeSecondary;
    @Autowired
    private ItemTypeService itemTypeService;


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
        Pager<ItemTypeSecondary> pagers = null;
        if (user1.getRole().getEnName().equals("admin")) {
            pagers = service.getList(itemTypeSecondary);
            ActionContext.getContext().put("pagers", pagers);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", itemTypeSecondary);
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
        Pager<ItemType> pagers = itemTypeService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        return SUCCESS;
    }

    /**
     * 查询修改
     *
     * @return
     */
    public String edit() {
        ItemTypeSecondary bean = service.findById(itemTypeSecondary.getId());
        Pager<ItemType> pagers = itemTypeService.getList(null);
        ActionContext.getContext().put("pagers", pagers);
        ActionContext.getContext().put("bean", bean);
        return SUCCESS;
    }

    /**
     * 更新
     *
     * @return
     */
    public void update() throws IOException {
        service.updates(itemTypeSecondary);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        JsonUtils.jsonObject(jsonObject);
    }

    /**
     * 保存
     *
     * @return
     */
    public void save() throws IOException {
        service.save(itemTypeSecondary);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        JsonUtils.jsonObject(jsonObject);
    }

    public void delete() throws IOException {
        itemTypeSecondary.setIsDelete(1);
        service.updates(itemTypeSecondary);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        jsonObject.put("url", "itemtypesecondary_list.do");
        JsonUtils.jsonObject(jsonObject);
    }

    @Override
    public ItemTypeSecondary getModel() {
        if (itemTypeSecondary == null) {
            itemTypeSecondary = new ItemTypeSecondary();
        }
        return itemTypeSecondary;
    }

    public ItemTypeSecondary getItemTypeSecondary() {
        return itemTypeSecondary;
    }

    public void setItemTypeSecondary(ItemTypeSecondary itemTypeSecondary) {
        this.itemTypeSecondary = itemTypeSecondary;
    }
}
