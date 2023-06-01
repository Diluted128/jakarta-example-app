<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.employeeservice.Employee"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Lista pracownikow</h1>
    <%

        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (!employees.isEmpty()) {
            %>
            <ul>
                <%
                for (Employee employee : employees) {
                %>
                <li>ID: <%= employee.getId() %></li>
                <li>Name: <%= employee.getName() %></li>
                <li>Surname: <%= employee.getSurname() %></li>
                <li>Occupation: <%= employee.getOccupation() %></li>
                <hr>
                <%
                }
                %>
            </ul>
            <%
        } else {
            %>
            <p>Brak pracowników</p>
            <%
        }
            %>

    <h1>Employee by ID</h1>
    <form action="${pageContext.request.contextPath}/employee" method="get">
        <label for="name">Id:</label>
        <input type="text" id="emp_id" name="emp_id" required><br>
        <input type="submit" value="Search"/>
    </form>

    <h1>Add employee</h1>
    <form action="${pageContext.request.contextPath}/employee" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" required><br>

        <label for="occupation">Occupation:</label>
        <input type="text" id="occupation" name="occupation" required><br>

        <input type="submit" value="Add Employee"/>
    </form>

    <h1>Update Employee</h1>
    <form action="${pageContext.request.contextPath}/employee" method="post">
        <label for="name">Id:</label>
        <input type="text" id="id" name="id" required><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="surname">Surname:</label>
        <input type="text" id="surname" name="surname" required><br>
        <label for="occupation">Occupation:</label>
        <input type="text" id="occupation" name="occupation" required><br>
        <input type="hidden" name="put" value="put">
        <input type="submit" value="Update Employee"/>
    </form>
</body>
</html>