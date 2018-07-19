<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情</title>
</head>
<body>
	<h1>用户详情</h1>
		<c:forEach items="${users}" var="user">
			<ul>
				<li>用户名 : ${user.username} </li>
				<li>性别:  ${user.gender} </li>
				<li>启用:  ${user.enable} </li>
				<li>最后一次登录时间: ${user.lastlogin }</li>
			
			</ul>
		</c:forEach>
</body>
</html>