package com.glearning.collegefest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.glearning.collegefest.service.DomainUserDetailsService;

@Configuration
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DomainUserDetailsService domainUserDetailsService;
	
	@Override
	public void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
		authManagerBuilder
		.userDetailsService(this.domainUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable();
		http.headers().disable();
		
		http.authorizeRequests()
		    .antMatchers("/h2-console/**")
		    .permitAll()
		    .antMatchers(HttpMethod.GET, "/students*","/students/**")
	        .hasAnyRole("USER", "ADMIN") 
		    .antMatchers(HttpMethod.POST, "/students*","/students/**")
		    .hasRole("ADMIN")
		    .anyRequest().authenticated()
		    .and()
		    .httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
