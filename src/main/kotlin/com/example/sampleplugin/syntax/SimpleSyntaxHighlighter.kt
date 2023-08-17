package com.example.sampleplugin.syntax

import com.example.sampleplugin.SimpleLexerAdapter
import com.example.sampleplugin.psi.SimpleTokenSets
import com.example.sampleplugin.psi.SimpleTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class SimpleSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val EMPTY_KEYS = arrayOf<TextAttributesKey>()
        val BAD_CHARACTER = createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        val ID = createTextAttributesKey("SIMPLE_ID", DefaultLanguageHighlighterColors.IDENTIFIER)
        val KEYWORD = createTextAttributesKey("SIMPLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)

        val STRING = createTextAttributesKey("SIMPLE_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = createTextAttributesKey("SIMPLE_NUMBER", DefaultLanguageHighlighterColors.NUMBER)

        val LINE_COMMENT = createTextAttributesKey("SIMPLE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BLOCK_COMMENT = createTextAttributesKey("SIMPLE_BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)

        val DOT = createTextAttributesKey("SIMPLE_DOT", DefaultLanguageHighlighterColors.DOT)
        val COMMA = createTextAttributesKey("SIMPLE_COMMA", DefaultLanguageHighlighterColors.COMMA)
        val COLON = createTextAttributesKey("SIMPLE_COLON", DefaultLanguageHighlighterColors.COMMA)
        val SEMICOLON = createTextAttributesKey("SIMPLE_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)

        val TYPE_NAME = createTextAttributesKey("SIMPLE_TYPE_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
        val TYPE_REFERENCE = createTextAttributesKey("SIMPLE_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE)

        val PARENS = createTextAttributesKey("SIMPLE_PARENS", DefaultLanguageHighlighterColors.PARENTHESES)
        val BRACES = createTextAttributesKey("SIMPLE_BRACES", DefaultLanguageHighlighterColors.BRACES)
        val BRACKETS = createTextAttributesKey("SIMPLE_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    }

    override fun getHighlightingLexer(): Lexer {
        return SimpleLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        if (SimpleTokenSets.KEYWORDS.contains(tokenType)) {
            return arrayOf(KEYWORD)
        }

        return when (tokenType) {
            SimpleTypes.ID -> arrayOf(ID)

            SimpleTypes.VALUE_INTEGER, SimpleTypes.VALUE_FLOAT -> arrayOf(NUMBER)

            SimpleTypes.LINE_COMMENT -> arrayOf(LINE_COMMENT)
            SimpleTypes.BLOCK_COMMENT -> arrayOf(BLOCK_COMMENT)

            SimpleTypes.DOT -> arrayOf(DOT)
            SimpleTypes.COMMA -> arrayOf(COMMA)
            SimpleTypes.COLON -> arrayOf(COLON)
            SimpleTypes.SEMICOLON -> arrayOf(SEMICOLON)

            SimpleTypes.LPAREN, SimpleTypes.RPAREN -> arrayOf(PARENS)
            SimpleTypes.LCURLY, SimpleTypes.RCURLY -> arrayOf(BRACES)
            SimpleTypes.LBRACK, SimpleTypes.RBRACK -> arrayOf(BRACKETS)

            TokenType.BAD_CHARACTER -> arrayOf(BAD_CHARACTER)

            else -> EMPTY_KEYS
        }
    }
}