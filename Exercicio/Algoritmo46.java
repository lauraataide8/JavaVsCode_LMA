import java.util.Scanner;

public class Algoritmo46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o saldo da aplicação (ex: 1000,00): ");
        double saldo = scanner.nextDouble();

        double novoSaldo = saldo * 1.01;

        System.out.println("O novo saldo com reajuste de 1% é: " + novoSaldo);

    }
}