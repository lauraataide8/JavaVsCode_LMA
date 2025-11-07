import java.util.Scanner;
import java.lang.Math; // Importa a classe de matemática

public class Algoritmo42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ângulo em graus: ");
        double anguloGraus = scanner.nextDouble();

        // Converte graus para radianos, pois o Math.sin/cos usa radianos
        double anguloRadianos = Math.toRadians(anguloGraus);

        double seno = Math.sin(anguloRadianos);
        double coseno = Math.cos(anguloRadianos);
        double tangente = Math.tan(anguloRadianos);
        double secante = 1 / coseno;
        double cossecante = 1 / seno;
        double cotangente = 1 / tangente;

        System.out.println("Seno: " + seno);
        System.out.println("Coseno: " + coseno);
        System.out.println("Tangente: " + tangente);
        System.out.println("Secante: " + secante);
        System.out.println("Cossecante: " + cossecante);
        System.out.println("Cotangente: " + cotangente);

            }
}