/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema25 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int entrada;
        String salida = "";
        
        System.out.println("Introdusca un numero");
        entrada = Integer.parseInt(input.readLine());
        
        if (entrada < 0 || entrada > 5000) {
            throw new Error("Numero fuera del rango de valores");
        }
        
        while (entrada >= 1000) {
            salida += "M";
            entrada-= 1000;
        }
        
        if (entrada >= 900) {
            salida += "CM";
            entrada-= 900;
        }
        
        if (entrada >= 500) {
            salida += "D";
            entrada-= 500;
        }
        
        if (entrada >= 400) {
            salida += "CD";
            entrada-= 400;
        }
        
        while (entrada >= 100) {
            salida += "C";
            entrada-= 100;
        }
        
        if (entrada >= 90) {
            salida += "XC";
            entrada-= 90;
        }
        
        if (entrada >= 50) {
            salida += "L";
            entrada-= 50;
        }
        
        if (entrada >= 40) {
            salida += "XL";
            entrada-= 40;
        }
        
        while (entrada >= 10) {
            salida += "X";
            entrada-= 10;
        }
        
        if (entrada >= 9) {
            salida += "IX";
            entrada-= 9;
        }
        
        if (entrada >= 5) {
            salida += "V";
            entrada-= 5;
        }
        
        if (entrada >= 4) {
            salida += "IV";
            entrada-= 4;
        }
        
        while (entrada >= 1) {
            salida += "I";
            entrada-= 1;
        }
        
        System.out.println(String.format("el numero en romano es %s", salida));
    }
}
