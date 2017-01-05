/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoIgreja;
import br.com.genises.model.Igreja;
import br.com.genises.principal.Principal;

/**
 *
 * @author Robert Frederico
 */
public class BIgreja {

    DaoIgreja daoIgreja = new DaoIgreja();

    public Igreja pesquisaIgreja() throws Exception {
        Igreja igreja = new Igreja();
        igreja = daoIgreja.pesquisaIgreja();
        return igreja;
    }

    public void gravar(Igreja igreja) throws Exception {
        daoIgreja.gravar(igreja);
    }

    public void alterar(Igreja igreja) throws Exception {
        daoIgreja.alterar(igreja);
    }

}
