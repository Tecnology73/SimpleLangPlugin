package org.intellij.sdk.language;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.SimpleParserDefinition;
import org.intellij.sdk.language.psi.SimpleTypes;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.HighlighterColors.BAD_CHARACTER;
import static org.intellij.sdk.language.SimpleSyntaxHighlighterColors.*;

public class SimpleSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    static {
        fillMap(ATTRIBUTES, LINE_COMMENT, SimpleParserDefinition.LINE_COMMENT);
        fillMap(ATTRIBUTES, BLOCK_COMMENT, SimpleParserDefinition.MULTILINE_COMMENT);
        fillMap(ATTRIBUTES, BRACES, SimpleTypes.LBRACE, SimpleTypes.RBRACE);
        fillMap(ATTRIBUTES, PARENTHESIS, SimpleTypes.LPAREN, SimpleTypes.RPAREN);
        fillMap(ATTRIBUTES, BRACKETS, SimpleTypes.LBRACK, SimpleTypes.RBRACK);
        fillMap(ATTRIBUTES, BAD_CHARACTER, TokenType.BAD_CHARACTER);
        fillMap(ATTRIBUTES, IDENTIFIER, SimpleTypes.IDENTIFIER);
        fillMap(ATTRIBUTES, DOT, SimpleTypes.DOT);
        fillMap(ATTRIBUTES, COLON, SimpleTypes.COLON);
        fillMap(ATTRIBUTES, SEMICOLON, SimpleTypes.SEMICOLON);
        fillMap(ATTRIBUTES, COMMA, SimpleTypes.COMMA);
        fillMap(ATTRIBUTES, IDENTIFIER, SimpleTypes.IDENTIFIER);
        fillMap(ATTRIBUTES, SimpleParserDefinition.KEYWORDS, KEYWORD);
        fillMap(ATTRIBUTES, SimpleParserDefinition.OPERATORS, OPERATOR);
//        fillMap(ATTRIBUTES, SimpleParserDefinition.STRING_LITERALS, STRING);
        fillMap(ATTRIBUTES, SimpleParserDefinition.NUMBERS, NUMBER);
//        fillMap(ATTRIBUTES, MEMBER, SimpleTypes.BASE_EXPRESSION);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SimpleLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        return pack(ATTRIBUTES.get(tokenType));
    }

}