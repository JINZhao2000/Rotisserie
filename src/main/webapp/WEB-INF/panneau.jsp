<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 26/02/2021
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panneau de Commande</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        getQueue();
        getBac();
        getPret();
        setInterval(
            getBac,5000
        );
        function getQueue() {
            $.ajax({
                type: "POST",
                url: "./queue.action",
                dataType: "json",
                success: function (data) {
                    let content = "";
                    for (let i = 0; i < data.length; i++) {
                        content += "<tr>";
                        content += "<td>" + data[i].commande.nomClient + "</td>";
                        content += "<td>" + data[i].commande.numCom + "</td>";
                        content += "<td>" + data[i].poulet.taille + "</td>";
                        content += "<td><a href='./mettreAuBac.action?mab=" + data[i].wid + "' class='btn btn-primary'>Mettre au bac</a></td>";
                        content += "</tr>";
                    }
                    $("#wait").html(content);
                }
            });
        }

        function getBac() {
            $.ajax({
                type: "POST",
                url: "./getAllBac.action",
                dataType: "json",
                success: function (data) {
                    let content = "";
                    for (let i = 0; i < data.length; i++) {
                        content += "<tr>";
                        content += "<td>" + data[i].bid + "</td>";
                        if (data[i].numCom === 0) {
                            content += "<td>Non occupe</td>";
                            content += "<td>Non occupe</td>";
                            content += "<td>Non occupe</td>";
                            content += "<td></td>";
                        } else {
                            content += "<td>" + data[i].numCom + "</td>";
                            if (data[i].statuts === 1) {
                                content += "<td>En train de cuire</td>";
                            } else {
                                content += "<td>C'est cuit</td>";
                            }
                            content += "<td>" + data[i].taille + "</td>";
                            if (data[i].statuts === 2) {
                                content += "<td>" + "<a href='sortirDuBac.action?bid=" + data[i].bid + "' class='btn btn-primary'>Sortir du bac</a>" + "</td>";
                            } else {
                                content += "<td></td>";
                            }
                        }
                        content += "</tr>";
                    }
                    $("#bac").html(content);
                }
            })
        }

        function getPret() {
            $.ajax({
                type: "POST",
                url: "./commandesPretes.action",
                dataType: "json",
                success: function (data) {
                    console.log(data);
                    let content = "";
                    for (let i = 0; i < data.length; i++) {
                        content += "<tr>";
                        content += "<td>" + data[i].nomClient + "</td>";
                        content += "<td>" + data[i].numCom + "</td>";
                        content += "<td><a href='./retirer.action?numCom=" + data[i].numCom + "' class='btn btn-primary'>Retirer la commande</a></td>";
                        content += "</tr>";
                    }
                    $("#pret").html(content);
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>Panneau d'affichage</small>
                </h1>
                <h2>
                    <small>Commandes Pretes</small>
                </h2>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Nom Client</th>
                    <th>Num Commande</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody id="pret">

                </tbody>
            </table>
        </div>
    </div>
    <hr>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <small>Bac manager</small>
                </h2>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Num Bac</th>
                    <th>Status</th>
                    <th>Num Commande</th>
                    <th>Poulet</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody id="bac">

                </tbody>
            </table>
        </div>
    </div>
    <hr>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h2>
                    <small>File d'attente</small>
                </h2>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>Nom Client</th>
                    <th>Num Commande</th>
                    <th>Poulet A Cuir</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody id="wait">

                </tbody>
            </table>
        </div>
    </div>
    <a href="toIndex.action" class="btn btn-primary">Retour</a>
</div>
</body>
</html>
