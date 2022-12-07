<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>

<!-- Button Chi envoyé dans le post -->
<form action="/EniDemo/ExampleButtonValue" method="post">
    <input type="hidden" name="selection" value="chi"/>
    <input type="submit" value="Pierre"/>
</form>

<!-- Button Chi envoyé dans le post -->
<form action="/EniDemo/ExampleButtonValue" method="post"><input type="hidden" name="selection" value="fu"/><input type="submit" value="Feuille"/></form>

<!-- Button Chi envoyé dans le post -->
<form action="/EniDemo/ExampleButtonValue" method="post"><input type="hidden" name="selection" value="mi"/><input type="submit" value="Ciseaux"/></form>


<p><%= request.getAttribute("person") %></p>


<body>

</body>

</html>