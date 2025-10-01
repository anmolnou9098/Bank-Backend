package com.example.BankBackend.Controller;

import com.example.BankBackend.Model.BankadminModel;
import com.example.BankBackend.Service.Admin.adminServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private adminServiceImp adminservice;

    @PostMapping("/create")
    public ResponseEntity<String> createAccount(
            @Valid @RequestBody BankadminModel accountDetails) {
        String response = adminservice.createAccount(accountDetails);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<BankadminModel>> getAllAccount(){
        List<BankadminModel> get=adminservice.getAllAccountDetails();
        return new ResponseEntity<>(get,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody BankadminModel UpdateAccount ,@PathVariable Long id){
        String update=adminservice.UpdateAccount(UpdateAccount,id);
      return new ResponseEntity<>(update,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        String delete =adminservice.deleteAccount(id);
        return new ResponseEntity<>(delete,HttpStatus.ACCEPTED);

    }
}
