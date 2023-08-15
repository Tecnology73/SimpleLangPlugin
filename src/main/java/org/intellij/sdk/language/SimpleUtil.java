// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.SimpleFile;
import org.intellij.sdk.language.psi.SimpleTypeDeclaration;

import java.util.*;

public class SimpleUtil {
    public static List<SimpleTypeDeclaration> findTypeDeclarations(Project project, String key) {
        List<SimpleTypeDeclaration> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                SimpleTypeDeclaration[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleTypeDeclaration.class);
                if (properties != null) {
                    for (SimpleTypeDeclaration property : properties) {
                        if (key.equals(property.getIdentifier().getText())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public static List<SimpleTypeDeclaration> findTypeDeclarations(Project project) {
        List<SimpleTypeDeclaration> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                SimpleTypeDeclaration[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, SimpleTypeDeclaration.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}