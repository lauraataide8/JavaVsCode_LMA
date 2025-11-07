import java.util.Scanner;

public class Algoritmo47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro de 3 dígitos (ex: 123): ");
        int numeroCDU = scanner.nextInt(); // ex: 123

        // Pega a centena (C)
        int centena = numeroCDU / 100;     // 123 / 100 = 1

        // Pega o resto
        int resto1 = numeroCDU % 100;      // 123 % 100 = 23

        // Pega a dezena (D)
        int dezena = resto1 / 10;          // 23 / 10 = 2

        // Pega a unidade (U)
        int unidade = numeroCDU % 10;      // 123 % 10 = 3

        // Monta o número invertido UDC
        int numeroUDC = (unidade * 100) + (dezena * 10) + centena;

        System.out.println("Número original (CDU): " + numeroCDU);
        System.out.println("Número invertido (UDC): " + numeroUDC);
    }
}