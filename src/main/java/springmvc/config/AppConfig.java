package springmvc.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration			//标明配置文件
@ComponentScan("springmvc")   //开启自动扫描
@EnableWebMvc 					
@MapperScan("springmvc.mapper") 	
@EnableTransactionManagement //开启spring事务支持
@PropertySource("classpath:jdbc.properties")		
public class AppConfig extends WebMvcConfigurerAdapter {
		@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			// book-list -> /WEB-INF/jsp/book-list.jsp
			// 对于控制器方法返回的字符串，会用以下规则解析成jsp路径，然后forward
			// 前缀 + 返回字符串 + 后缀 = jsp路径
			//            前缀                                      后缀
			registry.jsp("/WEB-INF/jsp/", ".jsp");
		}
		
		@Bean
		public DataSource dataSource(Environment env) { 
			DriverManagerDataSource ds = new DriverManagerDataSource(
					env.getProperty("jdbc.url"),
					env.getProperty("jdbc.username"),
					env.getProperty("jdbc.password"));
			ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
			return ds;
		}	
		
		@Bean // 定义Mybatis的会话工厂
		public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
			SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
			sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
			sf.setDataSource(dataSource);
			return sf;
		}
		
		@Bean	// spring事务需要事务管理器组件
		public PlatformTransactionManager transactionManager(DataSource dataSource) {
			
			return new DataSourceTransactionManager(dataSource);
		}
	
}
