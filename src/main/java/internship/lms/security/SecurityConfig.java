package internship.lms.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationHandler successHandler;
	
	@Autowired
	DataSource dataSource;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select uname,pass,enabled from user where uname=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/test2.html").hasRole("ADMIN")
				.antMatchers("/userforgetpass/**").hasRole("ANONYMOUS")
				.antMatchers("/**").hasRole("USER")
				.and().formLogin().loginPage("/login.jsp").successHandler(successHandler)
				.permitAll().and().logout().permitAll();

	}

} 

