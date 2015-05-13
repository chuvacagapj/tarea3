/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema34 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] materias = {"Matematicas", "Fisica", "Quimica", "Etica", "Historia",
                             "Geografia", "Artes", "Gimnacia", "Taller", "Biologia"};
        double[] calificaciones = new double[10];
        double suma = 0, entrada;
        
        System.out.println("Introdusca la calificacion de las siguientes materias");
        for (int i = 0; i < 10; i++) {
            
            System.out.println(materias[i]);
            entrada = Double.parseDouble(input.readLine());
            
            if (entrada < 0 || entrada > 10) {
                throw new Error(String.format("%f no es una calificacion valida",
                        entrada));
            }
            
            suma += entrada;
        }
        
        System.out.println(String.format("El promedio es de %.2f", suma/10));
    }
}
