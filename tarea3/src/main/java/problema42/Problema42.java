/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema42;

import java.util.Random;

/**
 *
 * @author jesus
 */
public class Problema42 {
    
    public static void main(String[] args) {
        Random a = new Random();
        int[][][] matriz = new int[3][12][4];
        int[][] reportes = new int[12][4];
        int suma = 0;
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 4; k++) {
                    matriz[i][j][k] = a.nextInt();
                }
            }
        }
        
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    suma += matriz[k][i][j];
                }
                reportes[i][j] = suma;
                suma = 0;
            }
        }
        
        System.out.println("Reporte de empleados");
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.println(String.format(
                            "El empleado %d vendio el mes %d el producto %d las ventas %d",
                            i, j, k, matriz[i][j][k]));
                }
            }
        }
        
        System.out.println("Reporte de Totales");
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(
                        String.format("El mes %d el producto %d se vendio %d",
                                i, j, reportes[i][j]));
            }
        }
        
    }
}
