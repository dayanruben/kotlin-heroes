package heroes12.practice

import utils.withFile

fun main() {
    withFile {
        val t = readln().toInt()
        repeat(t) {
            val n = readln().toInt()
            println(n - 1)
        }
    }
}
