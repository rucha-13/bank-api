package com.org.app.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class PreAuthTokenFilter extends AbstractPreAuthenticatedProcessingFilter{

	private static final Logger LOG = LoggerFactory.getLogger(PreAuthTokenFilter.class);
	
	private String authHeaderName;
	
	public PreAuthTokenFilter(String authHeaderName) {
		this.authHeaderName = authHeaderName;
	}
	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		 return request.getHeader(authHeaderName);
	}

	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		 return null;
	}

}
