<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>购物首页</title>
    <link type="text/css" href="${ctx}/resource/web/css/css.css" rel="stylesheet" />
    <script type="text/javascript" src="${ctx}/resource/web/js/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/resource/web/js/js.js"></script>
    <link rel="shortcut icon" href="../favicon.ico">
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/assets/normalize.css" />
    <!-- common styles -->
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/assets/dialog.css" />
    <!-- individual effect -->
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/assets/dialog-cathy.css" />
    <script src="${ctx}/resource/assets/modernizr.custom.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>
    <script src="${ctx}/resource/AJAX.js" type="text/javascript"></script>
</head>
<script>
    $(function () {
        if (${login} == 1){
            top.location = 'shopping_login.do';
        }
    })
</script>
<body>
<div class="hrader" id="header">
    <div class="top">
        <c:if test="${not empty user.realName}"><a href="##" style="color:#C94E13;">欢迎会员:  ${user.realName}</a></c:if>
        <c:if test="${empty user.realName}">
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
<form action="shopping_list.do" method="post" class="proDingzhi" id="sub">
    <input type="hidden" name="itemTypeSecondary.id" id="id"/>
    <img src="${ctx}/resource/web/images/dingzhi.jpg" width="972" height="167" />
    <div class="bdsharebuttonbox">
        <a href="#" class="bds_more" data-cmd="more"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
    <table class="proDSel" style="font-size: 12px">

<c:forEach items="${itemType.datas}" var="c" varStatus="l">
            <tr>
             <th><h3>${c.name}</h3></th>
            <td>
                <div class="proPosition">
                    <ul class="xuan">
                        <c:forEach items="${itemTypelist.datas}" var="b" varStatus="l">
                        <c:if test='${c.id == b.itemType.id}'>
                            <li>
                                    <input type="checkbox" value="${b.id}" name="type" id="${b.id}"/>
                                <a href="#" onclick="sub(${b.id})">${b.name}</a>
                            </li>
                        </c:if>
                        </c:forEach>
                        <div class="clearfix"></div>
                    </ul><!--xuan/-->
                    <span class="duoxuan">多选 </span><!--duoxuan/-->
                    <input type="submit" src="${ctx}/resource/web/images/queding.png" class="queen2" />
                    <div class="more-shou"><span class="more">更多 &gt;</span>
                        <span class="shou">收起 &gt;</span>
                    </div><!--more-shou/-->
                </div>
            </td>
        </tr>
</c:forEach>
    </table><!--proDSel/-->
    <div style="height:15px;">&nbsp;</div>
    <ul class="proSelect">
        <li>图书名称</li>
        <li>借阅时间</li>
        <li>是否借阅</li>
        <li>图书所有人电话</li>
        <li>图书状态</li>
        <li>去评论</li>
        <div class="clears"></div>
    </ul><!--proSelect/-->
<c:forEach items="${pagers.datas}" var="b" varStatus="l">
    <ul class="proSelect" style="border-top: none;">
        <a href="shopping_detail.do?id=${b.goods.id}"><li>${b.goods.name}</li></a>
        <li>${b.time}</li>
        <li> <c:if test='${b.isYj == 0}'>未借</c:if>
            <c:if test='${b.isYj == 1}'>已借</c:if>
            <c:if test='${b.isYj == 2}'>拒绝</c:if>
        </li>
        <a href="##"><li>${b.goods.user.phone}</li></a>
            <li>
                <c:if test='${b.isYj == 3}'><a href="##">已经归还图书</a></c:if>
            </li>
        <li><c:if test='${b.isYj == 1 || b.isYj == 3}'><a href="shopping_edit.do?id=${b.goods.id}">现在去</a></c:if></li>
        <div class="clears"></div>
    </ul><!--proSelect/-->
    </c:forEach>
</form><!--proDingzhi/-->
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
function sub(id) {
    $('#id').val(id);
    $('#sub').submit();
}
    function cart(id) {
        $.ajax({
            cache: false,
            type: "post",
            url: "goods_loan.do",
            data:{id: id},// 你的formid
            async: false,
            success: function(data){
                if (!data.flag){
                    $('#somedialogs').click();
                    $('#xinxi').html("请先登陆");
                    $('#tiaoz').attr("href","shopping_login.do");
                } else {
                    $('#somedialogs').click();
                    $('#xinxi').html("借阅申请提交成功等待所有人确认")
                    $('#tiaoz').attr("href","##");
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                }
            }
        });
    }

function edit(id, bookLoanId) {
    layer.confirm('确认要还书吗？', function () {
        updateId('goods_back.do', '还书成功', id)
        $.ajax({
            cache: false,
            type: "post",
            url: "goods_back.do",
            data:{id: id, bookLoanId: bookLoanId},// 你的formid
            async: false,
            success: function(data){
                if (data.flag){
                    layer.msg("还书成功", {
                        icon: 1,
                        time: 2000 //2秒关闭（如果不配置，默认是3秒）
                    }, function(){
                        shuaxin2();
                        window.location.href = data.url;
                    });
                }
            }
        });
    });
}

function shou(id) {
    layer.confirm('确认收到图书了吗？', function () {
        updateId('goods_backs.do', '操作成功', id)
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
