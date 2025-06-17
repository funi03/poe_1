/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class RegisterLoginTest {
    
    public RegisterLoginTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    
    /**
     * Test of checkusername method, of class RegisterLogin.
     */
    @org.junit.jupiter.api.Test
    public void testCheckusername() {
        System.out.println("checkusername");
        String username = " Fun_4";
        RegisterLogin instance = new RegisterLogin();
        boolean expResult = false;
        boolean result = instance.checkusername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class RegisterLogin.
     */
    @org.junit.jupiter.api.Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = " Funanani#@3 ";
        RegisterLogin instance = new RegisterLogin();
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkcellphonenumber method, of class RegisterLogin.
     */
    @org.junit.jupiter.api.Test
    public void testCheckcellphonenumber() {
        System.out.println("checkcellphonenumber");
        String cellphonenumber = " +27714125463 ";
        RegisterLogin instance = new RegisterLogin();
        boolean expResult = false;
        boolean result = instance.checkcellphonenumber(cellphonenumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class RegisterLogin.
     */
    @org.junit.jupiter.api.Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = " Fun_4";
        String password = "Funanani#@3";
        RegisterLogin instance = new RegisterLogin();
        String expResult = "You are successful registered";
        String result = instance.registerUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class RegisterLogin.
     */
    @org.junit.jupiter.api.Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = " Fun_4";
        String password = "Funanani#@3";
        String verifyUsername = "Fun_4";
        String verifyPassword = "Funanani#@3";
        RegisterLogin instance = new RegisterLogin();
        boolean expResult = false;
        boolean result = instance.loginUser(username, password, verifyUsername, verifyPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Returnloginstatus method, of class RegisterLogin.
     */
    @org.junit.jupiter.api.Test
    public void testReturnloginstatus() {
        System.out.println("Returnloginstatus");
        String username = "Fun_4";
        String password = "Funanani#@3";
        String verifyUsername = "Fun_4";
        String verifyPassword = " Funanani#@3";
        RegisterLogin instance = new RegisterLogin();
        String expResult = "Login successful";
        String result = instance.Returnloginstatus(username, password, verifyUsername, verifyPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
