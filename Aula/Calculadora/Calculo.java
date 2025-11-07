package Calculadora;

public class Calculo {
    double numero_01;
    double numero_02;
    double total;

    // classe sem o main= Classe Model
    public void somar(double a, double b) {
        numero_01 = a;
        numero_02 = b;

        total = numero_01 + numero_02;
        System.out.println("total:" + total);

    }

    public void subtrair(double a, double b) {
        numero_01 = a;
        numero_02 = b;

        total = numero_01 + numero_02;
        System.out.println("total:" + total);
    }
}

