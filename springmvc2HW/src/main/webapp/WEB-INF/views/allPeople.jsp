<%@ page import="java.util.List" %>
<%@ page import="edu.spring.first.data.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>People List</title>
</head>
<body>
    <h1>People List</h1>

    <%
        List<Person> people = (List<Person>) request.getAttribute("people");
        if (people != null && !people.isEmpty()) {
            for (Person p : people) {
                out.print("<h2>" + p.getName() + "</h2>");
                out.print("<p>Age: " + p.getAge() + "</p>");
                out.print("<p>Gender: " + p.getGender() + "</p>");
                out.print("</form>");
                out.print("<hr>");
            }
        } else {
            out.print("<p>Nikogo</p>");
        }
    %>

    <a href="/people/new">Add New Person</a>

    <a href="/">Back to Main</a>
</body>
</html>