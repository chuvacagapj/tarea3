/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema35 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] materias = {"Matematicas", "Fisica", "Quimica", "Etica", "Historia",
                             "Geografia", "Artes", "Gimnacia", "Taller", "Biologia"};
        double[] calificaciones = new double[10];
        boolean bandera = true;
        double entrada1;
        int entrada2;
        
        System.out.println("Introdusca la calificacion de las siguientes materias");
        for (int i = 0; i < 10; i++) {
            
            System.out.println(materias[i]);
            entrada1 = Double.parseDouble(input.readLine());
            
            if (entrada1 < 0 || entrada1 > 10) {
                throw new Error(String.format("%f no es una calificacion valida",
                        entrada1));
            }
            
        }
        
        while (bandera) {
            try{
                System.out.println("introdusca la opcion deseada");
                for (int i = 0; i < 10; i++) {
                    System.out.println(
                            String.format("\t%2d) saber la calificacion de %s", 
                                    i, materias[i]));
                }
                System.out.println("En caso de salir precione cualquier otra tecla");
                entrada2 = Integer.parseInt(input.readLine());
                
                System.out.println(String.format("La calificacion de %s: %.2f", 
                        materias[entrada2-1], calificaciones[entrada2-1]));
            }catch (Exception ex) {
                bandera = false;
            }
        }
        
    }
}
