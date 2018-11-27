/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.pasienHelper;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class testLogin {
    public static void main(String[] args) {
        pasienHelper helper = new pasienHelper();
        System.out.println("Login = " + helper.login1("afrarian", "afrarian123").getUserNamePsn());
    }
}
