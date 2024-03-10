import java.util.*
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    var u: Double
    println("Введіть межі для x")
    val a = readln().toDouble()
    val b = readln().toDouble()
    var x = a
    val hx = (b - a) / 7
    println("Введіть межі для y")
    val c = readln().toDouble()
    val d = readln().toDouble()
    var y = c
    val hy = (d - c) / 7
    print(" y\\x ")
    for (i in 0..7) print("%8.2f".format(x + hx * i))
    println()
    for (i in 0..7) {
        print("%5.2f".format(y))
        x = a
        for (j in 0..7) {
            u = sin(x) + cos(y)
            print("%8.2f".format(u))
            x += hx
        }
        println()
        y += hy
    }
}
