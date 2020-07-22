package com.org.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.app.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long>{
	public Token findByTokenValue(String tokenValue);
}
