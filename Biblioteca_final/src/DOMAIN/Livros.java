package DOMAIN;

public class Livros {

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

}
