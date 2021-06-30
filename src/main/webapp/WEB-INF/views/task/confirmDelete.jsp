<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie użytkownika</title>
</head>
<body>
<form method="post" action="">
    <p>Czy usunąć zlecnie o id = ${task.id})?</p>
    <p>
        <input type="hidden" name="id" value="${task.id}"/>
        <a href="/task/all"><button>Nie</button></a>
        <button type="submit">Tak</button>
    </p>
</form>
</body>
</html>
