package utils

import java.io.Closeable
import java.io.File
import java.io.FileInputStream
import java.io.PrintStream

fun <T : Closeable, R> T.useWith(block: T.() -> R): R = use { with(it, block) }

fun withFile(input: String = "test.in", output: String = "test.out", block: () -> Unit) {
    val originalIn = System.`in`
    val originalOut = System.out

    try {
        System.setIn(FileInputStream(input))
        System.setOut(PrintStream(File(output)))

        block()
    } finally {
        System.setIn(originalIn)
        System.setOut(originalOut)
    }
}
