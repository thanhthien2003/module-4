<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/19/2023
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form:form method="post" modelAttribute="mail" action="/edit">
    <form:hidden path="id"/>
    Languages:
    <form:select path="languages">
        <form:option value="English"/>English
        <form:option value="Vietnamese"/>Vietnamese
        <form:option value="Japanese"/>Japanese
        <form:option value="Chinese"/>Chinese
    </form:select>
    <br>
    Page Size:
    <form:select path="pageSize">
        <form:option value="5"/>5
        <form:option value="10"/>10
        <form:option value="15"/>15
        <form:option value="25"/>25
        <form:option value="50"/>50
        <form:option value="100"/>100
    </form:select> email per page
    <br>
    Spams filter: <form:checkbox path="spamsFilter" label="Enable spams filter"/>
    <br>
    Signature: <form:textarea path="signature"/>
    <br>
    <form:button type="submit">Update</form:button>
    <form:button type="reset">Cancel</form:button>
</form:form>
</body>
</html>
