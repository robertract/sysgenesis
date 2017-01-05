/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;


import br.com.genises.model.PlanoConta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class DaoPlanoConta extends Dao {

   

    public List<PlanoConta> pesquisaFiltro(String filtro) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.NOME, a.CLASSIFICACAO, a.TIPO, a.NATUREZA, a.FLAG_DRE, a.ativo, a.passivo FROM PLANO_CONTA a where " + filtro;
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<PlanoConta> contas = new ArrayList<>();
            while (resultSet.next()) {
                PlanoConta plano = new PlanoConta();
                plano.setId(resultSet.getLong(1));
                plano.setNome(resultSet.getString(2));
                plano.setClassificacao(resultSet.getString(3));
                plano.setTipo(resultSet.getString(4));
                plano.setNatureza(resultSet.getString(5));
                plano.setDre(resultSet.getBoolean(6));
                plano.setAtivo(resultSet.getBoolean(7));
                plano.setPassivo(resultSet.getBoolean(8));
                contas.add(plano);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return contas;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void salva(PlanoConta p) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO PLANO_CONTA (NOME, CLASSIFICACAO, TIPO, NATUREZA, FLAG_DRE,ATIVO, PASSIVO)"
                    + " VALUES (?,?,?,?,?,?,?);";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, p.getNome());
            preparedStatement.setString(2, p.getClassificacao());
            preparedStatement.setString(3, p.getTipo());
            preparedStatement.setString(4, p.getNatureza());
            preparedStatement.setBoolean(5, p.getDre());
            preparedStatement.setBoolean(6, p.getAtivo());
            preparedStatement.setBoolean(7, p.getPassivo());

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }

    }

    public void atualiza(PlanoConta p) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE PLANO_CONTA SET NOME = ? , CLASSIFICACAO = ?,TIPO=?, NATUREZA=? ,FLAG_DRE=?, ativo=? , passivo=? WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, p.getNome());
                preparedStatement.setString(2, p.getClassificacao());
                preparedStatement.setString(3, p.getTipo().toString());
                preparedStatement.setString(4, p.getNatureza().toString());
                preparedStatement.setBoolean(5, p.getDre());
                preparedStatement.setLong(6, p.getId());
                preparedStatement.setBoolean(7, p.getAtivo());
                preparedStatement.setBoolean(8, p.getPassivo());
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

    public void excluir(PlanoConta p) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "delete from PLANO_CONTA WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setLong(1, p.getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            ex.printStackTrace();
            throw new Exception("PLANO DE CONTA USADO EM OUTRO CADASTRADO, E NÃO PODERÁ SER APAGADO!!");
        }
    }

    public List<PlanoConta> list() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.NOME, a.CLASSIFICACAO, a.TIPO, a.NATUREZA, "
                    + "a.FLAG_DRE, a.ativo, a.passivo FROM PLANO_CONTA a";
            //System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<PlanoConta> contas = new ArrayList<>();
            while (resultSet.next()) {
                PlanoConta plano = new PlanoConta();
                plano.setId(resultSet.getLong(1));
                plano.setNome(resultSet.getString(2));
                plano.setClassificacao(resultSet.getString(3));
                plano.setTipo(resultSet.getString(4));
                plano.setNatureza(resultSet.getString(5));
                plano.setDre(resultSet.getBoolean(6));
                plano.setAtivo(resultSet.getBoolean(7));
                plano.setPassivo(resultSet.getBoolean(8));
                contas.add(plano);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return contas;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
