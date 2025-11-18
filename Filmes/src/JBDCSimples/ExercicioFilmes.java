package JBDCSimples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ExercicioFilmes {

    public static void main(String[] args) {

        /*
         * Drivers JDBC para referência:
         * MySQL = com.mysql.cj.jdbc.Driver (novo) ou com.mysql.jdbc.Driver (antigo)
         * PostgreSQL = org.postgresql.Driver
         * Oracle = oracle.jdbc.driver.OracleDriver
         */

        // --- 1. Constantes de Conexão ---
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/filmes"; // BD 'filmes' no 'localhost'

        // ATENÇÃO: Nunca deixe senhas "hardcoded" (fixas no código) em projetos reais.
        // Use variáveis de ambiente ou arquivos de configuração.
        final String USER = "root";
        final String PASSWORD = "1500";

        // --- 2. Declaração dos Recursos ---
        // Declaramos fora do try para que o 'finally' possa acessá-los
        Connection connection = null;
        PreparedStatement stmInsert = null; // Statement para Inserção
        PreparedStatement stmSelect = null; // Statement para Seleção
        ResultSet rs = null;                // Objeto que armazena o resultado da consulta

        try {
            // --- 3. Conexão ---
            Class.forName(DRIVER); // Carrega o driver JDBC do MySQL na memória
            connection = DriverManager.getConnection(URL, USER, PASSWORD); // Estabelece a conexão
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!!");

            // --- 4. Inserção de Dados (PreparedStatement) ---
            String sqlInsert = "INSERT INTO filmes(titulo, genero, produtora, datCompra) VALUES (?,?,?,?)";

            // Prepara o comando, evitando SQL Injection
            stmInsert = connection.prepareStatement(sqlInsert);

            // Define os valores para os placeholders '?' (começando do índice 1)
            stmInsert.setString(1, "Batman");
            stmInsert.setString(2, "Ação/fantasia");
            stmInsert.setString(3, "WB");
            stmInsert.setString(4, "2021-02-15"); // ALERTA: Coluna 'datCompra' é DATE?
            // É mais seguro usar: stmInsert.setDate(4, java.sql.Date.valueOf("2021-02-15"));

            stmInsert.executeUpdate(); // Executa o comando de inserção
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!");

            // --- 5. Listagem dos Dados ---
            String sqlSelect = "SELECT * FROM filmes";
            stmSelect = connection.prepareStatement(sqlSelect);
            rs = stmSelect.executeQuery(); // Executa a consulta e armazena os resultados no ResultSet

            // StringBuilder é mais eficiente para montar strings grandes
            StringBuilder sb = new StringBuilder("Filmes cadastrados: \n\n");

            // Itera por cada linha (filme) retornada pelo banco
            while (rs.next()) {
                // Pega os dados da linha atual pelo nome da coluna
                sb.append("ID: ").append(rs.getInt("codigo")).append("\n");
                sb.append("TITULO: ").append(rs.getString("titulo")).append("\n");
                sb.append("GENERO: ").append(rs.getString("genero")).append("\n");
                sb.append("PRODUTORA: ").append(rs.getString("produtora")).append("\n");
                sb.append("DATA LANÇAMENTO: ").append(rs.getString("datCompra")).append("\n\n"); // Add \n extra
            }

            JOptionPane.showMessageDialog(null, sb.toString());

        } catch (ClassNotFoundException e) {
            // Erro: O driver .jar do MySQL não foi encontrado no projeto (classpath)
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            // Erro de SQL (ex: senha errada, tabela não existe, sintaxe SQL)
            JOptionPane.showMessageDialog(null, "Erro na conexão ou SQL: " + e.getMessage());
        } finally {
            // --- 6. Fechamento de Recursos (CRUCIAL) ---
            // O 'finally' é executado sempre, com ou sem erro.
            // Isso garante que os recursos (conexões) sejam liberados.
            // Fechamos na ordem inversa que abrimos (ResultSet -> Statement -> Connection)
            try {
                if (rs != null) rs.close();
                if (stmSelect != null) stmSelect.close();
                if (stmInsert != null) stmInsert.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                // Logar o erro de fechamento, se ocorrer
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }
}