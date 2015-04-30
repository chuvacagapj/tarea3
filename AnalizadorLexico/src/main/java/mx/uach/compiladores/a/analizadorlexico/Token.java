/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uach.compiladores.a.analizadorlexico;

import java.util.Objects;

/**
 *El modelo que contiene los elementos que conforman la expresion dividos en los 
 *elementos que describe el alfabeto y la gramatica.
 * 
 * @author Jesus Jose Garcia Pardo
 * @since 06/03/2015 
 * @version 1.0
 */
public class Token {
    
    public static final int COMA = ',';
    public static final int PUNTO = '.';
    public static final int PUNTO_COMA = ';';
    public static final int PAR_IZQ = '(';
    public static final int PAR_DER = ')';
    public static final int ATOMO = 600;
    public static final int VARIABLE = 700;
    public static final int PREDICADO = 800;
    public static final int ENTERO = 900;
    public static final int PTO_FIJO = 1000;
    public static final int PTO_FLOT = 1100;
    public static final int IMPLICA = 1200;
    public static final int LISTA = 1300;
    public static final int CADENA = 1400;
    
    
    private Integer linea;
    private int token;
    private String lexema;
    
    /**
     * Constructor basico para genera los token's
     * @param linea posicion donde se localiza el lexema.
     * @param token identificador numerico.
     * @param lexema caracter o cadena de caracteres (valor real).
     */

    public Token(Integer linea, int token, String lexema) {
        this.linea = linea;
        this.token = token;
        this.lexema = lexema;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
    /**
     * Metodo que genera una cadena con los elementos del token.
     * @return cadena conel formato linea, token, lexem.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.linea, this.token, this.lexema);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.linea);
        hash = 41 * hash + this.token;
        hash = 41 * hash + Objects.hashCode(this.lexema);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.linea, other.linea)) {
            return false;
        }
        if (this.token != other.token) {
            return false;
        }
        if (!Objects.equals(this.lexema, other.lexema)) {
            return false;
        }
        return true;
    }
    
    
}