<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
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
    <%--<script type="text/javascript" src="${ctx}/resource/pl/js/demo.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="${ctx}/resource/pl/style.css" />
    <script>
        window.UEDITOR_HOME_URL = "/resource/ueditor/";
    </script>
    <script charset="utf-8" src="${ctx}/resource/ueditor/ueditor.config.js"></script>
    <script charset="utf-8" src="${ctx}/resource/ueditor/ueditor.all.js"></script>
    <script src="${ctx}/resource/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="${ctx}/resource/vue/vue.min.1.0.24.js"></script>
    <script type="text/javascript" src="${ctx}/resource/vue/vue-resource.js"></script>
</head>
<style>
    .file1 {
        position: relative;
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
    }

    .file1 input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
    }

    .file1:hover {
        background: #AADFFD;
        border-color: #78C3F3;
        color: #004974;
        text-decoration: none;
    }

    .label {
        float: left;
        text-align: center;
        line-height: 50px;
    }

    .field {
        float: left;
    }

    .input {
        width: 200px;
        margin-right: 25px;

    }

    .myButton {
        -moz-box-shadow: 0px 1px 0px 0px #f0f7fa;
        -webkit-box-shadow: 0px 1px 0px 0px #f0f7fa;
        box-shadow: 0px 1px 0px 0px #f0f7fa;
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #33bdef), color-stop(1, #019ad2));
        background: -moz-linear-gradient(top, #33bdef 5%, #019ad2 100%);
        background: -webkit-linear-gradient(top, #33bdef 5%, #019ad2 100%);
        background: -o-linear-gradient(top, #33bdef 5%, #019ad2 100%);
        background: -ms-linear-gradient(top, #33bdef 5%, #019ad2 100%);
        background: linear-gradient(to bottom, #33bdef 5%, #019ad2 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#33bdef', endColorstr='#019ad2', GradientType=0);
        background-color: #33bdef;
        -moz-border-radius: 6px;
        -webkit-border-radius: 6px;
        border-radius: 6px;
        border: 1px solid #057fd0;
        display: inline-block;
        cursor: pointer;
        color: #ffffff;
        font-family: Arial;
        font-size: 15px;
        font-weight: bold;
        padding: 6px 100px;
        text-decoration: none;
        text-shadow: 0px -1px 0px #5b6178;
    }

    .myButton:hover {
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #019ad2), color-stop(1, #33bdef));
        background: -moz-linear-gradient(top, #019ad2 5%, #33bdef 100%);
        background: -webkit-linear-gradient(top, #019ad2 5%, #33bdef 100%);
        background: -o-linear-gradient(top, #019ad2 5%, #33bdef 100%);
        background: -ms-linear-gradient(top, #019ad2 5%, #33bdef 100%);
        background: linear-gradient(to bottom, #019ad2 5%, #33bdef 100%);
        filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#019ad2', endColorstr='#33bdef', GradientType=0);
        background-color: #019ad2;
    }

    .myButton:active {
        position: relative;
        top: 1px;
    }
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
<body style="background-color: white; position: absolute; top: 0; left: 200px">
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
                <tr>
                    <th width="70">所有人</th>
                    <td>
                        ${bean.user.realName}
                    </td>
                </tr>
                <tr>
                    <th width="70">评价次数</th>
                    <td>
                        ${bean.user.pjcs}
                    </td>
                </tr>
            </table>
        </div>
        <div class="clears"></div>
    </div>

    <div class="buyDtl2">
        <ul class="buydel2Eq">
            <li style="background-color: #00a0e9; color: white" id="buydlList2">图书描述</li>
            <div class="clears"></div>
        </ul>
        <div class="buydlList2" style="display: block">
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
        </div>
    </div>
</div>
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
</div>
<input class="myButton" type="button" value="返回" onclick="javascript:history.go(-1);" style="margin-left: 300px;">
<script src="${ctx}/resource/assets/classie.js"></script>
<script src="${ctx}/resource/assets/dialogFx.js"></script>
<script>


    function onShow(type) {
        if(type == 1){
            $(".buydlList2").show();
            $(".buydlList3").hide();
            $("#buydlList2").css("background-color", "#00a0e9");
            $("#buydlList2").css("color", "white");
            $("#buydlList3").css("background-color", "#f2f2f2");
            $("#buydlList3").css("color", "black");
        } else {
            $(".buydlList2").hide();
            $(".buydlList3").show();
            $("#buydlList3").css("background-color", "#00a0e9");
            $("#buydlList3").css("color", "white");
            $("#buydlList2").css("background-color", "#f2f2f2");
            $("#buydlList2").css("color", "black");
        }
    }
</script>
</body>
</html>