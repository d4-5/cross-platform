import java.io.Serializable

class Tour (var surname: String,
    var name: String,
    var tourName: String,
    var duration: Int = 0,
    var price: Int = 0,
    var paid: Boolean = false ): Serializable {

    var id: Int = 0
    constructor():this("Unknown", "Unknown", "Unknown"){
    }

    override fun toString(): String {
        var str = id.toString() + ") " + " Name: " + name + " Surname: " + surname +
                " Tour name: " + tourName + " Duration: " + duration +
                " Price: " + price + " Paid: "
        str += if (paid) {
            "Так"
        } else {
            "Ні"
        }
        return str
    }
    constructor(id: Int, surname: String, name: String,
                tourName: String, duration: Int,
                price: Int, paid: Boolean): this(surname,
        name, tourName, duration, price, paid) {
        this.id = id
    }
}