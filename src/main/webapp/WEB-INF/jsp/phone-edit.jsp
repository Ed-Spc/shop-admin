<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/> 

<t:layout title="添加手机">
	<jsp:attribute name="css">
    	<link href="${contextPath}/assets/css/form.css" rel="stylesheet">
	</jsp:attribute>
	
	<jsp:attribute name="js">
		<script>
      		console.log('手机列表');
   		 </script>
	</jsp:attribute>
	
	<jsp:body>
	<form:form action="" method="post" commandName="phone">
		手机品牌:<form:input type="text" path="brand"/>
		<form:errors path="brand" cssClass="field-error" /></br>
		型       号:<form:input type="text" path="model"/><form:errors path="model" cssClass="field-error" />											</br></br>
		
		操作系统:<form:input type="text" path="os"/><form:errors path="os" cssClass="field-error" />											</br></br>
		核心处理器:<form:input type="text" path="cpuBrand"/><form:errors path="cpuBrand" cssClass="field-error" />									</br></br>
		运行内存:<form:input type="text" path="ram"/><form:errors path="ram" cssClass="field-error" />											</br></br>
		存储容量:<form:input type="text" path="storage" />	<form:errors path="storage" cssClass="field-error" />									</br></br>
		颜       色:<form:input type="text" path="color" /><form:errors path="color" cssClass="field-error" />											</br></br>
		价       格:<form:input type="text" path="price" /><form:errors path="price" cssClass="field-error" />											</br></br>
		评       价:<form:textarea path="description" />	<form:errors path="description" cssClass="field-error" />											</br></br>
		
		<button TYPE="submit">确认提交</button>
	</form:form>
	</jsp:body>	
</t:layout>

