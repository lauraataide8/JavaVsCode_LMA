package CalculadoraCientifica;

public class CalculoCientifico extends Calculo{
    public void raio (double a, double b) {
        numero_01 = a;
        numero_02 = b;
        total = numero_01 + numero_02;
        System.out.println(total);
    }
    public void area (double a, double b) {
        numero_01 = a;
        numero_02 = b;
        total = numero_01 - numero_02;
        System.out.println(total);
    }

}
