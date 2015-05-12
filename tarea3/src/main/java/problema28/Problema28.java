/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema28;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema28 {
    public static void main(String[] args) {
        Random moneda =  new Random();
        
        System.out.println("Lanzando moneda");
        
        if (moneda.nextBoolean()) {
            System.out.println("Callo aguila");
        }else{
            System.out.println("Callo sello");
        }
    }
}
