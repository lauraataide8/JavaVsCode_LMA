import java.util.Scanner;
import java.lang.Math;

public class Algoritmo44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número (logaritmando): ");
        double num = scanner.nextDouble();

        System.out.print("Digite a base do logaritmo: ");
        double base = scanner.nextDouble();

        // Fórmula de mudança de base
        double logResultado = Math.log(num) / Math.log(base);

        System.out.println("O logaritmo de " + num + " na base " + base + " é: " + logResultado);

    }
}