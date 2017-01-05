/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoCidade;
import br.com.genises.model.Cidade;
import br.com.genises.principal.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert Frederico
 */
public class BCidade {

    DaoCidade cidadeDao = new DaoCidade();

    public List<Cidade> buscaCidade(String uf) throws Exception {
        List<Cidade> cidades = new ArrayList<>();
        cidades = cidadeDao.buscaCidade(uf);
        return cidades;
    }
}
