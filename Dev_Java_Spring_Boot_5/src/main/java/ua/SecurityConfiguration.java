package ua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	private final UserDetailsService service;
	
	public SecurityConfiguration(UserDetailsService service) {
		this.service = service;
	}
	
	@Autowired
	public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder
		.userDetailsService(this.service)
		.passwordEncoder(encoder());
	}

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.usernameParameter("login")
			.passwordParameter("password")
			.loginPage("/login")
			.failureUrl("/login?fail=true")
		.and().logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.deleteCookies("JSESSIONID", "Secret_cookei")
		.and()
			.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/admin/**").hasRole("ADMIN")
			
			.anyRequest().permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/")
		.and()
			.rememberMe()
			.rememberMeParameter("rememberMe")
			.key("my super secret key")
			.rememberMeCookieName("Secret_cookei");
	}
}
