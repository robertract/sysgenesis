/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoLancamentoBanco;
import br.com.genises.dao.DaoUsuario;
import br.com.genises.model.LancamentoBanco;

/**
 *
 * @author Tiago
 */
public class BLancamentoBanco {

    public void salvar(LancamentoBanco lancamento) throws Exception {
        DaoLancamentoBanco dao = new DaoLancamentoBanco();
        if (lancamento.getId() == null) {
            dao.salva(lancamento);
        } else {
            dao.atualiza(lancamento);
        }
    }

}
