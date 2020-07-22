package com.org.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.app.entity.Token;
import com.org.app.repository.TokenRepository;
import com.org.app.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService{

	@Autowired
	private TokenRepository repository;
	@Override
	public Token findBytokenValue(String tokenValue) {
		return repository.findByTokenValue(tokenValue);
	}

}
