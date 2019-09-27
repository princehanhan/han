<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册</title>
    <link type="text/css" href="${ctx}/resource/web/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/resource/web/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/web/js/js.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>
    <style type="text/css">
        .file {
            display: inline-block;
            background: #D0EEFF;
            border: 1px solid #99D3F5;
            border-radius: 4px;
            padding: 4px 12px;
            overflow: hidden;
            color: #1E88C7;
            text-decoration: none;
            text-indent: 0;
            line-height: 20px;
            margin-left: 230px;
            margin-top: 8px;
        }
        .file input {
            font-size: 100px;
            opacity: 0;

        }
        .file:hover {
            background: #AADFFD;
            border-color: #78C3F3;
            color: #004974;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="hrader" id="header">
    <a href="shopping_login.do" style="color:#FD7306;margin-left:20px;">请登录</a>
    <div class="topNav">
        <a href="##" style="color:#FD7306;">首页</a>
        <a href="##">悬赏榜</a>
        <a href="##" class="luntan">论坛</a>
        <a href="##">帮助</a>
        <a href="#">&nbsp;</a>
        <a href="#" class="lan">中文</a>
        <a href="#" class="lan">English</a>
    </div><!--topNav/-->
</div><!--hrader/-->
<div class="mainCont">
    <h1 class="logo" style="text-align:left;">
        <a href="##" style='width: 304px; height: 74px; display: block'></a>
    </h1>
    <div class="loginBuy" style="height: 630px">
        <div class="loginBuyLeft">
            <ul class="regEq">
                <li class="regEqBg1" style="width: 100%">用户注册</li>
                <div class="clears"></div>
            </ul><!--regEq/-->
            <form action="user_websave.do" method="post" class="regForm" id="form-user-add" style="height: 500px">
                <input type="hidden"  name="role.id" value="2" style="width: 220px"/>
                <input type="hidden"  name="userId" value="1" style="width: 220px"/>
                <div class="loginBuyList">
                <label for="name">登陆账号：</label>
                <input type="text" id="name" name="name" style="width: 220px"/>
            </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="name">真实姓名：</label>
                    <input type="text" id="realName" name="realName" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="tel">手机号码：</label>
                    <input type="text" id="tel" name="phone" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="xh">班级：</label>
                    <input type="text" id="bj" name="bj" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="xh">所属系：</label>
                    <input type="text" id="ssx" name="ssx" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="xh">专业：</label>
                    <input type="text" id="zy" name="zy" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="xh">学号：</label>
                    <input type="text" id="xh" name="xh" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="zp1">照片认证：</label>
                    <input type="text" id="rz" name="zp1" style="width: 220px"/>
                    <a href="javascript:;" class="file">选择文件
                        <input type="file" id="zp1" name="file">
                    </a>
                </div><!--loginBuyList/-->
                <div class="loginBuyList">
                    <label for="pwd">设置密码：</label>
                    <input type="text" id="pwd" name="pass" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="loginBuyList" style="border:#DEDEDE 1px solid;">
                    <label for="pwd1">确认密码：</label>
                    <input type="text" id="pwd1" style="width: 220px"/>
                </div><!--loginBuyList/-->
                <div class="regSubs" style="margin-top: -8px">
                    <input type="button" value=" 注 册 " onclick="sub()" style="width: 310px"/>
                </div><!--regSub/-->
            </form><!--/-->

        </div><!--loginBuyLeft-->
        <div class="loginBuyRight">
            <div class="regDl">
                <a href="shopping_login.do"><img src="${ctx}/resource/web/images/dl.jpg" width="180" height="60" /></a>
                <p>已有<a href="shopping_login.do">用户</a>账号点击登录！</p>
            </div><!--regDl/-->
        </div><!--loginBuyRight/-->
        <div class="clears"></div>
    </div><!--loginBuy/-->
</div><!--mainCont/-->
<script>
    $(".file").on("change", "input[type='file']", function () {
        var filePath = $(this).val();
        var filePath = filePath.split('\\');
        var filePath = filePath[filePath.length - 1];
        $('#rz').val(filePath);
        $('#zp1').val(filePath);
    })

    function sub() {
        var name = $('#name').val();
        var realName = $('#realName').val();
        var tel = $('#tel').val();
        var pwd = $('#pwd').val();
        var pwd1 = $('#pwd1').val();
        var rz = $('#rz').val();
        var xh = $('#xh').val();
        var bj = $('#bj').val();
        var ssx = $('#ssx').val();
        var zy = $('#zy').val();
        if (name == null || name == ""){
            msg("请输入登陆名");
            return false;
        } else if (realName == null || realName == ""){
            msg("请输入真实姓名");
            return false;
        } else if (tel == null || tel == "") {
            msg("请输入电话号码");
            return false;
        } else if (bj == null || bj == ""){
            msg("请输入班级");
            return false;
        } else if (ssx == null || ssx == "") {
            msg("所属系不能为空");
            return false;
        } else if (zy == null || zy == "") {
            msg("所属专业不能为空");
            return false;
        } else if (xh == null || xh == "") {
                msg("请输入学号");
                return false;
        } else if (rz == null || rz == "") {
                msg("学生证图片不能为空");
                return false;
        } else  if (pwd == null || pwd == "") {
                msg("密码错误");
                return false;
            } else if (pwd1 != pwd){
                msg("两次输入密码不一样");
                return false;
        } else {
            var formData = new FormData($( "#form-user-add" )[0]);
            $.ajax({
                type: "post",
                url: "user_websave.do",
                data:formData,// 你的formid
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function(data){
                    if (data.flag){
                        layer.msg('注册成功', {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                            window.location.href = data.url;
                        });
                    } else {
                        layer.msg(data.msg, {
                            icon: 1,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                        });
                    }
                }
            });
        }
    }

    function msg(data) {
        layer.msg(data, {
            icon: 1,
            time: 2000 //2秒关闭（如果不配置，默认是3秒）
        }, function(){
        });
    }


</script>
</body>
</html>
