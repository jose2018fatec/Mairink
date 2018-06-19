package DAO;

import DOMAIN.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe para realizar as operações na tabela livros da base de dados.
 * @author Jose
 */
public class OperacaoBancoLivro {

    // Atributo armazenando um objeto da classe para gerenciar a conexão com o banco de dados no MySQL.
    ConexaoBD conexaoBD = new ConexaoBD();

    // Método para incluir um livro na tabela livros do banco de dados.
    public void incluir(Livros livro) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre; // usado para executar uma instrução SQL no banco de dados.
        // utiliza o caractere de interrogação ? para indicar o lugar que terá um dado inserido, 
        // posteriormente definido pelos métodos setters (ex.: setString, setInt, setFloat, etc...), 
        // onde o primeiro valor passado no parâmetro é o número/índice do valor indicado pelo ?
        // e o segundo é o objeto que será o valor indicado pelo ? na posição informada no primeiro parâmetro..
        try {
            String sql = "INSERT INTO livros (nome, autor) VALUES (?,?)";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, livro.getNome());
            pre.setString(2, livro.getAutor());
            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Livro incluído com sucesso!");
        } catch (SQLException e) { // erro ao incluir o registro
            JOptionPane.showMessageDialog(null, "Erro ao incluir: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método incluir

    // Método para alterar um livro na tabela livros do banco de dados.
    public void alterar(Livros livro) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "UPDATE livros SET nome=?, autor=? WHERE codlivro=?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, livro.getNome());
            pre.setString(2, livro.getAutor());
            pre.setInt(3, livro.getCodlivro());
            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Livro alterado com sucesso!");
        } catch (SQLException e) { // erro ao alterar o registro
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método alterar

    // Método para excluir um livro na tabela livros do banco de dados.
    public void excluir(Livros livro) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "DELETE FROM livros WHERE codlivro=?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, livro.getCodlivro());
            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
        } catch (SQLException e) { // erro ao excluir o registro
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método excluir

    // Método para listar os registros da tabela livros do banco de dados.
    public ResultSet listar() {
        Statement st;
        ResultSet rs = null; //Representação na memória de uma tabela
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //TYPE_SCROLL_SENSITIVE: possibilidade de acessar os registros
            //CONCUR_UPDATABLE: alterar valores contidos no rs
            rs = st.executeQuery("SELECT * FROM livros ORDER BY nome"); // executa a instrução SQL informada.
            //exibindo temporariamente os dados codigo e descricao
            System.out.println("\nListagem dos livros");
            System.out.println("codlivro - nome - autor");
            while (rs.next()) { // enquanto possuir registro na tabela representada na memória pelo Java, que é o ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                System.out.printf("%8s - %s - %s\n", rs.getString("codlivro"), rs.getString("nome"), rs.getString("autor"));
            }
            rs.first(); // volta ao primeiro registro
        } catch (SQLException e) { // erro ao listar o(s) registro(s)
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return rs;
    } // Fim do método listar

    // Método para buscar um registro da tabela livros pelo campo nome.
    // Retorna um objeto do tipo ResultSet, que conterá os dados dos campos de todos 
    // os registros resultantes da Query informada na consulta.
    public ResultSet buscarLivroNome(String nome) {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.prepareStatement("SELECT * FROM livros WHERE nome LIKE ?");
            st.setString(1, nome + '%');
            rs = st.executeQuery(); // executa a instrução SQL informada no PreparedStatement.
            System.out.println("\nLivros encontrados");
            System.out.println("codlivro - nome - autor");
            while (rs.next()) { // enquanto possuir registro na tabela representada na memória pelo Java, que é o ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                System.out.printf("%8s - %s - %s\n", rs.getString("codlivro"), rs.getString("nome"), rs.getString("autor"));
            }
            rs.first(); // volta ao primeiro registro
        } catch (SQLException e) { // erro ao buscar o(s) registro(s)
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + e.getMessage());
        }
        return rs;
    } // Fim do método buscarLivroNome

} // Fim da classe
