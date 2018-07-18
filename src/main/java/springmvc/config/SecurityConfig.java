package springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig{
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager us = new InMemoryUserDetailsManager();
			us.createUser( User.withUsername("����")
										.password("123456")
										.authorities("admin").build()
					);
		
		return us;
	}


}
