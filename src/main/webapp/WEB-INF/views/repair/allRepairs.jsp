<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Naprawy</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Koszt części</th>
            <th>Koszt robocizny</th>
            <th>Zlecnie</th>
        </tr>
        <c:forEach items="${repairList}" var="repair">
            <tr>
                <td>${repair.id}</td>
                <td>${repair.partsCost}</td>
                <td>${repair.jobCost}</td>
                <td>${repair.task.id}</td>
                <td>
                    <a href="/repair/edit?id=${repair.id}"><button>Edytuj</button></a>
                    <a href="/repair/delete?id=${repair.id}"><button>Usuń</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/repair/add"><button>Dodaj naprawę</button></a>
</div>
</body>
</html>