package org.intellij.sdk.language.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.intellij.sdk.language.SimpleLanguage;
import org.intellij.sdk.language.SimpleLexerAdapter;
import org.intellij.sdk.language.parser.SimpleParser;
import org.jetbrains.annotations.NotNull;

public class SimpleParserDefinition implements ParserDefinition {
    public static final IElementType LINE_COMMENT = new SimpleTokenType("SIMPLE_LINE_COMMENT");
    public static final IElementType MULTILINE_COMMENT = new SimpleTokenType("SIMPLE_MULTILINE_COMMENT");

    public static final IElementType WS = new SimpleTokenType("SIMPLE_WHITESPACE");
    public static final IElementType NLS = new SimpleTokenType("SIMPLE_WS_NEW_LINES");

    public static final TokenSet WHITESPACES = TokenSet.create(WS, NLS);
    public static final TokenSet COMMENTS = TokenSet.create(LINE_COMMENT, MULTILINE_COMMENT);
    //    public static final TokenSet STRING_LITERALS = TokenSet.create(STRING);
    public static final TokenSet NUMBERS = TokenSet.create(SimpleTypes.INT);
    public static final TokenSet KEYWORDS = TokenSet.create(
            SimpleTypes.FUNC, SimpleTypes.RETURN, SimpleTypes.TYPE_, SimpleTypes.NEW);
    public static final TokenSet OPERATORS = TokenSet.create(
            SimpleTypes.EQUAL, SimpleTypes.ASSIGN);

    public static final IFileElementType FILE = new IFileElementType(SimpleLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new SimpleLexerAdapter();
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new SimpleParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITESPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return SimpleTypes.Factory.createElement(node);
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new SimpleFile(viewProvider);
    }
}
