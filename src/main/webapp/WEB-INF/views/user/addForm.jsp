<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
<h1>Formualarz rejestracji:</h1>
<form:form method="post" modelAttribute="user"></br>
    <form:input path="firstName" placeholder="Imię"/></br>
    <form:input path="lastName" placeholder="Nazwisko"/></br>
    <form:input path="email" placeholder="email"/></br>
    <form:input path="phoneNumber" placeholder="Numer telefonu"/></br>
    <form:input path="password" placeholder="Hasło"/></br>
    <input type="submit" value="Dodaj użytkownika">
</form:form>
</body>
</html>

