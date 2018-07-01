package internship.lms.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SuccessHandler successHandler;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private RestAccessDeniedHandler restAccessDeniedHandler;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select uname,pass,enabled from user where uname=?")
		.authoritiesByUsernameQuery("select user_uname, role from user_roles where user_uname=?");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/test2.html").hasRole("ADMIN")
				.antMatchers("/userforgetpass/**").hasAnyRole("ANONYMOUS","USER","ADMIN")
				.antMatchers("/adduser").hasAnyRole("ANONYMOUS","USER","ADMIN")
				.antMatchers("/**").hasAnyRole("USER","ADMIN")
				.anyRequest().authenticated()
			    .and()
				.exceptionHandling()
			    .accessDeniedHandler(restAccessDeniedHandler)
				.and().formLogin().loginPage("/login.jsp").successHandler(successHandler)
				.permitAll().and().logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
			    .deleteCookies("JSESSIONID")
			    .permitAll();
	}

} 

