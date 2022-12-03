package utils

import java.io.File

object AoCUtils {

    fun linesFromFileToList(filename: String) = File(filename).useLines { it.toList() }

    fun getFilePath(path: String): String = object {}.javaClass.getResource(path)?.file ?: throw NoSuchFileException(File(path))
}