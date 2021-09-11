<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="pl">
<head>
    <title>Strona logowania</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
<link rel="stylesheet" href="">
</head>
<body>
<div class="sidenav">
    <div class="login-main-text">
        <h2>Warsztat samochodowy<br> Strona logowania</h2>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form>
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" placeholder="email">
                </div>
                <div class="form-group">
                    <label>Hasło</label>
                    <input type="password" class="form-control" placeholder="hasło">
                </div>
                <button type="submit" class="btn btn-black">Zaloguj</button>
                <button type="submit" class="btn btn-secondary">Zarejestruj</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>