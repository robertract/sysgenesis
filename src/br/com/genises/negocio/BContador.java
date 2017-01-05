/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.model.Contador;
import br.com.genises.dao.DaoContador;

/**
 *
 * @author rober
 */
public class BContador {

    DaoContador daoContador = new DaoContador();

    public Contador pesquisaContador() throws Exception {
        Contador contador = new Contador();
        contador = daoContador.pesquisaContador();
        return contador;

    }

    public void gravar(Contador contador) throws Exception {
        daoContador.gravar(contador);

    }

    public void alterar(Contador contador) throws Exception {
        daoContador.alterar(contador);
    }

}
