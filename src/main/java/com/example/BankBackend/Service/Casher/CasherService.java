package com.example.BankBackend.Service.Casher;

import com.example.BankBackend.Model.BankadminModel;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CasherService {
     String transfer(Long id1,Long id2,int amount);
     List<BankadminModel> getDetails(Pageable pg);
}
