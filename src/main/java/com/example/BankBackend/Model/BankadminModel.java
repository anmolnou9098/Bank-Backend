package com.example.BankBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Bank")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BankadminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @NotBlank
    private String address;
    @NotBlank
    @Size(min = 12,message = "Can not be Empty")
    private String aadharNo;
    @NotBlank
    @Size(min = 10,message = "Can not be Empty")
    private String MobileNo;
    private String email;
    private Integer cashDeposited;

}
