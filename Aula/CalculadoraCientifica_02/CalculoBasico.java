package CalculadoraCientifica_02;

public class CalculoBasico extends Calculo{

    public double numero_01;
    public double numero_02;

    public void somar(double a, double b) {
        numero_01 = a;
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