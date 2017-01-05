/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GRUD;

import br.com.genises.model.Cidade;
import br.com.genises.model.Fornecedor;
import br.com.genises.negocio.BFornecedor;
import br.com.genises.view.exception.NegocioException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class FornecedorCrud {

    @Test
    public void verificaInsercao() {
        try {
            Cidade c = new Cidade();
            c.setCodigoIbge("1100452");
            Fornecedor f = new Fornecedor();
            f.setCidade(c);
            f.setCnpjCpf("90312");
            f.setComplemento("adfa");
            f.setEndereco("adfads");
            f.setId(0);
            f.setIe("032");
            f.setNome("afdadfs");
            f.setObservacao("adfasdfasdf");
            f.setNumero("adfasdfas");
            BFornecedor b = new BFornecedor();
            b.save(f);
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
        

    }

}
