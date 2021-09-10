<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n/messages"/>
<%--TODO make simply apearence--%>
<html lang="${sessionScope.lang}">
<head>
    <title>Catalog</title>
</head>
<body>
<table>
    <tr valign='top'>
        <td>
            <table>
                <tr>
                    <td>
                        <%@include file='/parts/header.html' %>
                    </td>
                </tr>
                <tr>
                    <td>
                        <%@include file='/parts/navbar.html' %>
                    </td>
                </tr>
                <tr>
                    <td>
                        <h2>
                            <%--                        TODO make i18n--%>
                            Catalog
                        </h2>
                    </td>
                </tr>
            </table>
            <p style="color: red;">${errorString}</p>
            <table border="1" cellpadding="5" cellspacing="1">
                <tr>
                    <th>id</th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Publisher</th>
                    <th>Publishing date</th>
                    <th>ISBN</th>
                    <th>Quantity</th>
                    <c:if test="${roleLoginedUser.equals('ADMIN')}">
                        <th>
                            EDIT
                        </th>
                    </c:if>
                    <c:if test="${roleLoginedUser.equals('USER')}">
                        <th>
                            ORDER
                        </th>
                    </c:if>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.publisher}</td>
                        <td>${book.publishingDate}</td>
                        <td>${book.ISBN}</td>
                        <td>${book.quantity}</td>
                        <c:if test="${roleLoginedUser.equals('ADMIN')}">
                            <td><a href="editBook?id=${book.id}">EDIT</a></td>
                        </c:if>
                        <c:if test="${roleLoginedUser.equals('USER')}">
                            <td><a href="orderBook?id=${book.id}">ORDER</a></td>
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
