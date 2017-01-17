/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoMembro;
import br.com.genises.model.Membro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rober
 */
public class BMembro {

    public List<Membro> pesquisarMembros(String pesquisar) throws Exception {
        return daoMembro.pesquisarMembros(pesquisar);
    }

    DaoMembro daoMembro = new DaoMembro();

    public boolean verificaExistencia(String cpf) throws Exception {
        if (daoMembro.verificaExistencia(cpf) == false) {
            return false;
        } else {
            return true;
        }
    }

    public void gravar(Membro m) throws Exception {
        daoMembro.gravar(m);
    }

    public List<Membro> pesquisaMembros(String filtro) throws Exception {
        return daoMembro.pesquisarMembrosGUI(filtro);
    }

    public Membro pesquisaCompleta(Membro membro) throws Exception {
        return daoMembro.pesquisaCompleta(membro);
    }

    public void update(Membro m) throws Exception {
        daoMembro.update(m);
    }
}
