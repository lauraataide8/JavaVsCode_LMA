import java.util.Scanner;

public class Algoritmo34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();

        int antecessor = numero - 1;
        int sucessor = numero + 1;

        System.out.println("O antecessor é: " + antecessor);
        System.out.println("O sucessor é: " + sucessor);

         }
}