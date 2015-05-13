/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema30;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema30 {
    
    public static void pantallazo(int cab1, int cab2){
        
        System.out.println("caballo 1");
        
        for (int i = 0; i < cab1; i++) {
            System.out.print("#");
        }
        
        System.out.println("");
        
        System.out.println("caballo 2");
        
        for (int i = 0; i < cab2; i++) {
            System.out.print("#");
        }
        
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        int cab1 = 0, cab2 = 0;
        
        while (cab1 < 40 || cab2 < 40) {
            if (random.nextBoolean()) {
                cab1++;
            }else{
                cab2++;
            }
            pantallazo(cab1, cab2);
        }
        
        if (cab1 > cab2) {
            System.out.println("Gano el caballo 1");
        }else{
            System.out.println("Gano el caballo 2");
        }
    }
}
