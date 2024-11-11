<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="pl">
<head>
    <title>Warsztat motoryzacyjny - Pracownicy</title>
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

<%@include file="../pageParts/header.jsp"%>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/customers">
                            <span data-feather="home"></span>
                            Klienci
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/employee">
                            <span data-feather="file"></span>
                            Pracownicy
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/task/all">
                            <span data-feather="shopping-cart"></span>
                            Zlecenia
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/vehicle/all">
                            <span data-feather="home"></span>
                            Pojazdy
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">

                <div class="btn-toolbar mb-2 mb-md-0">
                    </button>
                </div>
            </div>

            <h2>Pracownicy</h2>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Imię</th>
                        <th scope="col">Nazwisko</th>
                        <th scope="col">Email</th>
                        <th scope="col">Telefon</th>
                        <th scope="col">Opcje</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${employees}" var="emp">
                        <tr>
                            <td>${emp.id}</td>
                            <td>${emp.firstName}</td>
                            <td>${emp.lastName}</td>
                            <td>${emp.email}</td>
                            <td>${emp.phoneNumber}</td>
                            <td>
                                <a href="/user/edit?id=${emp.id}" class="btn btn-dark" role="button">Edytuj</a>
                                <a href="/user/delete?id=${emp.id}" class="btn btn-danger" role="button">Usuń</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <a href="/user/addEmployee" class="btn btn-primary" role="button">Dodaj pracownika </a>
            </div>
        </main>
    </div>
</div>
<%@include file="../pageParts/footer.jsp"%>

</body>

</html>