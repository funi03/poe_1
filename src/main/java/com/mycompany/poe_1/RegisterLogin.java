/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_1;

/**
 *
 * @author RC_Student_lab
 */
class RegisterLogin {
    // username method 
     public boolean checkusername(String username){
        if(username.contains("_") && username.length()==5 ){
            return true;
        }else{
            return false;
        }
    }
     
     // password method
      public boolean checkPassword(String password){
        
        if (password.length() >=8 && password.matches(".*[A-Z].*") && password.matches(".*[a-z].*")&& password.matches(".*[0-9].*")&& password.matches(".*[!@#$%^&*()_+-={}|:';<>?,./].*")){
            return true;
        }else{
            return false;
        }
    }
      
     
     // cellphone method
     public boolean checkcellphonenumber(String cellphonenumber){
       if(cellphonenumber.startsWith("+27")&& cellphonenumber.length()==12 && cellphonenumber.matches(".*[0-9].*")){
           return true;
       }else{
           return false;
       }
   }
  
     public String registerUser(String username, String password){
         String message;
         if(checkusername(username)== false){
             message = "username is incorrectly formated";
             return message;
         }
         else if(checkPassword(password) ==false){
             message = "password is incorrectly formated";
             return message;
         }else{
             message = "username and password is correctly formated";
             return message;
         }
     
     }
     public boolean loginUser(String username,String password,String verifyUsername,String verifyPassword){
         return verifyUsername.equals(username)&& verifyPassword.equals(password);
        
       
     }
     public String Returnloginstatus(String username ,String password,String verifyUsername,String verifyPassword){
         String message;
         if (loginUser(username,password,verifyUsername,verifyPassword)==true){
             message = "successful login";
             return message;
         }else{ 
             message = "failed login";
             return message;
             
        
            
             
         }
         
     }
    
}
