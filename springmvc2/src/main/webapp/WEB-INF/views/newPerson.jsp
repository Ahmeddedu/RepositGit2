<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Person</title>
</head>
<body>
    <h1>Add New Person</h1>

    <form action="/people" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <label for="gender">Gender:</label>
        <select id="gender" name="gender" required>
            <option value="Muzhlan">Male</option>
            <option value="Zhenchina">Female</option>
        </select><br><br>

        <input type="submit" value="Add Person">
    </form>

    <a href="/people">Back to People List</a>
</body>
</html>
