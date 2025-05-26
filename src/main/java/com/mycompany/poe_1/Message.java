/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_1;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author RC_Student_lab
 */
class Message {
    private final String messageID;
   private final int  messageNumber;
   private final String recipient;
   private final String content;
   private final String messageHash;
  
    
   
   public Message(String messageID, int messageNumber,String recipient,String content,String messageHash){
       this.messageID = messageID;
       this.messageNumber= messageNumber;
       this.recipient = recipient;
       this.content = content;
       this.messageHash = messageHash;
 
   }
   // getters
   public String getMessageID (){ return messageID;}
   public  int getMessageNumber(){return messageNumber;}
   public String getRecipient(){return recipient;}
   public String getContent(){ return content;}
   public String getMessageHash(){ return messageHash;}
   
   // Validation method
   public static boolean checkMesaageID(String ID){
       return ID != null && ID.length() == 10 && ID.matches("\\d+");
       
   }
    public static boolean checkRecipientcell(String number){
        return number != null && number.matches("\\+2\\d{10,15}$");
    }
    
    // message hash creation
    public static String createMessageHash(String messageID,int messageNumber,String content){
        String[] words = content.split("\\s+");
        String firstword = words.length > 0 ? words[0] : "";
        String lastword = words.length > 1 ? words[words.length - 1] : firstword;
        String IDprefix = messageID.substring(0, 2);
        return(IDprefix + ":" + messageNumber + ":" + firstword + lastword).toUpperCase();
  
        
    }
    
    // store the message.
    public void storeMessage() {
    String json = String.format(
        "{\"messageId\":\"%s\",\"messageNumber\":%d,\"recipient\":\"%s\",\"content\":\"%s\",\"messageHash\":\"%s\"}",
        this.messageID,
        this.messageNumber,
        this.recipient,
        this.content.replace("\"", "\\\""),
        this.messageHash
    ); 
    
    try (FileWriter file = new FileWriter("stored_messages.json" , true)){
        file.write(json + "\n");
        file.flush();
    }catch (IOException e) {
        System.out.println("Error storing message: " + e.getMessage());
        
    }
        
    }
    
    
    
    
  
   
    
    
}

    