<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>图书详情</title>
    <link type="text/css" href="${ctx}/resource/web/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/resource/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/resource/AJAX.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/assets/normalize.css" />
    <!-- common styles -->
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/assets/dialog.css" />
    <!-- individual effect -->
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/assets/dialog-cathy.css" />
    <script src="${ctx}/resource/assets/modernizr.custom.js"></script>
</head>
<style>
    td{font-size: 12px}
    th{font-size: 12px}
</style>
<script>
    $(function(){
        //.buyimgBig img
        $(".buyimgBig img:first").fadeIn();
        $(".buyimgsmall li:first").addClass("bsi");
        $(".buyimgsmall li").click(function(){
            $(this).addClass("bsi").siblings("li").removeClass("bsi");
            var bsiindex=$(this).index();
            $(".buyimgBig img").eq(bsiindex).fadeIn().siblings(".buyimgBig img").hide();
        })
    })
</script>
<body style="background-color: white">
<div class="hrader" id="header">
    <div class="top">
        <c:if test="${not empty user.realName}"><a href="##" style="color:#C94E13;">欢迎会员:  ${user.realName}</a></c:if>
        <c:if test="${empty user.realName}"><a href="##" style="color:#C94E13;">
        <a href="shopping_login.do" style="color:#C94E13;">请登录</a>
        <a href="shopping_zhuce.do">注册</a>
        </c:if>
        <ul class="topNav">
            <li><a href="shopping_list.do">首页 </a></li>
            <li><a href="bookloan_list.do">我的图书 </a></li>
            <li class="gouwuche"><a href="bookloan_listls.do">历史借阅</a> </li>
            <li><a href="#" class="lan">中文</a></li>
            <li><a href="#" class="lan">English</a></li>
            <div class="clears"></div>
        </ul><!--topNav/-->
    </div><!--top/-->
</div><!--hrader/-->
<div class="mid">
    <h1 class="logo" style="text-align:left;">
        <a href="index.html"><img src="${ctx}/resource/web/images/logo.png" width="304" height="74" /></a>
    </h1>
    <form action="shopping_list.do" method="post" class="subBox">
        <div class="subBox2">
            <input type="text" class="subText" name="name"/>
            <input type="image" src="${ctx}/resource/web/images/sub.jpg" width="95" height="32" class="subImg" />
            <div class="hotci">
            </div><!--hotci/-->
        </div><!--subBox2/-->
    </form><!--subBox/-->
    <div class="ding-gou">
        <div class="ding">
            <a href="theorder_list.do"><img src="${ctx}/resource/web/images/dingdan.jpg" width="106" height="32" /></a>
        </div><!--ding/-->
        <div class="gou">
            <a href="shoppingcart_list.do"><img src="${ctx}/resource/web/images/gouwuche.jpg" width="126" height="32" /></a>
        </div><!--gou/-->
        <div class="clears"></div>
    </div><!--ding-gou/-->
</div><!--mid-->
<div class="navBox navBg1">
    <ul class="nav">
        <li><a href="shopping_list.do">首页</a></li>
        <li><a href="bookloan_list.do">我的图书</a></li>
        <li><a href="bookloan_listls.do">历史借阅</a></li>
        <div class="clears"></div>
    </ul><!--nav/-->
