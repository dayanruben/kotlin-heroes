package heroes12

fun main() {
    val t = readln().toInt()
    val digits = "0123456789"
    val uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowers = "abcdefghijklmnopqrstuvwxyz"

    repeat(t) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }

        val password = StringBuilder()
        for (i in 0 until c) {
            password.append(lowers[i % lowers.length])
        }
        for (i in 0 until b) {
            password.append(uppers[i % uppers.length])
        }
        for (i in 0 until a) {
            password.append(digits[i % digits.length])
        }

        for (i in 1 until password.length) {
            if (password[i] == password[i - 1]) {
                for (ch in (digits + lowers + uppers)) {
                    if (ch != password[i - 1] && (i == password.length - 1 || ch != password[i + 1])) {
                        password.setCharAt(i, ch)
                        break
                    }
                }
            }
        }

        println(password)
    }
}