<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Статьи</title>
</head>
<body>
<h2>Статьи</h2>
<ul>
    <c:forEach var="article" items="${articles}">
        <li>
            <b>Заголовок:</b> ${article.title} <br>
            <b>Текст:</b> ${article.text} <br>
            <b>Автор:</b> ${article.author} <br>
            <hr>
        </li>
    </c:forEach>
</ul>

<form action="avtori" method="get">
    <button type="submit">Перейти к авторам</button>
</form>
</body>
</html>
