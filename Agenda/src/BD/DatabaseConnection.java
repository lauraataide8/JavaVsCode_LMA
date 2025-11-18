package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public final class DatabaseConnection { // Adicionado 'final' para indicar que é uma classe utilitária

    // --- Constantes para a conexão ---
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBNAME = "agenda";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private static final String LOGIN = "root";
    private static final String PASSWORD = "1500";

    /**
     * Construtor privado.
     */
    private DatabaseConnection() {}

    /**
     * Método ESTÁTICO que retorna uma NOVA conexão com o banco.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // 1. Carrega o driver
            Class.forName(DRIVER);

            // 2. Retorna a nova conexão
            // Removida a linha de System.out.println
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);

        } catch (ClassNotFoundException e) {
            // Lança uma SQLException mais detalhada
            throw new SQLException("Erro: Driver MySQL nao encontrado. Verifique se o .jar está no classpath.", e);
        }
    }

    // ----------------------------------------------------------------------
    // --- MÉTODOS ESTÁTICOS AUXILIARES PARA FECHAR RECURSOS ---
    // ----------------------------------------------------------------------

    /**
     * Fecha a conexão com o banco de dados.
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
     * Fecha o Statement ou PreparedStatement.
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
     * Fecha o ResultSet.
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