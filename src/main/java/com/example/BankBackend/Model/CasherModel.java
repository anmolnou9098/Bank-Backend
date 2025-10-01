package com.example.BankBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="Casher")
@AllArgsConstructor
@NoArgsConstructor
@Data


public class CasherModel {
   @Id
   private int id;
   private Long id1;
   private Long id2;
   private int amount;
}
