<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<title>Книга контактов</title>
</head>
<body>

	<div class="cover">
		<h2 class="contact">Пользователь, ${user.name} ${user.lastname}</h2>



		<c:url var="addUrl" value="/contact/add?id=${user.id}" />
		<table class="table_price">
			<thead>
				<tr>
					<th>Контакт</th>
					<th colspan="2"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<c:url var="editUrl" value="/contact/edit?id=${contact.id}" />
					<c:url var="deleteUrl" value="/contact/remove?id=${contact.id}" />
					<tr>
						<td><c:out value="${contact.phone}" /></td>
						<td><a href="${editUrl}">Edit</a></td>
						<td><a href="${deleteUrl}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p class="contact">
			<c:if test="${empty contacts}">
Нет контактов.
</c:if>
		<p class="contact">
		<p class="contact">
			<a href="${addUrl}"> <input type="button" value="Добавить контакт" /></a>
		<p class="contact">
	</div>

</body>
</html>