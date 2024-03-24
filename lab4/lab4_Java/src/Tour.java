import java.io.Serializable;

public class Tour implements Serializable {
    public static final long serialVersionUID = 1110111;
    private int id;
    private String surname;
    private String name;
    private String tourName;
    private int duration;
    private int price;
    private boolean paid;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String brand) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTourName() {
        return tourName;
    }
    public void sepTourName(String tourName) {
        this.tourName = tourName;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public boolean getPaid() {
        return paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    @Override
    public String toString() {
        String str = id + ") " + " Name: " + name + " Surname: " + surname
                + " Tour name: " + tourName + " Duration: " + duration +
                " Price: " + price + " Paid: ";
        if (paid){
            str += "Так";
        } else{
            str += "Ні";
        }
        return str;
    }
    public Tour() {
    }
    public Tour(String surname, String name, String tourName, int duration, int price, boolean paid) {
        this.id = 0;
        this.surname = surname;
        this.name = name;
        this.tourName = tourName;
        this.duration = duration;
        this.price = price;
        this.paid = paid;
    }
    public Tour(int id, String surname, String name, String tourName, int duration, int price, boolean paid) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.tourName = tourName;
        this.duration = duration;
        this.price = price;
        this.paid = paid;
    }
}