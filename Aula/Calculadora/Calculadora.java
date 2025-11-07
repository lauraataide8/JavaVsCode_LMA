package Calculadora;

import java.util.Scanner;

public class Calculadora {
    public static void main (String[] args) {
        Calculo calc = new Calculo(); // instanciando da classe calculo.
        Scanner ler = new Scanner(System.in); // instancia da classe scanner, importando os valores.

        System.out.println("digite um numero: ");
        calc.numero_01 = ler.nextDouble();
        System.out.println("digite outro numero: "); // Mudei aqui para "outro numero"
        calc.numero_02 = ler.nextDouble();

        System.out.println("\n--- Escolha a Operação ---");
        System.out.println("1: Somar");
        System.out.println("2: Subtrair");
        System.out.print("Digite sua opção: "); // Usei print para o cursor ficar ao lado


        int opcao = ler.nextInt();

        //Usar 'switch' para decidir o que fazer
        switch (opcao) {
            case 1:
                // Chama APENAS a soma
                System.out.print("O resultado da soma é: "); // Adicionando contexto
                calc.somar(calc.numero_01, calc.numero_02);
                break; // 'break' é essencial para sair do switch

            case 2:
                // Chama APENAS a subtração
                System.out.print("O resultado da subtração é: "); // Adicionando contexto
                calc.subtrair(calc.numero_01, calc.numero_02);
                break;

            default:
                // Caso o usuário digite algo diferente de 1 ou 2
                System.out.println("Opção inválida!");
                break;


        }

    }
}