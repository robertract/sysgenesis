/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.model;

import br.com.genises.view.util.tablemodel.Tabela;

/**
 *
 * @author Administrador
 */
public class Banco {

    private long id;
    private String banco;
    private String agencia;
    private String conta;
    private String titular;
    private String gerente;

    @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "id", tipoAtributo = "numero", visivelOutraTela = false, nomeOutraTela = "")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Tabela(nome = "Banco", tamanho = 130, posicao = 1, nomePesquisa = "banco", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    @Tabela(nome = "Agência", tamanho = 80, posicao = 2, nomePesquisa = "agencia", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    @Tabela(nome = "Conta", tamanho = 100, posicao = 3, nomePesquisa = "conta", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Tabela(nome = "Titular", tamanho = 200, posicao = 4, nomePesquisa = "titular", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Tabela(nome = "Gerente", tamanho = 200, posicao = 5, nomePesquisa = "gertente", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String toString() {
        return banco + " | AG:" + agencia + " | CC:" + conta;
    }
}
