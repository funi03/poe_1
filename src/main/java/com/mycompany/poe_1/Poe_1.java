/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_1;

import java.util.ArrayList;
import java.util.Iterator;


import java.util.Random;

import javax.swing.JOptionPane;

/** 
 *
 * @author RC_Student_lab
 */
public class Poe_1 {
    
    private static final ArrayList<Message> messages = new ArrayList<>();
      private static int totalMessagesSent = 0;
   private static int messagesSent = 0;
   
    private final ArrayList<Message> sentMessages = new ArrayList<>();
    private final ArrayList<Message> disregardedMessages = new ArrayList<>();
    private final ArrayList<Message> storedMessages = new ArrayList<>();
    
  public void displaySentMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No sent messages found.");
            return;
        }
        
         StringBuilder sb = new StringBuilder("Sent Messages:\n");
        for (Message m : sentMessages) {
            sb.append("Recipient: ").append(m.getRecipient())
              .append(", Message: ").append(m.getContent()).append("\n");
        }
     JOptionPane.showMessageDialog(null, sb.toString());
    }
  
   
   public void searchByMessageID(String id) {
        for (Message m : sentMessages) {
            if (m.getMessageID().equals(id)) {
                JOptionPane.showMessageDialog(null, "Found:\nRecipient: " + m.getRecipient() + "\nMessage: " + m.getContent());
                return;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Message ID not found.");
    }
   
    public void searchByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder("Messages sent to " + recipient + ":\n");
        boolean found = false;
        for (Message m : sentMessages) {
            if (m.getRecipient().equals(recipient)) {
                sb.append(m.getContent()).append("\n");
                found = true;
            }
        }
        
         for (Message m : storedMessages) {
            if (m.getRecipient().equals(recipient)) {
                sb.append(m.getContent()).append("\n");
                found = true;
            }
        }
          if (found) {
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No messages found for this recipient.");
        }
    }
    public void deleteByHash(String hash) {
        Iterator<Message> iterator = sentMessages.iterator();
        while (iterator.hasNext()) {
            Message m = iterator.next();
            if (m.getMessageHash().equals(hash)) {
                iterator.remove();
                JOptionPane.showMessageDialog(null, "Message successfully deleted.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Message hash not found.");
    }
     public void displayFullReport() {
        StringBuilder sb = new StringBuilder("Full Message Report:\n");
        for (Message m : sentMessages) {
            sb.append("Message ID: ").append(m.getMessageID())
              .append(", Hash: ").append(m.getMessageHash())
              .append(", Recipient: ").append(m.getRecipient())
              .append(", Message: ").append(m.getContent()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
       
     
        
    public static void main(String[] args) {
        RegisterLogin objRegisterLogin = new RegisterLogin();
        
        // Displaying login header
        JOptionPane.showMessageDialog(null, "============================= REGISTER =============================");
        
        // Prompting the user for username using JOptionPane
        String username = JOptionPane.showInputDialog("Please enter your username");
        // Check the username
        if(objRegisterLogin.checkusername(username) == true){
            JOptionPane.showMessageDialog(null, "Thank you for the username");
        } else {
            JOptionPane.showMessageDialog(null, "The username is incorrectly formatted");
        }
        
        // Prompting the user for password using JOptionPane
        String password = JOptionPane.showInputDialog("Please enter your password");

        // Check the password
        if (objRegisterLogin.checkPassword(password) == true) {
            JOptionPane.showMessageDialog(null, "Thank you for the PASSWORD");
        } else {
            JOptionPane.showMessageDialog(null, "The password is incorrectly formatted");
        }
        
         // Prompting the user for cellphone using JOptionPane
        String cellphonenumber = JOptionPane.showInputDialog("Please enter your cellphone");

        // Check the cellphone number
        if (objRegisterLogin.checkcellphonenumber(cellphonenumber) == true) {
            JOptionPane.showMessageDialog(null, "Thank you for the PHONE NUMBER");
        } else {
            JOptionPane.showMessageDialog(null, "The cellphone number is incorrectly formatted");
        }
        
          // Prompting for first name
        String firstname = JOptionPane.showInputDialog("Enter your first name");

        // Prompting for last name
        String lastname = JOptionPane.showInputDialog("Enter your last name");

        // Displaying login header
        JOptionPane.showMessageDialog(null, "============================= Login =============================");
        
        // Registration (assuming username, password are already collected)
        objRegisterLogin.registerUser(username, password);

        // Prompt user to verify username and password for login
        String verifyUsername = JOptionPane.showInputDialog("Please enter the username that you signed up with");
        String verifyPassword = JOptionPane.showInputDialog("Please enter the password that you signed up with");

        // Check login
        if (objRegisterLogin.loginUser(username, password, verifyUsername, verifyPassword)) {
            JOptionPane.showMessageDialog(null, "Login successful! " + firstname + " " + lastname + " it is great to see you again");
            objRegisterLogin.Returnloginstatus(username, password, verifyUsername, verifyPassword);
        } else {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
        
        
        
        
        // part 2
        
         JOptionPane.showMessageDialog(null, "WELCOME TO QUICKCHAT");
        runApplication();
        
    }
    private static void runApplication() {
        boolean running = true;
 while (running) {
        String menu = """
                Main Menu:
                1) Send messages
                2) Show report
                3) Part 3 features
                4) Quit
                """;

        String input = JOptionPane.showInputDialog(null, menu, "QuickChat Main Menu", JOptionPane.QUESTION_MESSAGE);

        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            continue;
        }

        switch (choice) {
            case 1 -> sendMessages();
            case 2 -> displayReport();
            case 3 -> part3Menu();
            case 4 -> {
                running = false;
                JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessagesSent + "\nGoodbye!");
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid choice.");
        }
    }
}
       
    private static void sendMessages() {
    // Ask how many messages the user wants to send
    String input = JOptionPane.showInputDialog("How many messages would you like to send?");
    int messageCount;

    try {
        messageCount = Integer.parseInt(input);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Please enter a valid number");
        return;
    }

    for (int i = 0; i < messageCount; i++) {
        JOptionPane.showMessageDialog(null, "Creating message " + (i + 1) + " of " + messageCount);
        Message message = createMessage(i + 1);
        if (message != null) {
            messages.add(message);
            totalMessagesSent++;
            displayMessageDetails(message);
        }
    }
}
    private static Message createMessage(int messageNumber) {
    // Prompt for recipient's cell number
    String recipient = JOptionPane.showInputDialog("Enter recipient's cell number (with international code):");

    if (!Message.checkRecipientcell(recipient)) {
        JOptionPane.showMessageDialog(null, "Invalid recipient number. Must be 10 digits with international code.");
        return null;
    }

    // Prompt for message content
    String content = JOptionPane.showInputDialog("Enter your message (max 250 characters):");

    if (content.length() > 250) {
        JOptionPane.showMessageDialog(null, "Message too long. Message must be 250 characters or less.");
        return null;
    }

    // Generate messageID and messageHash
    String messageID = generateMessageID();
    String messageHash = Message.createMessageHash(messageID, messageNumber, content);

    Message message = new Message(messageID, messageNumber, recipient, content, messageHash);

    // Show options to the user
    String[] options = {"Send Message", "Disregard Message", "Store the Message to Send Later"};
    int action = JOptionPane.showOptionDialog(
            null,
            "What would you like to do with this message?",
            "Message Options",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
    );

    switch (action) {
        case 0: // Send Message
            return message;
        case 1: // Disregard Message
            return null;
        case 2: // Store Message to Send Later
            message.storeMessage();
            JOptionPane.showMessageDialog(null, "Message stored successfully.");
            return null;
        default: // Any invalid selection or closing dialog
            JOptionPane.showMessageDialog(null, "Invalid choice. Message will be disregarded.");
            return null;
    }
}
    private static String generateMessageID() {
    Random random = new Random();
    long ID = 1000000000L + random.nextInt(900000000);
    String messageID = String.valueOf(ID);

    // Optional: show the generated ID in a dialog
    JOptionPane.showMessageDialog(null, "Generated Message ID: " + messageID);

    return messageID;
}
    private static void displayMessageDetails(Message message) {
    String details = "Message Details:\n"
            + "ID: " + message.getMessageID() + "\n"
            + "Hash: " + message.getMessageHash() + "\n"
            + "Recipient: " + message.getRecipient() + "\n"
            + "Message: " + message.getContent();

    JOptionPane.showMessageDialog(null, details);
}
    //PART 3
    private static void part3Menu() {
    boolean running = true;

    while (running) {
        String menu = """
                PART 3 MENU:
                1) Display All Messages
                2) Display Longest Message
                3) Search by Message ID
                4) Search by Recipient
                5) Delete by Hash
                6) Back to Main Menu
                """;

        String input = JOptionPane.showInputDialog(menu);
        int choice;

        if (input == null) {
            // user pressed cancel or closed the window
            running = false;
            continue;
        }

        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number (1 to 6).");
            continue;
        }

        switch (choice) {
            case 1 -> displayReport();
            case 2 -> displayLongestMessage();
            case 3 -> searchByMessageID();
            case 4 -> searchByRecipient();
            case 5 -> deleteByHash();
            case 6 -> running = false;
            default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please select 1 to 6.");
        }
    }
}

   private static void displayReport() {
    if (messages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No messages available.");
        return;
    }

    StringBuilder report = new StringBuilder("All Messages Report:\n\n");

    for (Message message : messages) {
        report.append("ID: ").append(message.getMessageID()).append("\n")
              .append("Hash: ").append(message.getMessageHash()).append("\n")
              .append("Recipient: ").append(message.getRecipient()).append("\n")
              .append("Message: ").append(message.getContent()).append("\n\n");
    }

    // Display entire report
    JOptionPane.showMessageDialog(null, report.toString());
}

    private static void displayLongestMessage() {
    if (messages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No messages available.");
        return;
    }

    Message longest = messages.get(0);
    for (Message msg : messages) {
        if (msg.getContent().length() > longest.getContent().length()) {
            longest = msg;
        }
    }

    String details = "Longest Message:\n\n"
            + "ID: " + longest.getMessageID() + "\n"
            + "Hash: " + longest.getMessageHash() + "\n"
            + "Recipient: " + longest.getRecipient() + "\n"
            + "Message: " + longest.getContent();

    JOptionPane.showMessageDialog(null, details);
 }
    
   private static void searchByMessageID() {
    String id = JOptionPane.showInputDialog("Enter Message ID:");

    if (id == null || id.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No Message ID entered.");
        return;
    }

    for (Message msg : messages) {
        if (msg.getMessageID().equals(id)) {
            displayMessageDetails(msg);  // this already uses JOptionPane
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Message ID not found.");
  }
    
    private static void searchByRecipient() {
    String recipient = JOptionPane.showInputDialog("Enter Recipient (+27...):");

    if (recipient == null || recipient.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No recipient entered.");
        return;
    }

    boolean found = false;
    for (Message msg : messages) {
        if (msg.getRecipient().equals(recipient)) {
            displayMessageDetails(msg);  // already uses JOptionPane
            found = true;
        }
    }

    if (!found) {
        JOptionPane.showMessageDialog(null, "No messages found.");
    }
  }
    
    private static void deleteByHash() {
    String hash = JOptionPane.showInputDialog("Enter Message Hash:");

    if (hash == null || hash.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hash entered.");
        return;
    }

    Iterator<Message> iterator = messages.iterator();
    while (iterator.hasNext()) {
        Message msg = iterator.next();
        if (msg.getMessageHash().equals(hash)) {
            iterator.remove();
            JOptionPane.showMessageDialog(null, "Message deleted.");
            return;
        }
    }

    JOptionPane.showMessageDialog(null, "Message hash not found.");
}


   
        
    }

     
       
        
    
    
   
        
        
    
   
    
   
    
    
  
    

   




   

 

       
    

       
       



    
  

      
      






