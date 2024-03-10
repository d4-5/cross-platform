import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x, u, s = 1, eps = 0.00001;
        System.out.println("Введіть значення x");
        x = scanner.nextDouble();
        u = x*x;
        int n = 1;
        while(Math.abs(u)>eps) {
            s -= u; u *= -4*x*x/((2*n+1)*(2*n+2));
            n++;
        }
        System.out.printf("Значення суми s = %.6f\n", s);
        System.out.printf("Значення функції: %.6f\n", Math.pow(Math.cos(x),2));
        System.out.println("Кількість доданків " + n);

    }
}