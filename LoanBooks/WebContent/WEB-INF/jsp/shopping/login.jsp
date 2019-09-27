<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登陆</title>
    <link type="text/css" href="${ctx}/resource/web/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/resource/web/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/resource/web/js/js.js"></script>
    <script type="text/javascript" src="${ctx}/resource/AJAX.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>

</head>

<body>
<div class="hrader" id="header">
    <a href="shopping_login.do" style="color:#FD7306;margin-left:20px;">请登录</a>
    <a href="shopping_zhuce.do">注册</a>
    <div class="topNav">
        <a href="shopping_list.do" style="color:#FD7306;">首页</a>
        <%--<a href="buy.html">买家</a>--%>
        <%--<a href="sell.html">卖家</a>--%>
        <%--<a href="vipuser_vipuser.do">会员中心</a>--%>
        <%--<a href="##">悬赏榜</a>--%>
        <%--<a href="##" class="luntan">论坛</a>--%>
        <%--<a href="##">帮助</a>--%>
        <%--<a href="#">&nbsp;</a>--%>
        <%--<a href="#" class="lan">中文</a>--%>
        <%--<a href="#" class="lan">English</a>--%>
    </div><!--topNav/-->
</div><!--hrader/-->
<div class="mainCont">
    <h1 class="logo" style="text-align:left;">
        <a href="##" style='width: 304px; height: 74px; display: block'>
        </a>
    </h1>
    <div class="loginBox">
        <div class="loginLeft">
            <img src="${ctx}/resource/web/images/login.jpg" width="567" height="348" />
        </div><!--loginLeft/-->
        <div class="loginRight">
            <form class="login" action="shopping_index.do" method="post" id="login">
                <label>邮箱/用户名/已验证手机</label>
                <input type="text" class="loginName" name="names"/>
                <label>密码</label>
                <input type="password" class="loginPwd" name="pass"/>
                <div class="jizhu">
                    <input type="checkbox" /> 一周内免登陆 <a href="#">忘记密码</a>
                </div><!--jizhu/-->
                <div class="loginSub">
                    <input type="button" value=" 登 录 " onclick="sub()"/>
                </div><!--loginSub/-->
                <h2>合作伙伴登录：</h2>
                <img src="${ctx}/resource/web/images/hezuo.jpg" width="260" height="30" />
            </form><!--login/-->
        </div><!--loginRight/-->
        <div class="clears"></div>
    </div><!--loginBox/-->
</div><!--mainCont/-->
<script>
    function sub() {
        login("shopping_index.do", "login");
    }
</script>
</body>
</html>
