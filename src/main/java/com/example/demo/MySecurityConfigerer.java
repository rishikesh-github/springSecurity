package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class MySecurityConfigerer extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		InMemoryUserDetailsManager user = new InMemoryUserDetailsManager();
//		UserDetails build = User.withUsername("rishi").password(passwordEncoder.encode("googlebest")).authorities("read").build();
//		user.createUser(build);
//		auth.userDetailsService(user).passwordEncoder(passwordEncoder);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
	}
}
