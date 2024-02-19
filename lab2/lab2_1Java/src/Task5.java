import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число A: ");
        int A = scanner.nextInt();

        System.out.print("Введіть число B: ");
        int B = scanner.nextInt();

        if (A % 2 == 0 && B % 2 == 0) {
            A /= 2;
            B /= 2;
        } else if (A % 2 != 0 && B % 2 != 0) {
            A = (A + B) / 2;
            B = A;
        }

        System.out.println("Нове значення A: " + A);
        System.out.println("Нове значення B: " + B);
    }
}
