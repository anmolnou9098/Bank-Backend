package com.example.BankBackend.Repository;

import com.example.BankBackend.Model.BankadminModel;
import com.example.BankBackend.Model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ManagerRepository extends JpaRepository<ManagerModel,Integer> {




}
