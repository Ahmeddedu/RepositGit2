<%@ page import="java.util.List" %>
<%@ page import="data.dto.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
    <h1>Articles List</h1>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Text</th>
            <th>Published</th>
            <th>Author ID</th>
        </tr>
        <% for (Article article : (List<Article>)request.getAttribute("articles")) { %>
        <tr>
            <td><%= article.getTitle() %></td>
            <td><%= article.getText() %></td>
            <td><%= article.isPublished() %></td>
            <td><%= article.getAuthorId() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>