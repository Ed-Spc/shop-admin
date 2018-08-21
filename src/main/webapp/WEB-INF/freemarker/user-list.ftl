<#include 'layout.ftl'>

<@layout title="用户列表">

	<h1>用户详情</h1>
		<#list users as user>
			<ul>
				<li>用户名 : ${user.username} </li>
				<li>性别:  ${user.gender} </li>
				<li>启用:  ${user.enable} </li>
				<li>最近一次登录时间: ${user.lastlogin }</li>
			
			</ul>
		</#list>

</@layout>