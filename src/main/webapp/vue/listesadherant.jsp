<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cxt" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des livres</title>
</head>
<body>
<h1>Gestion d'une Bibliotheque</h1>
<h2>Liste des Adherants</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom et Prenom</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${adherants}" var="adherant">
        <tr>
            <td>${adherant.ida}</td>
            <td>${adherant.nom} ${adherant.prenom} </td>
            <td>
                <a href="${cxt}/empruntsadherant/${adherant.ida}">Liste des emprunts</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="${cxt}/ajoutLivre">Ajouter un Livre</a>
<a href="${cxt}/saveadherant">Enregister un Emprunt</a>
<a href="${cxt}/listesadherant">Listes des Adeherants</a>
</body>
</html>