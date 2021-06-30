<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edytuj zlecenie</title>
</head>
<body>
<h1>Formularz edycji zlecenia naprawy</h1>
<c:url var="edit_url" value="/task/edit"/>
<form:form method="post" modelAttribute="task" action="${edit_url}">
    <form:hidden path="id"/></br>
    <form:input path="registrationDate"/></br>
    <form:input path="dateRepair"/></br>
    <form:input path="desctription"/></br>
    <form:input path="vehicle"/></br>
    <input type="submit" value="Zapisz zlecenie">
</form:form>
</body>
</html>