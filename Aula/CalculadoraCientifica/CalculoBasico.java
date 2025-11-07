package CalculadoraCientifica;

public class CalculoBasico  extends Calculo {
    public void somar(double a, double b) {
        double numero_01 = a;
        numero_02 = b;
        double total = numero_01 + numero_02;
        System.out.println(total);
    }

    public void subtrair(double a, double b) {
        numero_01 = a;
        numero_02 = b;
        total = numero_01 - numero_02;
        System.out.println(total);
    }

    public void multiplicar(double a, double b) {
        numero_01 = a;
        numero_02 = b;
        total = numero_01 * numero_02;
        System.out.println(total);
    }

    public void dividir(double a, double b) {
        numero_01 = a;
        numero_02 = b;
        total = numero_01 / numero_02;
        System.out.println(total);
    }
}