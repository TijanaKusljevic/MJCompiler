package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROG, yytext()); }
"print" 	{ return new_symbol(sym.PRINT, yytext()); }
"return" 	{ return new_symbol(sym.RETURN, yytext()); }
"void" 		{ return new_symbol(sym.VOID, yytext()); }
<YYINITIAL> "+" 		{ return new_symbol(sym.PLUS, yytext()); }
"=" 		{ return new_symbol(sym.EQUAL, yytext()); }
";" 		{ return new_symbol(sym.SEMI, yytext()); }
"," 		{ return new_symbol(sym.COMMA, yytext()); }
"(" 		{ return new_symbol(sym.LPAREN, yytext()); }
")" 		{ return new_symbol(sym.RPAREN, yytext()); }
"{" 		{ return new_symbol(sym.LBRACE, yytext()); }
"}"			{ return new_symbol(sym.RBRACE, yytext()); }
"++"	{ return new_symbol(sym.PLUSPLUS, yytext()); }
"--"	{ return new_symbol(sym.MINUSMINUS, yytext()); }
"read"	{ return new_symbol(sym.READ, yytext()); }
"-"		{ return new_symbol(sym.MINUS, yytext()); }
"*"     { return new_symbol(sym.MUL, yytext()); }
"/"     { return new_symbol(sym.DIV, yytext()); }
"%"     { return new_symbol(sym.MOD, yytext()); }
"'"[\040-\176]"'" {return new_symbol (sym.CHARCONST, new Character (yytext().charAt(1)));} 
"false"     { return new_symbol(sym.FALSE, yytext()); }
"true"     { return new_symbol(sym.TRUE, yytext()); }
"new"     { return new_symbol(sym.NEW, yytext()); }
"[" 	  { return new_symbol(sym.LSQUARE, yytext()); }
"]" 	  { return new_symbol(sym.RSQUARE, yytext()); }
"." 	  { return new_symbol(sym.POINT, yytext()); }
"break" 	  { return new_symbol(sym.BREAK, yytext()); }
"continue" 	  { return new_symbol(sym.CONTINUE, yytext()); }
"for" 	  { return new_symbol(sym.FOR, yytext()); }
"||"      { return new_symbol(sym.OR, yytext()); }
"&&"      { return new_symbol(sym.AND, yytext()); }
"=="      { return new_symbol(sym.EQUEQU, yytext()); }
"!=" 	{ return new_symbol(sym.NOTEQU, yytext()); }
">" 	{ return new_symbol(sym.GT, yytext()); }
">=" 	{ return new_symbol(sym.GE, yytext()); }
"<"		{ return new_symbol(sym.LT, yytext()); }
"<="	{ return new_symbol(sym.LE, yytext()); }
"if"    { return new_symbol(sym.IF, yytext()); }
"else"  { return new_symbol(sym.ELSE, yytext()); }
"const" { return new_symbol(sym.CONSTANT, yytext()); }
"enum"  { return new_symbol(sym.ENUM, yytext()); }
":"  { return new_symbol(sym.DVETACKE, yytext()); }
"?" {return new_symbol(sym.UPITNIK, yytext());}
"#" {return new_symbol(sym.TARABA, yytext());}
"^" {return new_symbol(sym.KOREN, yytext());}

<YYINITIAL> "//" 		     { yybegin(COMMENT); }
<COMMENT> .      { yybegin(COMMENT); }
<COMMENT> "\r\n" { yybegin(YYINITIAL); }

[0-9]+  { return new_symbol(sym.NUMBER, new Integer (yytext())); }
([a-z]|[A-Z])[a-z|A-Z|0-9|_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1)+" sa pocetkom u koloni "+(yycolumn+1)); }






