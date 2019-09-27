<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link href="${ctx}/resource/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${ctx}/resource/css/style.css"/>
    <link href="${ctx}/resource/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome.min.css" />
    <!--[if IE 7]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${ctx}/resource/assets/css/ace-ie.min.css" />
    <![endif]-->
    <script src="${ctx}/resource/assets/js/jquery.min.js"></script>
    <script src="${ctx}/resource/AJAX.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript" ></script>
    <script src="${ctx}/resource/assets/laydate/laydate.js" type="text/javascript"></script>
    <title>一级分类添加</title>
</head>
<body>
<form action="itemtypesecondary_save.do" method="post" class="form form-horizontal" id="form-user-add">
    <div class="Operate_cont clearfix">
        <label class="form-label">一级分类：</label>
        <div class="formControls ">
            <select name="itemType.id" id="names" style=" width:150px">
                <option>--选择一级分类--</option>
                <c:forEach items="${pagers.datas}" var="c" varStatus="l">
                <option value="${c.id}" <c:if test='${c.id == bean.id}'>selected="selected"</c:if>>${c.name}</option>
                </c:forEach>
            </select>
        </div>
        </div>
    <div class="Operate_cont clearfix">
        <label class="form-label" >二级分类：</label>
        <div class="formControls ">
            <input type="text" class="input-text" value="" placeholder="" id="name" name="name">
        </div>
    </div>
    <div class="">
        <div class="" style=" text-align:center">
            <input class="btn btn-primary radius" type="button" value="提交" onclick="sub()">
        </div>
    </div>
</form>
<script>
//    AJAX(url, msg, id) {
function sub() {
    var names = $('#names').val();
    var name = $('#name').val();
    if (names == null || names == "") {
        layer.alert("一级分类不能为空！\r\n",{
            title: '提示框',
            icon:0,
        });
    } else if (name == null || name == "") {
        layer.alert("分类名称不能为空！\r\n",{
            title: '提示框',
            icon:0,
        });
    } else {
        AJAX('itemtypesecondary_save.do', "提交成功", "form-user-add");
    }
}
</script>
</body>
</html>