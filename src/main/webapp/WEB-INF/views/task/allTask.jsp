<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Zlecenia</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Przyjęcie zlecenia</th>
            <th>Data zakończenia zlecenia</th>
            <th>Opis</th>
            <th>Pojazd</th>
            <th>Opcje</th>
        </tr>
        <c:forEach items="${taskList}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.registrationDate}</td>
                <td>${task.dateRepair}</td>
                <td>${task.desctription}</td>
                <td>${task.vehicle.producent} ${task.vehicle.model}</td>
                <td>
                    <a href="/task/edit?id=${task.id}"><button>Edytuj</button></a>
                    <a href="/task/delete?id=${task.id}"><button>Usuń</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/task/add"><button>Dodaj zlecenie</button></a>
</div>
</body>
</html>