<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj zlecenie naprawy</title>
</head>
<body>
<h1>Formularz dodawania naprawy:</h1>
<form:form method="post" modelAttribute="task"></br>
    <form:select path="" placeholder="Data przyjęcia"/></br>
    <form:input path="dateRepair" placeholder="Termin naprawy"/></br>
    <form:textarea path="desctription" placeholder="Opis"/></br>
    <form:select path="vehicle" items="${vehicles}"/></br>
<input type="submit" value="Dodaj zlecenie">
</form:form>
</body>
</html>

