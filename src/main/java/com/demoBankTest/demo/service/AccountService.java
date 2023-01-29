package com.demoBankTest.demo.service;

import com.demoBankTest.demo.model.Account;
import com.demoBankTest.demo.model.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service
public class AccountService {
    private final CustomerService customerService;
    private final List<Customer> customerList;

    public AccountService(CustomerService customerService, List<Customer> customerList) {
        this.customerService = customerService;
        this.customerList = customerList;
    }

    public Account createdAccount(Account account,List<Account> accountList){
        if(checkCustomerId(account.getCustomerId())){
            accountList.add(account);
        }

        return account;
    }

    public void deleteAccount(String accountId,List<Account> accountList){
        for(int i=0; i<accountList.size();i++){
            if(accountId.equals(accountList.get(i).getId())){
                customerList.remove(i);
                break;
            }
        }

    }

    public Account getAccount(String accountId,List<Account> accountList){
        Account account=null;
        for(int i=0; i<accountList.size();i++){
            if(accountId.equals(accountList.get(i).getId())){
                account=accountList.get(i);
                break;
            }
        }

        return account;
    }

    public Account withdrawMoney(String accountId, Double amount,List<Account> accountList){
      Account account = getAccount(accountId,accountList);
      if(account==null){
          System.out.println("Couldnt find any accountId with this id: "+ accountId);
          return null;
      }else{
         Double balance= account.getBalance();
         if(balance>amount){
             account.setBalance(balance- amount);
             updateAccount(account,accountId,accountList);
         }else{
             System.out.println("Insseficient funds for this account"+ accountId+ "current balance is:"+balance);

         }

      }
      return  account;
    }
    public Account addMoney(String accountId,Double amount, List<Account> accountList){
        Account account = getAccount(accountId,accountList);
        if(account==null){
            System.out.println("Couldnt find any accountId with this id: "+ accountId);
            return null;
        }else{
            Double balance= account.getBalance();
            if(balance>amount){
                account.setBalance(balance+ amount);
                updateAccount(account,accountId,accountList);
            }

        }
        return  account;

    }

    private List<Account> updateAccount(Account account,String accountId,List<Account> accountList){
        Account oldAccount = new Account();
        for(int i=0; i<accountList.size();i++){
            if(accountId.equals(accountList.get(i).getId())){
                oldAccount= accountList.get(i);
                accountList.remove(i);
                break;
            }
        }
        oldAccount.setBalance(account.getBalance());

        accountList.add(oldAccount);
        return accountList;
    }
    private boolean checkCustomerId(String customerId) {
        Customer customer = customerService.getCustomer(customerId,customerList);
        if(customer==null){
            return false;
        }else{
            System.out.println("Couldnt find any customer with this id: "+ customerId);
            return true;
        }
    }
}
