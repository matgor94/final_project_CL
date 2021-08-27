<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Edytuj pojazdu</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Formularz edycji pojadzu</h1>--%>
<%--<c:url var="edit_url" value="/vehicle/edit"/>--%>
<%--<form:form method="post" modelAttribute="vehicle" action="${edit_url}">--%>
<%--    <form:hidden path="id"/></br>--%>
<%--    <form:input path="producent"/></br>--%>
<%--    <form:input path="model"/></br>--%>
<%--    <form:input path="yearOfProduction"/></br>--%>
<%--    <form:input path="km"/></br>--%>
<%--    <form:hidden path="capacity"/></br>--%>
<%--    <input type="submit" value="Zapisz pojazd">--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Edytuj zlecenie</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Formularz edycji zlecenia naprawy</h1>--%>
<%--<c:url var="edit_url" value="/task/edit"/>--%>
<%--<form:form method="post" modelAttribute="task" action="${edit_url}">--%>
<%--    <form:hidden path="id"/></br>--%>
<%--    <form:input path="registrationDate"/></br>--%>
<%--    <form:input path="dateRepair"/></br>--%>
<%--    <form:input path="desctription"/></br>--%>
<%--    <form:input path="vehicle"/></br>--%>
<%--    <input type="submit" value="Zapisz zlecenie">--%>
<%--</form:form>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <title>Edytuj pojazd</title>
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
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3">Formularz edycji pojazdu</a>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" href="#">Wyloguj</a>
        </div>
    </div>
</header>
<div class="container" align="center">

    <form:form method="post" modelAttribute="vehicle">
        <form:hidden path="id"/>
        <div class="mb-3">
            <label class="form-label"><b>Producent</b></label>
            <form:input path="producent" placeholder="producent" class="form-control"/>
        </div>
        <b></b>
        <div class="mb-3">
            <label class="form-label"><b>Model</b></label>
            <form:input path="model" placeholder="Model" class="form-control"/>
        </div>
        <div class="mb-3">
            <label class="form-label"><b>Rok produkcji</b></label>
            <form:input path="yearOfProduction" placeholder="Rok produkcji" class="form-control"/>
        </div>
       <div class="mb-3">
           <label class="form-label"><b>Przebieg</b></label>
           <form:input path="km" placeholder="Przebieg (w km)" class="form-control"/>
       </div>
        <div class="mb-3">
            <b><label class="form-label">Pojemność</label></b>
            <form:input path="capacity" placeholder="Pojemność" class="form-control"/>
        </div>
        <button type="submit" class="btn btn-primary">Zapisz pojazd</button>
    </form:form>
</div>

<script src="/src/main/webapp/resources/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
        integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
        integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
        crossorigin="anonymous"></script>
<script src="/src/main/webapp/resources/js/dashboard.js"></script>
<footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <div class="col-md-4 d-flex align-items-center">
        <span class="text-muted">Mateusz Górczyński ${time} </span>
    </div>
</footer>
</body>

</html>