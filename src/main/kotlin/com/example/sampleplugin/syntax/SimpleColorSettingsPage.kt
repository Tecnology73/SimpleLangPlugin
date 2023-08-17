package com.example.sampleplugin.syntax

import com.example.sampleplugin.Icons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class SimpleColorSettingsPage : ColorSettingsPage {
    private val DESCRIPTORS = arrayOf<AttributesDescriptor>(
            // AttributesDescriptor("Identifier", DataFusionSyntaxHighlighter.ID),
            AttributesDescriptor("Keyword", SimpleSyntaxHighlighter.KEYWORD),
            AttributesDescriptor("String", SimpleSyntaxHighlighter.STRING),
            AttributesDescriptor("Number", SimpleSyntaxHighlighter.NUMBER),
            AttributesDescriptor("Line comment", SimpleSyntaxHighlighter.LINE_COMMENT),
            AttributesDescriptor("Block comment", SimpleSyntaxHighlighter.BLOCK_COMMENT),
            AttributesDescriptor("Type reference", SimpleSyntaxHighlighter.TYPE_REFERENCE),
    )

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Simple Language"
    }

    override fun getIcon(): Icon? {
        return Icons.LogoLight
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return SimpleSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """
// Just a single line comment.
type User {
    a: int;
    b: int = 32;
    c = 32;
    age: int;
}

/* Block Comment */
func<User> getAge() i32 {
    return 0;
}

/**
 * Multiline block comment
 */
func main() i32 {
    user = new User();
    user.getAge();

    return 0;
}
"""
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}