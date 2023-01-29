package com.demoBankTest.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer extends BaseEntity{
    private String name;
    private String surname;
    private String address;
    private City city;
    private String email;
    private String phone;
    private Integer birtDate;
}
