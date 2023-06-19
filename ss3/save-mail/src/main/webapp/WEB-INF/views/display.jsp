<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/19/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body>
<p>
    ${msg}
</p>
<table class="table table-bordered" style="background-color: #acb8bb">
    <thead style="background-color: aqua">
    <th>STT</th>
    <th>ID</th>
    <th>Languages</th>
    <th>Page Size</th>
    <th>Spams Filter</th>
    <th>Sisnature</th>
    <th>Edit</th>
    </thead>
    <tbody>
    <c:forEach items="${mailList}" var="mail" varStatus="loop">
        <tr>
            <td>
                <c:out value="${loop.count}"/>
            </td>
            <td>
                <c:out value="${mail.id}"/>
            </td>
            <td>
                <c:out value="${mail.languages}"/>
            </td>
            <td>
                <c:out value="${mail.pageSize}"/>
            </td>
            <td>
                <c:out value="${mail.spamsFilter}"/>
            </td>
            <td>
                <c:out value="${mail.signature}"/>
            </td>
            <td>
                <form action="/showFormEdit" method="get">
                    <input name="idEdit" value="${mail.id}" hidden>
                    <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
</body>
</html>
