import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import mx.uach.compiladores.a.analizadorlexico.Token;
%%
%public
%class Lexema
%standalone
%cup
%line
%{
    private List<Token> tokens = new ArrayList<>();
%}
%{
    public List<String> analizar (String archivo){
        FileReader in = null;
        try{
            in = new FileReader(archivo);
            Lexer lexer = new Lexer(in);
            while(!lexer.zzAtEOF){
                lexer.yylex();
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
        return this.tokens;
    }

    public Token token(Integer linea, int tk, String lex){
        return new Token(linea, tk, lex)
    }
%}
finLinea  = \r|\n|\r\n
entrada   = [^\r\n] 
especial  = [^a-zA-Z0-9_]
entero    = [+-][0-9]+
pto_fijo  = [+-]([0-9]*"."[0-9]+ |  [0-9]+"."[0-9]*) | [0-9]*"."[0-9]+ |  [0-9]+"."[0-9]*
pto_flot  = ({entero} | {pto_fijo})[Ee]{entero}
argumento = {entero} | {cadena} | {lista} | {pto_fijo} | {pto_flot} | {atomo} | {predicado}
cadena    = \"[^\"]\"
argumentos= {argumento} (","{argumento})*
lista     = "["{argumentos}"]" 
predicado = {atomo}"("{argumentos}")"
atomo = [a-z][a-zA-Z0-9_]* | \'{entrada}+\' | {especial}+
%%

<YYINITIAL>{
    {entero}      {tokens.add(token(yyline, Token.ENTERO,     yytext()))}
    {pto_fijo}    {tokens.add(token(yyline, Token.PTO_FIJO,   yytext()))}
    {pto_flot}    {tokens.add(token(yyline, Token.PTO_FLOT,   yytext()))}
    {cadena}      {tokens.add(token(yyline, Token.CADENA,     yytext()))}
    {lista}       {tokens.add(token(yyline, Token.LISTA,      yytext()))}
    {predicado}   {tokens.add(token(yyline, Token.PREDICADO,  yytext()))}
    {atomo}       {tokens.add(token(yyline, Token.ATOMO,      yytext()))}
    "."           {tokens.add(token(yyline, Token.PUNTO,      yytext()))}
    ","           {tokens.add(token(yyline, Token.COMA,       yytext()))}
    ";"           {tokens.add(token(yyline, Token.PUNTO_COMA, yytext()))}
    "("           {tokens.add(token(yyline, Token.PAR_IZQ,    yytext()))}
    ")"           {tokens.add(token(yyline, Token.PAR_DER,    yytext()))} 


    [^]           {throw new Error(
        String.format(
            "Error de sintaxis en la linea %s, el caracter: '%s' no es valido",
            yytext());}
}