/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package br.com.genises.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Contador {

    private long id;
    private String nome;
    private String endereco;
    private String bairro;
    private Cidade cidade;
    private String cep;
    private String telefone;
    private String celular;
    private String email;
    private String cpf;
    private String crc;
    private String ufCrc;
    private Date emissaoCrc;
    private String rg;

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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getUfCrc() {
        return ufCrc;
    }

    public void setUfCrc(String ufCrc) {
        this.ufCrc = ufCrc;
    }

    public Date getEmissaoCrc() {
        return emissaoCrc;
    }

    public void setEmissaoCrc(Date emissaoCrc) {
        this.emissaoCrc = emissaoCrc;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Contador other = (Contador) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
