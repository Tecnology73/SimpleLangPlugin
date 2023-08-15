// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import org.intellij.sdk.language.SimpleFileType;
import org.intellij.sdk.language.psi.impl.SimpleTypeDeclarationImpl;

public class SimpleElementFactory {
    public static SimpleFile createFile(Project project, String text) {
        return (SimpleFile) PsiFileFactory.getInstance(project).createFileFromText("d.simple", SimpleFileType.INSTANCE, text);
    }

    public static PsiElement createIdentifier(Project project, String name) {
        final SimpleFile file = createFile(project, "type " + name + "{}");
        return ((SimpleTypeDeclarationImpl) file.getFirstChild()).getIdentifier();
    }
}
