package com.example.sampleplugin.psi

import com.example.sampleplugin.SimpleFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.childrenOfType

object SimpleElementFactory {
    @JvmStatic
    fun createIdentifier(project: Project?, name: String): SimpleNamedElement {
        val file = createFile(project, "type $name {}")
        return file.firstChild.childrenOfType<SimpleNamedElement>().first()
    }

    fun createFile(project: Project?, text: String?): SimpleFile {
        return text?.let {
            PsiFileFactory.getInstance(project).createFileFromText("dummy.simple", SimpleFileType.INSTANCE, it)
        } as SimpleFile
    }
}
