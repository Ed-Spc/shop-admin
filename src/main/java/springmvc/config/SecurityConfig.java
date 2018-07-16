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
			.authorizeRequests()  //������Ȩ
			.antMatchers("/login").permitAll() //loginҳ�����������˵�½
			.antMatchers("/**").authenticated() //ͨ�������֤�Ŀ��Է�������ҳ��
			
			.and()
			
			.sessionManagement()   //�Ự����
				.maximumSessions(1) //���ͬʱ��½�� 1
				.sessionRegistry(sessionRegistry())
				.and()
			.and()
			.formLogin()    //����¼
			.loginPage("/login")  //ָ����¼ҳ��·��
			.defaultSuccessUrl("/"); //ָ��Ĭ�ϵ�¼�ɹ�ҳ�� ·��
	}
	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}
	
}
