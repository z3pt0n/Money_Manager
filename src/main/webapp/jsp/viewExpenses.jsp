<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
    <title>All Expenses</title>
    <style>
        body { font-family: Arial; padding: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { padding: 10px; border: 1px solid #ccc; text-align: center; }
        .btn { margin-top: 20px; padding: 8px 16px; background: #4CAF50; color: white; border: none; cursor: pointer; }
        .btn:hover { background-color: #45a049; }
    </style>
</head>
<body>
    <h2>Expense Tracker</h2>
    <a href="jsp/addExpense.jsp"><button class="btn">Add Expense</button></a>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Category</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td>${expense.id}</td>
                <td>${expense.title}</td>
                <td>${expense.amount}</td>
                <td>${expense.date}</td>
                <td>${expense.category}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
