/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.model;

import br.com.genises.view.util.tablemodel.Tabela;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Tiago
 */
public class Pagar {

    private long id;
    private String conta;
    private LocalDate data;
    private LocalDate vencimento;
    private BigDecimal valor;
    private BigDecimal juros;
    private BigDecimal descontos;
    private BigDecimal valorTotal;
    private LocalDate dataPagamento;
    private BigDecimal valorPago;
    private String situacao;
    private String historico;
    private PlanoConta plano;
    private Fornecedor fornecedor;
    private Boolean selecionado;

    public Pagar() {
        this.selecionado = false;
    }

    // @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "id", tipoAtributo = "numero")
    @Tabela(nome = "Código", tamanho = 50, posicao = 13, nomePesquisa = "paga.id", tipoAtributo = "numero", visivelOutraTela = false, nomeOutraTela = "")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Tabela(nome = "Conta", tamanho = 150, posicao = 0, nomePesquisa = "pagar.conta", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    @Tabela(nome = "Data Emissão", tamanho = 150, posicao = 1, nomePesquisa = "pagar.data", tipoAtributo = "data", visivelOutraTela = false, nomeOutraTela = "")
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Tabela(nome = "Data Vencimento", tamanho = 150, posicao = 2, nomePesquisa = "pagar.vencimento", tipoAtributo = "data", visivelOutraTela = false, nomeOutraTela = "")
    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    @Tabela(nome = "Valor", tamanho = 150, posicao = 3, nomePesquisa = "pagar.valor", tipoAtributo = "decimal", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Tabela(nome = "Juros", tamanho = 150, posicao = 4, nomePesquisa = "pagar.juros", tipoAtributo = "decimal", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getJuros() {
        return juros;
    }

    public void setJuros(BigDecimal juros) {
        this.juros = juros;
    }

    @Tabela(nome = "Descontos", tamanho = 150, posicao = 5, nomePesquisa = "pagar.descontos", tipoAtributo = "decimal", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getDescontos() {
        return descontos;
    }

    public void setDescontos(BigDecimal descontos) {
        this.descontos = descontos;
    }

    @Tabela(nome = "Total", tamanho = 150, posicao = 6, nomePesquisa = "pagar.VALOR_TOTAL", tipoAtributo = "decimal", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Tabela(nome = "Data Pagamento", tamanho = 150, posicao = 7, nomePesquisa = "pagar.data_pagamento", tipoAtributo = "data", visivelOutraTela = false, nomeOutraTela = "")
    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    @Tabela(nome = "Valor Pago", tamanho = 150, posicao = 8, nomePesquisa = "pagar.valor_pago", tipoAtributo = "decimal", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    @Tabela(nome = "Situação", tamanho = 150, posicao = 9, nomePesquisa = "pagar.situacao", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Tabela(nome = "Historico", tamanho = 150, posicao = 10, nomePesquisa = "pagar.historico", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Tabela(nome = "Plano", tamanho = 150, posicao = 11, nomePesquisa = "object", tipoAtributo = "object", visivelOutraTela = false, nomeOutraTela = "")
    public PlanoConta getPlano() {
        return plano;
    }

    public void setPlano(PlanoConta plano) {
        this.plano = plano;
    }

    @Tabela(nome = "Fornecedor", tamanho = 150, posicao = 12, nomePesquisa = "object", tipoAtributo = "object", visivelOutraTela = false, nomeOutraTela = "")
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Tabela(nome = "...", tamanho = 50, posicao = 0, nomePesquisa = "id", tipoAtributo = "boolean", visivelOutraTela = false, nomeOutraTela = "")
    public Boolean getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Boolean selecionado) {
        this.selecionado = selecionado;
    }

}
