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
    <title>一级分类修改</title>
</head>
<body>
<form action="itemtype_update.do" method="post" class="form form-horizontal" id="form-user-add">
    <input type="hidden" value="${bean.id}" name="id"/>
    <div class="Operate_cont clearfix">
        <label class="form-label"><span class="c-red">*</span>分类名称：</label>
        <div class="formControls ">
            <input type="text" class="input-text" value="${bean.name}" placeholder="" name="name" id="name">
        </div>
    </div>
    <div class="">
        <div class="" style=" text-align:center">
            <input class="btn btn-primary radius" type="button" value="提交" onclick="sub()">
        </div>
    </div>
</form>
<script>
    function sub() {
        var name = $('#name').val();
        if (name == null || name == "") {
            layer.alert("分类名称不能为空！\r\n",{
                title: '提示框',
                icon:0,
            });
        } else {
            AJAX('itemtype_update.do', "提交成功", "form-user-add");
        }
    }
</script>
</body>
</html>