<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <title>Add Expense</title>
</head>
<body>
    <h2>Add Expense</h2>
    <form action="${pageContext.request.contextPath}/add-expense" method="post">
        Title: <input type="text" name="title" required><br><br>
        Amount: <input type="number" step="0.01" name="amount" required><br><br>
        Date (YYYY-MM-DD): <input type="text" name="date" required><br><br>
        Category: <input type="text" name="category" required><br><br>
        <input type="submit" value="Add Expense">
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/list-expenses">View All Expenses</a>
</body>
</html>
