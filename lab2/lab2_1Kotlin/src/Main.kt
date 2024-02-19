fun main() {
    print("Введіть число A: ")
    var A = readln().toInt()

    print("Введіть число B: ")
    var B = readln().toInt()

    if (A % 2 == 0 && B % 2 == 0) {
        A /= 2
        B /= 2
    } else if (A % 2 != 0 && B % 2 != 0) {
        A = (A + B) / 2
        B = A
    }

    println("Нове значення A: $A")
    println("Нове значення B: $B")
}
