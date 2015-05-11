/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * //TODO javadoc
 * @author jesus
 */
public class Problema7 {
    public static void main(String[] args) throws IOException {
        String entrada;        
        int cont = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        entrada = input.readLine().trim();
        
        while (!entrada.isEmpty()) {
            cont += 1;
            entrada = input.readLine().trim();
        }
        
        System.out.println(String.format("Se introdujeron %d fraces", cont));
    }
}
