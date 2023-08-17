// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.intellij.sdk.language;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.intellij.sdk.language.psi.*;

import java.util.*;

public class SimpleUtil {
    public static List<? extends SimpleNamedElement> findDeclarations(Project project, String key, Class<? extends SimpleNamedElement> tClass) {
        List<SimpleNamedElement> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile == null) continue;

            Collection<SimpleNamedElement> properties = PsiTreeUtil.findChildrenOfType(simpleFile, tClass);
            if (properties.isEmpty()) continue;

            for (SimpleNamedElement property : properties) {
                if (key.equals(property.getName())) {
                    result.add(property);
                }
            }
        }

        return result;
    }

    public static <T extends SimpleNamedElement> List<T> findDeclarations(Project project, Class<T> tClass) {
        List<T> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SimpleFile simpleFile = (SimpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile == null) continue;

            T[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, tClass);
            if (properties != null) {
                Collections.addAll(result, properties);
            }
        }

        return result;
    }
}