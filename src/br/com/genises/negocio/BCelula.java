/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoCelula;
import br.com.genises.model.Celula;
import br.com.genises.model.Membro;
import java.util.List;

/**
 *
 * @author rober
 */
public class BCelula {

    DaoCelula daoCelula = new DaoCelula();

    public void gravar(Celula c) throws Exception {
        daoCelula.gravar(c);
    }

    public void update(Celula c) throws Exception {
        daoCelula.update(c);
    }

    public List<Celula> pesquisaCelula(String pesquisar) throws Exception {
        return daoCelula.pesquisaCelula(pesquisar);

    }

    public List<Celula> listarCelulas() throws Exception {
        return daoCelula.listarCelulas();

    }

    public List<Membro> pesquisarMembros(long id) throws Exception {
        return daoCelula.pesquisarMembros(id);

    }

    public void gravarMembro(Membro membroSelecionado, Celula celulaSelecionada) throws Exception {
        daoCelula.gravarMembro(membroSelecionado, celulaSelecionada);

    }

    public boolean verificaExistencia(Celula celulaV) throws Exception {
        return daoCelula.verificaExistencia(celulaV);
    }

    public boolean membroPertence(long idCelula, long idMembro) throws Exception {
        return daoCelula.membroPertence(idCelula, idMembro);

    }

    public void deletaMembro(long idM, long idC) throws Exception {
        daoCelula.deletaMembro(idM, idC);
    }

}
