package heroes12

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val a = readln().split(" ").map { it.toInt() }.sorted()
        var ok = true
        for (i in 0 until n) {
            val l = 2 * i
            val r = 2 * i + 1
            if (r < a.size - 1 && a[r] - a[l] > a[r + 1] - a[r]) {
                ok = false
                break
            }
            if (l > 0 && a[r] - a[l] > a[l] - a[l - 1]) {
                ok = false
                break
            }
        }
        println(if (ok) "YES" else "NO")
    }
}