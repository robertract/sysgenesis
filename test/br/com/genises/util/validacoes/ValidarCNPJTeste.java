/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.util.validacoes;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class ValidarCNPJTeste {
    
   @Test
    public void deveRetornarIncorreto(){
        assertEquals(ValidarCNPJ.isCNPJ("10399682000100"), true);
        
    }
    @Test
    public void deveRetornarCorreto(){
        assertEquals(ValidaCPF.isCPF("0342519719"), false);
        
    }
    
}
