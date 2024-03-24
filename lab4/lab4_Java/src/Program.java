import java.util.List;
import java.util.Scanner;
public class Program {
    private static Repository repository;
    public static void main(String[] args) {
        repository = new FileRepository("tours.dat");
        List<Tour> tours;
        Scanner input = new Scanner(System.in);
        int choice;
        String tourName;
        Tour tour;

        while (true) {
            System.out.println("Оберіть потрібну дію:");
            System.out.println("1 - переглянути всі записи");
            System.out.println("2 - додати запис");
            System.out.println("3 - видалити запис");
            System.out.println("4 - шукати клієнтів за назвою туру");
            System.out.println("5 - шукати клієнтів за назвою туру і оплатою");
            System.out.println("0 - завершити роботу програми");
            choice = Integer.parseInt(input.nextLine());

            if(choice == 0) break;
            switch(choice){
                case 1:
                    tours = repository.getAll();
                    for (Tour t: tours){
                        System.out.println(t);
                    }
                    break;
                case 2:
                    tour = inputNewTour();
                    repository.addTour(tour);
                    break;
                case 3:
                    System.out.println("Вкажіть id запису");
                    int id = Integer.parseInt(input.nextLine());
                    tour = repository.getById(id);
                    if(tour == null){
                        System.out.println("Запису з таким id немає");
                    }
                    else{
                        if(repository.deleteTour(id)){
                            System.out.println("Дані успішно вилучено");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Задайте назву туру:");
                    tourName = input.nextLine();
                    tours = repository.getByTourName(tourName);
                    int sum = 0;
                    for (Tour t: tours){
                        System.out.println(t);
                        sum += t.getPrice();
                    }
                    System.out.println("Кількість знайдених записів: " + tours.size());
                    System.out.println("Виручка від продажів: " + sum);
                    break;
                case 5:
                    System.out.println("Задайте назву туру:");
                    tourName = input.nextLine();
                    boolean paid = inputPaid();
                    tours = repository.getByTourNameAndPaid(tourName, paid);
                    tours.stream().forEach(System.out::println);
                    break;
            }
        }
    }
    private static Tour inputNewTour() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть дані.");
        System.out.println("Прізвище:");
        String surname = scanner.nextLine();
        System.out.println("Ім\'я:");
        String name = scanner.nextLine();
        System.out.println("Назва туру:");
        String tourName = scanner.nextLine();
        System.out.println("Тривалість:");
        int duration = scanner.nextInt();
        System.out.println("Ціна:");
        int price = scanner.nextInt();
        boolean paid = inputPaid();
        return new Tour(surname, name, tourName, duration, price, paid);
    }

    private static boolean inputPaid(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Чи внесли клієнти кошти на оплату(Так/Ні):");
            String paid = scanner.nextLine();
            if (paid.equals("Так")){
                return true;
            }
            else if (paid.equals("Ні")){
                return false;
            }
        }
    }
}