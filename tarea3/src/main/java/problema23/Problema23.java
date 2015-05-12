/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema23 {
    
    public static final int TOTAL = 73;
    
    private String acomodo;
    private int columnas;

    public String getAcomodo() {
        return acomodo;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
         if (columnas == 0 || columnas >= 18) {
            throw new Error("Numero de columnas no soportadas");
        }
         
        this.columnas = columnas;
        this.calcular();
    }
    
    public Problema23(int columnas){
       this.acomodo = "";
       this.setColumnas(columnas);
    }
    
    private void calcular(){
        int casilla = 0;
        
        for (int i = 0; i <= 100; i++) {
            if (this.columnas <= casilla ) {
                this.acomodo += "\n";
                casilla = 0;
            }
            
            this.acomodo = String.format("%s%3d ", this.acomodo, i);
            casilla++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introdusca un numero de columnas entre el 1 y el 18");
        Problema23 p = new Problema23(Integer.parseInt(input.readLine()));
        
        System.out.println(p.getAcomodo());
    }
}
