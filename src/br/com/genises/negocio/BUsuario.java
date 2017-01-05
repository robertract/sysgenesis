/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package br.com.genises.negocio;

import br.com.genises.dao.DaoUsuario;
import br.com.genises.model.Usuario;

/**
 *
 * @author rober
 */
public class BUsuario {

    DaoUsuario dao = new DaoUsuario();

    public void save(Usuario usuario) throws Exception {

        if (usuario.getId() == null) {
            dao.salva(usuario);
        } else {
            dao.atualiza(usuario);
        }
    }

    public boolean verificaExistencia(Usuario usuarioV) throws Exception {
        return dao.verificaExistencia(usuarioV);
    }

}
