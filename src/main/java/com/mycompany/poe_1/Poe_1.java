/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** 
 *
 * @author RC_Student_lab
 */
public class Poe_1 {
    
    private static final ArrayList<Message> messages = new ArrayList<>();
      private static int totalMessagesSent = 0;
    private  static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        RegisterLogin objRegisterLogin = new RegisterLogin();
        Scanner input  = new Scanner(System.in);
        
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
        
        // part 2
        
        System.out.println("WELCOME TO QUICKCHAT");
        runApplication();
 
    }
    private static void runApplication(){
        boolean running = true ;
        
        while(running){
            System.out.println("\nMain Menu");
            System.out.println("1) send messages");
            System.out.println("2)  show recent sent messages");
            System.out.println("3) Quit");
            System.out.println("Enter your choices");
            
            int choice;
            try {
                choice  = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Please enter a valid number (1, 2 or 3)");
                continue;
                
            }
            switch (choice){
                case 1 : sendMessages();
                case 2 : System.out.println("\nComing soon");
                case 3 : {
                    running = false;
                    System.out.println("\nTotal messages sent: " + totalMessagesSent);
                    System.out.println("Goodbye!");
                    
                }
                default : System.out.println("Invalid choice. please enter 1,2, or 3");
            }
        }
    }
    private static void sendMessages(){
        System.out.println("\nHow many messages would you like to send");
        int messageCount;
        
        try{
            messageCount = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Please enter a valid number");
            return;
  
        }
        for (int i = 0; i<messageCount; i++){
            System.out.println("\nCreating message" + (i + 1) + " of " + messageCount);
            Message message = createMessage(i + 1);
            if(message != null){
                messages.add(message);
                totalMessagesSent++;
                displayMessageDetails(message);
            }
            
        }
    }
    
    private static Message createMessage(int messageNumber){
        System.out.println("Enter recipient' s cell number(with  international code):");
        String recipient = scanner.nextLine();
        if(Message.checkRecipientcell(recipient)){
            System.out.println("Invalid recipient number. Must be 10 digits with international code.");
            return null;
        }
        System.out.println("Enter your message(max 250 characters):");
        String content = scanner.nextLine();
        if(content.length() > 250) {
            System.out.println("Message too long , type again message must be 250 characters or less");
            return null;
        }
        
        String messageID = generateMessageID();
        String messageHash = Message.createMessageHash(messageID, messageNumber,content);
        
        Message message = new Message(messageID,messageNumber, recipient, content,messageHash);
        
        System.out.println("\n what would you like to do with this message");
        System.out.println("1) send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) store the message send later");
        System.out.println("Enter your choice");
        
        int action ;
        try{
            action = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Invalid choice. your message is disregarded");
            return null;
            
           
        }
        switch(action){
            case 1 -> {
                return message;
            }
            case 2 -> {
                return null;
            }
            case 3 -> {
                message.storeMessage();
                System.out.println("Message stored successfully ");
                return null;
                
            }
            default -> {
                System.out.println("Invalid choice . message will be disregarded");
                return null;
            }
        }
        
    }
    
    private static String generateMessageID() {
        Random random = new Random();
        long ID = 1000000000L + random.nextInt(900000000);
        return String.valueOf(ID);
        
    }
    
    private static void displayMessageDetails(Message message){
        System.out.println("\nMessage Details:");
        System.out.println("ID:" + message.getMessageID());
        System.out.println("Hash:" + message.getMessageHash());
        System.out.println("Recipient:" + message.getRecipient());
        System.out.println("Message:" + message.getContent());
        System.out.println("                 ");
    }
    
  
}
      
      






