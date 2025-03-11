<%@ page import="java.util.List" %>
<%@ page import="first.data.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title> Articles</title>
    </head>
    <body>
        <div>
            <div>

                <%
                    List<Article> articles = (List<Article>) request.getAttribute("articles");

                    if (articles != null && !articles.isEmpty()) {
                        for (Article a : articles) {
                            out.print("<h2>" + a.getTitle() );
                                   out.print("<form action=\"articles\\" + a.getTitle() + "?action=delete\" method=\"post\" style='display:inline'>");
                                                        out.print("<input width=15px type='image' src='close.png'/>") ;
                           out.print("</h2>");
                            out.print("<div>" + a.getText() );

                            out.print("</div>");
                            out.println("</form>");



                        }
                    } else out.println("<p>No articles for today!</p>");
                %>
            </div>
        </div>

        <div>
            <button onclick="location.href='/'">Back to main</button>
            <button onclick="location.href='/newArticleForm.html'">create new article</button>
        </div>
    </body>
</html>