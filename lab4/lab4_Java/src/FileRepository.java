import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class FileRepository implements Repository{
    private String fileName;
    private List<Tour> tours;
    public FileRepository(String fileName) {
        this.tours = new ArrayList<>();
        this.fileName = fileName;
        if ((new File(fileName)).exists()){
            this.reloadData();
        }
    }
    @Override
    public List<Tour> getAll() {
        reloadData();
        return tours;
    }
    private void reloadData() {
        if ((new File(fileName)).exists()) {
            try (FileInputStream fileInputStream =
                         new FileInputStream(fileName)) {
                try (ObjectInputStream objectInputStream =
                             new ObjectInputStream(fileInputStream)) {
                    tours = (List<Tour>) objectInputStream
                            .readObject();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public Tour getById(int id) {
        reloadData();
        Optional<Tour> foundTour = this.tours.stream()
                .filter(new Predicate<Tour>() {
                    @Override
                    public boolean test(Tour tour) {
                        return tour.getId()==id;
                    }
                })
                .findFirst();
        Tour tour = null;
        if(foundTour.isPresent()){
            tour = foundTour.get();
        }
        return tour;
    }
    @Override
    public boolean addTour(Tour tour) {
        int id = 0;
        reloadData();
        if(this.tours.size()>0) {
            OptionalInt maxId = this.tours.stream()
                    .mapToInt(t -> t.getId()).max();
            if (maxId != null) {
                id = maxId.getAsInt();
            }
        }
        tour.setId(id+1);
        tours.add(tour);
        try {
            save();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    private void save() throws IOException {
        try(FileOutputStream fileOutputStream =
                    new FileOutputStream(fileName)){
            try(ObjectOutputStream objectOutputStream =
                        new ObjectOutputStream(fileOutputStream)){
                objectOutputStream.writeObject(this.tours);
            }
        }
    }
    @Override
    public boolean deleteTour(int id) {
        reloadData();
        Optional<Tour> foundTour = tours.stream().filter(t->t.getId()==id).findFirst();
        if(foundTour.isPresent()){
            Tour tour = foundTour.get();
            tours.remove(tour);
            try {
                save();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
    @Override
    public List<Tour> getByTourName(String tourName) {
        reloadData();
        List<Tour> result = tours.stream()
                .filter(new Predicate<Tour>() {
                    @Override
                    public boolean test(Tour tour) {
                        return tour.getTourName().equalsIgnoreCase(tourName);
                    }
                })
                .collect(Collectors.toList());
        return result;
    }
    @Override
    public List<Tour> getByTourNameAndPaid(String tourName, boolean paid) {
        reloadData();
        List<Tour> result = tours.stream()
                .filter(new Predicate<Tour>() {
                    @Override
                    public boolean test(Tour tour) {
                        return tour.getTourName().equalsIgnoreCase(tourName)
                                && tour.getPaid() == paid;
                    }
                })
                .collect(Collectors.toList());
        return result;
    }
}