/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.model;

import br.com.genises.view.util.tablemodel.Tabela;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Cheque {

    private int id;
    private String emitente;
    private Banco banco;
    private Historico historico;
    private String numero;
    private BigDecimal  valor;
    private PlanoConta plano;
    private Date dataEntrada;
    private Date dataCompensacao;
    private String tipo;
    private String status;
    
    
    
    @Tabela(nome = "Tipo", tamanho = 100, posicao = 1, nomePesquisa = "tipo", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "id", tipoAtributo = "numero", visivelOutraTela = false, nomeOutraTela = "")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Tabela(nome = "Emitente", tamanho = 200, posicao = 2, nomePesquisa = "emitente", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getEmitente() {
        return emitente;
    }

    public void setEmitente(String emitente) {
        this.emitente = emitente;
    }

    @Tabela(nome = "Banco", tamanho = 200, posicao = 3, nomePesquisa = "banco", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @Tabela(nome = "Historico", tamanho = 200, posicao = 4, nomePesquisa = "historico", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        this.historico = historico;
    }

    @Tabela(nome = "Numero", tamanho = 200, posicao = 5, nomePesquisa = "numero", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Tabela(nome = "Valor", tamanho = 100, posicao = 6, nomePesquisa = "valor", tipoAtributo = "numero", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Tabela(nome = "Plano de Conta", tamanho = 200, posicao = 7, nomePesquisa = "plano", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public PlanoConta getPlano() {
        return plano;
    }

    public void setPlano(PlanoConta plano) {
        this.plano = plano;
    }

    @Tabela(nome = "Data Entrada", tamanho = 100, posicao = 8, nomePesquisa = "data", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Tabela(nome = "Data Compensação", tamanho = 200, posicao = 9, nomePesquisa = "compensacao", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public Date getDataCompensacao() {
        return dataCompensacao;
    }

    public void setDataCompensacao(Date dataCompensacao) {
        this.dataCompensacao = dataCompensacao;
    }

    @Tabela(nome = "Status", tamanho = 100, posicao = 10, nomePesquisa = "status", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
