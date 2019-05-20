package com.disqo.notemanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * author by davitpetrosyan on 2019-05-20.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

		//TODO @Davit (temporary permit all requests)
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("admin")
				.password("{noop}Admin123456")
				.roles("ADMIN", "USER");
	}
}

