/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoHistorico;
import br.com.genises.model.Historico;
import java.util.List;

/**
 *
 * @author rober
 */
public class BHistorico {

    DaoHistorico daoH = new DaoHistorico();

    public boolean existeCodigo(int codigo) throws Exception {
        return daoH.existeCodigo(codigo);

    }

    public void save(Historico h) throws Exception {
        daoH.save(h);
    }

    public List<Historico> pesquisaHistorico(String string) throws Exception {
        return daoH.pesquisarHistorico(string);
    }

}
