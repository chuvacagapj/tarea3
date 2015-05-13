/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema41;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema41 {
    
    public static void main(String[] args) {
        Random a = new Random();
        int centro = 0, suma = 0;
        float max = 0;
        int[][][] matriz = new int[5][10][20];
    
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 20; k++) {
                    matriz[i][j][k] = a.nextInt(10) +1;
                }
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 20; k++) {
                    suma += matriz[i][j][k];
                }
                System.out.println(
                        String.format("La media del curso %d del centro %d es %.2f",
                                j, i, suma/20.0));
                if (max < suma/20.0) {
                    max = (float) (((float)suma)/20.0) ;
                    centro = i;
                }
                suma = 0;
            }
        }
        
        System.out.println(String.format(
                "La media maxima por curso es del centro %d y es %.2f", centro+1,
                max));
    }
}
