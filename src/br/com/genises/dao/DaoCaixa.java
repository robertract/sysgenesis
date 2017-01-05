/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Caixa;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tiago
 */
public class DaoCaixa extends Dao {

    public void excluir(Caixa get) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "delete from caixa where id=?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {
                preparedStatement.setLong(1, get.getId());

                preparedStatement.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }
    }

    public void salvar(Caixa caixa) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO CAIXA (DOCUMENTO, HISTORICO, DATA_HORA, VALOR, PLANO, "
                    + "TIPO_LANCAMENTO,CODIGOLANCAMENTO) "
                    + "VALUES (?,?,?,?,?,?,?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {
                preparedStatement.setString(1, caixa.getDocumento());
                preparedStatement.setString(2, caixa.getHistorico());
                preparedStatement.setDate(3, Date.valueOf(caixa.getDataHora()));
                preparedStatement.setBigDecimal(4, caixa.getValor());
                preparedStatement.setLong(5, caixa.getPlano().getId());
                preparedStatement.setString(6, caixa.getTipo().name());
                preparedStatement.setLong(7, caixa.getCodigoLancamento());

                preparedStatement.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }
    }

}
