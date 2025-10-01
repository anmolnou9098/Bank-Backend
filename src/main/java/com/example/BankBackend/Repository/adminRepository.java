package com.example.BankBackend.Repository;

import com.example.BankBackend.Model.BankadminModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface adminRepository extends JpaRepository<BankadminModel,Long> {
    Optional<BankadminModel> findByAadharNo(String aadharNo);
    @Query("SELECT SUM(a.cashDeposited) FROM Bank a")
    Double getTotalCashAvailable();
    @Query("SELECT a FROM Bank a ORDER BY a.id DESC")
    List<BankadminModel> getLastTransaction(Pageable pageable);

}
