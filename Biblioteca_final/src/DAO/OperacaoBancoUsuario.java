package DAO;

/**
 *
 * @author Jose
 */
import DOMAIN.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class OperacaoBancoUsuario {

    ConexaoBD conexaoBD = new ConexaoBD();

    public void incluir(Usuario a) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;

        try {
            String sql = "INSERT INTO usuarios "
                    + "(nome) "
                    + "VALUES (?)";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNome());

            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário incluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método incluir

    public void alterar(Usuario a) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;

        try {
            String sql = "UPDATE usuarios SET "
                    + "nome=? "
                    + "WHERE codusuario=?";
            pre = conexao.prepareStatement(sql);
            pre.setString(1, a.getNome());
            pre.setInt(2, a.getCodusuario());

            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
        }
    } // Fim do método alterar

    public void excluir(Usuario usuario) {
        Connection conexao = conexaoBD.obterConexao();
        PreparedStatement pre;

        try {
            String sql = "DELETE FROM usuarios "
                    + "WHERE codusuario=?";
            pre = conexao.prepareStatement(sql);
            pre.setInt(1, usuario.getCodusuario());

            pre.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
        } finally {
            conexaoBD.fecharConexao();
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
            rs = st.executeQuery("SELECT * FROM usuarios ORDER BY nome");

            //exibindo temporariamente os dados codigo e nome
            System.out.println("\nListagem dos Usuários");
            System.out.println("codusuario - nome");
            while (rs.next()) {
                System.out.printf("%10s - %s\n", rs.getString("codusuario"), rs.getString("nome"));
            }
            rs.first();//volta ao primeiro registro
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + e.getMessage());
        }
        return rs;
    } // Fim do método listar

    public ResultSet buscarUsuarioNome(String nome) {
        PreparedStatement st;
        ResultSet rs = null;
        try {
            Connection conexao = conexaoBD.obterConexao();
            st = conexao.prepareStatement("SELECT * FROM usuarios WHERE nome LIKE ?");
            st.setString(1, nome + '%');

            rs = st.executeQuery();
            System.out.println("\nUsuários encontrados");
            System.out.println("codusuario - nome ");
            while (rs.next()) {
                System.out.printf("%10s - %s\n", rs.getString("codusuario"), rs.getString("nome"));
            }
            rs.first();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar: " + e.getMessage());
        }
        return rs;
    } // Fim do método buscarUsuarioNoem

}//Fim do programa
