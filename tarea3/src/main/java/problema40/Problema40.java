/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema40;

/**
 *
 * @author jesus
 */
public class Problema40 {

    public static void main(String[] args) {
        int a = 1;
        int[][][] matriz = new int[3][4][5];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    matriz[i][j][k] = a;
                    a++;
                }
            }
        }
        
         for (int i = 0; i < 3; i++) {
             System.out.println(String.format("Pagina %d", i+1));
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 5; k++) {
                    System.out.print(String.format("%2d ", matriz[i][j][k]));
                }
                System.out.println("");
            }
        }
    }
}
