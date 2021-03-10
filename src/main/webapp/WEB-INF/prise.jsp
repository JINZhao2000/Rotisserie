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
    <title>Prise de Commande</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        $.ajax({
            type: "POST",
            url: "./stock.action",
            dataType: "json",
            success: function (data){
                document.getElementById("snL").innerHTML = data[0].stock;
                document.getElementById("snM").innerHTML = data[1].stock;
                document.getElementById("snS").innerHTML = data[2].stock;
            }
        })
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <small>Prise de Commande</small>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <form action="saveCommande.action" method="post" onsubmit="return validation()" class="form-horizontal">
                <div class="form-group">
                    <label>Nom Client: </label>
                    <input type="text" class="form-control" name="cnom" required>
                </div><br>
                <div class="form-group">
                    <label>Frit: </label>
                    <input type="number" class="form-control" name="frit" value="0" required>
                </div><br>
                <div class="form-group">
                    <label>Taille de Poulet: </label><br>
                    <label>L:</label>
                    <input type="number" class="form-control" name="nL" id="nL" value="0" required><br>
                    <label>M:</label>
                    <input type="number" class="form-control" name="nM" id="nM" value="0" required><br>
                    <label>S:</label>
                    <input type="number" class="form-control" name="nS" id="nS" value="0" required><br>
                </div><br>
                <div class="form-group">
                    <label>Stock Actuel: </label><br>
                    <label>L: <span id="snL"></span></label><br>
                    <label>M: <span id="snM"></span></label><br>
                    <label>S: <span id="snS"></span></label><br>
                </div><br>
                <div class="form-group">
                    <input type="reset" value="vider" class="btn btn-primary">
                    <div class="col-md-4 column"></div>
                    <input type="submit" value="enregistrer" class="btn btn-primary">
                </div>
            </form>
            <a href="toIndex.action" class="btn btn-primary">Retour</a>
        </div>
    </div>

</div>
</body>
<script type="text/javascript">
    let nL = document.getElementById("nL");
    let nM = document.getElementById("nM");
    let nS = document.getElementById("nS");
    let snL = document.getElementById("snL");
    let snM = document.getElementById("snM");
    let snS = document.getElementById("snS");
    let nCommande = [nL, nM, nS];
    let nStock = [snL, snM, snS];
    for(let i=0; i<nCommande.length; i++){
        nCommande[i].addEventListener("keyup",function (){
            if(parseInt(this.value)>parseInt(nStock[i].innerHTML)||parseInt(this.value)<0){
                this.style = "border-color:red";
            }else {
                this.style = "border-color:green";
            }
        })
    }
    let cnom = document.getElementsByName("cnom")[0];
    cnom.addEventListener("keyup",function (){
        if(this.value.trim()!==""){
            this.style = "border-color:green";
        }
    })
    function validation() {
        let nL = document.getElementById("nL");
        let nM = document.getElementById("nM");
        let nS = document.getElementById("nS");
        let nCommande = [nL, nM, nS];
        let cnom = document.getElementsByName("cnom")[0];
        let cprenom = document.getElementsByName("cprenom")[0];
        if(cnom.value.trim()===""){
            cnom.style = "border-color:red";
            return false;
        }
        for (let i=0; i<nCommande.length; i++){
            if(parseInt(nCommande[i].value)>parseInt(nStock[i].innerHTML)||parseInt(nCommande[i].value)<0){
                nCommande[i].style = "border-color:red";
                return false;
            }
        }
        return true;
    }
</script>
</html>
