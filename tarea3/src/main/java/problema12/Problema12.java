/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema12;

/**
 *
 * @author jesus
 */
public class Problema12 {
    
    public static void main(String[] args) {
        int   par = 0;
        int impar = 0;
        
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                par += i;
            }else{
                impar += i;
            }
        }
        
        System.out.println(String.format("La suma de impares es: %d", impar));
        System.out.println(String.format("La suma de pares es: %d", par));
    }
}
