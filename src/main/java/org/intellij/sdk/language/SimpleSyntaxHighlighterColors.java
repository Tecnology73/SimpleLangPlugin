package org.intellij.sdk.language;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import kotlin.random.Random;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class SimpleSyntaxHighlighterColors {
    public static final TextAttributesKey LINE_COMMENT = createTextAttributesKey("SIMPLE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BLOCK_COMMENT = createTextAttributesKey("SIMPLE_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("SIMPLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING = createTextAttributesKey("SIMPLE_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("SIMPLE_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey BRACES = createTextAttributesKey("SIMPLE_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PARENTHESIS = createTextAttributesKey("SIMPLE_PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("SIMPLE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("SIMPLE_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("SIMPLE_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey DOT = createTextAttributesKey("SIMPLE_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("SIMPLE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey COLON = createTextAttributesKey("SIMPLE_COLON", HighlighterColors.TEXT);
    public static final TextAttributesKey COMMA = createTextAttributesKey("SIMPLE_COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey TYPE_NAME = createTextAttributesKey("SIMPLE_TYPE_NAME", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey MEMBER = createTextAttributesKey("SIMPLE_MEMBER", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey INSTANCE_FIELD = createTextAttributesKey("SIMPLE_INSTANCE_FIELD", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey INSTANCE_METHOD = createTextAttributesKey("SIMPLE_INSTANCE_METHOD", DefaultLanguageHighlighterColors.INSTANCE_METHOD);
}
