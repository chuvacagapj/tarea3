/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema37;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema37 {
    public static void main(String[] args) {
        Random random = new Random();
        int numeros[][] = new int[4][5];
        int transpu[][] = new int[5][4];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                numeros[i][j] = random.nextInt(100) + 1;
            }
        }
        
        System.out.println("Matriz original");
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(String.format("%3d ", numeros[i][j]));
            }
            System.out.println("");
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                transpu[j][i] = numeros[i][j];
            }
        }
        
        System.out.println("Matris transpuesta");
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(String.format("%3d ", transpu[i][j]));
            }
            System.out.println("");
        }
    }
}
