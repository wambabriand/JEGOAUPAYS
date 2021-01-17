package com.security;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.cors(c ->{
				CorsConfigurationSource cs = r -> {
					CorsConfiguration cc = new CorsConfiguration();
					cc.setAllowedOrigins( List.of("*"));
					cc.setAllowedMethods( List.of("GET","POST","PUT", "DELETE", "OPTIONS"));
					cc.setAllowedHeaders(List.of("*"));
					
					return cc;
				};
				c.configurationSource(cs);
			})
			//.and()
			.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilter(new JwtAuthenFilter(authenticationManager()))
			.addFilterAfter(new JwtVerifierToken(), JwtAuthenFilter.class)
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/admin").permitAll()
			.antMatchers("/static/**").permitAll()
			.antMatchers("/home").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/api/jego/unlock/**").permitAll()
			.antMatchers("/api/all/**").permitAll()
			//.antMatchers("/api/jego/lock/admin/**")
			//.hasAuthority("ROLE_admin")
			//.permitAll()
			.antMatchers("/api/jego/lock/admin/**").hasAnyRole("admin")
			.antMatchers("/api/user/**").hasRole("user")
			.antMatchers("/**").permitAll()
			.anyRequest()
			.authenticated();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	/*
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE", "OPTIONS"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
	}
	
	
	 
	 CorsConfigurationSource cs =  r -> {
			CorsConfiguration cc = new CorsConfiguration();
			cc.setAllowedOrigins( List.of("*"));
			cc.setAllowedMethods( List.of("GET","POST","PUT", "DELETE"));
			return cc;
		};
		return cs;
	 
	 * 
	 .cors( c ->{
				CorsConfigurationSource cs = r -> {
					CorsConfiguration cc = new CorsConfiguration();
					cc.setAllowedOrigins( List.of("*"));
					cc.setAllowedMethods( List.of("GET","POST","PUT", "DELETE"));
					return cc;
				};
				c.configurationSource(cs);
			})
	 
	 */
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	
}
