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
public class Usuario {

    private Long id;
    private String nomeUsuario;
    private String usuario;
    private String email;
    private String senha;
    private String repetirSenha;
    private Perfil perfil;

    @Tabela(nome = "Código", tamanho = 50, posicao = 0, nomePesquisa = "id", tipoAtributo = "numero",visivelOutraTela = false, nomeOutraTela = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Tabela(nome = "Usuário", tamanho = 230, posicao = 1, nomePesquisa = "usuario", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRepetirSenha() {
        return repetirSenha;
    }

    public void setRepetirSenha(String repetirSenha) {
        this.repetirSenha = repetirSenha;
    }

    @Tabela(nome = "Nome", tamanho = 230, posicao = 2, nomePesquisa = "nome", tipoAtributo = "string" ,visivelOutraTela = false, nomeOutraTela = "")
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String NomeUsuario) {
        this.nomeUsuario = NomeUsuario;
    }

    @Tabela(nome = "E-Mail", tamanho = 230, posicao = 3, nomePesquisa = "email", tipoAtributo = "string", visivelOutraTela = false, nomeOutraTela = "")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
