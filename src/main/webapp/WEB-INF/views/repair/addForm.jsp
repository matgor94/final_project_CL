<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj zlecenie naprawy</title>
</head>
<body>
<h1>Formularz dodawania naprawy:</h1>
<form:form method="post" modelAttribute="repair"></br>
    <form:input path="partsCost" placeholder="Koszt części"/>
    <form:input path="jobCost" placeholder="Koszt robocizny"/>
    <form:select path="task" items="${task}" placeholder="Zlecene"/>
<input type="submit" value="Dodaj naprawę">
</form:form>
</body>
</html>

