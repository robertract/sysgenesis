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
public class LancamentoBanco {

    private Long id;
    private String documento;
    private LocalDate data;
    private BigDecimal valor;
    private LocalDate preDatado;
    private LocalDate compensadoEm;
    private Boolean necessitaConfirmar;
    private Banco banco;
    private String tipoLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Tabela(nome = "Documento", tamanho = 120, posicao = 2, nomePesquisa = "", tipoAtributo = "string", visivelOutraTela = true, nomeOutraTela = "CNPJ Fornecedor")
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getPreDatado() {
        return preDatado;
    }

    public void setPreDatado(LocalDate preDatado) {
        this.preDatado = preDatado;
    }

    public LocalDate getCompensadoEm() {
        return compensadoEm;
    }

    public void setCompensadoEm(LocalDate compensadoEm) {
        this.compensadoEm = compensadoEm;
    }

    public Boolean getNecessitaConfirmar() {
        return necessitaConfirmar;
    }

    public void setNecessitaConfirmar(Boolean necessitaConfirmar) {
        this.necessitaConfirmar = necessitaConfirmar;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

}
