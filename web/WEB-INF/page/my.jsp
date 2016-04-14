<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2015/12/18 0018
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/page/include/taglibs.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="content-language" content="utf-8"/>
    <jsp:include page="/WEB-INF/page/include/script.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/page/include/css.jsp"></jsp:include>
    <script src="${basepath }/js/fileupload/vendor/jquery.ui.widget.js"></script>
    <script src="${basepath }/js/fileupload/jquery.fileupload.js"></script>
    <script src="${basepath }/js/fileupload/jquery.iframe-transport.js"></script>
    <link rel="stylesheet" href="${basepath}/css/fileupload/jquery.fileupload.css">
    <title>My</title>
</head>
<body>
<jsp:include page="/WEB-INF/page/include/header.jsp"></jsp:include>
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
<div id="container" style="margin-top:85px;width: 100%;">
    <div onload="reset()" style="margin-left:20%;width: 500px;float: left">
    <form role="form" method="post"  action="uploadFiles.html" enctype="multipart/form-data" target="hidden_frame">
        <div class="form-group">
            <label for="name">名称</label>
            <input type="text" class="form-control" id="name" name="fileName"
                   placeholder="请输入名称">
        </div>
        <div class="form-group">
            <label for="inputfile">文件输入</label>
            <input name="file" type="file" id="inputfile">
            <p class="help-block">这里是块级帮助文本的实例。</p>
        </div>
        <span class="btn btn-success fileinput-button">
        <i class="glyphicon glyphicon-plus"></i>
        <span>Select files...</span>
            <!-- The file input field used as target for the file upload widget -->
        <input id="fileupload" type="file" name="files[]" multiple="">
         </span>
        <button type="submit" class="btn btn-primary start">
            <i class="glyphicon glyphicon-upload"></i>
            <span>Start upload</span>
        </button>
        <div class="checkbox">
            <label>
                <input name="isPublic" type="checkbox"> 是否共享
            </label>
        </div>
        <button type="submit" class="btn btn-default">提交</button>
    </form>

</div>
    <div id="resourceList" style="float: left;margin-left: 10%">

    </div>

</div>


</body>
<script type="text/javascript" src="${basepath }/js/user/my.js" charset="gbk"></script>
</html>
