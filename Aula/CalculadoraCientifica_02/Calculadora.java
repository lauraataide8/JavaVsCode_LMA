package CalculadoraCientifica_02;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        CalculadoraCientifica_02.CalculoBasico calculo = new CalculoBasico();

        try (Scanner ler = new Scanner(System.in)) {

            System.out.println("digite um número");
            calculo.numero_01 = ler.nextDouble();

            System.out.println("digite um número");
            calculo.numero_02 = ler.nextDouble();
        }

        calculo.somar(calculo.numero_01, calculo.numero_02);
        calculo.subtrair(calculo.numero_01, calculo.numero_02);
        calculo.multiplicar(calculo.numero_01, calculo.numero_02);
        calculo.dividir(calculo.numero_01, calculo.numero_02);

    }
}
