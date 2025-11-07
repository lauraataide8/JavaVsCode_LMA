package ClassesAtributos;

public class Crianca {

    public static void main(String[] args) {
        ClassesAtributos.Pessoa bebe = new ClassesAtributos.Pessoa();

        bebe.nome = "Robson";
        bebe.idade = 2;
        bebe.genero = "Masculino";
        bebe.nascionalidade = "Brasileiro";
        bebe.etnia = "Preta";
        bebe.altura= 0.60;

        System.out.println("Nome: "+bebe.nome);

        ClassesAtributos.Pessoa crianca = new ClassesAtributos.Pessoa();
        crianca.nome = "Josefina";
        crianca.acordado = "Não";
        System.out.println ("Nome: "+crianca.nome);
        crianca.falar();

    }

}