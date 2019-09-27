<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>网站信息</title>
    <link rel="stylesheet" href="${ctx}/resource/css/pintuer.css">
    <link rel="stylesheet" href="${ctx}/resource/css/admin.css">
    <script src="${ctx}/resource/js/jquery2.js"></script>
    <script src="${ctx}/resource/js/pintuer.js"></script>
    <script src="${ctx}/resource/AJAX.js"></script>
    <script src="${ctx}/resource/assets/layer/layer.js" type="text/javascript"></script>

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
        padding: 6px 24px;
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
<body>
<div class="panel admin-panel">
    <div class="panel-head">
        <div class="body-content">
            <form method="post" class="form-x" id="form" action="goods_save.do" enctype="multipart/form-data" onsubmit="myFrom()">
                <div class="form-group">
                    <div class="label">
                        <label>图书名称：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input w50" name="name" id="name"/>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图片1：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input tips" id="file1" style="width:25%; float:left;" value=""
                               data-toggle="hover" data-place="right" data-image=""/>
                        <a href="javascript:;" class="file1" id="zp1" style="margin-left: 20px; margin-top: 5px">选择文件
                            <input type="file" name="file" id="zp">
                        </a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图片2：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input tips" id="file2" style="width:25%; float:left;" value=""
                               data-toggle="hover" data-place="right" data-image=""/>
                        <a href="javascript:;" class="file1" id="zp2" style="margin-left: 20px; margin-top: 5px">选择文件
                            <input type="file" name="file">
                        </a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图片3：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input tips" id="file3" style="width:25%; float:left;" value=""
                               data-toggle="hover" data-place="right" data-image=""/>
                        <a href="javascript:;" class="file1" id="zp3" style="margin-left: 20px; margin-top: 5px">选择文件
                            <input type="file" name="file">
                        </a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图片4：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input tips" id="file4" style="width:25%; float:left;" value=""
                               data-toggle="hover" data-place="right" data-image=""/>
                        <a href="javascript:;" class="file1" id="zp4" style="margin-left: 20px; margin-top: 5px">选择文件
                            <input type="file" name="file">
                        </a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图片5：</label>
                    </div>
                    <div class="field">
                        <input type="text" class="input tips" id="file5" style="width:25%; float:left;" value=""
                               data-toggle="hover" data-place="right" data-image=""/>
                        <a href="javascript:;" class="file1" id="zp5" style="margin-left: 20px; margin-top: 5px">选择文件
                            <input type="file" name="file">
                        </a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图书介绍：</label>
                    </div>
                    <div class="field">
                        <textarea class="input" name="js" id="js" data-validate="required:图书介绍" style="width: 500px; height: 160px"></textarea>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="label">
                        <label>图书分类：</label>
                    </div>
                    <div class="field">
                        <select name="itemTypeSecondary.id" class="input w50" id="itemTypeSecondaryId">
                            <option value="">请选择分类</option>
                            <c:forEach items="${pagers.datas}" var="c" varStatus="l">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
                <div class="" style=" text-align:center">
                    <input class="myButton" type="submit" value="提交" >
                </div>
            </form>
        </div>
    </div>
    <script>
        function myFrom() {
            var name = $('#name').val();
            var zp = $('#zp').val();
            var itemTypeSecondaryId = $('#itemTypeSecondaryId').val();
            if (name == null || name == "" || zp == null || zp == "" || itemTypeSecondaryId == null || itemTypeSecondaryId == "") {
                alert("填写完整信息后提交")
                return false
            }
        }
        $("#zp1").on("change", "input[type='file']", function () {
            var filePath = $(this).val();
            var filePath = filePath.split('\\');
            var filePath = filePath[filePath.length - 1];
            $('#file1').val(filePath);
        })
        $("#zp2").on("change", "input[type='file']", function () {
            var filePath = $(this).val();
            var filePath = filePath.split('\\');
            var filePath = filePath[filePath.length - 1];
            $('#file2').val(filePath);
        })
        $("#zp3").on("change", "input[type='file']", function () {
            var filePath = $(this).val();
            var filePath = filePath.split('\\');
            var filePath = filePath[filePath.length - 1];
            $('#file3').val(filePath);
        })
        $("#zp4").on("change", "input[type='file']", function () {
            var filePath = $(this).val();
            var filePath = filePath.split('\\');
            var filePath = filePath[filePath.length - 1];
            $('#file4').val(filePath);
        })
        $("#zp5").on("change", "input[type='file']", function () {
            var filePath = $(this).val();
            var filePath = filePath.split('\\');
            var filePath = filePath[filePath.length - 1];
            $('#file5').val(filePath);
        })
    </script>
</body>
</html>