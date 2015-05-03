/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generated_SourcesPrueba;

import mx.uach.compiladores.a.analizadorlexico.Token;
import org.junit.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import Generated_Sources.Lexer;
import static org.junit.Assert.*;

/**
 *
 * @author jesus
 */
public class LexerTest {
    
    public LexerTest() {
    }
    
    

    @Test
    void pruebaEntero()throws IOException{
        String ruta = "/home/jesus/NetBeansProjects/AnalizadorLexico/AnalizadorLexico/src/test/java/pruebas/pruebaEntero.chuy";
        FileReader archivo = new FileReader(ruta);
        List<Token> tokens = null;
        
        Lexer lex = new Lexer(archivo);
        while(!lex.getzzAtEOF()){
                lex.yylex();
        }
        
        tokens = lex.analizar();
    }
    
    @Test(expected = Error.class)
    void pruebaEnteroFalla(){
        //TODO
    }
    
    @Test
    void pruebaCadena(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaCadenaFala(){
        //TODO
    }
    
    @Test
    void pruebaAtomo1(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaAtomo1Falla(){
        //TODO
    }
    
    @Test
    void pruebaAtomo2(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaAtomo2Falla(){
        //TODO
    }
    
    @Test
    void pruebaAtomo3(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaAtomo3Falla(){
        //TODO
    }
    
    @Test
    void pruebaPtoFijo(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaPtoFijoFalla(){
        //TODO
    }
    
    @Test
    void pruebaPtoFlot(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaPtoFlotFalla(){
        //TODO
    }
    
    @Test
    void pruebaVariable(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaVariableFalla(){
        //TODO
    }
    
    @Test
    void pruebaPredicado(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaPredicadoFalla(){
        //TODO
    }
    
    @Test
    void pruebaLista(){
        //TODO
    }
    
    @Test(expected = Error.class)
    void pruebaListaFalla(){
        //TODO
    }
}
