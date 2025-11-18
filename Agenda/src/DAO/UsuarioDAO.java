package DAO;

import BD.DatabaseConnection;
import InterfaceCRUD.CRUD;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class UsuarioDAO implements CRUD<Usuario> {

    // ----------------------------------------------------------------------
    // --- C R I A R --------------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean criar(Usuario usuario) {
        // Usando 'data_nascimento' no SQL (snake_case para MySQL)
        String sql = "INSERT INTO usuario (nome, genero, data_nascimento, nacionalidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getGenero());
            pstmt.setDate(3, java.sql.Date.valueOf(usuario.getDataNascimento()));
            pstmt.setString(4, usuario.getNacionalidade());

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGerado = rs.getInt(1);
                        usuario.setIdUsuario(idGerado);
                        return true;
                    }
                }
            }
            return false;

        } catch (SQLException e) {
            System.err.println("Erro ao salvar usuario: " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   T O D O S ------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public List<Usuario> buscartodos() {
        // CORRIGIDO: Usando 'id_usuario' no SQL para resolver o erro 'Unknown column'
        String sql = "SELECT id_usuario, nome, genero, data_nascimento, nacionalidade FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        // Lendo 'id_usuario' e 'data_nascimento' do ResultSet
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("nacionalidade")
                );
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os usuários: " + e.getMessage());
        }
        return usuarios;
    }

    // ----------------------------------------------------------------------
    // --- A T U A L I Z A R ------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean atualizar(Usuario usuario) {
        // Usando 'data_nascimento' e 'id_usuario' no SQL
        String sql = "UPDATE usuario SET nome = ?, genero = ?, data_nascimento = ?, nacionalidade = ? WHERE id_usuario = ?";

        if (usuario.getIdUsuario() == null || usuario.getIdUsuario() <= 0) {
            System.err.println("UsuarioDAO: Falha ao atualizar - ID do usuário é inválido.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getGenero());
            pstmt.setDate(3, Date.valueOf(usuario.getDataNascimento()));
            pstmt.setString(4, usuario.getNacionalidade());

            // WHERE
            pstmt.setInt(5, usuario.getIdUsuario());

            int linhasAfetadas = pstmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário com ID " + usuario.getIdUsuario() + ": " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- D E L E T A R ----------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean deletar(Integer id) {
        // Usando 'id_usuario' no SQL
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        if (id == null || id <= 0) {
            System.err.println("UsuarioDAO: Falha ao deletar - ID inválido.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int linhasAfetadas = pstmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar usuário com ID " + id + ": " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   P O R   I D (Método auxiliar para Controller) -------
    // ----------------------------------------------------------------------

    /** * Implementação do método que o Controller estava tentando chamar (buscarPorId).
     * Garante compatibilidade com o Controller.
     */
    public Usuario buscarPorId(Integer id) {
        // Delega para o método auxiliar mais específico.
        return buscarUsuarioPorId(id);
    }

    /** * Método auxiliar detalhado para buscar por ID.
     */
    public Usuario buscarUsuarioPorId(Integer id) {
        // Usando 'id_usuario' no SQL
        String sql = "SELECT id_usuario, nome, genero, data_nascimento, nacionalidade FROM usuario WHERE id_usuario = ?";
        Usuario usuario = null;

        if (id == null || id <= 0) {
            return null;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            // Lendo 'id_usuario' e 'data_nascimento' do ResultSet
                            rs.getInt("id_usuario"),
                            rs.getString("nome"),
                            rs.getString("genero"),
                            rs.getDate("data_nascimento").toLocalDate(),
                            rs.getString("nacionalidade")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por ID " + id + ": " + e.getMessage());
        }
        return usuario;
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   P O R   C A M P O (CRUD) ---------------------------
    // ----------------------------------------------------------------------
    @Override
    public List<Usuario> buscarPorCampo(String campo, String valor) {
        // A implementação completa deste método requer SQL dinâmico.
        System.out.println("Método 'buscarPorCampo' genérico não totalmente implementado.");
        return new ArrayList<>();
    }
}