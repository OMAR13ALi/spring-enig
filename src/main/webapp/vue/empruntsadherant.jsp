<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Emprunts d'un Adherant</title>
</head>
<body>
<h1>Gestion d'une Bibliotheque</h1>
<h2>Liste des Emprunts</h2>
<h3>Adherant: ${adherant.nom} ${adherant.prenom} (ID: ${adherant.ida})</h3>

<table border="1">
    <tr>
        <th>ID Emprunt</th>
        <th>Livre</th>
        <th>Date</th>
    </tr>
    <c:forEach items="${emprunts}" var="emprunt">
        <tr>
            <td>${emprunt.ide}</td>
            <td>${emprunt.livre.title}</td>
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
<a href="${cxt}/listesadherant">Retour a la liste des adherants</a> |
<a href="${cxt}/ajoutemprunt">Ajouter un emprunt</a>
</body>
</html>
