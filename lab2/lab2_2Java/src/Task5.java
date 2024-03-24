import java.util.Scanner;
import java.lang.Math;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть число a: ");
        int a = scanner.nextInt();

        System.out.print("Введіть число b: ");
        int b = scanner.nextInt();

        System.out.print("Введіть число c: ");
        int c = scanner.nextInt();

        System.out.printf("x^2/(%d*x + %d) < %d \n", a, b, c);

        if (a == 0 && b == 0){
            System.out.println("Розв'язків немає");
        }
        else{
            int A = 1;
            int B = -c*a;
            int C = -c*b;
            int D = B*B - 4*A*C;

            if (D > 0) {
                double x1 = (-B + Math.sqrt(D)) / (2 * A);
                double x2 = (-B - Math.sqrt(D)) / (2 * A);
                if (a != 0 && (x1 == (double) -b /a || x2 == (double) -b /a)){
                    System.out.println("Розв'язків немає");
                } else{
                    System.out.printf("x Є (%.2f ; %.2f)", x2, x1);
                }
            }
            else{
                System.out.println("Розв'язків немає");
            }
        }
    }
}