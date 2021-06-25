<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Pojazdy</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Rok produkcji</th>
            <th>Przebieg (km)</th>
            <th>Pojemność</th>
            <th>Opcje</th>
        </tr>
        <c:forEach items="${vehiclesList}" var="vehicle">
            <tr>
                <td>${vehicle.id}</td>
                <td>${vehicle.producent}</td>
                <td>${vehicle.model}</td>
                <td>${vehicle.yearOfProduction}</td>
                <td>${vehicle.km}</td>
                <td>${vehicle.capacity}</td>
                <td>
                    <a href=/vehicle/edit?id=${vehicle.id}><button>Edytuj</button></a>
                    <a href=/vehicle/delete?id=${vehicle.id}><button>Usuń</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/vehicle/add"><button>Dodaj nowy pojazd</button></a>
</div>
</body>
</html>