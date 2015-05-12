/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema29;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema29 {
   
    public static void main(String[] args) {
        Random d1 = new Random();
        Random d2 = new Random();
        int dado1, dado2;
        int cont = 0;
        
        for (int i = 0; i < 100; i++) {
            dado1 = d1.nextInt(6) + 1;
            dado2 = d2.nextInt(6) + 1;
            
            if (dado1 + dado2 == 10 ) {
                cont++;
            }
        }
        
        System.out.println(String.format("de las 100 solo %d sumaban 10", cont));
    }
    
}
