package ClassesAtributos;

public class Pessoa {
    //o que tenho (atributos)
    String nome;
    String genero;
    int idade;
    double altura;
    String etnia;
    String nascionalidade;
    String acordado;

    //o que faço (métodos)
    public String falar() {
        if (acordado.equals("sim")) {
            System.out.println("Eu posso falar");
        }else {
            System.out.println("não posso falar");
        }
        return null;
    }
    public String dormir() {
        return null;

    }
}
