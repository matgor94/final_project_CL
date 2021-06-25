<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Użytkownicy</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Email</th>
            <th>Opcje</th>
        </tr>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>
                    <a href="/user/edit?id=${user.id}"><button>Edytuj</button></a>
                    <a href="/user/delete?id=${user.id}"><button>Usuń</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/user/add"><button>Dodaj nowego użytkownika</button></a>
</div>
</body>
</html>