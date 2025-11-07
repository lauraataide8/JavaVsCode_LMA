import java.util.Scanner;

public class Algoritmo48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do salário mínimo (ex: 1400,00): ");
        double salarioMinimo = scanner.nextDouble();

        System.out.print("Digite a quantidade de quilowatts (kW) gasta: ");
        double qtdQuilowatts = scanner.nextDouble();

        // Calcula o valor de 1 kW
        double custoDe100Kw = salarioMinimo / 7.0;
        double valorPorQuilowatt = custoDe100Kw / 100.0;

        // Calcula o valor total a pagar
        double valorAPagar = valorPorQuilowatt * qtdQuilowatts;

        // Calcula o valor com 10% de desconto (multiplica por 0.90)
        double valorComDesconto = valorAPagar * 0.90;

        System.out.println("Valor por quilowatt: R$ " + valorPorQuilowatt);
        System.out.println("Valor a ser pago: R$ " + valorAPagar);
        System.out.println("Valor com 10% de desconto: R$ " + valorComDesconto);

    }
}