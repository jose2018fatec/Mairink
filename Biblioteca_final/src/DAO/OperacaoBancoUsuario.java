package DAO;

import DOMAIN.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe para realizar as operações na tabela usuarios da base de dados.
 * @author Jose
 */
public class OperacaoBancoUsuario {

    // Atributo armazenando um objeto da classe para gerenciar a conexão com o banco de dados no MySQL.
    ConexaoBD conexaoBD = new ConexaoBD();

    // Método para incluir um aluguel na tabela usuarios do banco de dados.
    public void incluir(Usuario a) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre; // usado para executar uma instrução SQL no banco de dados.
        // utiliza o caractere de interrogação ? para indicar o lugar que terá um dado inserido, 
        // posteriormente definido pelos métodos setters (ex.: setString, setInt, setFloat, etc...), 
        // onde o primeiro valor passado no parâmetro é o número/índice do valor indicado pelo ?
        // e o segundo é o objeto que será o valor indicado pelo ? na posição informada no primeiro parâmetro..

        try {
            String sql = "INSERT INTO usuarios (nome) VALUES (?)";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNome());

            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Usuário incluído com sucesso!");
        } catch (SQLException e) { // erro ao incluir o registro
            JOptionPane.showMessageDialog(null, "Erro ao incluir: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método incluir

    // Método para alterar um usuario na tabela usuarios do banco de dados.
    public void alterar(Usuario a) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;

        try {
            String sql = "UPDATE usuarios SET nome=? WHERE codusuario=?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNome());
            pre.setInt(2, a.getCodusuario());

            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
        } catch (SQLException e) { // erro ao alterar o registro
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método alterar

    // Método para excluir um usuario na tabela usuarios do banco de dados.
    public void excluir(Usuario usuario) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;

        try {
            String sql = "DELETE FROM usuarios WHERE codusuario=?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, usuario.getCodusuario());

            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        } catch (SQLException e) { // erro ao excluir o registro
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método excluir    

    // Método para listar os registros da tabela usuarios do banco de dados.
    public ResultSet listar() {
        Statement st;
        ResultSet rs = null; //Representação na memória de uma tabela

        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //TYPE_SCROLL_SENSITIVE: possibilidade de acessar os registros
            //CONCUR_UPDATABLE: alterar valores contidos no rs
            rs = st.executeQuery("SELECT * FROM usuarios ORDER BY nome"); // executa a instrução SQL informada.

            //exibindo temporariamente os dados codigo e nome
            System.out.println("\nListagem dos Usuários");
            System.out.println("codusuario - nome");
            while (rs.next()) { // enquanto possuir registro na tabela representada na memória pelo Java, que é o ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                System.out.printf("%10s - %s\n", rs.getString("codusuario"), rs.getString("nome"));
            }
            rs.first();//volta ao primeiro registro
        } catch (SQLException e) { // erro ao listar o(s) registro(s)
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return rs;
    } // Fim do método listar

    // Método para buscar um registro da tabela usuarios pelo campo nome.
    // Retorna um objeto do tipo ResultSet, que conterá os dados dos campos de todos 
    // os registros resultantes da Query informada na consulta.
    public ResultSet buscarUsuarioNome(String nome) {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.prepareStatement("SELECT * FROM usuarios WHERE nome LIKE ?");
            st.setString(1, nome + '%');

            rs = st.executeQuery(); // executa a instrução SQL informada no PreparedStatement.
            System.out.println("\nUsuários encontrados");
            System.out.println("codusuario - nome ");
            while (rs.next()) { // enquanto possuir registro na tabela representada na memória pelo Java, que é o ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                System.out.printf("%10s - %s\n", rs.getString("codusuario"), rs.getString("nome"));
            }
            rs.first(); // volta ao primeiro registro
        } catch (SQLException e) { // erro ao buscar o(s) registro(s)
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + e.getMessage());
        }
        return rs;
    } // Fim do método buscarUsuarioNome

} //Fim a classe
