<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2015/12/2 0002
  Time: 15:32
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
    <title>Welcome</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/page/include/header.jsp"></jsp:include>
    <div id="container" style="margin-top:85px;width: 100%;">
      <form id="importUserForm" action="importUser.do" enctype="multipart/form-data" method="post">
        <input type="file" name="file"  id="importUser" multiple>
        <input type="button" onclick="checkFile()" value="submit">
        <button onclick="checkFile()">submit</button>
      </form>
        <input name="input" onblur="checkInput()" value="123456">
        <input type="button" onclick="checkInput()" value="check">
    </div>
   </body>
<script type="text/javascript">
    function checkFile () {
        var fileNmae=$("#importUser").val();
        var allowedSufix={".xls":true,".xlsx":true};
        if(allowedSufix[fileNmae.substr(fileNmae.lastIndexOf("."),fileNmae.length)]){
              $("#importUserForm").submit();
        }else{
          alert("flase");
        }
    }
    function checkInput() {
        var inputValue=document.getElementsByTagName("input")["input"].value;
        var emptyInput=/^[\s]{0,}$/;
        var year=/(^[12]?\d{0,3})[-./][01][1-9][-./]([012][0-9]|[3][01])$/;
        if (emptyInput.test(inputValue)){
            console.log("empty input");
        }else if (year.test(inputValue)){
            console.log("currect year");
        }else{
            inputValue=inputValue.replace(/\s/g,"");
            console.log(inputValue);
        }

    }
</script>
</html>
