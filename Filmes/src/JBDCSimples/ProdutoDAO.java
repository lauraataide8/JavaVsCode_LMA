package JBCDSimples;

import java.sql.Connection;
import java.sql.Date; // Importa o Date do SQL
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {

    /**
     * Item 2: Insere um novo produto usando PreparedStatement.
     */
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, categoria, preco, dataCadastro) VALUES (?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conecta.getConexao(); // Usa o NOVO Conecta.java
            stmt = con.prepareStatement(sql);

            // Define os parâmetros do PreparedStatement
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setDate(4, Date.valueOf(produto.getDataCadastro())); // Converte LocalDate para java.sql.Date

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex.getMessage());
        } finally {
            Conecta.fecharConexao(con, stmt); // Fecha a conexão
        }
    }

    /**
     * Item 3: Lista todos os produtos cadastrados.
     */
    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = Conecta.getConexao();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();

                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getString("categoria"));
                p.setPreco(rs.getBigDecimal("preco"));
                p.setDataCadastro(rs.getDate("dataCadastro").toLocalDate()); // Converte java.sql.Date para LocalDate

                produtos.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + ex.getMessage());
        } finally {
            Conecta.fecharConexao(con, stmt, rs); // Fecha tudo
        }

        return produtos;
    }

    /**
     * Exclui um produto do banco de dados com base no ID.
     */
    public void excluir(int idProduto) {
        String sql = "DELETE FROM produto WHERE idProduto = ?";

        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = Conecta.getConexao();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idProduto); // Define o ID do produto que queremos excluir

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado (ID: " + idProduto + ").");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + ex.getMessage());
        } finally {
            Conecta.fecharConexao(con, stmt);
        }
    }

} // <-- Este é o '}' final da classe ProdutoDAO