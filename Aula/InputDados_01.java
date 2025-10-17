
import javax.swing.JOptionPane;

public class InputDados_01{

    public static void main(String[] args) {
        int nun01;
        int nun02;
        String aux;
        int total;

        aux = JOptionPane.showInputDialog("Digite um número1");
        nun01 = Integer.parseInt(aux);
        nun02 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número2"));

        total=nun01+nun02;
        JOptionPane.showMessageDialog(null, "total: "+total);
    }
}