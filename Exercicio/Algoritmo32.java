
import java.util.Scanner;

public class algoritmo_33 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int num1;
        int num2;

        System.out.print("Digite o PRIMEIRO número inteiro: ");
        num1 = leitor.nextInt();
        System.out.print("Digite o SEGUNDO número inteiro: ");
        num2 = leitor.nextInt();

        System.out.println("--- Resultados ---");
        System.out.println("O primeiro número : " + num1);
        System.out.println("O segundo número : " + num2);
    }
}
