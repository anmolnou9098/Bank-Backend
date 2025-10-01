package com.example.BankBackend.Repository;

import com.example.BankBackend.Model.CasherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface casherRepository extends JpaRepository<CasherModel,Integer> {

}