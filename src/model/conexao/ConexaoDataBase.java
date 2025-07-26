package src.model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/bdteste";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static Connection conexaoBanco() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexao;
        }catch (SQLException e) {
            System.out.println("ERRO AO TENTAR SE CONECTAR AO BANCO.");
            return null;
        }
    }
}
