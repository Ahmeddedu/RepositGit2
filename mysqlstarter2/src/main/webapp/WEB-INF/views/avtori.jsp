<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Авторы</title>
</head>
<body>
<h2>Авторы</h2>
<ul>
    <c:forEach var="author" items="${authors}">
        <li>${author}</li>
    </c:forEach>
</ul>
<form action="statti" method="get">
    <button type="submit">Перейти к статьям</button>
</form>
</body>
</html>