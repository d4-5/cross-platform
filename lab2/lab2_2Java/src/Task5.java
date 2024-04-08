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

            if(a == 0 && b != 0 && D > 0){
                double x1 = (-B + Math.sqrt(D)) / (2 * A);
                double x2 = (-B - Math.sqrt(D)) / (2 * A);
                System.out.printf("x Є (-∞ ; %.2f) and (%.2f ; ∞)", Math.min(x2, x1), Math.max(x2,x1));
            } else if (a != 0 && b == 0 && D > 0) {
                double x1 = (-B + Math.sqrt(D)) / (2 * A);
                double x2 = (-B - Math.sqrt(D)) / (2 * A);
                if (a > 0){
                    System.out.printf("x Є (-∞ ; %.2f)", Math.min(x2, x1));
                } else {
                    System.out.printf("x Є (%.2f ; ∞)", Math.max(x2, x1));
                }
            } else if (a != 0 && b != 0 && D > 0) {
                double x1 = (-B + Math.sqrt(D)) / (2 * A);
                double x2 = (-B - Math.sqrt(D)) / (2 * A);
                double x3 = (double) -b /a;
                double smallest, middle, largest;

                if (x1 <= x2 && x1 <= x3) {
                    smallest = x1;
                } else if (x2 <= x1 && x2 <= x3) {
                    smallest = x2;
                } else {
                    smallest = x3;
                }

                if (x1 >= x2 && x1 >= x3) {
                    largest = x1;
                } else if (x2 >= x1 && x2 >= x3) {
                    largest = x2;
                } else {
                    largest = x3;
                }

                middle = (x1 + x2 + x3) - smallest - largest;

                if (a > 0){
                    System.out.printf("x Є (-∞ ; %.2f) and (%.2f ; %.2f)", smallest, middle, largest);
                } else {
                    System.out.printf("x Є (%.2f ; %.2f) and (%.2f ; ∞)", smallest, middle, largest);
                }
            } else {
                System.out.println("Розв'язків немає");
            }
        }
    }
}