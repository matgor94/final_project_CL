<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie naprawy</title>
</head>
<body>
<form method="post" action="">
    <p>Czy usunąć naprawę ${repair.id}?</p>
    <p>
        <input type="hidden" name="id" value="${repair.id}"/>
        <a href="/repair/all"><button>Nie</button></a>
        <button type="submit">Tak</button>
    </p>
</form>
</body>
</html>
