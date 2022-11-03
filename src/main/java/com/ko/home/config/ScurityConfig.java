package com.ko.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.FormLoginBeanDefinitionParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ScurityConfig {

	@Bean
	WebSecurityCustomizer webSecurityConfig() {
		// Security에서 무시해야하는 URL 패턴 등록
		return web -> web
				.ignoring()
				.antMatchers("/images/**")
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/favicon/**")
				.antMatchers("/resources/**");
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity security)throws Exception {
		
		security
			.cors()
			.and()
			.csrf()
			.disable()
		.authorizeRequests() // 어떤 URL의 요청에 권한을 설정
			.antMatchers("/").permitAll() // 루트 밑 (인덱스)페이지는 누구나 허용
			.antMatchers("/login").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/manager").hasRole("MANAGER")
			.antMatchers("/qna/list").permitAll()
			.anyRequest().permitAll() // 그외 나머지는 누구나 허용
			.and()
		.formLogin()
			.loginPage("/member/login")
			.usernameParameter("id")
			.passwordParameter("pw")
			.defaultSuccessUrl("/")
			.failureUrl("/member/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();
		
		return security.build();
	}
	
	// 패스워드 인코더
	@Bean
	public PasswordEncoder getEncoder() {

		return new BCryptPasswordEncoder();
	}
	
}
