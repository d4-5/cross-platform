import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun main(args: Array<String>) {

    print("Введіть число a: ")
    val a = readln().toInt()

    print("Введіть число b: ")
    val b = readln().toInt()

    print("Введіть число c: ")
    val c = readln().toInt()

    println("x^2/(${a}*x + ${b}) < ${c}")

    if (a == 0 && b == 0) {
        println("Розв'язків немає")
    } else {
        val A = 1
        val B = -c * a
        val C = -c * b
        val D = B * B - 4 * A * C

        if (a == 0 && b != 0 && D > 0) {
            val x1 = (-B + sqrt(D.toDouble())) / (2 * A)
            val x2 = (-B - sqrt(D.toDouble())) / (2 * A)
            val minX = minOf(x2, x1)
            val maxX = maxOf(x2, x1)
            println("x Є (-∞ ; ${String.format("%.2f", minX)}) and (${String.format("%.2f", maxX)} ; ∞)")
        } else if (a != 0 && b == 0 && D > 0) {
            val x1 = (-B + sqrt(D.toDouble())) / (2 * A)
            val x2 = (-B - sqrt(D.toDouble())) / (2 * A)
            if (a > 0) {
                val minX = minOf(x2, x1)
                println("x Є (-∞ ; ${String.format("%.2f", minX)})")
            } else {
                val maxX = maxOf(x2, x1)
                println("x Є (${String.format("%.2f", maxX)} ; ∞)")
            }
        } else if (a != 0 && b != 0 && D > 0) {
            val x1 = (-B + sqrt(D.toDouble())) / (2 * A)
            val x2 = (-B - sqrt(D.toDouble())) / (2 * A)
            val x3 = -b.toDouble() / a
            val middle: Double

            val smallest = if (x1 <= x2 && x1 <= x3) {
                x1
            } else if (x2 <= x1 && x2 <= x3) {
                x2
            } else {
                x3
            }

            val largest = if (x1 >= x2 && x1 >= x3) {
                x1
            } else if (x2 >= x1 && x2 >= x3) {
                x2
            } else {
                x3
            }

            middle = (x1 + x2 + x3) - smallest - largest

            if (a > 0) {
                println("x Є (-∞ ; ${String.format("%.2f", smallest)}) and (${String.format("%.2f", middle)} ; ${String.format("%.2f", largest)})")
            } else {
                println("x Є (${String.format("%.2f", smallest)} ; ${String.format("%.2f", middle)}) and (${String.format("%.2f", largest)} ; ∞)")

            }
        }
    }

}