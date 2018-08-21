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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration			//���������ļ�
@ComponentScan("springmvc")   //�����Զ�ɨ��
@EnableWebMvc 					
@MapperScan("springmvc.mapper") 	
@EnableTransactionManagement //����spring����֧��
@PropertySource("classpath:jdbc.properties")		
public class AppConfig extends WebMvcConfigurerAdapter {
	/*	@Override
		public void configureViewResolvers(ViewResolverRegistry registry) {
			// book-list -> /WEB-INF/jsp/book-list.jsp
			// ���ڿ������������ص��ַ������������¹��������jsp·����Ȼ��forward
			// ǰ׺ + �����ַ��� + ��׺ = jsp·��
			//            ǰ׺                                      ��׺
			registry.jsp("/WEB-INF/jsp/", ".jsp");
		}*/
		
		@Bean
		public ViewResolver freeMarkerViewResolver() {
			FreeMarkerViewResolver fmkr = new FreeMarkerViewResolver("",".ftl");
			fmkr.setCache(false);  //关闭缓存 适合开发修改
			fmkr.setContentType("text/html;charset=utf-8");  //防止乱码
			return fmkr;
		}
		@Bean
		public FreeMarkerConfigurer freeMarkerConfigurer() {
			FreeMarkerConfigurer config =new FreeMarkerConfigurer();
			config.setTemplateLoaderPath("/WEB-INF/freemarker/");
			return config;
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
		
		@Bean // ����Mybatis�ĻỰ����
		public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
			SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
			sf.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
			sf.setDataSource(dataSource);
			return sf;
		}			
		
		@Bean	// spring������Ҫ������������
		public PlatformTransactionManager transactionManager(DataSource dataSource) {
			
			return new DataSourceTransactionManager(dataSource);
		}
	@Override //springMVC�޷�����Ľ���servlet����
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	// TODO Auto-generated method stub
		configurer.enable();
	}
}
