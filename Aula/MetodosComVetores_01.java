public class MetodosComVetores_01 {

    public static void main(String[] args) {
        // 1. O vetor de números que você quer somar
        int[] numeros = {2, 3, 4, 5};

        // 2. Chama o método 'somar' e guarda o resultado
        int resultadoSoma = somar(numeros);

        // 3. Imprime o resultado da soma
        System.out.println("A soma dos elementos é: " + resultadoSoma);
    }

    /**
     * Este método calcula a soma e a média de um vetor de inteiros.
     * Imprime a média e retorna o valor da soma.
     */
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

        // 3. Retorna a soma para o 'main'
        return soma;
    }

}