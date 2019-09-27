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
    td{font-size: 12px}
    th{font-size: 12px}

</style>
<script>
    $(function(){
        // 初始化消息输入框
        var um = UE.getEditor('myEditor');
    })

</script>
<body style="background-color: white">
<div class="buyinfo" style="float: left; margin-left: 5px">
    <div class="buyDtl">
        <div class="clears"></div>
    </div><!--buyDtl/-->

    <div class="buyDtl2">
        <ul class="buydel2Eq">
            <li onclick="onShow(1)" style="background-color: #00a0e9; color: white" id="buydlList2">图书描述</li>
            <li onclick="onShow(2)" id="buydlList3">评论</li>
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
        <%--评论--%>
        <div class="buydlList3" style="display: none">
            <%--评论开始--%>
            <div id="list">
                <div class="box clearfix" v-for="item in comments">
                    <a class="close" href="javascript:;">×</a>
                    <img class="head" src="${ctx}/resource/pl/images/1.jpg" alt=""/>
                    <div class="content">
                        <div class="main">
                            <p class="txt">
                                <span class="user">{{item.jyUser.realName}}：<button class="btn" @click="plus(item.id)" style="background-color: #00a0e9; width: 50px; height: 20px; color: white; float: right" >回 复</button></span>
                                <span v-html="item.nr"></span>
                            </p>
                            <%--<img class="pic" src="${ctx}/resource/pl/images/img1.jpg" alt=""/>--%>
                        </div>
                        <div class="info clearfix">
                            <span class="time">{{item.time.time | time}}</span>
                        </div>
                        <div class="{{item.id}}a">
                            <div class="comment-list" v-for="items in replyComments" v-if="item.id == items.comments.id">
                            <div class="comment-box clearfix" user="self">
                                <img class="myhead" src="${ctx}/resource/pl/images/my.jpg" alt=""/>
                                <div class="comment-content">
                                    <p class="comment-text"><span class="user">{{items.user.realName}}：</span><span v-html="items.nr"></span></p>
                                    <p class="comment-time">
                                        {{items.time.time | time}}
                                        <%--<a href="javascript:;" class="comment-operate">删除</a>--%>
                                    </p>
                                </div>
                            </div>
                        </div>
                        </div>
                        <%--<div class="{{styles}}" @click="plus">--%>
                            <%--&lt;%&ndash;<textarea class="comment" id="{{item.id}}" autocomplete="on">{{nr}}</textarea>&ndash;%&gt;--%>
                            <%--<button class="btn" @click="save(item.id)">回 复</button>--%>
                            <%--&lt;%&ndash;<span class="word"><span class="length">0</span>/140</span>&ndash;%&gt;--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
            <%--评论结束--%>


        </div>

    </div>
</div>
<div class="container">
    <div class="content">
        <div id="somedialog" class="dialog">
            <div class="dialog__overlay"></div>
            <div class="dialog__content" style="width: 80%; height: auto">
                    <%--editor--%>
                    <div class="chat-content">
                        <div class="am-g am-g-fixed chat-content-container">
                            <div class="am-u-sm-12">
                                <ul id="message-list" class="am-comments-list am-comments-list-flip"></ul>
                            </div>
                        </div>
                    </div>
                    <div class="message-input am-margin-top">
                        <div class="am-g am-g-fixed">
                            <div class="am-u-sm-12">
                                <form class="am-form" id="am-form">
                                    <div class="am-form-group">
                                        <script type="text/plain" id="myEditor" name="nr" style="width: 100%;height: 8rem;"></script>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <input type="hidden" id="pf"/>
                        <div id="star">
                            <span>评论打分</span>
                            <ul>
                                <li><a href="javascript:;">1</a></li>
                                <li><a href="javascript:;">2</a></li>
                                <li><a href="javascript:;">3</a></li>
                                <li><a href="javascript:;">4</a></li>
                                <li><a href="javascript:;">5</a></li>
                            </ul>
                            <span></span>
                            <p></p>
                        </div><!--star end-->
                        <div class="am-g am-g-fixed am-margin-top">
                            <div class="goumai">
                                <a href="##" @click="edit" class="buy-gou">发表评论</a>
                            </div>
                        </div>
                    </div>
                    <%--editor--%>
                    <div>
                <button class="action buy-mai" id="avc" data-dialog-close>关闭</button>
            </div>
            </div>
        </div>
    </div><!-- /content -->
