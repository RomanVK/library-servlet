<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n/messages"/>
<%--TODO make simply apearence--%>
<html lang="${sessionScope.lang}">
<head>
  <title>Users</title>
</head>
<body>
<table>
  <tr valign='top'>
    <td>
      <table>
        <tr><td><%@include file='/parts/header.html'%></td></tr>
        <tr><td><%@include file='/parts/navbar.html'%></td></tr>
        <tr><td>
          <h2>
            <%--                        TODO make i18n--%>
            Users
          </h2>
      </table>
      <p style="color: red;">${errorString}</p>
      <table border="1" cellpadding="5" cellspacing="1" >
        <tr>
          <th>id</th>
          <th>Email</th>
          <th>First name</th>
          <th>Last name</th>
          <c:if test="${roleLoginedUser.equals('ADMIN')}">
              <th>
                BLOCK/ UNBLOCK
              </th>
          </c:if>
          <c:if test="${roleLoginedUser.equals('LIBRARIAN')}">
            <th>
                SEE PROFILE
            </th>
          </c:if>
        </tr>
        <c:forEach items="${users}" var="user" >
          <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <c:if test="${roleLoginedUser.equals('ADMIN')}">
              <td>
                <c:choose>
                  <c:when test="${user.blocked==true}">
                    <a href="unblockUser?id=${user.id}">UNBLOCK</a>
                  </c:when>
                  <c:otherwise>
                    <a href="blockUser?id=${user.id}">BLOCK</a>
                  </c:otherwise>
                </c:choose>
              </td>
            </c:if>
            <c:if test="${roleLoginedUser.equals('LIBRARIAN')}">
              <td>
                <a href="profile?id=${user.id}">SEE PROFILE</a>
              </td>
            </c:if>
          </tr>
        </c:forEach>
      </table>
    </td>
  </tr>
</table>
</body>
</html>
