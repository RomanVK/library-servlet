<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="i18n/messages"/>
<%--TODO make simply apearence--%>
<html lang="${sessionScope.lang}">
<head>
    <title>Profile</title>
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
                        Profile
                    </h2>
                </td></tr>

                <tr><td>
                    Hello ${user.firstName} ${user.lastName}
                </td></tr>
                <tr><td>
                    Registration data
                </td></tr>
                <tr>
                    <td> ID </td> <td> ${user.id} </td>
                </tr>
                <tr>
                    <td> First name </td> <td> ${user.firstName} </td>
                </tr>
                <tr>
                    <td> Last name </td> <td> ${user.lastName} </td>
                </tr>
                <tr>
                    <td> Email </td> <td> ${user.email} </td>
                </tr>
                <tr>
                    <td> Lock status </td> <td> ${user.blocked} </td>
                </tr>
                <tr><td>
                    Ordered books---------------
                </td></tr>
                <tr><td>
                    Received books--------------
                </td></tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>
