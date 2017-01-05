/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoPagar;
import br.com.genises.model.Pagar;

/**
 *
 * @author Tiago
 */
public class BPagar {

    DaoPagar daoPagar = new DaoPagar();

    public void salvar(Pagar pagar) throws Exception {
        try {
            daoPagar.salvar(pagar);
        } catch (Exception e) {
            throw e;
        }

    }

}