</div>
<div class="button-wrap" style="display: none">
    <button data-dialog="somedialog" class="buy-mai" id="somedialogs"></button>
</div>
<script src="${ctx}/resource/assets/classie.js"></script>
<script src="${ctx}/resource/assets/dialogFx.js"></script>
<script>
    window.onload = function (){
        var oStar = document.getElementById("star");
        var aLi = oStar.getElementsByTagName("li");
        var oUl = oStar.getElementsByTagName("ul")[0];
        var oSpan = oStar.getElementsByTagName("span")[1];
        var oP = oStar.getElementsByTagName("p")[0];
        var i = iScore = iStar = 0;
        var aMsg = [
            "很不满意",
            "不满意",
            "一般",
            "满意",
            "非常满意"
        ]
        for (i = 1; i <= aLi.length; i++){
            aLi[i - 1].index = i;
            //鼠标移过显示分数
            aLi[i - 1].onmouseover = function (){
                fnPoint(this.index);
                //浮动层显示
                oP.style.display = "block";
                //计算浮动层位置
                oP.style.left = oUl.offsetLeft + this.index * this.offsetWidth - 104 + "px";
                //匹配浮动层文字内容
                oP.innerHTML = "<em><b>" + this.index + "</b> 分 " + aMsg[this.index - 1].match(/(.+)\|/)[1] + "</em>" + aMsg[this.index - 1].match(/\|(.+)/)[1]
            };
            //鼠标离开后恢复上次评分
            aLi[i - 1].onmouseout = function (){
                fnPoint();
                //关闭浮动层
                oP.style.display = "none"
            };
            //点击后进行评分处理
            aLi[i - 1].onclick = function (){
                iStar = this.index;
                $('#pf').val(iStar)
                oP.style.display = "none";
                oSpan.innerHTML = "<strong>" + (this.index) + " 分</strong> (" + aMsg[this.index - 1].match(/\|(.+)/)[1] + ")"
            }
        }
        //评分处理
        function fnPoint(iArg){
            //分数赋值
            iScore = iArg || iStar;
            for (i = 0; i < aLi.length; i++) aLi[i].className = i < iScore ? "on" : "";
        }

    };

    Vue.filter('time', function (value) {
        function add0(m) {
            return m < 10 ? '0' + m : m
        }
        var time = new Date(parseInt(value));
        var y = time.getFullYear();
        var m = time.getMonth() + 1;
        var d = time.getDate();
        var f = time.getMinutes();
        var mm = time.getSeconds();
        return y + '年' + add0(m) + '月' + add0(d) + "日 " + add0(f) + "分" + add0(mm) + "秒";
    })

    var demo2 = new Vue({
        el: 'body',
        data () {
            return {
                comments: [],
                replyComments: [],
                url: 'comments_list.do',
                user:'',
                styles:'text-box',
                nr:'评论…',
                userCommentsId:'${userCommentsId}',
                itemId:'',
                goodsId:'${goodsId}'
            }
        },
        ready: function () {
            this.$nextTick(function () {
                this.form()
            })
        },
        methods: {
            plus: function (id) {
                $('#somedialogs').click();
                this.itemId = id
            },
            form: function () {
                console.log(this.goodsId)
                this.$http.get(this.url, {goodsId: this.goodsId}).then(function (response) {
                    this.comments = response.data.list
                    this.replyComments = response.data.reply
                    this.user = response.data.user
                }).catch(function (response) {
                })
            },
            edit: function () {
                var pf = $('#pf').val();
                var nr  = UE.getEditor('myEditor').getContent().trim();
                if (nr != null && nr != "" && pf != null && pf != ""){
                    this.$http.get("usercomments_saves.do", {commentsId: this.itemId, nrs:nr, pfs:pf, id:this.userCommentsId}).then(function (response) {
                        layer.msg('回复成功', {offset: '400px'});
                        $('#avc').click();
                        this.$nextTick(function () {
                            this.form()
                        })
                    }).catch(function (response) {
                    })
                } else {
                    layer.msg('请填写完整信息', {offset: '400px'});
                }
            },
        },
    })
</script>
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
<script>
    function addG(id) {
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
