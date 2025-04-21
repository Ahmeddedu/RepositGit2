<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Список статей</title>
</head>
<body>
<h2>Всі статті</h2>
<ul>
    <c:forEach var="article" items="${articles}">
        <li>
            <strong>${article.title}</strong><br/>
            ${article.text}<br/>
            Автор: ${article.authorId} | Опубліковано: ${article.published}
        </li>
    </c:forEach>
</ul>
</body>
</html>
