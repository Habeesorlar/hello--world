
package Connectivity;


import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.Customer;

public class DataWriter {

    public static void addCustomer(String customername, String customerPassword, String customeraccountnumber, String customerPin,double customerbalance) throws IOException, SQLException {
        Connection conn = new ConnectionManager().getDbconnection();

        try {
            String sql = "insert into Customers(customer_name,customer_password,customer_account_number, customer_pin,customer_balance)values(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, customername);
            preparedStatement.setString(2, customerPassword);
            preparedStatement.setString(3, customeraccountnumber);
            preparedStatement.setString(4, customerPin);
            preparedStatement.setDouble(5, customerbalance);
            preparedStatement.executeUpdate();

            System.out.println("Customers Sucessfully added");
        } catch (SQLException ex) {
            if(ex.getClass() == SQLIntegrityConstraintViolationException.class){
                System.out.println("This account number has already been assigned to another customer.");
            }else{
                System.out.println("Not Added Sucessfully");
                Logger.getLogger(DataWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        conn.close();

    }

    public static void customerUpdate(int id, String customername, String customerPassword, String customeraccountnumber, String customerPin) {
        Connection conn = new ConnectionManager().getDbconnection();

        try {
            String sql = "UPDATE Customers SET customer_name = ? , customer_password = ?, customer_account_number = ?, customer_pin = ? WHERE id = ?";
            System.out.println("customer name ="+customername);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,customername);
            preparedStatement.setString(2, customerPassword);
            preparedStatement.setString(3, customeraccountnumber);
            preparedStatement.setString(4, customerPin);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            
            conn.close();
            System.out.println("Customers Sucessfully updated");
            
        } catch (SQLException ex) {
            System.out.println("customer not Updated");
          Logger.getLogger(DataWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void customerDelete(int id) throws SQLException {
        Connection conn = new ConnectionManager().getDbconnection();

        try {
            String sql = "DELETE FROM Customers WHERE id=?" ;
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
           
            System.out.println("Row deleted sucessfully");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }conn.close();
    }
    
    
    public static void deposit(double customerbalance, String customerAccountNumber) throws SQLException{
        Connection conn = new ConnectionManager().getDbconnection();
        double amount = 1000;
        
        try {
            
            String sql = "UPDATE Customers SET customer_balance = ? WHERE customer_account_number = ?";
            PreparedStatement update = conn.prepareStatement(sql);
            update.setDouble(1, customerbalance);
            update.setString(2, customerAccountNumber);
            update.executeUpdate();
            System.out.println("Deposit Successfull"+customerbalance);

        } catch (SQLException ex) {
            Logger.getLogger(DataWriter.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Deposit not Successfull");
        } 
    }

}
    
    



