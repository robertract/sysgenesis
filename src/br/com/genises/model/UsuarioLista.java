/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.model;

import java.util.List;

/**
 *
 * @author Tiago
 */
public class UsuarioLista {

    private long id;
    private String classe;
    private String nome;
    private Boolean padrao;
    private Usuario usuario;
    private List<UsuarioListaItens> itens;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getPadrao() {
        return padrao;
    }

    public void setPadrao(Boolean padrao) {
        this.padrao = padrao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public List<UsuarioListaItens> getItens() {
        return itens;
    }

    public void setItens(List<UsuarioListaItens> itens) {
        this.itens = itens;
    }

}
