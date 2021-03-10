<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 26/02/2021
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion Rotisserie</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <small style="font-size: 100px">Gestion de la Rotisserie</small>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a href="toPrise.action" class="btn btn-primary">Prise de Commande</a>
            </div>
            <div class="col-md-4 column">
                <a href="toPanneau.action" class="btn btn-primary">Panneau de Poulet</a>
            </div>
            <div class="col-md-4 column">
                <a href="logout.action" class="btn btn-primary">Se deconnecter</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
