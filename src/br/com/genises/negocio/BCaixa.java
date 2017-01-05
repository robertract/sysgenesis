/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoCaixa;
import br.com.genises.model.Caixa;

/**
 *
 * @author Tiago
 */
public class BCaixa {

    DaoCaixa daoCaixa = new DaoCaixa();

    public void salvar(Caixa caixa) throws Exception {
        try {
            daoCaixa.salvar(caixa);
        } catch (Exception e) {
            throw e;
        }

    }

}
