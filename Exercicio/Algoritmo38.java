import java.util.Scanner;

public class Algoritmo38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número real (ex: 10,0): ");
        double numero = scanner.nextDouble(); // nextDouble() lê números com vírgula

        double tercaParte = numero / 3.0;
        System.out.println("A terça parte é: " + tercaParte);

    }
}