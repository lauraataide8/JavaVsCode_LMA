package JBCDSimples;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class Main {

    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO(); // Nota: JBCDSimples.ProdutoDAO não é necessário

        // --- Item 1: Inserir um novo produto (opcional) ---
        // (Você pode comentar este bloco se não quiser inserir um novo
        // produto toda vez que rodar o programa)
        System.out.println("Inserindo novo produto...");
        Produto novoProduto = new Produto();
        novoProduto.setNome("Mouse Gamer");
        novoProduto.setCategoria("Periféricos");
        novoProduto.setPreco(new BigDecimal("250.00"));
        novoProduto.setDataCadastro(LocalDate.now());
        dao.inserir(novoProduto);

        // --- Item 2: Listar todos os produtos (para vermos os IDs) ---
        System.out.println("Listando produtos...");
        List<Produto> listaDeProdutos = dao.listarTodos();
        exibirListaEmDialogo(listaDeProdutos, "Produtos Atuais");


        // --- NOVO: Bloco para Excluir um Produto ---
        System.out.println("Iniciando exclusão...");
        try {
            // 1. Pede ao usuário o ID
            String idInput = JOptionPane.showInputDialog(
                    "Qual ID de produto você deseja excluir?\n(Deixe em branco para cancelar)"
            );

            // 2. Verifica se o usuário clicou em "cancelar" ou não digitou nada
            if (idInput != null && !idInput.trim().isEmpty()) {

                int idParaExcluir = Integer.parseInt(idInput); // Converte o texto para número

                // 3. CHAMA O MÉTODO DO DAO
                dao.excluir(idParaExcluir);

                // 4. Mostra a lista atualizada
                System.out.println("Listando produtos após exclusão...");
                List<Produto> listaAtualizada = dao.listarTodos();
                exibirListaEmDialogo(listaAtualizada, "Lista Atualizada");
            } else {
                JOptionPane.showMessageDialog(null, "Exclusão cancelada.");
            }

        } catch (NumberFormatException e) {
            // Isso acontece se o usuário digitar "abc" em vez de um número
            JOptionPane.showMessageDialog(null, "Erro: Você deve digitar um número de ID válido.");
        }

        System.exit(0);
    }

    /**
     * Método de ajuda para exibir a lista (para não repetir código)
     */
    public static void exibirListaEmDialogo(List<Produto> lista, String titulo) {
        StringBuilder sb = new StringBuilder("=== " + titulo + " ===\n\n");
        if (lista.isEmpty()) {
            sb.append("Nenhum produto cadastrado.");
        } else {
            for (Produto p : lista) {
                sb.append(p.toString());
            }
        }

        JTextArea textArea = new JTextArea(20, 40);
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 400));

        JOptionPane.showMessageDialog(
                null,
                scrollPane,
                titulo,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}