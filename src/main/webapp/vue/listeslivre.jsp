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
<h2>Liste des Départements</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Titre</th>
    <th>Action</th>
  </tr>
  <c:forEach items="${livres}" var="livre">
    <tr>
      <td>${livre.id}</td>
      <td>${livre.title}</td>
      <td>
        <a href="${cxt}/emprunts/${livre.id}">Liste des emprunt</a>
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