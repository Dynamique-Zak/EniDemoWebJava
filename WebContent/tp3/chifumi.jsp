<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chifoumi</title>
</head>
<body>

<h1>Chifoumi</h1>

<!-- Button Chi envoyé dans le post -->
<form action="/EniDemo/chifumi" method="post">
    <input type="hidden" name="selection" value="chi"/>
    <input type="submit" value="Pierre"/>
</form>

<!-- Button fu envoyé dans le post -->
<form action="/EniDemo/chifumi" method="post"><input type="hidden" name="selection" value="fu"/><input type="submit" value="Feuille"/></form>

<!-- Button mi envoyé dans le post -->
<form action="/EniDemo/chifumi" method="post"><input type="hidden" name="selection" value="mi"/><input type="submit" value="Ciseaux"/></form>



</body>
</html>