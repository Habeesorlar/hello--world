
package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    
    public Connection getDbconnection(){
        
        String stringConn = "com.mysql.cj.jdbc.Driver";
        String sql = "jdbc:mysql://localhost/gtbank1?user=admin&password=password";
        String user = "admin";
        String Password = "password";
        Connection connect = null;
        
        try{
             Class.forName(stringConn);
             connect = DriverManager.getConnection(sql, user,Password);// get connection to the database
             if (connect == null){
                 System.out.println("Connection Established");
             
             }
        } catch (ClassNotFoundException | SQLException e){
            
              System.out.println(e);
        }
        return connect;
    }
    
}

