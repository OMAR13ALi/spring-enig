<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ajouter un Livre</title>
</head>
<body>
<h1>Gestion d'une Biblotheque</h1>
<h2>Ajouter un Livre</h2>
<h3>Formulaire de saisie</h3>
<form:form action="saveemprunt" method="POST"      modelAttribute="emprunt">

    Date Emprunt <form:input path="Date" />
    <form:select path="livre.id" items= "${livres}"  itemLabel="title" itemValue="id" />
    <form:select path="adherant.ida" items=   "${adherants}"  itemLabel="nom" itemValue="ida" />

    <input type="submit" value="Enregistrer" />
</form:form>

<br>
<a href="${cxt}/listesadherant">Retour a la liste</a>
</body>
</html>
