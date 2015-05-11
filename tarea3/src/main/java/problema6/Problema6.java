/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * //TODO JAVADOC
 * @author jesus
 */
public class Problema6 {
    public static void main(String[] args) throws IOException {
        int entrada;        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introdusca un numero cualquiera:");
        entrada = Integer.parseInt(input.readLine());
        
        for (int i = 1; i <= entrada; i++) {
            System.out.println(i);
        }
    }
}
