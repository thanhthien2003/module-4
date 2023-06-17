<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="/save" method="post">
    Lettuce <input type="checkbox" value="Lettuce" name="condiment">
    Tomato <input type="checkbox" value="Tomato" name="condiment">
    Mustard <input type="checkbox" value="Mustard" name="condiment">
    Sprouts <input type="checkbox" value="Sprouts" name="condiment">
    <button type="submit">save</button>
</form>
condiment you choose: ${result}
</body>
</html>