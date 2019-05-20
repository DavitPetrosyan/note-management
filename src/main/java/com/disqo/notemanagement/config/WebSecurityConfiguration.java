package com.disqo.notemanagement.config;

import com.disqo.notemanagement.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;


	@Override
	public void configure(HttpSecurity http) throws Exception {

		http
				//HTTP Basic authentication
				.httpBasic()
				.and()
				.authorizeRequests()
				.anyRequest()
				.authenticated()
//				.antMatchers(HttpMethod.GET, "/notes/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/notes/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/notes/**").permitAll()
				.and()
				.csrf().disable()
				.formLogin().disable()
				.headers().frameOptions().disable();
	}

/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("{noop}Admin123456")
				.roles("ADMIN", "USER");
	}*/


	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(this.userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}

