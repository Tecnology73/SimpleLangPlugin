package com.example.sampleplugin.psi

import com.intellij.psi.tree.TokenSet

class SimpleTokenSets {
    companion object {
        val NEW_LINES = SimpleTokenType("SIMPLE_NEW_LINES")

        val COMMENTS = TokenSet.create(SimpleTypes.LINE_COMMENT, SimpleTypes.BLOCK_COMMENT)
        val WHITE_SPACE = TokenSet.create(com.intellij.psi.TokenType.WHITE_SPACE, NEW_LINES)

        val ID = TokenSet.create(SimpleTypes.ID)

        val TYPE_DECLARATION = TokenSet.create(SimpleTypes.TYPE_DECLARATION)
        val TYPE_FIELD = TokenSet.create(SimpleTypes.TYPE_FIELD)

        val FUNC_DECLARATION = TokenSet.create(SimpleTypes.FUNCTION_DECLARATION)

        val STRINGS = TokenSet.create()

        val PARENS = TokenSet.create(SimpleTypes.LPAREN, SimpleTypes.RPAREN)
        val BRACES = TokenSet.create(SimpleTypes.LCURLY, SimpleTypes.RCURLY)
        val BRACKS = TokenSet.create(SimpleTypes.LBRACK, SimpleTypes.RBRACK)

        val KEYWORDS = TokenSet.create(
                SimpleTypes.NEW_KW,
                SimpleTypes.FUNC_KW,
                SimpleTypes.TYPE_KW,
                SimpleTypes.RETURN_KW
        )
    }
}