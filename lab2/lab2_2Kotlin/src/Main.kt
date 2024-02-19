import java.util.*
import kotlin.math.sqrt

fun main(args: Array<String>) {

    print("Введіть число a: ")
    val a = readln().toInt()

    print("Введіть число b: ")
    val b = readln().toInt()

    print("Введіть число c: ")
    val c = readln().toInt()

    println("x^2/(${a}*x + ${b}) < ${c}")

    if (a == 0) {
        if (c * b <= 0) {
            println("Розв'язків немає")
        } else {
            val x1 = sqrt((c * b).toDouble())
            val x2 = -sqrt((c * b).toDouble())
            println("x Є (${String.format("%.2f", x2)} ; ${String.format("%.2f", x1)})")
        }
    } else {
        val A = 1
        val B = -c * a
        val C = -c * b
        val D = B * B - 4 * A * C

        if (D <= 0) {
            println("Розв'язків немає")
        } else {
            val x1 = (-B + sqrt(D.toDouble())) / (2 * A)
            val x2 = (-B - sqrt(D.toDouble())) / (2 * A)
            println("x Є (${String.format("%.2f", x2)} ; ${String.format("%.2f", x1)})")
        }
    }
}