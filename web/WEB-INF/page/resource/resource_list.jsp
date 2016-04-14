<%--
  Created by IntelliJ IDEA.
  User: cheng
  Date: 2016/1/7 0007
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/page/include/taglibs.jsp"%>
<table>
    <thead>
        <tr>
            <th align="left">
                <c:if test="${pagefn.no!=1}">
                <a href="#" onclick="page(${pagefn.no -1})">←</a>
                </c:if>
            </th>
            <th colspan="2" style="text-align: center">
                <select id="page" name="page" onchange="page(0)">
                    <c:forEach var="i" begin="1" end="${pagefn.totalPage}">
                        <c:if test="${i==pagefn.no}">
                            <option value="${i}" selected>${i}</option>
                        </c:if>
                        <c:if test="${i!=pagefn.no}">
                            <option value="${i}">${i}</option>
                        </c:if>

                    </c:forEach>

                </select>
            </th>
            <th style="text-align: right">
                <c:if test="${pagefn.no!=pagefn.totalPage}">
                    <a href="#" onclick="page(${pagefn.no +1})">→</a>
                </c:if>

            </th>
        </tr>
        <tr>
            <th class="sorting" width="50">编号</th>
            <th class="sorting" width="100">文件名</th>
            <th class="sorting" width="100">大小</th>
            <th class="sorting" width="50">操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="s" items="${resources}" varStatus="st">
        <tr class="gradeA <c:out value="${st.index%2==0?'even':'odd' }"/>">
            <td>
                ${st.index+1}
            </td>
            <td>
                ${s.name}
            </td>
            <td>
                ${s.size}
            </td>
            <td>
                <a href="downLoadFile.html?fileName=${s.name}">下载</a>
            </td>

        </tr>
        </c:forEach>
    </tbody>
</table>