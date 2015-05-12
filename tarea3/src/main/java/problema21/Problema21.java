/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema21;

/**
 *
 * @author jesus
 */
public class Problema21 {
    
    public static void main(String[] args) {
        int par   = 0;
        int impar = 0;
        
        for (int i = 1; i <= 1000; i++) {
            switch (i%2) {
                case 0:
                    par += i;
                    break;
                default:
                    impar += i;
            }
        }
        
        System.out.println(String.format("La suma de los pares es %d",     par));
        System.out.println(String.format("La suma de los impares es %d", impar));
    }
}
