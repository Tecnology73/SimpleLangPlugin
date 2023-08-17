package com.example.sampleplugin

import com.example.sampleplugin.parser.SimpleParser
import com.example.sampleplugin.psi.SimpleTokenSets
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.example.sampleplugin.psi.SimpleFile
import com.example.sampleplugin.psi.SimpleTypes

class SimpleParserDefinition : ParserDefinition {
    companion object {
        val FILE = IFileElementType(SimpleLanguage.INSTANCE)
    }

    override fun createLexer(project: Project?): Lexer {
        return SimpleLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return SimpleParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return SimpleTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return SimpleTokenSets.STRINGS
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return SimpleTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SimpleFile(viewProvider)
    }
}