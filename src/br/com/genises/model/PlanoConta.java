/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.model;

import br.com.genises.view.util.tablemodel.Tabela;

/**
 *
 * @author Tiago
 */
public class PlanoConta {

    private Long id;
    private String classificacao;
    private String nome;
    private String tipo;
    private String natureza;
    private Boolean dre;
    private Boolean ativo;
    private Boolean passivo;

    @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "plano_conta.id", tipoAtributo = "numero", visivelOutraTela = true, nomeOutraTela = "Código Plano")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Tabela(nome = "Classificação", tamanho = 300, posicao = 1, nomePesquisa = "plano_conta.classificacao", tipoAtributo = "string", visivelOutraTela = true, nomeOutraTela = "Classificação Plano")
    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    @Tabela(nome = "Nome", tamanho = 300, posicao = 2, nomePesquisa = "nome", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Tabela(nome = "Tipo", tamanho = 40, posicao = 3, nomePesquisa = "tipo", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Tabela(nome = "Natureza", tamanho = 60, posicao = 4, nomePesquisa = "natureza", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    @Tabela(nome = "DRE", tamanho = 60, posicao = 5, nomePesquisa = "flag_dre", tipoAtributo = "boolean", visivelOutraTela = false, nomeOutraTela = "")
    public Boolean getDre() {
        return dre;
    }

    public void setDre(Boolean dre) {
        this.dre = dre;
    }

    @Tabela(nome = "Ativo", tamanho = 50, posicao = 6, nomePesquisa = "ativo", tipoAtributo = "boolean", visivelOutraTela = false, nomeOutraTela = "")
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Tabela(nome = "Passivo", tamanho = 50, posicao = 7, nomePesquisa = "passivo", tipoAtributo = "boolean", visivelOutraTela = false, nomeOutraTela = "")
    public Boolean getPassivo() {
        return passivo;
    }

    public void setPassivo(Boolean passivo) {
        this.passivo = passivo;
    }

    @Override
    public String toString() {
        return this.nome + " :" + this.id;
    }

}
