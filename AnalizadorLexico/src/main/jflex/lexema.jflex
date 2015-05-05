package jflex;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import mx.uach.compiladores.a.analizadorlexico.Token;
%%
%public
%class Lexer
%integer
%line
%{
    private List<Token> tokens = new ArrayList<>();
%}
%{

    public List<Token> analizar ()throws IOException{
        for(Token tk: this.tokens){
            if(tk.getToken() == Token.LISTA || tk.getToken() == Token.PREDICADO){
                    this.argumento(tk);
            }
        }
        return this.tokens;
    }

    public void argumento(Token tk)throws IOException{
        List<Token> tks = null;
        Lexer lx        = null;
        String cadena   = tk.getLexema();
        boolean bandera = true;
        
        if(tk.getToken() == Token.LISTA){
            cadena = cadena.substring(1, cadena.length()-1);
            try{
                lx = new Lexer(new java.io.StringReader(cadena));
                while(!lx.zzAtEOF){
                    lx.yylex();
                }
                tks = lx.analizar();
            }catch (Error er) {
                throw new Error(
                    String.format(
                            "Error lexico en la linea %d: error en los argumentos de la lista: %s", 
                            tk.getLinea(), tk.getLexema()));
            }
        }else{
            cadena = cadena.substring(cadena.indexOf('(')+1, cadena.length()-1);
            try{
                lx = new Lexer(new java.io.StringReader(cadena));
                while(!lx.zzAtEOF){
                    lx.yylex();
                }
                tks = lx.analizar();
            }catch (Error er) {
                throw new Error(
                    String.format(
                            "Error lexico en la linea %d: error en los argumentos de la lista: %s", 
                            tk.getLinea(), tk.getLexema()));
            }
        }
        if (tks.isEmpty() && tk.getToken() == Token.PREDICADO) {
            throw new Error(
                    String.format(
                            "Error lexico en la linea %d: Los predicados deben tener almenos un argumento", 
                            tk.getLinea()));
        }
        for (Token tk1 : tks) {
            if(bandera){
                switch (tk1.getToken()) {
                    case Token.ATOMO:
                        break;
                    case Token.CADENA:
                        break;
                    case Token.ENTERO:
                        break;
                    case Token.LISTA:
                        break;
                    case Token.PREDICADO:
                        break;
                    case Token.PTO_FIJO:
                        break;
                    case Token.PTO_FLOT:
                        break;
                    case Token.VARIABLE:
                        break;
                    default:
                        throw new Error(String.format("Error lexico en linea %d: %s no es un argumento valido",
                                tk1.getLinea(), tk1.getLexema()));
                }
                bandera = false;
            }else{
                if (tk1.getToken() == Token.COMA) {
                    bandera = true;
                }else{
                    throw new Error(String.format("Error lexico en linea %d: se esperaba una ',' en vez de %s",
                                tk1.getLinea(), tk1.getLexema()));
                }
            }
        }
        
        if(bandera){
            throw new Error(String.format("Error lexico en linea %d: sobra una ','",
                                tk.getLinea()));
        }
    }

    public Token token(int linea, int tk, String cadena){
        return new Token(linea, tk, cadena);
    }

    public Boolean getzzAtEOF(){
        return zzAtEOF;
    }

    public static void main(String[] args) {
        FileReader in = null;
        String archivo = null;
        try{
            archivo = args[0];
            in = new FileReader(archivo);
            Lexer lexer = new Lexer(in);
            while(!lexer.zzAtEOF){
                lexer.yylex();
            }
            for(Token t: lexer.analizar()){
                System.out.println(t);
            }
        } catch (Exception ex){
            System.out.println("Error al analizar el archivo");
        } finally {
            try{
                in.close();
            }catch(Exception ex){
                System.out.println("Error al cerrar el archivo");
            }
        }
    }
%}

entrada         = [^\r\n]
entradacadena   = [^\r\n\"]
espaciosBlancos = [\r\n \t\f]
especial        = [^ \t\f\r\na-zA-Z0-9\"\',;().]
atomo      = [:lowercase:][a-zA-Z0-9_]* |  {especial}+ | \'{entrada}+\'
variable   = [:uppercase:][a-zA-Z0-9_]*
entero     = [+-]("0" | [1-9][0-9]*) | "0" | [1-9][0-9]*
pto_fijo   = {entero}"."[0-9]* | [+-]"."[0-9]+ | "."[0-9]+
pto_flot   = ({entero} | {pto_fijo})[Ee]{entero}
cadena     = \"{entradacadena}*\"

%%

";"     {tokens.add(token(yyline +1, ';',  yytext()));}
","     {tokens.add(token(yyline +1, ',',  yytext()));}
"("     {tokens.add(token(yyline +1, '(',  yytext()));}
")"     {tokens.add(token(yyline +1, ')',  yytext()));}

":-"    {tokens.add(token(yyline +1, Token.IMPLICA, yytext()));}

{atomo}  {tokens.add(token(yyline +1, Token.ATOMO,  yytext()));}
{entero} {tokens.add(token(yyline +1, Token.ENTERO, yytext()));}
{cadena} {tokens.add(token(yyline +1, Token.CADENA, yytext()));}

{variable} {tokens.add(token(yyline +1, Token.VARIABLE, yytext()));}
{pto_fijo} {tokens.add(token(yyline +1, Token.PTO_FIJO, yytext()));}
{pto_flot} {tokens.add(token(yyline +1, Token.PTO_FLOT, yytext()));}

"["{entrada}*"]"        {tokens.add(token(yyline +1, Token.LISTA,     yytext()));}
{atomo}"("{entrada}+")" {tokens.add(token(yyline +1, Token.PREDICADO, yytext()));}

{espaciosBlancos} {/* Ignorar */}

{atomo}"()" {throw new Error(String.format(
        "Error lexico en la linea %d: Los predicados deben tener argumentos",
        (yyline +1)));}

\"           {throw new Error(String.format(
        "Error lexico en la linea %d: falta un \" para cerrar la cadena",
        (yyline +1)));}

\'           {throw new Error(String.format(
        "Error lexico en la linea %d: falta un ' para cerrar la cadena",
        (yyline +1)));}

[+-][0-9]+ | [0-9]+  {throw new Error(String.format(
        "Error lexico en la linea %d: El unico entero que debe iniciar con cero es '0'",
        (yyline +1)));}

[:lowercase:][a-zA-Z0-9_]* {especial} {throw new Error(String.format(
        "Error lexico en la linea %d: %s no es un atomo valido",
        (yyline +1), yytext()));}

{especial}+[a-zA-Z0-9] {throw new Error(String.format(
        "Error lexico en la linea %d: %s no es un atomo valido",
        (yyline +1), yytext()));}

{variable}{especial}+ {throw new Error(String.format(
        "Error lexico en la linea %d: %s no es una variable valida",
        (yyline +1), yytext()));}

{pto_fijo}[a-zA-Z] {throw new Error(String.format(
        "Error lexico en la linea %d: %s no es un punto fijo valido",
        (yyline +1), yytext()));}

({entero} | {pto_fijo})[A-Za-z]({entero} | {pto_flot}) {throw new Error(
        String.format( "Error lexico en la linea %d: %s no es un punto flotante valido",
        (yyline +1), yytext()));}