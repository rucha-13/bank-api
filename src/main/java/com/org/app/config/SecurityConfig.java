package com.org.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.org.app.service.TokenService;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	private static final Logger LOG = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Value("${http.auth.tokenName}")
    private String authHeaderName;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		PreAuthTokenFilter filter = new PreAuthTokenFilter(authHeaderName);
		filter.setAuthenticationManager(new AuthenticationManager() {

			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				String principal = (String) authentication.getPrincipal();
				 if (tokenService.findBytokenValue(principal.toString()) == null)
	                {
	                    throw new BadCredentialsException("The API key was not found.");
	                }
	                authentication.setAuthenticated(true);
	                return authentication;
			}
			
		});
		 http.authorizeRequests()
	        .antMatchers
	        ("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui", "/webjars/**")
	        .permitAll()
		 .and()
		 .antMatcher("/**/").
		 csrf().disable().
         sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
         and().addFilter(filter).authorizeRequests(). anyRequest().authenticated();
         
		 /*http.authorizeRequests()
	        .antMatchers
	        ("/v2/api-docs", "/swagger-resources/configuration/ui", "/swagger-resources", "/swagger-resources/configuration/security", "/swagger-ui", "/webjars/**")
	        .permitAll()
	        .and().addFilter(filter)
	        .authorizeRequests()
	        .anyRequest()
	        .authenticated()
	        .and()
	        .csrf().disable();*/
	}
	
}
