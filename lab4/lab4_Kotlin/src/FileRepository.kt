import java.io.*
import java.util.stream.Collectors

class FileRepository(private val fileName: String) : Repository {
    private var tours: MutableList<Tour>

    init {
        tours = ArrayList()
    }
    // метод повертає актуальний список автомобілів
    override fun getAll(): List<Tour> {
        reloadData()
        return tours
    }

    private fun reloadData() {
        if (File(fileName).exists()) {
            try {
                FileInputStream(fileName).use {
                        fileInputStream -> try {
                    ObjectInputStream(fileInputStream).use {
                            objectInputStream ->
                        tours = objectInputStream
                            .readObject() as MutableList<Tour>
                    }
                } catch (e: ClassNotFoundException) {
                    throw RuntimeException(e)
                }
                }
            } catch (e: FileNotFoundException) {
                throw RuntimeException(e)
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }
    }

    override fun getById(id: Int): Tour {
        return Tour()
    }

    override fun addTour(tour: Tour): Boolean {
        var id = 0
        if (tours.size > 0) {
            val maxId = tours.stream().mapToInt {
                    t: Tour -> t.id }.max()
            if (maxId != null) {
                id = maxId.asInt
            }
        }
        tour.id = id + 1
        tours.add(tour)
        try {
            save()
        } catch (e: IOException) {
            return false
        }
        return true
    }

    @Throws(IOException::class)
    private fun save() {
        FileOutputStream(fileName).use {
                fileOutputStream ->
            ObjectOutputStream(fileOutputStream)
                .use { objectOutputStream ->
                    objectOutputStream.writeObject( tours )
                }
        }
    }

    override fun deleteTour(id: Int): Boolean {
        reloadData()
        val foundTour = tours.stream().filter {
                t: Tour -> t.id == id }.findFirst()
        if (foundTour.isPresent) {
            val tour = foundTour.get()
            tours.remove(tour)
            try {
                save()
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
            return true
        }
        return false
    }

    override fun getByTourName(tourName: String): List<Tour> {
        reloadData()
        return tours.stream()
            .filter { tour ->
                tour.tourName.equals(tourName, ignoreCase = true)
            }
            .collect(Collectors.toList())
    }

    override fun getByTourNameAndPaid(tourName: String, paid: Boolean): List<Tour> {
        reloadData()
        return tours.stream()
            .filter { tour ->
                (tour.tourName.equals(tourName, ignoreCase = true) && tour.paid == paid)
            }
            .collect(Collectors.toList())
    }
}