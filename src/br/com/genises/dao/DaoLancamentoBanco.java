/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.LancamentoBanco;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class DaoLancamentoBanco extends Dao {

    public List<LancamentoBanco> pesquisaFiltro(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void excluir(LancamentoBanco get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void salva(LancamentoBanco lancamento) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {

            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO LAN_BANCO (DOCUMENTO, DATA, VALOR, PRE_DATADO, COMPENSADO, "
                    + "CONFIRMA, BANCO, TIPO_LANCAMENTO) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, lancamento.getDocumento());
            preparedStatement.setDate(2, Date.valueOf(lancamento.getData()));
            preparedStatement.setBigDecimal(3, lancamento.getValor());
            preparedStatement.setDate(4, Date.valueOf(lancamento.getPreDatado()));
            preparedStatement.setDate(5, Date.valueOf(lancamento.getCompensadoEm()));
            preparedStatement.setBoolean(6,lancamento.getNecessitaConfirmar());
            preparedStatement.setLong(7, lancamento.getBanco().getId());
            preparedStatement.setString(8, lancamento.getTipoLancamento());

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }

    }

    public void atualiza(LancamentoBanco lancamento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
