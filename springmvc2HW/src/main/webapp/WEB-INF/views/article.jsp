<%@ page import="java.util.List" %>
<%@ page import="edu.web.store.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title><% out.println((String) request.getAttribute("pageTitle")); %></title>
    </head>
    <body>
        <%
            Article a = (Article) request.getAttribute("article");
            if (a != null) {
                out.println("<h2>" + a.getTitle() + "</h2>");
                out.println("<p>" + a.getText() + "</p>");
            } else {
                out.println("not found");
            }
        %>

        <div>
            <button onclick="location.href='/articles'">Back to list</button>
        </div>
    </body>
</html>
