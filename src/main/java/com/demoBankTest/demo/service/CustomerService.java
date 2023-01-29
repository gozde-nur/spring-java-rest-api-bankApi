package com.demoBankTest.demo.service;

import com.demoBankTest.demo.model.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class CustomerService {

   public List<Customer> createCustomer(Customer customer,List<Customer> customerList){
       customerList.add(customer);
       return customerList;
   }
   public List<Customer> updateCustomer(Customer customer,String customerId, List<Customer> customerList){
       Customer oldCustomer = new Customer();
       for(int i=0; i<customerList.size();i++){
           if(customerId.equals(customerList.get(i).getId())){
               oldCustomer.setId(customerList.get(i).getId());
               customerList.remove(i);
               break;
           }
       }
       oldCustomer.setAddress(customer.getAddress());
       oldCustomer.setBirtDate(customer.getBirtDate());
       oldCustomer.setCity(customer.getCity());
       oldCustomer.setName(customer.getName());
       oldCustomer.setSurname(customer.getSurname());
       oldCustomer.setEmail(customer.getEmail());
       oldCustomer.setPhone(customer.getPhone());

       customerList.add(oldCustomer);
       return customerList;
   }
   public List<Customer> deleteCustomer(String customerId ,List<Customer> customerList){
       for(int i=0; i<customerList.size();i++){
           if(customerId.equals(customerList.get(i).getId())){
               customerList.remove(i);
               break;
           }
       }
       return customerList;
   }
   public Customer getCustomer(String customerId,List<Customer> customerList){
       Customer customer = null;
       for(int i=0; i<customerList.size();i++){
           if(customerId.equals(customerList.get(i).getId())){
               customer= customerList.get(i);
               break;
           }
       }
       return customer;
   }

}
