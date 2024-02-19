fun main() {
    print("Введіть трицифрове ціле число: ")
    var n = readln().toInt()

    val a = n / 100
    val b = n / 10 - a*10

    n = n - a * 100 + a * 10 - b * 10 + b * 100
    println("Число після перестановки: $n")
}
