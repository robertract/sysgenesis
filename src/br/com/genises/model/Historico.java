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
public class Historico {

    private long codigo;
    private String descricao;
    private String tipo;

    @Tabela(nome = "Codigo", tamanho = 50, posicao = 0, nomePesquisa = "codigo", tipoAtributo = "numero" , visivelOutraTela = false, nomeOutraTela = "")
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    @Tabela(nome = "Descrição", tamanho = 525, posicao = 1, nomePesquisa = "descricao", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Tabela(nome = "Tipo", tamanho = 150, posicao = 2, nomePesquisa = "tipo", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return descricao;
    }

    
}
