<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <title>Warsztat motoryzacyjny - Resetowanie hasła </title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>


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
<div class="px-4 py-5 my-5 text-center">
    <h1 class="display-5 fw-bold">Resetowanie hasła</h1>
    <div class="col-lg-6 mx-auto">
        <p class="lead mb-4">Wprowadź email którego użyłeś przy rejestracji oraz nowe hasło </p>
    </div>
</div>
<div class="container" align="center">
<form:form method="post" modelAttribute="password">
    <div class="form-group row">
        <b><label class="col-sm-2 col-form-label">Email</label></b>
        <form:input path="email" type="text" class="form-control" name="email" id="email" placeholder="email"/>
    </div>
    <div class="form-group row">
        <b><label class="col-sm-2 col-form-label">Hasło </label></b>
        <form:input path="password" id="password" name="password" placeholder="Hasło" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-primary">Zatwierdź</button>
</form:form>
</div>
<%@include file="../pageParts/footer.jsp"%>>
</body>
</html>