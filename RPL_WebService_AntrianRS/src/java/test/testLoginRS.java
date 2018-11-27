/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import helper.rumahSakitHelper;

/**
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
public class testLoginRS {
    public static void main(String[] args) {
        rumahSakitHelper helper = new rumahSakitHelper();
        System.out.println("Login = " + helper.login1("srimulyani", "sri1234").getUserNameRs());
    }
}
