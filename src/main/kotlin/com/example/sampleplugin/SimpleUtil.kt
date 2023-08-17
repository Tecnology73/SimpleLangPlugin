package com.example.sampleplugin

import com.example.sampleplugin.psi.SimpleFile
import com.example.sampleplugin.psi.SimpleTypeDeclaration
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil

object SimpleUtil {
    fun findTypeDeclarations(project: Project): List<SimpleTypeDeclaration> {
        val results = mutableListOf<SimpleTypeDeclaration>()
        val virtualFiles = FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project))

        virtualFiles.forEach { file ->
            val simpleFile = PsiManager.getInstance(project).findFile(file)
            val properties = PsiTreeUtil.findChildrenOfType(simpleFile, SimpleTypeDeclaration::class.java)

            results.addAll(properties)
        }

        return results
    }

    fun findTypeDeclarations(project: Project, key: String): List<SimpleTypeDeclaration> {
        val results = mutableListOf<SimpleTypeDeclaration>()
        val virtualFiles = FileTypeIndex.getFiles(SimpleFileType.INSTANCE, GlobalSearchScope.allScope(project))

        virtualFiles.forEach { file ->
            val simpleFile = PsiManager.getInstance(project).findFile(file) as SimpleFile? ?: return@forEach
            val properties = PsiTreeUtil.findChildrenOfType(simpleFile, SimpleTypeDeclaration::class.java)
                    .filter { it.name == key }

            results.addAll(properties)
        }

        return results
    }
}