/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema38 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        float[][] matriz = null;
        int cursos, alumnos;
        
        System.out.println("Introdusca el numero de cursos" );
        cursos  = Integer.parseInt(input.readLine());
        System.out.println("Introdusca el numero de alumnos");
        alumnos = Integer.parseInt(input.readLine());
        
        matriz = new float[cursos][alumnos];
        
        for (int i = 0; i < cursos; i++) {
            for (int j = 0; j < alumnos; j++) {
                System.out.println(String.format(
                        "Introdusca la calificacion del curso %d del alumno %d",
                        i, j));
                matriz[i][j] = Float.parseFloat(input.readLine());
            }
        }
    }
}
