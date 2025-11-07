public class Comentarios {
    // Criando o metodo Main, esse comentario nao aparece para o usuário
    public static void main(String [] args) {
        /*
        public refere-se a visibilidade do método.
        static refere-se a propriedade da classe.
        void refere-se ao método não retornar nenhum valor.
        main refere-se ao nome do método de execução de toda a aplicação.
        String[]args é o vetor de string do java.
        */
        System.out.println("Testando comentários");
        System.out.print("Testando opçao de print sem ln");
        /* Diferenças entre println e print:
        println - pula para a próxima linha
        print- mantém todo o textot na mesma linha.*/

        System.out.println("\n1º linha \n2º linha \n3º linha");
        System.out.println("\n1º linha \tnome  \tendedeço"+
        "\n2º linha \tnome \tendedeço \ttelefone"+
        "\n3º linha  \tendedeço \ttelefone ");
    }

    
}