<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n/messages"/>

<html lang="${sessionScope.lang}">
<head>
    <title>lib.ua</title>
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
                        <fmt:message key="label.welcome" />
                    </h2>
                </td></tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>


