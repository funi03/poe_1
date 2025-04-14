/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_1;

import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class Poe_1 {

    public static void main(String[] args) {
        RegisterLogin objRegisterLogin = new RegisterLogin();
        
        // creating a Scanner class
        Scanner scan = new Scanner(System.in);
        
        //Prompting the user for username
        System.out.println(" please enter your username");
        // user enters the username
        String username =scan.nextLine();
        //if statement to check the username
        if(objRegisterLogin.checkusername(username)== true){
            System.out.println("Thank you for the username");
        }else{
            //displaying the results
             System.out.println(" The username is incorrectly formatted");
             
                     
        }
        
        // prompting the user for password
        System.out.println("Please enter your password ");
        // user enters the password
        String password =scan.nextLine();
        // if statement to check the password
        if(objRegisterLogin.checkPassword(password)== true){
            System.out.println("Thank you for the PASSWORD");
        }else{
            //displaying the results
             System.out.println(" The password is incorrectly formatted");
             
            
        }
        //Prompting the user for cellphone
        System.out.println("Please enter your cellphone");
        //user enters the cellphone
        String cellphonenumber =scan.nextLine();
        // if statement to check the cellphone
        if(objRegisterLogin.checkcellphonenumber(cellphonenumber)== true){
            System.out.println("Thank you for the PHONE NUMBER");
        }else{
            // displaying the results
            System.out.println(" The cellphonenumber is incorrectly formatted");
             
            
            
        }
        System.out.println("Enter your first name");
        String firstname = scan.nextLine();
        
        System.out.println("Enter your last name");
        String lastname =scan.nextLine();
        
        System.out.println("=============================Login=============================");
        
         // display the users registration
        objRegisterLogin.registerUser(username, password);
        System.out.println("Please enter the username that you signed up with");
        String verifyUsername = scan.nextLine();
        
      System.out.println("Please enter the password that you signed up with");
      String verifyPassword  = scan.nextLine();
        
        if (objRegisterLogin.loginUser(username, password, verifyUsername,verifyPassword)){
            System.out.println(" Login successful! " + firstname + " " + lastname +  " it is great to see you again ");
            objRegisterLogin.Returnloginstatus(username,password,verifyUsername,verifyPassword);
        }else{
            System.out.println(" Login failed ");
        }
    
      
    
        
        
    
      
    }
}
