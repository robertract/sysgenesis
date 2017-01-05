/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Tiago
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

    int posicao();

    int tamanho();

    String nome();

    String nomePesquisa();

    String tipoAtributo();

    boolean visivelOutraTela();

    String nomeOutraTela();

}
