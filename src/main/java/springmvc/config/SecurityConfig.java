package springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()  //请求授权
			.antMatchers("/login").permitAll() //login页面允许所有人登陆
			.antMatchers("/**").authenticated() //通过身份验证的可以访问其他页面
			
			.and()
			
			.sessionManagement()   //会话管理
				.maximumSessions(1) //最大同时登陆数 1
				.sessionRegistry(sessionRegistry())
				.and()
			.and()
			.formLogin()    //表单登录
			.loginPage("/login")  //指定登录页面路径
			.defaultSuccessUrl("/"); //指定默认登录成功页面 路径
	}
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
}
