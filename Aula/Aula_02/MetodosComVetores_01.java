public class MetodosComVetores_01 {

    public static int somar(int[] vetor) {
        int soma = 0;

        // 1. Calcula a soma total primeiro
        for (int i = 0; i < vetor.length; i++) {
            soma = soma + vetor[i];
        }

        // 2. Calcula a média DEPOIS do loop, com a correção
        double media = (double) soma / vetor.length;

        // Agora sim, imprime o valor correto
        System.out.println("A média é: " + media);

        return soma;
    }
}