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
public class Fornecedor {

    private long id;
    private String nome;
    private String cnpjCpf;
    private String ie;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private Cidade cidade;
    private String observacao;

    @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "fornecedor.id", tipoAtributo = "numero", visivelOutraTela = true, nomeOutraTela = "Código Fornecedor")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Tabela(nome = "Nome", tamanho = 300, posicao = 1, nomePesquisa = "fornecedor.nome", tipoAtributo = "string", visivelOutraTela = true, nomeOutraTela = "Nome Fornecedor")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Tabela(nome = "CNPJ/CPF", tamanho = 120, posicao = 2, nomePesquisa = "cpf_cnpj", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "CNPJ Fornecedor")
    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    @Tabela(nome = "IE", tamanho = 80, posicao = 3, nomePesquisa = "ie", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    @Tabela(nome = "Endereco", tamanho = 130, posicao = 4, nomePesquisa = "endereco", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Tabela(nome = "Numero", tamanho = 50, posicao = 5, nomePesquisa = "numero", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Tabela(nome = "Complemento", tamanho = 100, posicao = 6, nomePesquisa = "complemento", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Tabela(nome = "Bairro", tamanho = 100, posicao = 7, nomePesquisa = "bairro", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Tabela(nome = "Cidade", tamanho = 100, posicao = 8, nomePesquisa = "cidade", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Tabela(nome = "Observacão", tamanho = 150, posicao = 9, nomePesquisa = "obs", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return this.nome + " :" + id;
    }

}
