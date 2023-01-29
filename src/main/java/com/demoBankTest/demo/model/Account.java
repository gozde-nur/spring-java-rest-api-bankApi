package com.demoBankTest.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account extends BaseEntity{
    private String customerId;
    private Integer createdYear;
    private Currency currency;
    private Double balance;
}
