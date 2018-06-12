package Teste;

import DOMAIN.Alugueis;
import DOMAIN.Livros;
import DOMAIN.Usuario;
import DAO.OperacaoBancoLivro;
import DAO.OperacaoBancoAlugueis;
import DAO.OperacaoBancoUsuario;
import DAO.ConexaoBD;
import java.sql.Date;
import java.sql.SQLException;

public class Teste {

    public static void main(String[] args) throws SQLException {
        ConexaoBD conexaoBD = new ConexaoBD();
        OperacaoBancoUsuario ob = new OperacaoBancoUsuario();
        OperacaoBancoLivro obc = new OperacaoBancoLivro();
        OperacaoBancoAlugueis obm = new OperacaoBancoAlugueis();

        //Usuario
        Usuario p1 = new Usuario();
        p1.setNome("José");

        System.out.println("\nIncluindo usuário");
        ob.incluir(p1);
        System.out.println("\nPesquisando usuário");
        p1.setCodusuario(ob.buscarUsuarioNome("José").getInt("codusuario"));
        System.out.println("\nAlterando usuário");
        ob.alterar(p1);
        System.out.println("\nExcluindo usuário");
        ob.excluir(p1);
        System.out.println("\nListando usuário");
        ob.listar();
        conexaoBD.fecharConexao();

        //Livros
        Livros l1 = new Livros();
        l1.setNome("Introdução à Programação");
        l1.setAutor("Anita Lopes");

        System.out.println("\nIncluindo livro");
        obc.incluir(l1);
        System.out.println("\nPesquisando livro");
        l1.setCodlivro(obc.buscarLivroNome("Introdução à Programação").getInt("codlivro"));
        System.out.println("\nAlterando livro");
        obc.alterar(l1);
        System.out.println("\nExcluindo livro");
        obc.excluir(l1);
        System.out.println("\nListando livro");
        obc.listar();
        conexaoBD.fecharConexao();

        //Alugueis
        Alugueis a1 = new Alugueis();
        a1.setNomeusuario("José");
        a1.setNomelivro("Introdução à Programação");
        a1.setDtdevolucao(new Date(2017-1900, 7-1, 8));

        System.out.println("\nIncluindo aluguel");
        obm.incluir(a1);
        System.out.println("\nPesquisando aluguel");
        a1.setCodaluguel(obm.buscarAluguel("José").getInt("codaluguel"));
        System.out.println("\nAlterando aluguel");
        obm.alterar(a1);
        System.out.println("\nExcluindo aluguel");
        obm.excluir(a1);
        System.out.println("\nListando aluguel");
        obm.listar();
        conexaoBD.fecharConexao();

    }
}
