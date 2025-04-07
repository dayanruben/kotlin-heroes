package heroes12

fun main() {
    val s = readln()
    val n = s.length
    val pg = IntArray(n + 1)
    val ps = IntArray(n + 1)
    val pb = IntArray(n + 1)
    for (i in 1..n) {
        pg[i] = pg[i - 1] + if (s[i - 1] == 'G') 1 else 0
        ps[i] = ps[i - 1] + if (s[i - 1] == 'S') 1 else 0
        pb[i] = pb[i - 1] + if (s[i - 1] == 'B') 1 else 0
    }
    val q = readln().toInt()
    val ans = buildString {
        repeat(q) {
            val (l, r) = readln().split(" ").map { it.toInt() }
            val g = pg[r] - pg[l - 1]
            val count = ps[r] - ps[l - 1]
            val b = pb[r] - pb[l - 1]
            val res = maxOf(g + minOf(count, b), count + minOf(g, b), b + minOf(g, count))
            append("$res\n")
        }
    }
    print(ans)
}