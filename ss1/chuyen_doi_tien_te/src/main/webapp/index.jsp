<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Calculator</title>
</head>
<body>
<h1><%= "Calculator" %>
</h1>
<br/>
<form method="post" action="/calculator">
    Enter your USD you have : <input type="number" min=0 name="usd" placeholder="USD" required>
    Enter your exchange <input type="number" min="0" name="exchange" placeholder="Tỉ giá" required>
    <button type="submit">Change</button>
</form>
</body>
</html>