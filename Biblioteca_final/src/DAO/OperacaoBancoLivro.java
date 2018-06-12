package DAO;

import DOMAIN.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class OperacaoBancoLivro {

    ConexaoBD conexaoBD = new ConexaoBD();

    public void incluir(Livros livro) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "INSERT INTO livros "
                    + "(nome, autor) "
                    + "VALUES (?,?)";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, livro.getNome());
            pre.setString(2, livro.getAutor());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro incluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir: " + e.getMessage());
        }
    } // Fim do método incluir

    public void alterar(Livros livro) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "UPDATE livros SET "
                    + "nome=?, autor=? "
                    + "WHERE codlivro=?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, livro.getNome());
            pre.setString(2, livro.getAutor());
            pre.setInt(3, livro.getCodlivro());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage());
        }
    } // Fim do método alterar

    public void excluir(Livros livro) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "DELETE FROM livros WHERE codlivro=?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, livro.getCodlivro());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        }
    } // Fim do método excluir

    public ResultSet listar() {
        Statement st;
        ResultSet rs = null; //Representação na memória de uma tabela
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //TYPE_SCROLL_SENSITIVE: possibilidade de acessar os registros
            //CONCUR_UPDATABLE: alterar valores contidos no rs
            rs = st.executeQuery("SELECT * FROM livros ORDER BY nome");
            //exibindo temporariamente os dados codigo e descricao
            System.out.println("\nListagem dos livros");
            System.out.println("codlivro - nome - autor");
            while (rs.next()) {
                System.out.printf("%8s - %s - %s\n", rs.getString("codlivro"), rs.getString("nome"), rs.getString("autor"));
            }
            rs.first();//volta ao primeiro registro
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return rs;
    } // Fim do método listar

    public ResultSet buscarLivroNome(String nome) {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.prepareStatement("SELECT * FROM livros WHERE nome LIKE ?");
            st.setString(1, nome + '%');
            rs = st.executeQuery();
            System.out.println("\nLivros encontrados");
            System.out.println("codlivro - nome - autor");
            while (rs.next()) {
                System.out.printf("%8s - %s - %s\n", rs.getString("codlivro"), rs.getString("nome"), rs.getString("autor"));
            }
            rs.first();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + e.getMessage());
        }
        return rs;
    } // Fim do método buscarLivroNome

}
