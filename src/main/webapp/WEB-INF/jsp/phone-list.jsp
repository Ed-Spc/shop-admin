<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 



<t:layout title="手机列表一览">
	<jsp:attribute name="css">
    	<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
	</jsp:attribute>
	<jsp:body>
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
	</jsp:body>
</t:layout>