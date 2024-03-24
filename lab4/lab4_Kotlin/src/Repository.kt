interface Repository {
    fun getAll(): List<Tour>
    fun getById(id: Int): Tour
    fun addTour(tour: Tour): Boolean
    fun deleteTour(id: Int): Boolean
    fun getByTourName(tourName: String): List<Tour>
    fun getByTourNameAndPaid(tourName: String, paid: Boolean): List<Tour>
}