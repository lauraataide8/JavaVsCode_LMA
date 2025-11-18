package DAO;

import BD.DatabaseConnection;
import InterfaceCRUD.CRUD;
import Model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO implements CRUD<Contato> {

    // ----------------------------------------------------------------------
    // --- C R I A R --------------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean criar(Contato contato) {
        String sql = "INSERT INTO contato (id_usuario, telefone, celular, email, principal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, contato.getIdUsuario());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getCelular());
            pstmt.setString(4, contato.getEmail());
            pstmt.setBoolean(5, contato.isPrincipal()); // Usando o getter isPrincipal()

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        contato.setIdContato(rs.getInt(1));
                        return true;
                    }
                }
            }
            return false;

        } catch (SQLException e) {
            System.err.println("Erro ao salvar contato: " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   T O D O S ------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public List<Contato> buscartodos() {
        String sql = "SELECT id_contato, id_usuario, telefone, celular, email, principal FROM contato";
        List<Contato> contatos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Contato contato = new Contato(
                        rs.getInt("id_contato"),
                        rs.getInt("id_usuario"),
                        rs.getString("telefone"),
                        rs.getString("celular"),
                        rs.getString("email"),
                        rs.getBoolean("principal")
                );
                contatos.add(contato);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os contatos: " + e.getMessage());
        }
        return contatos;
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   P O R   U S U Á R I O (MÉTODO ESSENCIAL) -------------
    // ----------------------------------------------------------------------

    /**
     * Busca Contatos usando o ID do Usuário (Chave Estrangeira).
     * ESTE MÉTODO RESOLVE A CHAMADA CORRETA NO USUARIO CONTROLLER.
     */
    public List<Contato> buscarContatosPorUsuario(Integer idUsuario) { //
        String sql = "SELECT id_contato, id_usuario, telefone, celular, email, principal FROM contato WHERE id_usuario = ?";
        List<Contato> contatos = new ArrayList<>();

        if (idUsuario == null || idUsuario <= 0) {
            return contatos;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Contato contato = new Contato(
                            rs.getInt("id_contato"),
                            rs.getInt("id_usuario"),
                            rs.getString("telefone"),
                            rs.getString("celular"),
                            rs.getString("email"),
                            rs.getBoolean("principal")
                    );
                    contatos.add(contato);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar contatos por ID do usuário: " + e.getMessage());
        }
        return contatos;
    }


    // ----------------------------------------------------------------------
    // --- A T U A L I Z A R ------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean atualizar(Contato contato) {
        String sql = "UPDATE contato SET id_usuario = ?, telefone = ?, celular = ?, email = ?, principal = ? WHERE id_contato = ?";

        if (contato.getIdContato() == null || contato.getIdContato() <= 0) {
            System.err.println("ContatoDAO: Falha ao atualizar - ID do contato é inválido.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, contato.getIdUsuario());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getCelular());
            pstmt.setString(4, contato.getEmail());
            pstmt.setBoolean(5, contato.isPrincipal());

            // WHERE
            pstmt.setInt(6, contato.getIdContato());

            int linhasAfetadas = pstmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar contato com ID " + contato.getIdContato() + ": " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- D E L E T A R ----------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean deletar(Integer id) {
        String sql = "DELETE FROM contato WHERE id_contato = ?";

        if (id == null || id <= 0) {
            System.err.println("ContatoDAO: Falha ao deletar - ID inválido.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int linhasAfetadas = pstmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar contato com ID " + id + ": " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   P O R   C A M P O (CRUD) ---------------------------
    // ----------------------------------------------------------------------
    @Override
    public List<Contato> buscarPorCampo(String campo, String valor) {
        // Implementação completa deste método requer SQL dinâmico.
        System.out.println("Método 'buscarPorCampo' genérico não totalmente implementado para ContatoDAO.");
        return new ArrayList<>();
    }
}