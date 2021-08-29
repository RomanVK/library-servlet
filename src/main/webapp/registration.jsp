<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n/messages"/>
<%--TODO make simply apearence--%>
<html  lang="${sessionScope.lang}">
<head>
    <title>Registration form</title>
</head>
<body>
<table>
    <tr valign='top'>
        <td>
            <table>
                <tr><td><%@include file='parts/header.html'%></td></tr>
                <tr><td><%@include file='parts/navbar.html'%></td></tr>
                <tr><td>
                    <h2>
                        <fmt:message key="label.registration.form" />
                    </h2>
                </td></tr>
                <tr><td>
                    <form method="POST" action="${pageContext.request.contextPath}/api/registration">
                        Email:<input type="text" name="email"/><br/>
                        First name:<input type="text" name="first_name" /><br/>
                        Last name:<input type="text" name="last_name" /><br/>
                        Password:<input type="text" name="password" /><br/>
                        <input type="submit" />
                    </form>
                </td></tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>