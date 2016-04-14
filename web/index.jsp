<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2015/12/2 0002
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/page/include/taglibs.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="content-language" content="utf-8"/>
    <jsp:include page="/WEB-INF/page/include/css.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/page/include/script.jsp"></jsp:include>

    <title>My website</title>
</head>
<body>
        <c:choose>
         <c:when test="${(signSuc == null ||  signSuc == true )&& login == null}">
            <div id="login">
         </c:when>
          <c:otherwise>
             <div id="login" style="display: none">
          </c:otherwise>
        </c:choose>
        <form id="loginForm" class="form-horizontal" role="form" action="login.html" style="margin-top: 10%;width: 40%">
            <div class="form-group">
                <label for="account" class="col-sm-2 control-label">账号</label>

                <div class="col-sm-10">
                    <input type="text" class="form-control" id="account" name="account"
                           placeholder="账号">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password"
                           placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> 请记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div style="white-space: nowrap" class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                    <a href="#" onclick="toSignUp()" class="hyperlink" style="font-size: 16px">注册</a>
                </div>
            </div>
        </form>
    </div>

             <c:choose>
             <c:when test="${(signSuc == null ||  signSuc == true )&& login == null}">
             <div id="signUp" style="display: none">
                 </c:when>
                 <c:otherwise>
                 <div id="signUp" >
                     </c:otherwise>
                     </c:choose>
            <form id="signUpForm" class="form-horizontal" role="form" action="toSign.html" style="margin-top: 10%;width: 40%">
                <div class="form-group">
                    <label for="account4sign" class="col-sm-2 control-label">账号</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="account4sign" name="account4sign"
                               placeholder="账号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password4sign" class="col-sm-2 control-label">密码</label>

                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="password4sign" name="password4sign"
                               placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="conform_password4sign" class="col-sm-2 control-label">确认密码</label>

                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="conform_password4sign"
                               name="conform_password4sign"
                               placeholder="确认密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name4sign" class="col-sm-2 control-label">姓名</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name4sign" name="name4sign"
                               placeholder="姓名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="name4sign" class="col-sm-2 control-label">验证码</label>
                    <div class="col-sm-10">
                        <input style="width: 200px;float: left" type="text" class="form-control" id="captcha" name="captcha"
                               placeholder="验证码">
                    <img style="float: left"  width="100px" height="34px" src="${basepath}/getCaptchaImg.do" onclick="this.src=this.src+'?'">
                    </div>
                </div>
                <div class="form-group">
                    <div style="white-space: nowrap" class="col-sm-offset-2 col-sm-10">
                        <button id="submit4signUp" name="submit4signUp" type="submit" value="submit4signUp" class="btn btn-default">注册</button>
                        <!-- <input id="submit4signUp" type="submit"  value="注册" class="btn btn-default"/>-->
                         <a href="#" onclick="toLogin()" class="hyperlink" style="font-size: 16px">登陆</a>
                     </div>
                 </div>
             </form>
                          </div>
         <script type="text/javascript">
             function login() {
                 var name = $("#name").val();
                 var password = $("#password").val();
                 $.ajax({
                     url: "login.html",
                     type: "POST",
                     dataType: "JSON",
                     data: {
                         "name": name,
                         "password": password
                     },
                     success: function (data) {
                         alert("as");
                     }
                 });
             }
             function signUp() {
                 alert("asd");
                 var account4sign = $("#account4sign").val();
                 var conform_password4sign = $("#conform_password4sign").val();
                 var name4sign = $("#name4sign").val();
                 $.ajax({
                     url: "index.html",
                     type: "POST",
                     dataType: "JSON",
                     data: {
                         "form":"signUp",
                         "account4sign": account4sign,
                         "conform_password4sign": conform_password4sign,
                         "name4sign": name4sign
                     },
                     success: function (data) {
                         alert("as");
                     }
                 });
             }

             function toSignUp() {
                 $("#login").fadeOut("slow", function () {
                     $("#signUp").css("display", "block");
                     $("#signUp").fadeIn("slow");
                 });
             }
             function toLogin() {
                 $("#signUp").fadeOut("slow", function () {
                     $("#login").css("display", "block");
                     $("#login").fadeIn("slow");
                 });
             }
             $(function () {
                 $("#signUpForm").bootstrapValidator({
                     message: 'This value is not valid',
                     feedbackIcons: {
                         valid: 'glyphicon glyphicon-ok',
                         invalid: 'glyphicon glyphicon-remove',
                         validating: 'glyphicon glyphicon-refresh'
                     },
                     fields: {
                         account4sign: {
                             trigger: "blur",
                             validators: {
                                 notEmpty: {
                                     message: 'The title is required'
                                 },
                                 remote: {
                                     message: 'The username is not available',
                                     url: 'verifyAccount.html',
                                     data: function (validator) {
                                         return {
                                             'account': validator.getFieldElements('account4sign').val()
                                         };
                                     }
                                 }
                             }
                         },
                         password4sign: {
                             validators: {
                                 notEmpty: {
                                     message: 'The title is required'
                                 },
                                 different: {
                                     field: 'account4sign',
                                     message: 'The username and password cannot be the same as each other'
                                 }
                             }
                         },
                         conform_password4sign: {
                             validators: {
                                 notEmpty: {
                                     message: 'The title is required'
                                 },
                                 identical: {
                                     field: 'password4sign',
                                     message: 'The password and its confirm are not the same'
                                 }
                             }
                         },
                         name4sign: {
                             validators: {
                                 notEmpty: {
                                     message: 'The title is required'
                                 }
                             }
                         },
                         captcha: {
                             validators: {
                                 notEmpty: {
                                     message: 'The title is required'
                                 },
                                 remote: {
                                     message: 'wrong captcha',
                                             url: 'verifyCaptcha.html',
                                             data: function (validator) {
                                         return {
                                             'captcha': validator.getFieldElements('captcha').val()
                                         };
                                     }
                                 }
                             }
                         }
                     }
                 });
             });

         </script>
 </body>
 </html>
