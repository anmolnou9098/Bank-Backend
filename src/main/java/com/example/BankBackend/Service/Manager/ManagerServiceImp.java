package com.example.BankBackend.Service.Manager;

import com.example.BankBackend.Repository.ManagerRepository;
import com.example.BankBackend.Repository.adminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements ManagerService{

    @Autowired
    private adminRepository adminrepo;



    @Autowired
    private ManagerRepository managerRepo;
    @Override
    public String countofAcounts() {
       Long count= adminrepo.count();
       return "No. of Active Accounts:"+count;
    }

    @Override
    public String TotalCashAvalibale() {
        Double totalcash=adminrepo.getTotalCashAvailable();
        if(totalcash==null){
            return "0.0";
        }
        return "Avalible cash is bank :"+totalcash;
    }

}
