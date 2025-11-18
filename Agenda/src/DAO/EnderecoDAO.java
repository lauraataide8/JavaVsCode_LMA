package DAO;

import BD.DatabaseConnection; // Assumindo esta classe
import InterfaceCRUD.CRUD;
import Model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO implements CRUD<Endereco> {

    // ----------------------------------------------------------------------
    // --- C R I A R --------------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean criar(Endereco endereco) {
        // Usando 'id_usuario' no SQL (Chave estrangeira)
        String sql = "INSERT INTO endereco (id_usuario, logradouro, numero, complemento, bairro, cidade, uf, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, endereco.getIdUsuario());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setString(6, endereco.getCidade());
            pstmt.setString(7, endereco.getUf());
            pstmt.setString(8, endereco.getCep());

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        endereco.setIdEndereco(rs.getInt(1));
                        return true;
                    }
                }
            }
            return false;

        } catch (SQLException e) {
            System.err.println("Erro ao salvar endereço: " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   T O D O S ------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public List<Endereco> buscartodos() {
        String sql = "SELECT id_endereco, id_usuario, logradouro, numero, complemento, bairro, cidade, uf, cep FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Endereco endereco = new Endereco(
                        rs.getInt("id_endereco"),
                        rs.getInt("id_usuario"),
                        rs.getString("logradouro"),
                        rs.getString("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("cep")
                );
                enderecos.add(endereco);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar todos os endereços: " + e.getMessage());
        }
        return enderecos;
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   P O R   U S U Á R I O (MÉTODO ESSENCIAL) -------------
    // ----------------------------------------------------------------------

    /**
     * Busca um Endereço usando o ID do Usuário (Chave Estrangeira).
     * ESTE MÉTODO RESOLVE O ERRO 'cannot find symbol' no UsuarioController.
     */
    public Endereco buscarEnderecoPorUsuario(Integer idUsuario) {
        String sql = "SELECT id_endereco, id_usuario, logradouro, numero, complemento, bairro, cidade, uf, cep FROM endereco WHERE id_usuario = ?";
        Endereco endereco = null;

        if (idUsuario == null || idUsuario <= 0) {
            return null;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idUsuario);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    endereco = new Endereco(
                            rs.getInt("id_endereco"),
                            rs.getInt("id_usuario"),
                            rs.getString("logradouro"),
                            rs.getString("numero"),
                            rs.getString("complemento"),
                            rs.getString("bairro"),
                            rs.getString("cidade"),
                            rs.getString("uf"),
                            rs.getString("cep")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar endereço por ID do usuário: " + e.getMessage());
        }
        return endereco;
    }


    // ----------------------------------------------------------------------
    // --- A T U A L I Z A R ------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean atualizar(Endereco endereco) {
        // Usando 'id_usuario' e 'id_endereco' no SQL
        String sql = "UPDATE endereco SET id_usuario = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, uf = ?, cep = ? WHERE id_endereco = ?";

        if (endereco.getIdEndereco() == null || endereco.getIdEndereco() <= 0) {
            System.err.println("EnderecoDAO: Falha ao atualizar - ID do endereço é inválido.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, endereco.getIdUsuario());
            pstmt.setString(2, endereco.getLogradouro());
            pstmt.setString(3, endereco.getNumero());
            pstmt.setString(4, endereco.getComplemento());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setString(6, endereco.getCidade());
            pstmt.setString(7, endereco.getUf());
            pstmt.setString(8, endereco.getCep());

            // WHERE
            pstmt.setInt(9, endereco.getIdEndereco());

            int linhasAfetadas = pstmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar endereço com ID " + endereco.getIdEndereco() + ": " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- D E L E T A R ----------------------------------------------------
    // ----------------------------------------------------------------------
    @Override
    public boolean deletar(Integer id) {
        String sql = "DELETE FROM endereco WHERE id_endereco = ?";

        if (id == null || id <= 0) {
            System.err.println("EnderecoDAO: Falha ao deletar - ID inválido.");
            return false;
        }

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int linhasAfetadas = pstmt.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar endereço com ID " + id + ": " + e.getMessage());
            return false;
        }
    }

    // ----------------------------------------------------------------------
    // --- B U S C A R   P O R   C A M P O (CRUD) ---------------------------
    // ----------------------------------------------------------------------
    @Override
    public List<Endereco> buscarPorCampo(String campo, String valor) {
        System.out.println("Método 'buscarPorCampo' genérico não implementado para EnderecoDAO.");
        return new ArrayList<>();
    }
}