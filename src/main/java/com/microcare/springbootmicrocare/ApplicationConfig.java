package com.microcare.springbootmicrocare;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
@SuppressWarnings("deprecation")
@Configuration 
public class ApplicationConfig extends WebSecurityConfigurerAdapter { 
   @Bean 
   public PasswordEncoder passwordEncoder() { 
      return new BCryptPasswordEncoder(); 
   } 
   @Override 
   protected void configure(HttpSecurity http) throws Exception { 
     /* http 
      .csrf().disable()
      .authorizeRequests()
      .antMatchers("/orders").permitAll()
      .antMatchers("/signup").permitAll()
      .antMatchers("/Order/{id}").permitAll()
      .antMatchers("/**").authenticated()
      .and()
     .formLogin().loginPage("/login")
     .permitAll() 
      .and() 
      .logout().invalidateHttpSession(true) 
      .clearAuthentication(true).permitAll(); 
   }
*/
	   http.cors();
	      http 
	      .csrf().disable()
	      .authorizeRequests()
	      .antMatchers("/signup").permitAll()
	      .antMatchers("/**").authenticated()
	      .and()
	      .httpBasic();


}}
