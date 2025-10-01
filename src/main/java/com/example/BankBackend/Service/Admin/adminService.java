package com.example.BankBackend.Service.Admin;

import com.example.BankBackend.Model.BankadminModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface adminService {
    String createAccount(BankadminModel Accountdetail);
    String deleteAccount(Long id);
    String UpdateAccount(BankadminModel Accountdetail,Long id);



    List<BankadminModel> getAllAccountDetails();
    Page<BankadminModel> getAdminByPagination(int pageNumber, int pageSize);

}
