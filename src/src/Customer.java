package src;

public class Customer { 
    private String customerName;
    private String customerPassword;
    private double customerBalance;
    private String customerPin;
    private String customerAcctNo;

    public Customer(){
        
    }
    
    public Customer(String customerAcctNo){
        this.customerAcctNo = customerAcctNo;
    }

    public Customer(String customerName, String customerAcctNo, String customerPassword, String customerPin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
            
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String CustomerPassword) {
        this.customerPassword = CustomerPassword;
    }

    public double getCustomerBalance() {
        return customerBalance;
    }

    public void setCustomerBalance(double CustomerBalance) {
        this.customerBalance = CustomerBalance;
    }

    public String getCustomerPin() {
        return customerPin;
    }

    public void setCustomerPin(String CustomerPin) {
        this.customerPin = CustomerPin;
    }

    public String getCustomerAcctNo() {
        return customerAcctNo;
    }

    public void setCustomerAcctNo(String customerAcctN0) {
        this.customerAcctNo = customerAcctN0;
    }
    
}
