import java.util.Scanner;

public class MetodosComVetores_02 {

    public static void main(String[] args) {

        // 1. Crie o Scanner primeiro
        Scanner ler = new Scanner(System.in);

        // 2. Pergunte o tamanho
        System.out.println("digite a quantidade de notas:");
        int n = ler.nextInt();

        // 3. AGORA crie o vetor, usando o 'n' que o usuário digitou
        double [] notas = new double[n];

        // 4. Agora o loop vai funcionar
        for (int i = 0; i < notas.length; i++) {
            System.out.print("digite a nota " + (i+1) + ": ");
            notas[i] = ler.nextDouble();
        }

        // (Opcional) Mostre as notas que foram digitadas
        System.out.println("Notas digitadas:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println(notas[i]);
        }
    }
}