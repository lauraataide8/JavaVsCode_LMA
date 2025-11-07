import java.util.Scanner;

public class Algoritmo40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dividendo (inteiro): ");
        int dividendo = scanner.nextInt();

        System.out.print("Digite o divisor (inteiro): ");
        int divisor = scanner.nextInt();

        int quociente = dividendo / divisor; // Pega a parte inteira
        int resto = dividendo % divisor;     // Pega o resto

        System.out.println("Dividendo: " + dividendo);
        System.out.println("Divisor: " + divisor);
        System.out.println("Quociente: " + quociente);
        System.out.println("Resto: " + resto);

    }
}