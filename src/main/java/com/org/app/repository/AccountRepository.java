package com.org.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
