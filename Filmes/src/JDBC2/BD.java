package JDBC2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {

    public Connection connection = null;

    // --- Constantes para a conexão ---
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DBNAME = "filmes";
    private final String URL = "jdbc:mysql://localhost:3306/" + DBNAME;
    private final String LOGIN = "root";
    private final String PASSWORD = "1500";

    /**
     * Tenta estabelecer a conexão e a armazena na variável 'connection'.
     * @return true se conectou, false se houve falha.
     */
    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("Conectado!");
            return true;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver nao encontrado: " + e.getMessage());
            return false;

        } catch (SQLException e) {
            System.out.println("Usuario, senha ou banco incorretos: " + e.toString());
            return false;
        }
    }

    /**
     * Fecha a conexão ativa com o banco.
     */
    public void close() {
        try {
            // É crucial verificar se a conexão não é nula
            // antes de tentar fechá-la, para evitar NullPointerException.
            if (connection != null) {
                connection.close();
                System.out.println("Desconectado.");
            }
        } catch (SQLException e) {
            // Lançar uma RuntimeException é uma forma de
            // sinalizar que algo inesperado ocorreu ao fechar o recurso.
            throw new RuntimeException(e);

        }
    }

}