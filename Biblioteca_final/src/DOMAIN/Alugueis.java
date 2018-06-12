package DOMAIN;

import java.sql.Date;

public class Alugueis {

    private Integer codaluguel;
    private String nomeusuario;
    private String nomelivro;
    private Date dtdevolucao;

    public Integer getCodaluguel() {
        return codaluguel;
    }

    public void setCodaluguel(Integer codaluguel) {
        this.codaluguel = codaluguel;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getNomelivro() {
        return nomelivro;
    }

    public void setNomelivro(String nomelivro) {
        this.nomelivro = nomelivro;
    }

    public Date getDtdevolucao() {
        return dtdevolucao;
    }

    public void setDtdevolucao(Date dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }

    @Override
    public String toString() {
        return "Aluguel: [codaluguel=" + codaluguel + ", nomeusuario=" + nomeusuario + ", nomelivro=" + nomelivro + ", dtdevolucao=" + dtdevolucao + "]";
    }
    
}
