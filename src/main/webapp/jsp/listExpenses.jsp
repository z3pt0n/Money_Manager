<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Expense" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>Expense List</title>
</head>
<body>
    <h2>Expense List</h2>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Category</th>
        </tr>

        <c:forEach var="e" items="${expenses}">
            <tr>
                <td>${e.id}</td>
                <td>${e.title}</td>
                <td>${e.amount}</td>
                <td>${e.date}</td>
                <td>${e.category}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/jsp/addExpense.jsp">Add Another Expense</a>
</body>
</html>
