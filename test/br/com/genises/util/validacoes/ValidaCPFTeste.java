/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.util.validacoes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class ValidaCPFTeste {
    @Test
    public void deveRetornarIncorreto(){
        assertEquals(ValidaCPF.isCPF("03425197193"), true);
        
    }
    @Test
    public void deveRetornarCorreto(){
        assertEquals(ValidaCPF.isCPF("0342519719"), false);
        
    }
}
