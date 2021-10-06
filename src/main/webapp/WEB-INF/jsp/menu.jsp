<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/6/2021
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.ATUber.ATUber.model.domain.Solicitante"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">ATuber</a>
        </div>
        <%Solicitante solicitante = (Solicitante) request.getAttribute("solicitante"); %>
        <%if(solicitante != null){%>
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/Corrida">Corridas</a></li>
            <li><a href="/Eats">Eats</a></li>
            <li><a href="/Correspondencia">Correspondências</a></li>

        </ul>
        <%}%>


        <ul class="nav navbar-nav navbar-right">
            <%if(solicitante != null){%>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${solicitante.nome}!!!</a></li>
            <%}%>
        </ul>
    </div>
</nav>
</body>
</html>
