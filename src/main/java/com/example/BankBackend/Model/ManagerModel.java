package com.example.BankBackend.Model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "Manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestNo;
    private int NumberofAccount;
    private int TotalCash;
}
