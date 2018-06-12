package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jose
 */
public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost/BD_projetoescola";
    private static final String USER = "root";
    private static final String PASSWD = "";
    private Connection con = null;

    public void carregarDriver() {
        try {
            //carrega o drive
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver carregado");
        } catch (ClassNotFoundException ex) {
            //se não carregar'
            System.out.println("O driver MYSQL não pode ser carregado. Erro: " + ex);
        }
    }

    public Connection obterConexao() {
        try {
            //verifica se conexão fechada ou inexistente
            //abre conexao
            if ((con == null) || (con.isClosed())) {
                con = DriverManager.getConnection(URL, USER, PASSWD);
                System.out.println("Conexao obtida com sucesso");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex);
        }
        return con;//Retorna uma conexao onde serao feitas as conexoes
        //operacao com o BD
    }

    public void fecharConexao() {
        try {
            if ((con != null) && (!con.isClosed())) {
                con.close();
                System.out.println("Conexão fechada ");

            }

        } catch (SQLException ex) {
            System.out.println("SQLException" + ex);
        }
    }//Fim do método fechar conexão
}
