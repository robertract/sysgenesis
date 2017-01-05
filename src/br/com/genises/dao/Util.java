/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

/**
 *
 * @author Tiago
 */
public class Util {

    public static boolean isLong(String a) {
        try {
            Long b = Long.parseLong(a);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
}
