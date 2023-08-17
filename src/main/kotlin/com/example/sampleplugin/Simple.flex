package com.example.sampleplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.example.sampleplugin.psi.SimpleTypes;
import com.example.sampleplugin.psi.SimpleTokenSets;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.example.sampleplugin.psi.SimpleTypes.*;

%%

%{
    public SimpleLexer() {
      this((java.io.Reader)null);
    }
%}

%public
%class SimpleLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

NEW_LINE = [\n\r]+
WHITE_SPACE = [\ \t\f]

LINE_COMMENT = "//".*

BLOCK_COMMENT_START = "/*"
BLOCK_COMMENT_END = "*/"
COMMENT_CONTENT = [^*] | [*]+[^*/]

VALUE_INTEGER = [0-9]+
ID = [a-zA-Z_][a-zA-Z_0-9]*

ESC = "\\" (["\\/"] | "b" | "f" | "n" | "r" | "t" | UNICODE)
UNICODE = "u" HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT

DECIMALS = [0-9] ("_"? [0-9])*

OCTAL_DIGIT = [0-7]
HEX_DIGIT = [0-9a-fA-F]
BIN_DIGIT = [0-1]
EXPONENT = [eE] [+-]? DECIMALS

%state BLOCK_COMMENT, VALUE_FLOAT

%%

<YYINITIAL> {
  {BLOCK_COMMENT_START}    { yybegin(BLOCK_COMMENT); return SimpleTypes.BLOCK_COMMENT; }
}
<BLOCK_COMMENT> {
  {COMMENT_CONTENT}        { return SimpleTypes.BLOCK_COMMENT; }
  {BLOCK_COMMENT_END}      { yybegin(YYINITIAL); return SimpleTypes.BLOCK_COMMENT; }
}

<YYINITIAL> {
    {WHITE_SPACE}+              { return com.intellij.psi.TokenType.WHITE_SPACE; }
    {NEW_LINE}+                 { return com.intellij.psi.TokenType.WHITE_SPACE; }

    {LINE_COMMENT}              { return LINE_COMMENT; }

    // Characters
    ":"                         { return COLON; }
    "::"                        { return COLONCOLON; }
    "."                         { return DOT; }
    ".."                        { return DOTDOT; }
    ","                         { return COMMA; }
    ";"                         { return SEMICOLON; }
    "{"                         { return LCURLY; }
    "}"                         { return RCURLY; }
    "["                         { return LBRACK; }
    "]"                         { return RBRACK; }
    "("                         { return LPAREN; }
    ")"                         { return RPAREN; }

    // Operators
    "+"                         { return PLUS; }
    "+="                        { return PLUSEQ; }
    "-"                         { return MINUS; }
    "-="                        { return MINUSEQ; }
    "*"                         { return MUL; }
    "*="                        { return MULEQ; }
    "/"                         { return DIV; }
    "/="                        { return DIVEQ; }
    "<"                         { return LANGLE; }
    ">"                         { return RANGLE; }
    "<="                        { return LE; }
    ">="                        { return GE; }
    "="                         { return EQ; }
    "=="                        { return EQEQ; }
    "!="                        { return NE; }
    "&&"                        { return AND; }
    "||"                        { return OR; }
    "!"                         { return NOT; }


    // Keywords
    "new"                       { return NEW_KW; }
    "func"                      { return FUNC_KW; }
    "type"                      { return TYPE_KW; }
    "return"                    { return RETURN_KW; }
//    "break"                     { return BREAK_KW; }
//    "continue"                  { return CONTINUE_KW; }
//    "if"                        { return IF_KW; }
//    "else"                      { return ELSE_KW; }
//    "for"                       { return FOR_KW; }
//    "as"                        { return AS_KW; }
//    "step"                      { return STEP_KW; }
//    "import"                    { return IMPORT_KW; }


//    {DOUBLE_QUOUTE_STRING}      { return DOUBLE_QUOUTE_STRING; }
//    {SINGLE_QUOUTE_STRING}      { return SINGLE_QUOUTE_STRING; }
//    {BACKTICK_STRING}           { return BACKTICK_STRING; }

//    "null" | "NULL"             { return VALUE_NULL; }
    "true" | "false"            { return VALUE_BOOL; }

    {VALUE_INTEGER}             { return VALUE_INTEGER; }

    "-"? [0-9]* "." [0-9]+ [eE][+\-]? [0-9]+ "f"  { return SimpleTypes.VALUE_FLOAT; }
    "-"? [0-9]+ [eE][+\-]? [0-9]+ "f"             { return SimpleTypes.VALUE_FLOAT; }
    "-"? [0-9]+ "f"                               { return SimpleTypes.VALUE_FLOAT; }

    {ID}                        { return ID; }

    .                           { return BAD_CHARACTER; }
}

[^] { return BAD_CHARACTER; }