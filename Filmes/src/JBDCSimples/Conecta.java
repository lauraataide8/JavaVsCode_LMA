package JBCDSimples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conecta {

    // ATENÇÃO: Atualize com suas credenciais do MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/loja"; // Banco 'loja'
    private static final String USER = "root"; // ex: "root"
    private static final String PASSWORD = "1500"; // ex: "1500"

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Método para obter uma conexão
    public static Connection getConexao() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    // Método para fechar a conexão
    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao fechar conexão: " + ex);
        }
    }

    // Método para fechar conexão e PreparedStatement
    public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fecharConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao fechar PreparedStatement: " + ex);
        }
    }

    // Método para fechar tudo (incluindo ResultSet)
    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao fechar ResultSet: " + ex);
        }
    }
}