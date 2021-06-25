<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj pojazd</title>
</head>
<body>
<h1>Formularz dodawania pojazdu:</h1>
<form:form method="post" modelAttribute="vehicle"></br>
    <form:input path="producent" placeholder="Producent"/></br>
    <form:input path="model" placeholder="Model"/></br>
    <form:input path="yearOfProduction" placeholder="Rok produkcji"/></br>
    <form:input path="km" placeholder="Przebieg (km)"/></br>
    <form:input path="capacity" placeholder="Pojemność"/></br>
<input type="submit" value="Dodaj pojazd">
</form:form>
</body>
</html>

