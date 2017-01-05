/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoPlanoConta;
import br.com.genises.model.PlanoConta;

/**
 *
 * @author Tiago
 */
public class BPlanoConta {

    public void save(PlanoConta plano) throws Exception {
        DaoPlanoConta dao = new DaoPlanoConta();
        if (plano.getId() == null) {
            dao.salva(plano);
        } else {
            dao.atualiza(plano);
        }
    }

}
