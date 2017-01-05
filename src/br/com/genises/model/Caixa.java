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
public class Caixa {

    private long id;
    private String documento;
    private String historico;
    private LocalDate dataHora;
    private BigDecimal valor;
    private PlanoConta plano;
    private TipoLancamento tipo;
    private Long codigoLancamento;

    public Caixa() {
        this.tipo = TipoLancamento.MANUAL;
        this.codigoLancamento = 0l;
    }

    @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "id", tipoAtributo = "numero", visivelOutraTela = false, nomeOutraTela = "")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Tabela(nome = "Documento", tamanho = 50, posicao = 0, nomePesquisa = "DOCUMENTO", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Tabela(nome = "Historico", tamanho = 50, posicao = 0, nomePesquisa = "HISTORICO", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Tabela(nome = "Data/Hora", tamanho = 50, posicao = 0, nomePesquisa = "data_hora", tipoAtributo = "data", visivelOutraTela = false, nomeOutraTela = "")
    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    @Tabela(nome = "Documento", tamanho = 50, posicao = 0, nomePesquisa = "VALOR", tipoAtributo = "numero", visivelOutraTela = false, nomeOutraTela = "")
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Tabela(nome = "Documento", tamanho = 50, posicao = 0, nomePesquisa = "plano", tipoAtributo = "object", visivelOutraTela = false, nomeOutraTela = "")
    public PlanoConta getPlano() {
        return plano;
    }

    public void setPlano(PlanoConta plano) {
        this.plano = plano;
    }

    @Tabela(nome = "Tipo Lançamento", tamanho = 50, posicao = 0, nomePesquisa = "tipo_lancamento", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Long getCodigoLancamento() {
        return codigoLancamento;
    }

    public void setCodigoLancamento(Long codigoLancamento) {
        this.codigoLancamento = codigoLancamento;
    }

}