</div><!--navBox/-->
<div class="bn"><img src="${ctx}/resource/web/images/dingzhi.jpg" width="972" height="167" /></div>
<div class="buyinfo">
    <div class="buyDtl">
        <div class="buyDtlLeft">
            <div class="buyimgBig">
                <img src="${ctx}${bean.fileName1}" width="360" height="360" />
                <img src="${ctx}${bean.fileName2}" width="360" height="360" />
                <img src="${ctx}${bean.fileName3}" width="360" height="360" />
                <img src="${ctx}${bean.fileName4}" width="360" height="360" />
                <img src="${ctx}${bean.fileName5}" width="360" height="360" />
            </div><!--buyimgBig/-->
            <ul class="buyimgsmall">
                <li><img src="${ctx}${bean.fileName1}" width="50" height="50" /></li>
                <li><img src="${ctx}${bean.fileName2}" width="50" height="50" /></li>
                <li><img src="${ctx}${bean.fileName3}" width="50" height="50" /></li>
                <li><img src="${ctx}${bean.fileName4}" width="50" height="50" /></li>
                <li><img src="${ctx}${bean.fileName5}" width="50" height="50" /></li>
            </ul><!--buyimgsmall/-->
        </div><!--buyDtlLeft/-->
        <div class="buyDtlRight">
            <h3>${bean.name}</h3>
            <table class="buyTable">
                <tr>
                    <th width="70" >图书编号</th>
                    <td>${bean.id}</td>
                </tr>
                <tr>
                    <th width="70">图书类型</th>
                    <td>
                        <ul class="buyji">
                            <li>${bean.itemTypeSecondary.name}</li>
                            <div class="clears"></div>
                        </ul><!--buyji/-->
                    </td>
                </tr>
                <tr>
                    <th width="70">借阅次数</th>
                    <td>
                        ${bean.count}
                    </td>
                </tr>
            </table><!--buyTable/-->
        </div><!--buyDtlRight/-->
        <div class="clears"></div>
    </div><!--buyDtl/-->
    <div class="buyDtl2">
        <ul class="buydel2Eq">
            <li>图书描述</li>
            <div class="clears"></div>
        </ul><!--buydel2Eq/-->
        <div class="buydlList2">
            <table cellpadding="0" cellspacing="1" width="100%" border="0" class="Ptable">
                <tr>
                <tr><tr><td class="tdTitle">图书编号</td>
                <td>${bean.id}</td>
            </tr>
                <tr>
                    <td class="tdTitle">图书类型</td>
                    <td>${bean.itemTypeSecondary.name}</td>
                </tr>
                <tr>
                    <td class="tdTitle">图书描述</td>
                    <td>${bean.js}</td>
                </tr>
                </table>
            <img src="${ctx}${bean.fileName1}" alt=""/>
            <img src="${ctx}${bean.fileName2}" alt=""/>
            <img src="${ctx}${bean.fileName3}" alt=""/>
            <img src="${ctx}${bean.fileName4}" alt=""/>
            <img src="${ctx}${bean.fileName5}" alt=""/>
        </div><!--buydlList/-->
    </div><!--buyDtl2/-->
</div><!--buyinfo/-->
<div class="container">
    <div class="content">
        <div id="somedialog" class="dialog">
            <div class="dialog__overlay"></div>
            <div class="dialog__content">
                <h2><strong id="xinxi"></strong></h2><div>
                <a href="" id="tiaoz"><button class="action buy-mai" data-dialog-close>关闭</button></a>
            </div>
            </div>
        </div>
    </div><!-- /content -->
</div><!-- /container -->
<div class="button-wrap" style="display: none">
    <button data-dialog="somedialog" class="buy-mai" id="somedialogs"></button>
</div>
<script src="${ctx}/resource/assets/classie.js"></script>
<script src="${ctx}/resource/assets/dialogFx.js"></script>
<script>
    function addG(id) {
        $.ajax({
            cache: false,
            type: "post",
            url: "goods_loan.do",
            data:{id: id},// 你的formid
            async: false,
            success: function(data){
                console.log(data)
                if (!data.flag){
                    alert(data.flag)
                    $('#somedialogs').click();
                    $('#xinxi').html("请先登陆");
                    $('#tiaoz').attr("href","shopping_login.do");
                } else {
                    $('#somedialogs').click();
                    $('#xinxi').html("借阅申请提交成功等待所有人确认")
                    $('#tiaoz').attr("href","bookloan_list.do");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            }
        });
    }

    (function() {
        var dlgtrigger = document.querySelector( '[data-dialog]' ),
                somedialog = document.getElementById( dlgtrigger.getAttribute( 'data-dialog' ) ),
                dlg = new DialogFx( somedialog );
        dlgtrigger.addEventListener( 'click', dlg.toggle.bind(dlg) );

    })();
</script>
</body>
</html>
