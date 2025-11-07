import java.util.Scanner;

public class Algoritmo41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a nota 1 (peso 1): ");
        double n1 = scanner.nextDouble();
        System.out.print("Digite a nota 2 (peso 2): ");
        double n2 = scanner.nextDouble();
        System.out.print("Digite a nota 3 (peso 3): ");
        double n3 = scanner.nextDouble();
        System.out.print("Digite a nota 4 (peso 4): ");
        double n4 = scanner.nextDouble();

        double somaValoresPesos = (n1 * 1) + (n2 * 2) + (n3 * 3) + (n4 * 4);
        double somaPesos = 1 + 2 + 3 + 4;

        double mediaPonderada = somaValoresPesos / somaPesos;

        System.out.println("A média ponderada é: " + mediaPonderada);

    }
}