package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BD {

    // --- Constantes Otimizadas (static final) ---
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBNAME = "agenda";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1500";

    /**
     * Tenta carregar o driver e estabelece uma nova conexão com o banco.
     * @return um objeto java.sql.Connection
     * @throws SQLException se a conexão falhar
     */
    public Connection getConnection() throws SQLException {
        try {
            // 1. Carrega o driver
            Class.forName(DRIVER);

            // 2. Retorna a nova conexão
            // Removida a mensagem de System.out.println
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);

        } catch (ClassNotFoundException e) {
            // Lança uma SQLException mais específica
            throw new SQLException("Erro: Driver MySQL nao encontrado. Detalhes: " + e.getMessage(), e);
        }
    }

    // ----------------------------------------------------------------------
    // --- MÉTODOS AUXILIARES PARA FECHAR CONEXÕES DE FORMA SEGURA ---
    // ----------------------------------------------------------------------

    /**
     * Fecha a conexão com o banco, se não for null.
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar Connection: " + e.getMessage());
            }
        }
    }

    /**
     * Fecha o Statement, se não for null.
     */
    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar Statement: " + e.getMessage());
            }
        }
    }

    /**
     * Fecha o ResultSet, se não for null.
     */
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar ResultSet: " + e.getMessage());
            }
        }
    }
}