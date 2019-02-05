
package admin;

import java.util.Scanner;


public class Admin {
    
    public static void login() {
        String username = null;
        String Password = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Provide your userName");
        username = input.nextLine();
        System.out.println("Provide your Password");
        Password = input.nextLine();

        if (username.equals("admin") && Password.equals("101010")) {
            System.out.println("Welcome Access Granted");
            // call admin menu method
            adminMenu();
            
        } 
        else if (username != username) {
            System.out.println("Invalid Username");
        } 
        else if (Password != Password) {
            System.out.println("Invalid Password");
        } 
        else {
            System.out.println("Please provide a valid username and password");
        }
    }
    public static void adminMenu() { // This method defines the admin menu page
        System.out.println("Select an Option");
        System.out.println("1 )Add New Customer\n2) Update Customer Record\n3) View Customer Details\n4) Delete a Customer\n5) Quit");
    }
}
