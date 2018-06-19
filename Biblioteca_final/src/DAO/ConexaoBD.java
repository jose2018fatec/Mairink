package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe para gerenciar a conexão com o MySQL pelo JDBC.
 * @author Jose
 */
public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost/BD_projetoescola"; // URL da Connection com o MySQL para o JDBC
    private static final String USER = "root"; // usuário da base de dados
    private static final String PASSWD = ""; // senha do usuário da base de dados
    private Connection con = null; // atributo Connection para armazenar a conexão com o MySQL

    // Método para carregar o Driver conector do MySQL em com.mysql.jdbc
    public void carregarDriver() {
        try { //carrega o drive
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver carregado");
        } catch (ClassNotFoundException ex) { // se não carregar, pois ocorreu algum erro
            System.out.println("O driver MYSQL não pode ser carregado. Erro: " + ex);
        }
    }

    // Método para retornar a Connection em java.sql
    public Connection obterConexao() {
        try {
            // verifica se conexão fechada ou inexistente
            // abre conexao
            if ((con == null) || (con.isClosed())) {
                con = DriverManager.getConnection(URL, USER, PASSWD);
                System.out.println("Conexao obtida com sucesso");
            }
        } catch (SQLException ex) { // erro ao obter a conexão
            System.out.println("SQLException: " + ex);
        }
        return con; // Retorna uma conexao onde serão feitas as conexões
        // operacao com o BD
    }

    // Método para fechar a conexão com o MySQL na "Connection con"
    public void fecharConexao() {
        try {
            // connection não está vazia e ainda está aberta,
            // então pode fechá-la.
            if ((con != null) && (!con.isClosed())) {
                con.close();
                System.out.println("Conexão fechada ");
            }
        } catch (SQLException ex) { // erro ao fechar a conexão
            System.out.println("SQLException" + ex);
        }
    } // Fim do método fechar conexão
    
} // Fim da classe
