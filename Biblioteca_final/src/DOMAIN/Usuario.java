package DOMAIN;

/**
 * Classe para criar objeto com os valores do campo de um registro da tabela usuario do banco de dados.
 * @author Jose
 */
public class Usuario {

	// Atributos da entidade Usuario
    private Integer codusuario;
    private String nome;

    public Integer getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuário: [codusuario=" + codusuario + ", nome=" + nome + "]";
    }

} // Fim da classe
