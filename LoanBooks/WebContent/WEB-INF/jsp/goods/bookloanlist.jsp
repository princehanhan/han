<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="${ctx}/resource/font/css/font-awesome.min.css"/>
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="${ctx}/resource/js/jquery-1.9.1.min.js"></script>
    <script src="${ctx}/resource/assets/js/typeahead-bs2.min.js"></script>
    <script src="${ctx}/resource/js/lrtk.js" type="text/javascript"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.min.js"></script>
    <script src="${ctx}/resource/assets/js/jquery.dataTables.bootstrap.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript" src="${ctx}/resource/Widget/swfupload/swfupload.js"></script>
    <script type="text/javascript" src="${ctx}/resource/Widget/swfupload/swfupload.queue.js"></script>
    <script type="text/javascript" src="${ctx}/resource/Widget/swfupload/swfupload.speed.js"></script>
    <script type="text/javascript" src="${ctx}/resource/Widget/swfupload/handlers.js"></script>
    <script type="text/javascript" src="${ctx}/resource/AJAX.js"></script>
    <title>图书管理</title>
</head>
<script>
    $(function () {
        if (${login} == 1){
            top.location = 'login_login.do';
        }
    })
</script>
<body>
<div id="Member_Ratings">
    <div class="d_Confirm_Order_style">
        <form method="post" action="goods_bookloanlist.do">
            <div class="search_style" style="margin-left: 20px">
                <ul class="search_content clearfix">
                    <li><label class="l_f">图书名称</label>
                    <input name="name" type="text" value="${bean.name}" class="text_add" style="width:200px"/>
                </li>

                    <li><label class="l_f">图书分类  </label></li>
                    <li><select name="itemTypeSecondary.id" id="names" style=" width:150px">
                            <option value="">--选择一级分类--</option>
                            <c:forEach items="${itemTypelist.datas}" var="c" varStatus="l">
                                <option value="${c.id}" <c:if test='${c.id == bean.itemTypeSecondary.id}'>selected="selected"</c:if>>${c.name}</option>
                            </c:forEach>
                        </select>
                    </li>
                    <li style="width:90px;">
                        <button type="submit" class="btn_search"><i class="icon-search"></i>查询</button>
                    </li>
                </ul>
            </div>
        </form>
    </div>
</div>
<div class=" clearfix" id="advertising">
        <div class="Ads_lists">
            <table class="table table-striped table-bordered table-hover" id="sample-table">
                <thead>
                <tr>
                    <th width="200">分类</th>
                    <th width="220px">图片</th>
                    <th width="180px">图书名称</th>
                    <th width="130px">借阅次数</th>
                    <th width="130px">借阅人</th>
                    <th width="130px">信用度</th>
                    <th width="250px">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pagers.datas}" var="c" varStatus="l">
                    <c:if test="${c.isDelete == 0}">
                <tr>
                    <td>${c.goods.itemTypeSecondary.name}</td>
                    <td><span class="ad_img"><img src="${ctx}${c.goods.fileName1}" style="width: 200px; height: auto"/></span></td>
                    <td><a href="goods_detail.do?id=${c.goods.id}">${c.goods.name}</a></td>
                    <td class="td-status"><span class="label label-success radius">${c.goods.count}</span></td>
                    <td class="td-status"><span class="label label-success radius">${c.jyUser.realName}</span></td>
                    <td class="td-status"><span class="label label-success radius">${c.jyUser.pf}</span></td>
                    <td class="td-manage">
                        <a title="借阅" onclick="edit(${c.id})" class="btn btn-xs btn-info"><i class="fa fa-edit bigger-120"></i></a>
                        <%--<a title="删除" href="javascript:;" onclick="del(${c.id})" class="btn btn-xs btn-warning"><i class="fa fa-trash  bigger-120"></i></a>--%>
                    </td>
                </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- 分页开始 -->
        <div class="pagelist">
            <pg:pager url="${ctx}/goods_bookloanlist.do" maxIndexPages="5" items="${pagers.total}" maxPageItems="15"
                      export="curPage=pageNumber">
                <pg:param name="name" value="${bean.name}"/>
                <pg:param name="itemTypeSecondary.id" value="${bean.itemTypeSecondary.id}"/>
                <pg:last>
                    共${pagers.total}记录,共${pageNumber}页,
                </pg:last>
                当前第${curPage}页
                <pg:first>
                    <a href="${pageUrl}">首页</a>
                </pg:first>
                <pg:prev>
                    <a href="${pageUrl}">上一页</a>
                </pg:prev>
                <pg:pages>
                    <c:choose>
                        <c:when test="${curPage eq pageNumber}">
                            <font color="red"><span class="current">${pageNumber }</span></font>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageUrl}">${pageNumber}</a>
                        </c:otherwise>
                    </c:choose>
                </pg:pages>
                <pg:next>
                    <a href="${pageUrl}">下一页</a>
                </pg:next>
                <pg:last>
                    <c:choose>
                        <c:when test="${curPage eq pageNumber}">
                            <a href="##">尾页</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageUrl}">尾页</a>
                        </c:otherwise>
                    </c:choose>

                </pg:last>
            </pg:pager>
        </div>
        <!-- 分页结束 -->
    </div>
</div>
</body>
</html>
<script>
    //初始化宽度、高度
    $(".widget-box").height($(window).height());
    $(".Ads_list").width($(window).width());
    //当文档窗口发生改变时 触发
    $(window).resize(function () {
        $(".widget-box").height($(window).height());
        $(".Ads_list").width($(window).width());
    });
    $(function () {
        $("#advertising").fix({
            float: 'left',
            //minStatue : true,
            skin: 'green',
            durationTime: false,
            stylewidth: '220',
            spacingw: 30,//设置隐藏时的距离
            spacingh: 250,//设置显示时间距
            set_scrollsidebar: '.Ads_style',
            table_menu: '.Ads_list'
        });
    });

    function edit(id) {
        layer.confirm('确认要借阅吗？', function () {
            updateId('bookloan_loansave.do', '借阅成功', id)
        });
    }
</script>
