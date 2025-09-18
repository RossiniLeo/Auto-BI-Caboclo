package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "";
    private static final String USER = "";
    private static final String PASSWORD = "";

    // Obtém conexão com o banco de dados
    public static Connection obtemConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}