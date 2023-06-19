<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1><%= "Dictionary" %>
</h1>
<br/>
<form method="post" action="/dictionary">
    <p> only used enter to translate these from this Because my level is limited : Apple , Banana , Coconut , Orange ,
    Mango , Cat , Dog , Lion , Tiger , Chicken , Pig
    </p>
   <span>Enter your word you want : </span>  <input type="text" name="word" placeholder="Example: apple">
    <button type="submit">Translate</button>
</form>
<p>${result}</p>
</body>
</html>