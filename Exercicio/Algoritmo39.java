import java.util.Scanner;

public class Algoritmo39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número real: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o segundo número real: ");
        double num2 = scanner.nextDouble();

        double media = (num1 + num2) / 2.0;
        System.out.println("Média: " + media);

    }
}