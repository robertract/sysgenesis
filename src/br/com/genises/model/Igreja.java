/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package br.com.genises.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Igreja {

    private long id;
    private String nome;
    private String endereco;
    private String bairro;
    private Cidade cidade;
    private String cep;
    private String telefone;
    private String celular;
    private String email;
    private String cnpj;
    private String registroCartorio;
    private String cnae;
    private Date dataInicio;
    private Contador contador;
    private ResponsavelLegal responsavelLegal;
    private List<Membro> membros;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRegistroCartorio() {
        return registroCartorio;
    }

    public void setRegistroCartorio(String registroCartorio) {
        this.registroCartorio = registroCartorio;
    }

    public String getCnae() {
        return cnae;
    }

    public void setCnae(String cnae) {
        this.cnae = cnae;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public ResponsavelLegal getResponsavelLegal() {
        return responsavelLegal;
    }

    public void setResponsavelLegal(ResponsavelLegal responsavelLegal) {
        this.responsavelLegal = responsavelLegal;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public void setMembros(List<Membro> membros) {
        this.membros = membros;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Igreja other = (Igreja) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
