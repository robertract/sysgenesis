/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class Membro {

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
    private String rg;
    private String orgaoEmissor;
    private String ufOrgao;
    private String ufRg;
    private String pai;
    private String mae;
    private Date nascimento;
    private String estadoCivil;
    private Date casamento;
    private String conjugue;
    private String filhos;
    private Date batismoAgua;
    private String nomeMinistro;
    private boolean outraIgreja;
    private String nomeIgreja;
    private boolean liderCelula;
    private boolean lidertreinamento;
    private boolean anfitriao;
    private boolean celula;
    private String naturalDe;
    private String cargo1;
    private String cargo2;
    private String cargo3;
    private boolean discipulado;
    private String nomeDiscipulador;
    private String AnfitriaoOnde;
    private String obs;
    private String ufNascimento;
    private Celula nomeCelula;

    public Celula getNomeCelula() {
        return nomeCelula;
    }

    public void setNomeCelula(Celula nomeCelula) {
        this.nomeCelula = nomeCelula;
    }

    public String getUfNascimento() {
        return ufNascimento;
    }

    public void setUfNascimento(String ufNascimento) {
        this.ufNascimento = ufNascimento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getAnfitriaoOnde() {
        return AnfitriaoOnde;
    }

    public void setAnfitriaoOnde(String AnfitriaoOnde) {
        this.AnfitriaoOnde = AnfitriaoOnde;
    }

    public boolean isDiscipulado() {
        return discipulado;
    }

    public void setDiscipulado(boolean discipulado) {
        this.discipulado = discipulado;
    }

    public String getNomeDiscipulador() {
        return nomeDiscipulador;
    }

    public void setNomeDiscipulador(String nomeDiscipulador) {
        this.nomeDiscipulador = nomeDiscipulador;
    }

    public boolean isCelula() {
        return celula;
    }

    public void setCelula(boolean celula) {
        this.celula = celula;
    }

    public String getCargo1() {
        return cargo1;
    }

    public void setCargo1(String cargo1) {
        this.cargo1 = cargo1;
    }

    public String getCargo2() {
        return cargo2;
    }

    public void setCargo2(String cargo2) {
        this.cargo2 = cargo2;
    }

    public String getCargo3() {
        return cargo3;
    }

    public void setCargo3(String cargo3) {
        this.cargo3 = cargo3;
    }

    public String getNaturalDe() {
        return naturalDe;
    }

    public void setNaturalDe(String naturalDe) {
        this.naturalDe = naturalDe;
    }

    public String getUfOrgao() {
        return ufOrgao;
    }

    public void setUfOrgao(String ufOrgao) {
        this.ufOrgao = ufOrgao;
    }

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public String getUfRg() {
        return ufRg;
    }

    public void setUfRg(String ufRg) {
        this.ufRg = ufRg;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Date getCasamento() {
        return casamento;
    }

    public void setCasamento(Date casamento) {
        this.casamento = casamento;
    }

    public String getConjugue() {
        return conjugue;
    }

    public void setConjugue(String conjugue) {
        this.conjugue = conjugue;
    }

    public String getFilhos() {
        return filhos;
    }

    public void setFilhos(String filhos) {
        this.filhos = filhos;
    }

    public Date getBatismoAgua() {
        return batismoAgua;
    }

    public void setBatismoAgua(Date batismoAgua) {
        this.batismoAgua = batismoAgua;
    }

    public String getNomeMinistro() {
        return nomeMinistro;
    }

    public void setNomeMinistro(String nomeMinistro) {
        this.nomeMinistro = nomeMinistro;
    }

    public boolean isOutraIgreja() {
        return outraIgreja;
    }

    public void setOutraIgreja(boolean outraIgreja) {
        this.outraIgreja = outraIgreja;
    }

    public String getNomeIgreja() {
        return nomeIgreja;
    }

    public void setNomeIgreja(String nomeIgreja) {
        this.nomeIgreja = nomeIgreja;
    }

    public boolean isLiderCelula() {
        return liderCelula;
    }

    public void setLiderCelula(boolean liderCelula) {
        this.liderCelula = liderCelula;
    }

    public boolean isLidertreinamento() {
        return lidertreinamento;
    }

    public void setLidertreinamento(boolean lidertreinamento) {
        this.lidertreinamento = lidertreinamento;
    }

    public boolean isAnfitriao() {
        return anfitriao;
    }

    public void setAnfitriao(boolean anfitriao) {
        this.anfitriao = anfitriao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Membro other = (Membro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
