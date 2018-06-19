package DOMAIN;

/**
 * Classe para criar objeto com os valores do campo de um registro da tabela livros do banco de dados.
 * @author Jose
 */
public class Livros {

	// Atributos da entidade Livros
    private Integer codlivro;
    private String nome;
    private String autor;

    public Integer getCodlivro() {
        return codlivro;
    }

    public void setCodlivro(Integer codlivro) {
        this.codlivro = codlivro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    @Override
    public String toString() {
        return "Livro: [codlivro=" + codlivro + ", nome=" + nome + ", autor=" + autor + "]";
    }

} // Fim da classe
