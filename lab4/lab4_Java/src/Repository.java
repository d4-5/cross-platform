import java.util.List;

public interface Repository {
    List<Tour> getAll();
    Tour getById(int id);
    boolean addTour(Tour tour);
    boolean deleteTour(int id);
    List<Tour> getByTourName(String tourName);
    List<Tour> getByTourNameAndPaid(String tourName, boolean paid);
}