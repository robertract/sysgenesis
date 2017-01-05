/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package br.com.genises.model;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Celula {

    private long id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cep;
    private Cidade cidade;
    private Membro anfitriao;
    private Membro lider;
    private Membro liderTreinamemto;
    private Membro supervisor;
    private List<Membro> membros;
    private String dia;
    private String hora;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Membro getAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(Membro anfitriao) {
        this.anfitriao = anfitriao;
    }

    public Membro getLider() {
        return lider;
    }

    public void setLider(Membro lider) {
        this.lider = lider;
    }

    public Membro getLiderTreinamemto() {
        return liderTreinamemto;
    }

    public void setLiderTreinamemto(Membro liderTreinamemto) {
        this.liderTreinamemto = liderTreinamemto;
    }

    public Membro getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Membro supervisor) {
        this.supervisor = supervisor;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Celula other = (Celula) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.nome;
    }
}
