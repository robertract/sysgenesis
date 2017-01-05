/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoBanco;
import br.com.genises.model.Banco;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class BBanco {

    DaoBanco daoB = new DaoBanco();

    public void save(Banco b) throws Exception {
        daoB.save(b);
    }

    public List<Banco> pesquisaBancos(String string) throws Exception {

        return daoB.pesquisarBancos(string);
    }

    public boolean verificaExistencia(Banco bancoV) throws Exception {
        return daoB.verificaExistencia(bancoV);
    }

    public void update(Banco b) throws Exception {
        daoB.update(b);
    }

}
