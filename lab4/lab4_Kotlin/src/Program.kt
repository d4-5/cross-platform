fun main() {
    val repository: Repository = FileRepository("tours.dat")
    var tours: List<Tour>
    var choice: Int
    var tourName: String
    var tour: Tour
    while (true) {
        println("Оберіть потрібну дію:")
        println("1 - переглянути всі записи")
        println("2 - додати запис")
        println("3 - видалити запис")
        println("4 - шукати клієнтів за назвою туру")
        println("5 - шукати клієнтів за назвою туру і оплатою")
        println("0 - завершити роботу програми")
        choice = readln().toInt()

        if (choice == 0) break
        when (choice) {
            1 -> {
                tours = repository.getAll()
                for (t in tours) {
                    println(t)
                }
            }

            2 -> {
                tour = inputNewTour()
                repository.addTour(tour)
            }

            3 -> {
                println("Вкажіть id запису")
                val id = readln().toInt()
                if (repository.deleteTour(id)) {
                    println("Дані успішно вилучено")
                } else {
                    println("Запису з таким id немає")
                }
            }

            4 -> {
                println("Задайте назву туру:")
                tourName = readln()
                tours = repository.getByTourName(tourName)
                var sum = 0
                for (t in tours) {
                    println(t)
                    sum += t.price
                }
                println("Кількість знайдених записів: " + tours.size)
                println("Виручка від продажів: $sum")
            }

            5 -> {
                println("Задайте назву туру:")
                tourName = readln()
                val paid = inputPaid()
                tours = repository.getByTourNameAndPaid(tourName, paid)
                tours.stream().forEach { x: Tour? -> println(x) }
            }
        }
    }
}

fun inputNewTour(): Tour {
    println("Введіть дані.")
    println("Прізвище:")
    val surname = readln()
    println("Ім\'я:")
    val name = readln()
    println("Назва туру:")
    val tourName = readln()
    println("Тривалість:")
    val duration = readln().toInt()
    println("Ціна:")
    val price = readln().toInt()
    val paid = inputPaid()
    return Tour(surname, name, tourName, duration, price, paid)
}

fun inputPaid(): Boolean {
    while (true) {
        println("Чи внесли клієнти кошти на оплату(Так/Ні):")
        val paid = readln()
        if (paid == "Так") {
            return true
        } else if (paid == "Ні") {
            return false
        }
    }
}