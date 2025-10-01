package com.example.BankBackend.Controller;

import com.example.BankBackend.Service.Manager.ManagerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerServiceImp msi;
    @GetMapping("/count")
    public ResponseEntity<String> totalaccounts(){
        String total= msi.countofAcounts();
        return new ResponseEntity<>(total, HttpStatus.FOUND);
    }
    @GetMapping("/cash")
    public  ResponseEntity<String> totalcash(){
        String totalcash= msi.TotalCashAvalibale();
        return new ResponseEntity<>(totalcash,HttpStatus.OK);
    }
}
