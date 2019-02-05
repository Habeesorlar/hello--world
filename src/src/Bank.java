/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.HashMap;

public class Bank {
    
    private double bankBalancePool;
    private String bankName;
    private  HashMap<String, Customer> bankCustomers = new HashMap<>(); 

    public double getBankBalancePool() {
        return bankBalancePool;
    }

    public void setBankBalancePool(double bankbalancepool) {
        this.bankBalancePool = bankbalancepool;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankname) {
        this.bankName = bankname;
    }

    public HashMap<String, Customer> getBankcustomers() {
        return bankCustomers;
    }

    public void setBankcustomers(HashMap<String, Customer> bankcustomers) {
        this.bankCustomers = bankcustomers;
    }
    
    public String deposit(double amount, String customerName, String customerPassword, String customerAccountNumber){
        Customer customer = bankCustomers.get(customerAccountNumber);
        if(customer == null){
            return "Customer does not exist";
        }
        String foundCustomerPassword = customer.getCustomerPassword();
        if(!foundCustomerPassword.equals(customerPassword)){
            return "Please provide valid password";
        }
        
        double customerBalance = customer.getCustomerBalance();
        customerBalance += amount;
        
        bankBalancePool +=  amount;
        
        return "Deposit successful";
    } 
    
    public String withdraw(double amount, String customerAccountNumber,String customerPin ){ 
        Customer customer = bankCustomers.get(customerAccountNumber);
        //validate the customer
        if(customer == null){
            return "Customer does not exist";
        }
        // validate the pin
        String validcustomerPin  = customer.getCustomerPin();
        if(!validcustomerPin.equals(customerPin)){
            return "Invalid pin";
        }
  
        //get customerbalance from the retrieved customer
        double customerBalance = customer.getCustomerBalance();
        
        if (customerBalance > amount){
            customerBalance = customerBalance - amount;
            
            bankBalancePool = customerBalance - amount;
          
            return "Take your cash.";
            
        }else return "Insufficient fund.";
    }
    
    public String sendMoney(double amount, String customerAccountNumber, String customerPIN, String receiverAcctNo, String receiverName){
        Customer customer = bankCustomers.get(customerAccountNumber);
        
        if (customer == null){
            return "Customer does not exist";
        }
        double senderBalance  = customer.getCustomerBalance();
        String senderPIN = customer.getCustomerPin();
        if(!senderPIN.equals(customerPIN)){
            return "Please Enter a Valid Pin";
        }
        
        Customer receiver = bankCustomers.get(receiverAcctNo);
        if (receiver == null){
            return "Sorry, the receiver is not our customer";
        }
        
        if(senderBalance < amount){
            return "Insufficient fund.";
        }
        
        String foundReceiverName = receiver.getCustomerName();
        
        if (!foundReceiverName.equalsIgnoreCase(receiverName)){
          
           return "Sorry, account number does not match account name";
        }else {
            double receiverBalance = receiver.getCustomerBalance();
            
            receiverBalance += amount;
            
            senderBalance -= amount;
        }
        
        return "Transaction Completed"; 
    }            
      
    public String viewcustomerBalance(String customerAccountNumber,String customerPassword){
        Customer customer = bankCustomers.get(customerAccountNumber);
        if(customer == null){
            return "You are not a Member of This Bank";
        }
        String foundCustomerPassword = customer.getCustomerPassword();
        
        if(!foundCustomerPassword.equals(customerPassword)){
           return "Invalid Pin";
        }
        else return "Your Balance is" + String.valueOf(customer.getCustomerBalance());
    
    }
}
