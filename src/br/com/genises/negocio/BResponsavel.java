/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoResponsavel;
import br.com.genises.model.ResponsavelLegal;

/**
 *
 * @author rober
 */
public class BResponsavel {

    DaoResponsavel daoResponsavel = new DaoResponsavel();

    public ResponsavelLegal pesquisaResponsavel() throws Exception {
        ResponsavelLegal r = new ResponsavelLegal();
        r = daoResponsavel.pesquisaResponsavel();
        return r;

    }

    public void gravar(ResponsavelLegal responsavel) throws Exception {
        daoResponsavel.gravar(responsavel);
    }

    public void alterar(ResponsavelLegal responsavel) throws Exception {
        daoResponsavel.alterar(responsavel);
    }

}
