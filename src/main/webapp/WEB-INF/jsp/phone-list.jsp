<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机商品一览</title>
	<style>
	#a{
		
		width:250px;
		display:inline-block;
	}
	</style>
</head>
<body>
	<div >
		<c:forEach items="${phones}" var="phone"> 
	<ul id="a">
		<li>品牌： ${phone.brand} ${phone.model}</li>
		<li>操作系统： ${phone.os}</li>
		<li>核心处理器： ${phone.cpuBrand}</li>
		<li>运行内存： ${phone.ram}</li>  
		<li>存储容量： ${phone.storage}</li>
		<li>颜色： ${phone.color}</li>
		<li>评价： ${phone.description}</li>
		<li>价格： ${phone.price}</li> </br>
		<a href="${contextPath}/edit/${phone.id}"> <button>修改</button><a/> <a href="${contextPath}/delete/${phone.id}"><button >删除</button></a>
	</ul>	
	</c:forEach>
	</div>
	
</body>
</html>