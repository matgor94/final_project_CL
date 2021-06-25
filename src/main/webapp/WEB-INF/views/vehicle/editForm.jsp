<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edytuj pojazdu</title>
</head>
<body>
<h1>Formularz edycji pojadzu</h1>
<c:url var="edit_url" value="/vehicle/edit"/>
<form:form method="post" modelAttribute="vehicle" action="${edit_url}">
    <form:hidden path="id"/></br>
    <form:input path="producent"/></br>
    <form:input path="model"/></br>
    <form:input path="yearOfProduction"/></br>
    <form:input path="km"/></br>
    <form:hidden path="capacity"/></br>
    <input type="submit" value="Zapisz pojazd">
</form:form>
</body>
</html>