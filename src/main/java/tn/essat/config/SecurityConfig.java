package tn.essat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tn.essat.service.IUserService;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	IUserService service;
	//definir les users
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder crypte=cryptage();
	auth.userDetailsService(service).passwordEncoder(crypte);
	}
	//definir les autorisation sur le user
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/add**/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf();
		
	
	
	}
	@Bean
	public PasswordEncoder cryptage() {
		return new BCryptPasswordEncoder();
	}
	

}
