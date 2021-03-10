<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 26/02/2021
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Rotisserie</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>Login pour la gestion de la rotisserie</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="login.action" method="post" class="form-inline">
        <div class="form-group">
            <label>Username: </label>
            <input type="text" class="form-control" name="uname" required>
        </div><br>
        <div class="form-group">
            <label>Password: </label>
            <input type="password" class="form-control" name="pwd" required>
        </div><br>
        <div class="form-group">
            <input type="reset" value="Vider" class="form-control">
        </div>
        <div class="form-group">
            <input type="submit" value="Se connecter" class="form-control">
        </div>
    </form>
</div>
</body>
</html>
