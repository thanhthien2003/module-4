<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/29/2023
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển Đổi Tiền Tệ</title>
</head>
<body>
<form method="post" action="/ChuyenDoiTienTeServlet">
<label for="rate">
  Rate:
</label>
  <br>
<input id="rate" name="rate" placeholder="22000" value="22000"><br>
  <label for="usd">
    USD:
  </label>
  <br>
  <input id="usd" name="usd"><br>
  <input type="submit" id="submit">
</form>
</body>
</html>
