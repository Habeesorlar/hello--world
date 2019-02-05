package bankoop;

import Connectivity.DataReader;
import Connectivity.DataWriter;
import java.io.IOException;
import java.sql.SQLException;
//import java.util.HashMap;
//dimport src.Customer;
import src.Bank;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import admin.Admin;

public class Main {
    
    public static void main(String[] args) throws SQLException {
        Bank bank = new Bank();// sets an instance of the class
        bank.setBankName("GTB");
        System.out.println("Welcome to " + bank.getBankName());
        Scanner input = new Scanner(System.in);
        displayMainMenu(input); // This function calls the displayMenu method;
        customerDisplayMenu(); 
        customerHandlemenu();
        
    }

    public static void displayMainMenu(Scanner inputScanner) {
        System.out.println("MAIN MENU");
        System.out.println("Please Select an Option");
        System.out.println("1) Admin\n2) Customer\n3) Exit");
        int option = inputScanner.nextInt();
        switch(option){
        
            case 1:
        {
            try {
                displayAdminmenu(inputScanner);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }

    public static void adminMenu() { // This method defines the admin menu page
        System.out.println("Select an Option");
        System.out.println("1 )Add New Customer\n2) Update Customer Record\n3) View Customer Details\n4) Delete a Customer\n5) Quit");
    }
    public static void validateAdminLogin(){//admin validation 
        Admin.login();
        
    }

    public static void displayAdminmenu(Scanner inputScanner) throws IOException, SQLException {// This method display the Admin menu page
        validateAdminLogin();
        adminMenu();
        Scanner inputString = new Scanner(System.in);
        int option = inputScanner.nextInt();
        
        switch (option) {
            case 1:
                System.out.println("Provide Customer Name");
                String customername = inputString.nextLine();
                System.out.println("Provide Customer Password");
                String customerpassword = inputString.nextLine();
                System.out.println("Provide Customer Account Number");
                String customeraccountnumber = inputString.nextLine();
                System.out.println("Provide CustomerPin");
                String customerPin = inputString.nextLine();
                System.out.println("Provide Customer Balance");
                double customerbalance = inputScanner.nextDouble();
                DataWriter.addCustomer(customername, customerpassword, customeraccountnumber, customerPin,customerbalance);
                break;
            case 2:
                System.out.println("Provide Customer Id");// This case updates a customer record;
                int id = inputScanner.nextInt();
                System.out.println("Provide Customer Name");
                customername = inputString.nextLine();
                System.out.println("Provide Customer Password");
                customerpassword = inputString.nextLine();
                System.out.println("Provide Customer Account Number");
                customeraccountnumber = inputString.nextLine();
                System.out.println("Provide Customer Pin");
                customerPin = inputString.nextLine();
                DataWriter.customerUpdate(id, customername, customerpassword, customeraccountnumber, customerPin);
                break;
            case 3:
                /*System.out.println("Provide Customer Id"); // This case deletes a row from the database
                id = inputScanner.nextInt();*/
                DataReader.viewCustomer();
                break;
            case 4:
                System.out.println("Provide Customer Id"); // This case deletes a row from the database
                id = inputScanner.nextInt();
                DataWriter.customerDelete(id);
                
            case 5: 
                System.out.println("Thank You");
            default: System.out.println("Invalid Selection"); 
                break;
        }

    }
    public static void customerDisplayMenu() {
        System.out.println("MENU");
        System.out.println("1) Deposit\n2) Withdraw\n3) SendMoney\n4) ViewBalance\n5) Quit");
        System.out.println("Please Select an Option");
       
    }
    public static void customerHandlemenu() throws SQLException{
        customerDisplayMenu();
        Scanner inputScanner = new Scanner(System.in);
        
        int customermenu = inputScanner.nextInt();
         switch (customermenu) {
                
                case 1:
                    System.out.println("Provide the amount you want to deposit");
                    double amount = inputScanner.nextDouble();
                    System.out.println("Provide your account Number");
                    String customerAccountNumber = inputScanner.next();
                    double customerbalance = 0;
                    DataWriter.deposit(customerbalance, customerAccountNumber);
                    
                    break;
                case 2:
                   
                    break;
                case 3:
                    
                    break;
                case 4:
                   
                    break;
                case 5:
                    System.out.println("Thank You For Banking With Us");
                    break;
                default:
                    System.out.println("Invalid Selection type");
                    break;
            }
    
    
    }

    public static String collectCustomerName(Scanner inputScanner) {
        System.out.println("Please provide your Name");
        String customerName = inputScanner.nextLine();
        return customerName;
    }

    public static String inputcustomerPassword(Scanner inputScanner) {
        System.out.println("Please Provide Your Password");
        String customerPassword = inputScanner.nextLine();
        return customerPassword;
    }

    public static String providecustomerAccountNumber(Scanner inputScanner) {
        System.out.println("Please Provide Your AccountNumber");
        String customerAccountNumber = inputScanner.nextLine();
        return customerAccountNumber;
    }

    public static double depositAmount(Scanner inputScanner) {
        System.out.println("Please Enter Your Deposit Amount");
        double amount = inputScanner.nextDouble();
        return amount;
    }

    public static double withdrawAmount(Scanner inputScanner) {
        System.out.println("Please Enter the Amount to withdraw");
        double amount = inputScanner.nextDouble();
        return amount;
    }

    public static String inputcustomerPin(Scanner inputScanner) {
        System.out.println("Please Provide Your Pin");
        String customerPIN = inputScanner.nextLine();
        return customerPIN;
    }

    public static String inputreceiverName(Scanner inputScanner) {
        System.out.println("Please Provide The Receiver Name");
        String receiverName = inputScanner.nextLine();
        return receiverName;
    }

    public static String inputreceiverAccountNumber(Scanner inputScanner) {
        System.out.println("Please Provide the receiver Account Number");
        String receiverAcctNo = inputScanner.nextLine();
        return receiverAcctNo;
    }

    public static double sendAmount(Scanner inputScanner) {
        System.out.println("Please Provide the amount you wish to Transfer");
        double amount = inputScanner.nextDouble();
        return amount;
    }
}
