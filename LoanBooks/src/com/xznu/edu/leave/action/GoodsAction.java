package com.xznu.edu.leave.action;

/**
 * 用户新增
 */

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xznu.edu.leave.model.BookLoan;
import com.xznu.edu.leave.model.Goods;
import com.xznu.edu.leave.model.ItemTypeSecondary;
import com.xznu.edu.leave.model.User;
import com.xznu.edu.leave.service.*;
import com.xznu.edu.leave.utils.JsonUtils;
import com.xznu.edu.leave.utils.Pager;
import com.xznu.edu.leave.utils.UUIDUtils;
import com.xznu.edu.leave.utils.UserUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.List;

@Controller("goodsAction")
@Scope("prototype")
public class GoodsAction extends ActionSupport implements ModelDriven<Goods> {
    @Autowired
    private BookLoanService bookLoanService;
    @Autowired
    private GoodsService service;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemTypeSecondaryService itemTypeSecondaryService;
    private Goods goods;
    private List<File> file;
    private List<String> fileFileName;
    private List<String> fileContentType;
    private Integer bookLoanId;


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
        Pager<Goods> pagers = null;
        if (user1.getRole().getEnName().equals("admin")) {
            pagers = service.getList2(goods);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", goods);
            return SUCCESS;
        } else {
            goods.setUser(user1);
            pagers = service.getList2(goods);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", goods);
            return SUCCESS;
        }
    }

    public String tjlist() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<Goods> pagers = null;
        if (user1.getRole().getEnName().equals("admin")) {
            pagers = service.getList2(goods);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", goods);
            return SUCCESS;
        } else {
            goods.setUser(user1);
            pagers = service.getList2(goods);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", goods);
            return SUCCESS;
        }
    }

    public String shlist() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        }
        Pager<Goods> pagers = null;
        if (user1.getRole().getEnName().equals("admin")) {
            pagers = service.getList2(goods);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", goods);
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

    public void sh() throws IOException {
        Goods bean = service.findById(goods.getId());
        bean.setIsSh(bean.getIsSh() == 1 ? 0 : 1);
        service.update(bean);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        jsonObject.put("url", "goods_shlist.do");
        JsonUtils.jsonObject(jsonObject);
    }

    /**
     * 上架图书
     *
     * @return
     */
    public void editSj() throws IOException {
        Goods bean = service.findById(goods.getId());
        bean.setIsSj(bean.getIsSj() == 1 ? 0 : 1);
        service.update(bean);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", true);
        jsonObject.put("url", "goods_list.do");
        JsonUtils.jsonObject(jsonObject);
    }

    /**
     * 更新
     *
     * @return
     */
    public String update() throws IOException {
        ActionContext ac = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
        String root = request.getRealPath("/upload");
        if (file != null) {
            for (int i = 0; i < file.size(); i++) {
                InputStream is = new FileInputStream(file.get(i));
                String f = UUIDUtils.create() + i;
                OutputStream os = new FileOutputStream(new File(root, f));
                byte[] buffer = new byte[500];
                int length = 0;
                while (-1 != (length = is.read(buffer, 0, buffer.length))) {
                    os.write(buffer);
                }
                os.close();
                is.close();
                if (i == 0) {
                    goods.setFileName1("\\upload\\" + f);
                }
                if (i == 1) {
                    goods.setFileName2("\\upload\\" + f);
                }
                if (i == 2) {
                    goods.setFileName3("\\upload\\" + f);
                }
                if (i == 3) {
                    goods.setFileName4("\\upload\\" + f);
                }
                if (i == 4) {
                    goods.setFileName5("\\upload\\" + f);
                }
            }
        }
        service.updates(goods);
        ActionContext.getContext().put("url", "goods_list.do");
        return "redirect";
    }

    /**
     * 保存
     *
     * @return
     */
    public String save() throws IOException {
        ActionContext ac = ActionContext.getContext();
        HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
        String root = request.getRealPath("/upload");
        if (file != null) {
            for (int i = 0; i < file.size(); i++) {
                InputStream is = new FileInputStream(file.get(i));
                String xx = new DateTime().toString();
                String f = new DateTime().toString("yyyyMMdd");
                f = UUIDUtils.create() + i;
                OutputStream os = new FileOutputStream(new File(root, f));
                byte[] buffer = new byte[500];
                int length = 0;
                while (-1 != (length = is.read(buffer, 0, buffer.length))) {
                    os.write(buffer);
                }
                os.close();
                is.close();
                if (i == 0) {
                    goods.setFileName1("\\upload\\" + f);
                }
                if (i == 1) {
                    goods.setFileName2("\\upload\\" + f);
                }
                if (i == 2) {
                    goods.setFileName3("\\upload\\" + f);
                }
                if (i == 3) {
                    goods.setFileName4("\\upload\\" + f);
                }
                if (i == 4) {
                    goods.setFileName5("\\upload\\" + f);
                }
            }
        }
        goods.setUser(UserUtils.getUser());
        goods.setCount(0);
        goods.setIsSj(0);
        goods.setIsJy(0);
        goods.setIsSd(0);
        goods.setIsSh(0);
        service.save(goods);
        ActionContext.getContext().put("url", "goods_list.do");
        return "redirect";
    }

    /**
     * list
     *
     * @return
     */
    public String bookloanlist() throws IOException {
        User user1 = UserUtils.getUser();
        if (user1 == null || user1.getId() == null) {
            ActionContext.getContext().put("login", 1);
            return SUCCESS;
        } else {
            BookLoan bookLoan = new BookLoan();
            Goods goods1 = new Goods();
            goods1.setUser(user1);
            bookLoan.setGoods(goods1);
            if (goods.getItemTypeSecondary() != null && !goods.getItemTypeSecondary().equals("")) {
                goods1.setItemTypeSecondary(goods.getItemTypeSecondary());
                bookLoan.setGoods(goods1);
            }
            Pager<BookLoan> pagers = bookLoanService.pagers(bookLoan);
            ActionContext.getContext().put("pagers", pagers);
            Pager<ItemTypeSecondary> itemTypelist = itemTypeSecondaryService.getList(null);
            ActionContext.getContext().put("itemTypelist", itemTypelist);
            ActionContext.getContext().put("user", user1);
            ActionContext.getContext().put("bean", goods);
        }
        return SUCCESS;
    }

    /**
     * 保存借阅
     */
    public void loan() throws IOException {
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        if (user == null) {
            jsonObject.put("flag", false);
            JsonUtils.jsonObject(jsonObject);
        } else {
            if (goods != null) {
                Goods goods1 = service.findById(goods.getId());
                BookLoan bookLoan = new BookLoan();
                bookLoan.setIsDelete(0);
                bookLoan.setTime(new Date());
                bookLoan.setGoods(goods1);
                bookLoan.setJyUser(user);
                bookLoan.setIsYj(0);
                bookLoanService.save(bookLoan);
                jsonObject.put("flag", true);
                JsonUtils.jsonObject(jsonObject);
            }
        }
    }

    /**
     * 归还
     */
    public void back() throws IOException {
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        if (user == null) {
            jsonObject.put("flag", false);
            JsonUtils.jsonObject(jsonObject);
        } else {
            if (goods != null) {
                Goods goods1 = service.findById(goods.getId());
                goods1.setIsJy(0);
                goods1.setIsSd(0);
                goods1.setIsSj(0);
                service.update(goods1);
                user.setZd(0);
                userService.update(user);
                BookLoan bookLoan = bookLoanService.findById(bookLoanId);
                bookLoan.setIsDelete(1);
                bookLoan.setIsYj(3);
                bookLoanService.update(bookLoan);
                jsonObject.put("flag", true);
                jsonObject.put("url", "bookloan_list.do");
                JsonUtils.jsonObject(jsonObject);
            }
        }
    }

    public void backs() throws IOException {
        User user = UserUtils.getUser();
        JSONObject jsonObject = new JSONObject();
        if (user == null) {
            jsonObject.put("flag", false);
            JsonUtils.jsonObject(jsonObject);
        } else {
            if (goods != null) {
                Goods goods1 = service.findById(goods.getId());
                goods1.setIsSd(1);
                service.update(goods1);
                user.setZd(1);
                userService.update(user);
                jsonObject.put("flag", true);
                jsonObject.put("url", "bookloan_list.do");
                JsonUtils.jsonObject(jsonObject);
            }
        }
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

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public List<String> getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(List<String> fileFileName) {
        this.fileFileName = fileFileName;
    }

    public List<String> getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(List<String> fileContentType) {
        this.fileContentType = fileContentType;
    }

    public Integer getBookLoanId() {
        return bookLoanId;
    }

    public void setBookLoanId(Integer bookLoanId) {
        this.bookLoanId = bookLoanId;
    }
}
