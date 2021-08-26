<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Dodaj zlecenie naprawy</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Formularz dodawania zlecenia naprawy:</h1>--%>
<%--<form:form method="post" modelAttribute="task"></br>--%>
<%--    <form:input type="date" path="registrationDate"  placeholder="Data przyjęcia"/></br>--%>
<%--    <form:input type="date" path="dateRepair" placeholder="Termin naprawy"/></br>--%>
<%--    <form:textarea path="desctription" placeholder="Opis zlecenia"/></br>--%>
<%--    <form:select path="vehicle" items="${vehicles}" placeholder="Pojazd" itemValue="id" itemLabel="model"/></br>--%>
<%--<input type="submit" value="Dodaj zlecenie">--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <title>Formularz dodawania zlecenia</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/dashboard/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>

    <!-- Bootstrap core CSS -->
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


    <!-- Custom styles for this template -->
    <link href="/src/main/webapp/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>

<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3">Formularz dodawania zlecenia</a>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" href="#">Wyloguj</a>
        </div>
    </div>
</header>
<div class="container" align="center" >

    <form:form method="post" modelAttribute="task" cssClass="col-form-label">
            <div class="form-group">
                <b><label>Data przyjęcia: </label></b>
                    <form:input type="date" class="form-cntrol" path="registrationDate" id="registrationDate" placeholder="${date}"/>
            </div></br></br>
        <div class="form-group">
            <b><label>Termin naprawy: </label> </b>
            <form:input type="date" class="form-cntrol" path="dateRepair" id="dateRepair" placeholder="Termin naprawy"/>
        </div></br></br>
        <div class="form-group">
            <b> <label>Opis zlecenia:</label></b></br>
            <form:textarea path="desctription" placeholder="Opis zlecenia"/>
        </div></br></br>
        <div class="form-group">
            <b><label>Wybierz pojazd:</label>   </b>
            <form:select path="vehicle" items="${vehicles}" placeholder="Pojazd" itemValue="id" itemLabel="model"/>
        </div>
        <button type="submit" class="btn btn-primary">Dodaj</button>
    </form:form>
</div>
<script src="/src/main/webapp/resources/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="/src/main/webapp/resources/js/dashboard.js"></script>
<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
    <span class="text-muted">Mateusz Górczyński ${date} </span>
</footer>
</body>

</html>