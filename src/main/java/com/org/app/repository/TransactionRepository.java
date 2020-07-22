package com.org.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.app.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    Optional <List<Transaction>> findByAccountAccountIDOrderByTimestampAsc(long accountId);
}
