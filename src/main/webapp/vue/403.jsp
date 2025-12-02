<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Acces Refuse</title>
    <style>
        body { font-family: Arial; text-align: center; padding: 50px; }
        .error-box { border: 2px solid red; padding: 30px; display: inline-block; }
        h1 { color: red; }
    </style>
</head>
<body>
<div class="error-box">
    <h1>403 - Acces Refuse</h1>
    <h2>Vous n'avez pas les permissions necessaires</h2>
    <p>Utilisateur: <sec:authentication property="name"/></p>
    <p>Roles: <sec:authentication property="authorities"/></p>
    <br>
    <a href="${cxt}/listeslivre">Retour a l'accueil</a> |
    <a href="${cxt}/logout">Se deconnecter</a>
</div>
</body>
</html>
