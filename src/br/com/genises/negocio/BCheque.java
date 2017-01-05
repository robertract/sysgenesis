/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoCheque;
import br.com.genises.model.Cheque;
import java.util.List;

/**
 *
 * @author rober
 */
public class BCheque {

    DaoCheque daoC = new DaoCheque();

    public boolean verificaExistencia(String numero) throws Exception {
        return daoC.verificaExistencia(numero);
    }

    public void save(Cheque c) throws Exception {
        daoC.save(c);
    }

    public List<Cheque> pesquisarFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Double pesquisarReceber() throws Exception {
        Double valorReceber;
        valorReceber = daoC.pesquisarReceber();
        return valorReceber;
    }

    public Double pesquisarPagar() throws Exception {
        Double valorPagar;
        valorPagar = daoC.pesquisarPagar();
        return valorPagar;
    }

}
