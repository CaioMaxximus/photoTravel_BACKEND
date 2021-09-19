package com.PhotoTravel.photoTravel.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private HttpSecurity httpSecurity;
	@Autowired
	private JWTRequestFilter jwtRequestFilter;
	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	this.httpSecurity = httpSecurity;
	httpSecurity.csrf().disable()
	// Não cheque essas requisições
	.authorizeRequests().antMatchers("/login","/posts/{userNick}/{order}", "/users/search/{nick}/short", "/users/search/{nick}/long", "/users" ,"/posts/**", "/users/all").permitAll().
	// Qualquer outra requisição deve ser checada
	anyRequest().authenticated().and().
	exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
}
