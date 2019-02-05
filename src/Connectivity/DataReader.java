/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectivity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataReader {
    public static void viewCustomer() throws SQLException{
        Connection conn = new ConnectionManager().getDbconnection();

        try {

            String sql = "SELECT * FROM customers";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
              System.out.println(result.getString("customer_name"));
              System.out.println(result.getString("customer_password"));
              System.out.println(result.getString("customer_balance"));
              System.out.println(result.getString("customer_pin"));
              System.out.println(result.getString("customer_account_number"));
            }
            result.close();
            
        } catch (SQLException ex) {
            System.out.println("Data cannot be displayed");
            Logger.getLogger(DataWriter.class.getName()).log(Level.SEVERE, null, ex);

        } conn.close();

    }
    
}