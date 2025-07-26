package src.model.Update;

import src.model.conexao.ConexaoDataBase;
import src.model.entidade.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Inserindo {

    private static List<Produto> lista = new ArrayList<>();
     //CRIAÇÃO DA TABELA
    public static void criarTabela() {
        String tabela = "CREATE TABLE IF NOT EXISTS compras ("+
                        "IdProduto INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                        "nome VARCHAR(100)," +
                        "preco DOUBLE)";

        try (
                Connection conexao = ConexaoDataBase.conexaoBanco();
                Statement statement = conexao.createStatement();
                ) {
                statement.executeUpdate(tabela);
        }catch (SQLException e) {
            System.out.println("ERRO NA CRIAÇÃO DA TABELA.");
        }
    }

    //INSERINDO DADOS NO BANCO EM LISTA
    public static void inserirDados(String nome, double preco) {

        String sql = "insert into compras (nome, preco) values (?, ?)";

        try (
                Connection conexao = ConexaoDataBase.conexaoBanco();
                PreparedStatement ps = conexao.prepareStatement(sql);
                ) {
            ps.setString(1, nome);
            ps.setDouble(2, preco);
            ps.executeUpdate();

            lista.add(new Produto(nome, preco));

        }catch (SQLException e) {
            System.out.println("ERRO NA INSERSAO DE DADOS.");
        }
    }
    public static List<Produto> getLista() {
        return lista;
    }
}
