package org.intellij.sdk.language;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

import static org.intellij.sdk.language.SimpleSyntaxHighlighterColors.*;

public class SimpleColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Brackets", BRACKETS),
            new AttributesDescriptor("Braces", BRACES),
            new AttributesDescriptor("Types", TYPE_NAME),
            new AttributesDescriptor("Identifier", IDENTIFIER),
            new AttributesDescriptor("Member", MEMBER),
            new AttributesDescriptor("Instance//Method", INSTANCE_METHOD),
            new AttributesDescriptor("Instance//Field", INSTANCE_FIELD),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return SimpleIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new SimpleSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// Just a single line comment.\n" +
                "type User {\n" +
                "    a: int;\n" +
                "    b: int = 32;\n" +
                "    c = 32;\n" +
                "    age: int;\n" +
                "}\n" +
                "\n" +
                "/* Block Comment */\n" +
                "func<User> getAge() i32 {\n" +
                "    return 0;\n" +
                "}\n" +
                "\n" +
                "/**\n" +
                " * Multiline block comment\n" +
                " */\n" +
                "func main() i32 {\n" +
                "    user = new User();\n" +
                "    user.getAge();\n" +
                "\n" +
                "    return 0;\n" +
                "}\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Simple";
    }

}
