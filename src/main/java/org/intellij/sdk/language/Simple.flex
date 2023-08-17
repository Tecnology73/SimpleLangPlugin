package org.intellij.sdk.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import static org.intellij.sdk.language.psi.SimpleTypes.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static org.intellij.sdk.language.psi.SimpleParserDefinition.*;

%%

%class SimpleLexer
%implements FlexLexer
%unicode
%public

%function advance
%type IElementType

NL = \R
WS = [ \t\f]

LINE_COMMENT = "//" [^\r\n]*
MULTILINE_COMMENT = "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?

LETTER = [:letter:] | "_"
DIGIT =  [:digit:]

INT_DIGIT = [0-9]

//NUM_INT = '0' | [1-9]{INT_DIGIT}*
NUM_INT = {INT_DIGIT}*

IDENT = {LETTER} ({LETTER} | {DIGIT} )*

%state MAYBE_SEMICOLON

%%

<YYINITIAL> {
{WS}                                      { return WS; }
{NL}+                                     { return NLS; }

{LINE_COMMENT}                            { return LINE_COMMENT; }
{MULTILINE_COMMENT}                       { return MULTILINE_COMMENT; }

"{"                                       { return LBRACE; }
"}"                                       { yybegin(MAYBE_SEMICOLON); return RBRACE; }
"("                                       { return LPAREN; }
")"                                       { yybegin(MAYBE_SEMICOLON); return RPAREN; }
"["                                       { return LBRACK; }
"]"                                       { yybegin(MAYBE_SEMICOLON); return RBRACK; }

";"                                       { return SEMICOLON; }
":"                                       { return COLON; }
","                                       { return COMMA; }
"."                                       { return DOT; }
".."                                      { return DOUBLE_DOT; }

"<"                                      { return LESS_THAN; }
">"                                      { return GREATER_THAN; }

"="                                       { return ASSIGN; }
"=="                                      { return EQUAL; }

"return"                                  { return RETURN; }
"new"                                     { return NEW; }

"func"                                    { return FUNC; }

"type"                                    { return TYPE_; }

{IDENT}                                   { yybegin(MAYBE_SEMICOLON); return IDENTIFIER; }

{NUM_INT}                                 { yybegin(MAYBE_SEMICOLON); return INT; }

.                                         { return BAD_CHARACTER; }
}

<MAYBE_SEMICOLON> {
{WS}                                      { return WS; }
{NL}                                      { yybegin(YYINITIAL); yypushback(yytext().length()); return SEMICOLON_SYNTHETIC; }
{LINE_COMMENT}                            { return LINE_COMMENT; }
{MULTILINE_COMMENT}                       { return MULTILINE_COMMENT; }
.                                         { yybegin(YYINITIAL); yypushback(yytext().length()); }
}