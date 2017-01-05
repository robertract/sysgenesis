/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoFornecedor;
import br.com.genises.dao.DaoUsuario;
import br.com.genises.model.Fornecedor;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class BFornecedor {

    DaoFornecedor daoF = new DaoFornecedor();

    public boolean verificaCpfCnpj(String text) throws Exception {
        return daoF.verificaCpfCnpj(text);
    }

    public void save(Fornecedor fornecedor) throws Exception {

        if (fornecedor.getId() == 0) {
            daoF.save(fornecedor);
        } else {
            daoF.update(fornecedor);
        }
    }

    public List<Fornecedor> pesquisarFiltro(String filtro) throws Exception {
        return daoF.pesquisaFiltro(filtro);
    }

}
