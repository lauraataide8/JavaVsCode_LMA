import  java.util.Scanner;
public class InputDados_02 {

    public static void main(String[] args) {
        int nun01;
        int nun02;
        int total;

        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um número:");
        nun01 = ler.nextInt();
        System.out.println("Digite um segundo número:");
        nun02 = ler.nextInt();


        total = nun01+nun02;
        System.out.println("total:"+total);
    }
}