package DAO;

import DOMAIN.Alugueis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Classe para realizar as operações na tabela alugueis da base de dados.
 * @author Jose
 */
public final class OperacaoBancoAlugueis {

    // Atributo armazenando um objeto da classe para gerenciar a conexão com o banco de dados no MySQL.
    ConexaoBD conexaoBD = new ConexaoBD();

    // Método para incluir um aluguel na tabela alugueis do banco de dados.
    public void incluir(Alugueis aluguel) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre; // usado para executar uma instrução SQL no banco de dados.
        // utiliza o caractere de interrogação ? para indicar o lugar que terá um dado inserido, 
        // posteriormente definido pelos métodos setters (ex.: setString, setInt, setFloat, etc...), 
        // onde o primeiro valor passado no parâmetro é o número/índice do valor indicado pelo ?
        // e o segundo é o objeto que será o valor indicado pelo ? na posição informada no primeiro parâmetro..
        try {
            String sql = "INSERT INTO alugueis "
                    + "(nomeusuario, nomelivro, dtdevolucao) "
                    + "VALUES (?, ?, ?)";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, aluguel.getNomeusuario());
            pre.setString(2, aluguel.getNomelivro());
            pre.setDate(3, aluguel.getDtdevolucao());
            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Aluguel incluído com sucesso!");
        } catch (SQLException e) { // erro ao incluir o registro
            JOptionPane.showMessageDialog(null, "Erro ao incluir: " + e.getMessage());
        }
    } // Fim do método incluir

    // Método para alterar um aluguel na tabela alugueis do banco de dados.
    public void alterar(Alugueis aluguel) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "UPDATE alugueis SET "
                    + "nomeusuario=?, nomelivro=?, dtdevolucao=? "
                    + "WHERE codaluguel=?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, aluguel.getNomeusuario());
            pre.setString(2, aluguel.getNomelivro());
            pre.setDate(3, aluguel.getDtdevolucao());
            pre.setInt(4, aluguel.getCodaluguel());

            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Aluguel alterado com sucesso!");
        } catch (SQLException b) { // erro ao alterar o registro
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + b.getMessage());
        }
    } // Fim do método alterar

    // Método para excluir um aluguel na tabela alugueis do banco de dados.
    public void excluir(Alugueis aluguel) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "DELETE FROM alugueis WHERE codaluguel=?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, aluguel.getCodaluguel());
            pre.executeUpdate(); // executa a instrução SQL informada no PreparedStatement.
            JOptionPane.showMessageDialog(null, "Aluguel excluído com sucesso!");
        } catch (SQLException b) { // erro ao excluir o registro
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + b.getMessage());
        }
    } // Fim do método excluir

    // Método para listar os registros da tabela alugueis do banco de dados.
    public ResultSet listar() {
        Statement st;
        ResultSet rs = null; // Representação na memória de uma tabela
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //TYPE_SCROLL_SENSITIVE: possibilidade de acessar os registros
            //CONCUR_UPDATABLE: alterar valores contidos no rs
            rs = st.executeQuery("SELECT * FROM alugueis ORDER BY nomeusuario, nomelivro");  // executa a instrução SQL informada.
            //exibindo temporariamente os dados codigo e nomeUsuario
            System.out.println("\nListagem dos Aluguéis");
            System.out.println("codaluguel - nomeusuario - nomelivro - dtdevolucao");
            while (rs.next()) { // enquanto possuir registro na tabela representada na memória pelo Java, que é o ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                System.out.printf("%10s - %s - %s - %s\n", rs.getInt("codaluguel"), rs.getString("nomeusuario"), rs.getString("nomelivro"), rs.getDate("dtdevolucao"));
            }
            rs.first(); // volta ao primeiro registro
        } catch (SQLException e) { // erro ao listar o(s) registro(s)
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return rs;
    } // Fim do método listar

    // Método para buscar um registro da tabela alugueis pelo campo nomeusuario.
    // Retorna um objeto do tipo ResultSet, que conterá os dados dos campos de todos 
    // os registros resultantes da Query informada na consulta.
    public ResultSet buscarAluguel(String nomeUsuario) {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.prepareStatement("SELECT * FROM alugueis "
                    + "WHERE nomeusuario LIKE ?");
            st.setString(1, nomeUsuario + '%');
            rs = st.executeQuery(); // executa a instrução SQL informada no PreparedStatement.
            System.out.println("\nAluguel encontrado");
            System.out.println("codaluguel - nomeusuario - nomelivro - dtdevolucao");
            while (rs.next()) { // enquanto possuir registro na tabela representada na memória pelo Java, que é o ResultSet, 
                // executa as intruções dentro do laço e passa para o próximo registro.
                System.out.printf("%10s - %s - %s - %s\n", rs.getInt("codaluguel"), rs.getString("nomeusuario"), rs.getString("nomelivro"), rs.getDate("dtdevolucao"));
            }
            rs.first(); // volta ao primeiro registro
        } catch (SQLException b) { // erro ao buscar o(s) registro(s)
            System.out.println("Erro" + b.getMessage());
        }
        return rs;
    } // Fim do método buscarAluguel

} // Fim da classe
