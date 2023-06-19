<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>VietNamese Dictionary</h1>
<form method="post" action="/TuDienThucHanhServlet">
    <input type="text" name="textSearch" placeholder="Nhap chu vao: ">
    <button type="submit">Xac nhan</button>
    <h1> Result: ${result} </h1>
</form>
</body>
</html>