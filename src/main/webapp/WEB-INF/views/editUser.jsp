<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<h2 class="contact">Изменить пользователя</h2>
	<c:url var="saveUrl" value="/users/update?id=${user.id}" />
	<form:form  id="contactform" modelAttribute="user" method="POST"
		action="${saveUrl}">
		<p class="contact">
			<form:label path="name">Имя:</form:label>
		</p>
		<p class="contact">
			<form:input path="name" value = "${user.name}"/>
		</p>

		<p class="contact">
			<form:label path="lastname">Фамилия: </form:label>
		</p>
		
		<p class="contact">
			<form:input path="lastname" value = "${user.lastname}"/>
		</p>

		<p class="contact">
			<input type="submit" value="Сохранить" />
		</p>
	</form:form>
</div>
</body>
</html>