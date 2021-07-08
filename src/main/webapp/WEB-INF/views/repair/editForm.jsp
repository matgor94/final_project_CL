<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edytuj użytkownika</title>
</head>
<body>
<h1>Formularz edycji naprawy</h1>
<c:url var="edit_url" value="/repair/edit"/>
<form:form method="post" modelAttribute="repair" action="${edit_url}">
    <form:hidden path="id"/></br>
    <form:input path="partsCost"/></br>
    <form:input path="jobCost"/></br>
    <form:select items="task" path="task"/></br>
    <input type="submit" value="Zapisz naprawę">
</form:form>
</body>
</html>