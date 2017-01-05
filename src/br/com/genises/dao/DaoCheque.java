/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cheque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author rober
 */
public class DaoCheque extends Dao {

    public boolean verificaExistencia(String numero) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT ID, EMITENTE, NUMERO_CHEQUE FROM CHEQUE WHERE NUMERO_CHEQUE LIKE ?";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, numero);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return true;

            } else {
                resultSet.close();
                preparedStatement.close();
                connection.close();
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public void save(Cheque c) throws Exception {

        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO CHEQUE(EMITENTE, ID_BANCO, ID_HISTORICO, "
                    + "VALOR, NUMERO_CHEQUE, DATA_ENTRADA, DATA_COMPENSACAO, TIPO, STATUS) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, c.getEmitente());
                preparedStatement.setLong(2, c.getBanco().getId());
                preparedStatement.setLong(3, c.getHistorico().getCodigo());
                preparedStatement.setBigDecimal(4, c.getValor());
                preparedStatement.setString(5, c.getNumero());
                java.util.Date utilDateEnt = c.getDataEntrada();
                java.sql.Date sqlDateEnt = new java.sql.Date(utilDateEnt.getTime());
                preparedStatement.setDate(6, sqlDateEnt);

                java.util.Date utilDateComp = c.getDataCompensacao();
                java.sql.Date sqlDateComp = new java.sql.Date(utilDateComp.getTime());
                preparedStatement.setDate(7, sqlDateComp);

                preparedStatement.setString(8, c.getTipo());
                preparedStatement.setString(9, c.getStatus());

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

    public void excluir(Cheque get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Double pesquisarReceber() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT SUM(VALOR) AS SOMA FROM CHEQUE WHERE STATUS = 'Em Aberto' and TIPO = 'Recebido'";
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Double valorReceber = 0.00;
            if (resultSet.next()) {

                valorReceber = resultSet.getDouble(1);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return valorReceber;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public Double pesquisarPagar() throws Exception {

        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT SUM(VALOR) AS SOMA FROM CHEQUE WHERE STATUS = 'Em Aberto' and TIPO = 'Emitido'";
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Double valorPagar = 00.00;

            if (resultSet.next()) {

                valorPagar = resultSet.getDouble(1);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return valorPagar;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

}
