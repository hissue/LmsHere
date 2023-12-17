package com.homework.lms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("studentId")
				.defaultSuccessUrl("/login")
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true);

		http.authorizeHttpRequests()
//			.requestMatchers("/comment/**",
//					"/course/**",
//					"/lecture/**",
//					"/lecturecomment/**",
//					"/major/**",
//					"/role/**",
//					"/student/**").hasRole("USER")
//			.requestMatchers("/board/**").hasAnyRole("USER","ADMIN")
//			.requestMatchers("/**","/css/**","/js/**","/images/**").permitAll()
			.requestMatchers("/**").permitAll();
		
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
}
