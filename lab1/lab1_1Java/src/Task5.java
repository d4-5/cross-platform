import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть довжину сторони a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть довжину сторони b: ");
        double b = scanner.nextDouble();

        double S = a * b;
        double P = 2 * (a + b);

        System.out.println("Площа прямокутника: " + S);
        System.out.println("Периметр прямокутника: " + P);
    }
}
