import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.pow

fun main() {
    var u: Double
    var s = 1.0
    val eps = 0.00001
    println("Введіть значення x")
    val x = readln().toDouble()
    u = x * x
    var n = 1
    while (abs(u) > eps) {
        s -= u
        u *= -4 * x * x / ((2 * n + 1) * (2 * n + 2))
        n++
    }

    System.out.printf("Значення суми s = %.6f\n", s)
    System.out.printf("Значення функції: %.6f\n", cos(x).pow(2))
    println("Кількість доданків $n")
}
