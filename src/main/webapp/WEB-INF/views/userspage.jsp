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
		<h2 class="contact">Пользователи</h2>

		<c:url var="addUrl" value="/users/add" />
		<c:url var="showContacts" value="/contact/list" />


		<table class="table_price">
			<thead>
				<tr>
					<th>Имя</th>
					<th>Фамилия</th>
					<th colspan="3"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">

					<c:url var="showContacts"
						value="/contact/list?id=${user.id}&name=${user.name}&lastname=${user.lastname}" />
					<c:url var="editUrl" value="users/edit?id=${user.id}" />
					<c:url var="deleteUrl" value="users/delete?id=${user.id}" />
					<tr>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.lastname}" /></td>
						<td><a href="${showContacts}">Просмотреть</a></td>
						<td><a href="${editUrl}">Исправить</a></td>
						<td><a href="${deleteUrl}">Удалить</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	<p class="contact">
		<c:if test="${empty users}">
Нет пользователей
</c:if>

	<p class="contact">

	<p class="contact">
		<a href="${addUrl}">
			 <input type="button" value="Добавить пользователя" />
		</a>
	<p class="contact">
	</div>

</body>
</html>