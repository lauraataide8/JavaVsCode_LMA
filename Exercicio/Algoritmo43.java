import java.util.Scanner;
import java.lang.Math;

public class Algoritmo43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número para calcular o log na base 10: ");
        double num = scanner.nextDouble();

        double log10 = Math.log10(num);
        System.out.println("O logaritmo na base 10 é: " + log10);

    }
}