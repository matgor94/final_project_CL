<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edytuj użytkownika</title>
</head>
<body>
<h1>Formularz edycji użytkownika</h1>
<c:url var="edit_url" value="/user/edit"/>
<form:form method="post" modelAttribute="user" action="${edit_url}">
    <form:hidden path="id"/></br>
    <form:input path="firstName"/></br>
    <form:input path="lastName"/></br>
    <form:input path="email"/></br>
    <form:input path="phoneNumber"/></br>
    <form:hidden path="password"/></br>
    <input type="submit" value="Zapisz użytkownika">
</form:form>
</body>
</html>