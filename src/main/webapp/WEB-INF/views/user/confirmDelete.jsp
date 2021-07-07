<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie użytkownika</title>
</head>
<body>
<form method="post" action="">
    <p>Czy usunąć użytkownika ${user.firstName} ${user.lastName})?</p>
    <p>
        <input type="hidden" name="id" value="${user.id}"/>
        <a href="/user/all"><button>Nie</button></a>
        <button type="submit">Tak</button>
    </p>
</form>
</body>
</html>
