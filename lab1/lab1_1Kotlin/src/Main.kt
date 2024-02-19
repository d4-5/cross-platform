fun main() {
    print("Введіть довжину сторони a: ")
    val a = readln().toDouble()
    print("Введіть довжину сторони b: ")
    val b = readln().toDouble()

    val S = a * b
    val P = 2 * (a + b)

    println("Площа прямокутника: $S")
    println("Периметр прямокутника: $P")
}
