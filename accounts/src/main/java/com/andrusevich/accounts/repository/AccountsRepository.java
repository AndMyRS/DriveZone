package com.andrusevich.accounts.repository;

import com.andrusevich.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomerId(Long id);

    @Transactional
    @Modifying
    void deleteByCustomerId(Long id);
}
