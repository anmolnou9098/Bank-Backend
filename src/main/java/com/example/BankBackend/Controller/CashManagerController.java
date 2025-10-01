package com.example.BankBackend.Controller;

import com.example.BankBackend.Model.BankadminModel;
import com.example.BankBackend.Repository.casherRepository;
import com.example.BankBackend.Service.Casher.CasherImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cash")
public class CashManagerController {
    @Autowired
    private CasherImp cash;

    @PutMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long id1, @RequestParam Long id2, @RequestParam int amount) {
        String res = cash.transfer(id1, id2, amount);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

    @GetMapping("/last")
    public ResponseEntity<List<BankadminModel>> lastdetails(@RequestParam int n){
        List<BankadminModel> a=cash.getDetails(PageRequest.of(0,n));
        return new ResponseEntity<>(a,HttpStatus.FOUND);
    }

}