/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema36;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema36 {
    
    public static void main(String[] args) {
        Random random = new Random();
        int numeros[][] = new int[4][5];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                numeros[i][j] = random.nextInt(100) + 1;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(String.format("%3d ", numeros[i][j]));
            }
            System.out.println("");
        }
    }
}
