package DAO;

import DOMAIN.Alugueis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public final class OperacaoBancoAlugueis {

    ConexaoBD conexaoBD = new ConexaoBD();

    public void incluir(Alugueis aluguel) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "INSERT INTO alugueis "
                    + "(nomeusuario, nomelivro, dtdevolucao) "
                    + "VALUES (?, ?, ?)";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, aluguel.getNomeusuario());
            pre.setString(2, aluguel.getNomelivro());
            pre.setDate(3, aluguel.getDtdevolucao());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluguel incluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir: " + e.getMessage());
        }
    } // Fim do método incluir

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

            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluguel alterado com sucesso!");
        } catch (SQLException b) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + b.getMessage());
        }
    } // Fim do método alterar

    public void excluir(Alugueis aluguel) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;
        try {
            String sql = "DELETE FROM alugueis WHERE codaluguel=?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, aluguel.getCodaluguel());
            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aluguel excluído com sucesso!");
        } catch (SQLException b) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + b.getMessage());
        }
    } // Fim do método excluir

    public ResultSet listar() {
        Statement st;
        ResultSet rs = null; //Representação na emória de uma tabela
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //TYPE_SCROLL_SENSITIVE: possibilidade de acessar os registros
            //CONCUR_UPDATABLE: alterar valores contidos no rs
            rs = st.executeQuery("SELECT * FROM alugueis ORDER BY nomeusuario, nomelivro");
            //exibindo temporariamente os dados codigo e nomeUsuario
            System.out.println("\nListagem dos Aluguéis");
            System.out.println("codaluguel - nomeusuario - nomelivro - dtdevolucao");
            while (rs.next()) {
                System.out.printf("%10s - %s - %s - %s\n", rs.getInt("codaluguel"), rs.getString("nomeusuario"), rs.getString("nomelivro"), rs.getDate("dtdevolucao"));
            }
            rs.first();//volta ao primeiro registro
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return rs;
    } // Fim do método listar

    public ResultSet buscarAluguel(String nomeUsuario) {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.prepareStatement("SELECT * FROM alugueis "
                    + "WHERE nomeusuario LIKE ?");
            st.setString(1, nomeUsuario + '%');
            rs = st.executeQuery();
            System.out.println("\nAluguel encontrado");
            System.out.println("codaluguel - nomeusuario - nomelivro - dtdevolucao");
            while (rs.next()) {
                System.out.printf("%10s - %s - %s - %s\n", rs.getInt("codaluguel"), rs.getString("nomeusuario"), rs.getString("nomelivro"), rs.getDate("dtdevolucao"));
            }
            rs.first();
        } catch (SQLException b) {
            System.out.println("Erro" + b.getMessage());
        }
        return rs;
    } // Fim do método buscarAluguel

}
