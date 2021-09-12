<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <title>Warsztat samochodowy - Edytuj użytkownika</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"
            integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js"
            integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/"
            crossorigin="anonymous"></script>


    <link href="/src/main/webapp/resources/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <link href="/src/main/webapp/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>

<%@include file="../pageParts/header.jsp"%>
<div class="container" align="center">

    <form:form method="post" modelAttribute="user">
        <form:hidden path="id"/>
        <div class="mb-3">
            <label><b>Imię</b></label>
            <form:input path="firstName" placeholder="Imię" class="form-control"/>
        </div>
        <div class="mb-3">
            <label><b>Nazwisko</b></label>
            <form:input path="lastName" placeholder="Nazwisko" class="form-control"/>
        </div>
        <div class="mb-3">
            <label><b>Email</b></label>
            <form:input type="email" path="email" placeholder="Email" class="form-control"/>
        </div>
        <div class="mb-3">
            <label><b>Numer telefonu</b></label>
            <form:input path="phoneNumber" placeholder="Numer telefonu" class="form-control"/>
        </div>
        <form:hidden path="password"/>
        <button type="submit" class="btn btn-primary">Edytuj</button>
    </form:form>
</div>

<%@include file="../pageParts/footer.jsp"%>

</body>

</html>