/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class DaoBanco extends Dao {

    public void save(Banco b) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO BANCO(BANCO, AGENCIA, CONTA, TITULAR, GERENTE) "
                    + "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, b.getBanco());
                preparedStatement.setString(2, b.getAgencia());
                preparedStatement.setString(3, b.getConta());
                preparedStatement.setString(4, b.getTitular());
                preparedStatement.setString(5, b.getGerente());

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

    public List<Banco> pesquisarBancos(String string) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT ID, BANCO, AGENCIA, CONTA, TITULAR, GERENTE FROM BANCO WHERE " + string + " ORDER BY BANCO";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
//            preparedStatement.setString(1, string);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Banco> bancos = new ArrayList<>();
            while (resultSet.next()) {

                Banco b = new Banco();
                b.setId(resultSet.getInt(1));
                b.setBanco(resultSet.getString(2));
                b.setAgencia(resultSet.getString(3));
                b.setConta(resultSet.getString(4));
                b.setTitular(resultSet.getString(5));
                b.setGerente(resultSet.getString(6));

                bancos.add(b);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return bancos;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public void excluir(Banco get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean verificaExistencia(Banco bancoV) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT ID, BANCO, AGENCIA, CONTA, TITULAR, GERENTE FROM BANCO WHERE BANCO = ? AND CONTA = ? AND AGENCIA = ?";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, bancoV.getBanco());
            preparedStatement.setString(2, bancoV.getConta());
            preparedStatement.setString(3, bancoV.getAgencia());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public void update(Banco b) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE BANCO SET BANCO = ?, AGENCIA = ?, CONTA = ?, "
                    + "TITULAR = ?, GERENTE = ? WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, b.getBanco());
                preparedStatement.setString(2, b.getAgencia());
                preparedStatement.setString(3, b.getConta());
                preparedStatement.setString(4, b.getTitular());
                preparedStatement.setString(5, b.getGerente());
                preparedStatement.setLong(6, b.getId());

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
