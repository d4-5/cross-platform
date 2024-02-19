import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть трицифрове ціле число: ");
        int n = scanner.nextInt();

        int a = n / 100;
        int b = n/10 - a*10;

        n = n - a*100 + a*10 - b*10 + b*100;

        System.out.println("Число після перестановки: " + n);
    }
}
