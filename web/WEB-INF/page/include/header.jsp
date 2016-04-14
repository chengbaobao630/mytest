<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2015/12/17 0017
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basepath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="content-language" content="utf-8"/>
    <jsp:include page="/WEB-INF/page/include/script.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/page/include/css.jsp"></jsp:include>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        #userChoose{
            position:relative;
        }
        #userChoose:hover  .chooseCont{
            display: block;
        }
        .chooseCont{
            display: none;
            position: absolute;
            z-index: 2;
            list-style: none;
        }
        .chooseCont li{
            text-align: center;
            width: 60px;
            font-size: 10px;
            padding:0 8px;
            background-color:black;
            border-bottom: 1px #fff solid;
            line-height: 35px;
        }
        #userChoose .chooseCont li a{
            color:#fff;
        }
        #userChoose .chooseCont li a:hover{
            color:#fff;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="navbar-wrapper" style="position: fixed;z-index: 999;width: 100%;height:45px;top: 0px; ">
    <div class="container">
        <div class="navwrapper">
            <div class="navbar navbar-inverse navbar-static-top" style="background-color: black;">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Cc-Home</a>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="menuItem"><a href="${basepath}/welcome.html">Home</a></li>
                            <li class="menuItem"><a href="#features">Features</a></li>
                            <li class="menuItem"><a href="#updates">Updates</a></li>
                            <li class="menuItem"><a href="#installation">Installation</a></li>
                            <li class="menuItem"><a href="#one-pager">One Pager</a></li>
                            <li class="menuItem"><a href="#extras">Extras</a></li>
                            <li class="menuItem"><a href="#wordpress">Wordpress</a></li>
                            <li class="menuItem"><a href="#contact">Contact</a></li>
                        </ul>
                        <div id="userChoose"  style="line-height: 50px;font-size: 12px;float: right;position: relative;white-space: nowrap;padding-right: 50px;color: black">你好，
                            <a >${user.name}
                                <ul class="chooseCont">
                                    <li ><a href="${basepath}/user/my.html">个人中心</a></li>
                                    <li><a href="#">我的收藏</a></li>
                                    <li><a href="#">点了白点</a></li>
                                    <li><a href="${basepath}/logout.html">退出</a></li>
                                </ul>
                            </a>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>

</body>
</html>
