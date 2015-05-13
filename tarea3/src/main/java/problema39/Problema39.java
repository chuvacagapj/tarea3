/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema39;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema39 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[][] matriz = null;
        int[] auxiliar = null;
        int filas, columnas, k;
        
        System.out.println("Introdusca el numero de filas"   );
        filas    = Integer.parseInt(input.readLine());
        System.out.println("Introdusca el numero de columnas");
        columnas = Integer.parseInt(input.readLine());
        
        matriz   = new int[filas][columnas];
        auxiliar = new int[columnas];
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println(String.format(
                        "Introdusca la calificacion del curso %d del alumno %d",
                        i, j));
                matriz[i][j] = Integer.parseInt(input.readLine());
            }
        }
        
        for (int i = 1; i < filas; i++) {
            auxiliar = matriz[i];
            k = i;
            while (true) {
                if (k == 0) {
                    matriz[k] = auxiliar;
                    break;
                }
                
                if (matriz[k-1][0] > auxiliar[0]) {
                    matriz[k] = matriz [k-1];
                    k--;
                }else{
                    matriz[k] = auxiliar;
                    break;
                }
            }
        }
        
        System.out.println("Matriz ordenada");
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(String.format("%d ", matriz[i][j]));
            }
            System.out.println("");
        }
    }
}
