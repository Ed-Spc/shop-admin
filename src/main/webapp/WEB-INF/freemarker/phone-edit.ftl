<#include 'layout.ftl'>

<#macro css>

</#macro>

<#macro js>
	
</#macro>

<@layout title="添加手机">
	<form action="" method="post" >
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
		手机品牌:
		<@spring.formSingleSelect "phone.brand"
		{
		   '':'---请选择品牌---',
		   '华为':'华为',
		   '锤子':'锤子',
		   '黑莓':'黑莓'   
		}>
		</@spring.formSingleSelect>
		<#--  <@sping.showErrors "br" "field-error"/> -->
		
		型       号:<@spring.formInput "phone.model"/>
			<#--  <@sping.showErrors "br" "field-error"/> -->											</br></br>
		
		操作系统:<@spring.formSingleSelect "phone.os"
				{   'Android':'Android',
					'IOS':'IOS'
				}>
				</@spring.formSingleSelect>
			<#--  <@sping.showErrors "br" "field-error"/> -->											</br></br>
		核心处理器:<@spring.formInput "phone.cpuBrand"/>
		
			<#--  <@sping.showErrors "br" "field-error"/> -->								</br></br>
		运行内存:<@spring.formInput "phone.ram" 'min="1" max="6" placehoder="GB"' "number" />		
			<#--  <@sping.showErrors "br" "field-error"/> -->											</br></br>
		存储容量:<@spring.formInput "phone.storage" "number"
									'min="16" max="128" placehoder="GB"' />	
		
			<#--  <@sping.showErrors "br" "field-error"/> -->									</br></br>
		颜       色:<@spring.formInput "phone.color" />
		
			<#--  <@sping.showErrors "br" "field-error"/> -->											</br></br>
		价       格:<@spring.formInput "phone.price" />
		
			<#--  <@sping.showErrors "br" "field-error"/> -->											</br></br>
		评       价:<@spring.formTextarea "phone.description" />
		
			<#--  <@sping.showErrors "br" "field-error"/> -->											</br></br>
		
		<button TYPE="submit">确认提交</button>
	</form>
		
</@layout>

