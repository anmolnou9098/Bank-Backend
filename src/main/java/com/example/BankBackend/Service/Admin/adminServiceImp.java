package com.example.BankBackend.Service.Admin;


import com.example.BankBackend.Model.BankadminModel;
import com.example.BankBackend.Repository.adminRepository;
import com.example.BankBackend.Service.Mail.SimpleMailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class adminServiceImp implements adminService {
    @Autowired
    private adminRepository adminrepo;

    @Autowired
    private SimpleMailer mailer;


    @Override
    public String createAccount(BankadminModel accountDetail) {
        if (adminrepo.findByAadharNo(accountDetail.getAadharNo()).isPresent()) {
            return "Account already exists with this Aadhar number";
        }

        adminrepo.save(accountDetail);
        mailer.sendMail(accountDetail.getEmail(),"Welcome....","Your Account is created with id "+accountDetail.getId()+"\n with Aadhar "+accountDetail.getAadharNo());

        return "Account with " + accountDetail.getMobileNo() + " is created successfully";
    }


    @Override
    public String deleteAccount(Long id) {
        Optional<BankadminModel> tobeDeleted =adminrepo.findById(id);
        if(tobeDeleted==null){
            throw new RuntimeException("Not Exist");
        }
        adminrepo.deleteById(id);
        BankadminModel delete=tobeDeleted.get();
        mailer.sendMail(delete.getEmail(),"Regret",
                "Your Accout No with id "+delete.getId()+" is deleted Scssesfully");
        return "Deleted ScccessFully";


    }

    @Override
    public String UpdateAccount(BankadminModel Accountdetail,Long id) {
        Optional<BankadminModel> toBeUpdate=adminrepo.findById(id);
        if(toBeUpdate==null){
            throw new RuntimeException("Id Not Exist");
        }
        Accountdetail.setId(id);
        adminrepo.save(Accountdetail);

        return "Account Update Successfully";


    }

    @Override
    public List<BankadminModel> getAllAccountDetails() {
       List<BankadminModel> getall= adminrepo.findAll();
       if(getall.isEmpty()){
           throw new RuntimeException("No Account Avalible ");
       }
       mailer.sendMail("anmolnougarhiya@gmail.com","List of All Account",""+getall);
       return getall;

    }

    @Override
    public Page<BankadminModel> getAdminByPagination(int pageNumber, int pageSize) {
        return adminrepo.findAll(PageRequest.of(pageNumber, pageSize));
    }
}
