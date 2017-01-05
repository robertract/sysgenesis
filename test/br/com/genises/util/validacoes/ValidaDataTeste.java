/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.util.validacoes;

import br.com.genises.view.exception.NegocioException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class ValidaDataTeste {

    @Test
    public void deveRetornarDataIncorretaMaiorQueSistema() {
        assertEquals(ValidaData.dataMaiorSistema("31/12/2151"), true);
    }

    @Test
    public void deveRetornarDataCorretaMaiorQueSistema() {
        assertEquals(ValidaData.dataMaiorSistema("31/12/1988"), false);
    }

    @Test
    public void deveRetornarDataCorretaMaiorIdade() {
        assertEquals(ValidaData.dataVerificaMaiorIdade("14/11/1991"), false);
    }
    @Test(expected = NegocioException.class)
    public void deveRetornarDataIncorretaMaiorIdade() {
        ValidaData.dataVerificaMaiorIdade("14/11/199");
    }

}
