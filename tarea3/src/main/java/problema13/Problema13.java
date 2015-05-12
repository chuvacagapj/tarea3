/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema13;

/**
 *
 * @author jesus
 */
public class Problema13 {
    
    public static void main(String[] args) {
        int cont = 0;
        
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0 || i%3 == 0) {
                System.out.println(i);
                cont += 1;
            }
        }
        
        System.out.println(String.format("En total son %d numeros", cont));
    }
}
