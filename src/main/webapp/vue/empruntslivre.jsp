<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Emprunts d'un Livre</title>
</head>
<body>
<h1>Gestion d'une Bibliotheque</h1>
<h2>Liste des Emprunts</h2>
<h3>Livre: ${livre.title} (ID: ${livre.id})</h3>

<table border="1">
    <tr>
        <th>ID Emprunt</th>
        <th>Adherant</th>
        <th>Date</th>
    </tr>
    <c:forEach items="${emprunts}" var="emprunt">
        <tr>
            <td>${emprunt.ide}</td>
            <td>${emprunt.adherant.nom} ${emprunt.adherant.prenom}</td>
            <td>${emprunt.date}</td>
        </tr>
    </c:forEach>
    <c:if test="${empty emprunts}">
        <tr>
            <td colspan="3" style="text-align: center;">Aucun emprunt trouve</td>
        </tr>
    </c:if>
</table>
<br>
<a href="${cxt}/listeslivre">Retour a la liste des livres</a> |
<a href="${cxt}/ajoutemprunt">Ajouter un emprunt</a>
</body>
</html>
