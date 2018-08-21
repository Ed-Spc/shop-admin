<#include 'layout.ftl'>

	<#macro css>
    	<link href="<@spring.url '/assets/css/form.css'/>" rel="stylesheet">
	</#macro>
<@layout title="手机列表一览">
	<jsp:body>
	<div >
		<#list phones as phone> 
		<ul id="a">
		<li>品牌： ${phone.brand} ${phone.model}</li>
		<li>操作系统： ${phone.os}</li>
		<li>核心处理器： ${phone.cpuBrand}</li>
		<li>运行内存： ${phone.ram}</li>  
		<li>存储容量： ${phone.storage}</li>
		<li>颜色： ${phone.color}</li>
		<li>评价： ${phone.description}</li>
		<li>价格： ${phone.price}</li> </br>
		
		<a href="<@spring.url '/edit/phone.id'/>"> <button>修改</button><a/>
		<a href="<@spring.url '/delete/phone.id'/>"><button >删除</button></a>
	</ul>	
	</#list>
	</div>	
	</jsp:body>
</@layout>