import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
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
    public List<Token> analizar (){
        
        return this.tokens;
    }

    public Token token(int linea, int tk, String cadena){
        return new Token(linea, tk, cadena);
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
espaciosBlancos = [\r\n \t\f]
especial        = [^ \t\f\r\na-zA-Z0-9\"\',;]
atomo      = [:lowercase:][a-zA-Z0-9_]* |  {especial}+ | \'{entrada}+\'
variable   = [:uppercase:][a-zA-Z0-9_]*
entero     = [+-]("0" | [1-9][0-9]*) | "0" | [1-9][0-9]*
pto_fijo   = {entero}"."[0-9]* | [+-]"."[0-9]+ | "."[0-9]+
pto_flot   = ({entero} | {pto_fijo})[Ee]{entero}
cadena     = \"{entrada}*\"

%%

";"     {tokens.add(token(yyline +1, ';',  yytext()));}
","     {tokens.add(token(yyline +1, ',',  yytext()));}
"("     {tokens.add(token(yyline +1, '(',  yytext()));}
")"     {tokens.add(token(yyline +1, ')',  yytext()));}

":-"    {tokens.add(token(yyline +1, Token.IMPLICA, yytext()));}
"[]"    {tokens.add(token(yyline +1, Token.LISTA,   yytext()));}

{atomo}  {tokens.add(token(yyline +1, Token.ATOMO,  yytext()));}
{entero} {tokens.add(token(yyline +1, Token.ENTERO, yytext()));}
{cadena} {tokens.add(token(yyline +1, Token.CADENA, yytext()));}

{variable} {tokens.add(token(yyline +1, Token.VARIABLE, yytext()));}
{pto_fijo} {tokens.add(token(yyline +1, Token.PTO_FIJO, yytext()));}
{pto_flot} {tokens.add(token(yyline +1, Token.PTO_FLOT, yytext()));}

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

"0"[0-9]* \" {throw new Error(String.format(
        "Error lexico en la linea %d: El unico entero que debe iniciar con cero es '0'",
        (yyline +1)));}

[:lowercase:][a-zA-Z0-9_]* {especial} {throw new Error(String.format(
        "Error lexico en la linea %d: %s no es un atomo valido,
        (yyline +1), yytext()));}