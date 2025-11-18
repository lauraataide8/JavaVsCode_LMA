package View;

import DAO.UsuarioDAO;
import Model.Usuario;
import java.time.LocalDate;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import BD.DatabaseConnection; // Adicionado para o teste direto

public class Main {

    public static void main(String[] args) {

        System.out.println(">>> Iniciando o programa Agenda <<<");
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // --- 1. Teste de Criação (Revisado) ---
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("Fulano de Teste");
        novoUsuario.setGenero("Masculino");
        novoUsuario.setDataNascimento(LocalDate.of(1990, 5, 20));
        novoUsuario.setNacionalidade("Brasileiro");

        System.out.println("\n--- Teste 1: Criar Usuário ---");
        if (usuarioDAO.criar(novoUsuario)) {
            System.out.println("SUCESSO: Usuario criado! ID: " + novoUsuario.getIdUsuario());
        } else {
            System.out.println("FALHA: Não foi possível criar o usuário.");
        }

        // --- 2. Teste de Listagem (Busca Todos) ---
        System.out.println("\n--- Teste 2: Buscar Todos ---");
        List<Usuario> usuarios = usuarioDAO.buscartodos();
        if (!usuarios.isEmpty()) {
            System.out.println("SUCESSO: Usuários encontrados (" + usuarios.size() + "):");
            for (Usuario u : usuarios) {
                System.out.println("  " + u);
            }
        } else {
            System.out.println("AVISO: Nenhuma usuário encontrado no banco.");
        }

        // --- 3. Teste Direto de Conexão Estática ---
        // Aqui demonstramos o uso direto do método estático e o fechamento automático.
        System.out.println("\n--- Teste 3: Conexão Direta ---");
        try (Connection conn = DatabaseConnection.getConnection()) {
            // A linha acima chama o método estático e, se for bem-sucedido:
            if (conn != null && !conn.isClosed()) {
                System.out.println("SUCESSO: Conexão estática estabelecida e ativa.");
            } else {
                System.out.println("FALHA: Conexão estática retornou nula ou fechada.");
            }
        } catch (SQLException e) {
            System.err.println("ERRO: Falha ao obter conexão estática ou ao fechar. Mensagem: " + e.getMessage());
        }
        // Ao sair do bloco try-with-resources, conn.close() é chamado automaticamente.


        System.out.println("\n>>> Fim do programa Agenda <<<");
    }
}