<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n/messages"/>
<%--TODO make simply apearence--%>
<html lang="${sessionScope.lang}">
<head>
  <title>Librarians</title>
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
            Librarians
          </h2>
        </td></tr>
      </table>
        <p style="color: red;">${errorString}</p>
        <table border="1" cellpadding="5" cellspacing="1" >
          <tr>
            <th>id</th>
            <th>Email</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Delete</th>
          </tr>
          <c:forEach items="${librarians}" var="librarian" >
            <tr>
              <td>${librarian.id}</td>
              <td>${librarian.email}</td>
              <td>${librarian.firstName}</td>
              <td>${librarian.lastName}</td>
              <td>
                <a href="deleteLibrarian?id=${librarian.id}">Delete</a>
              </td>
            </tr>
          </c:forEach>
        </table>
        <a href="createLibrarian" >Create Librarian</a>
    </td>
  </tr>
</table>
</body>
</html>
