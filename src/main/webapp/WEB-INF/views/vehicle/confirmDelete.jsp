<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Usuwanie pojazdu</title>
</head>
<body>
<form method="post" action="">
    <p>Czy usunąć pojazd ${vehicle.producent} ${vehicle.model}, id = ${vehicle.id})?</p>
    <p>
        <input type="hidden" name="id" value="${vehicle.id}"/>
        <a href="/vehicle/all"><button>Nie</button></a>
        <button type="submit">Tak</button>
    </p>
</form>
</body>
</html>