/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class DaoHistorico extends Dao {

    public boolean existeCodigo(int codigo) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT CODIGO, DESCRICAO, TIPO FROM HISTORICO WHERE CODIGO = ?";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setInt(1, codigo);
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

    public void save(Historico h) throws SQLException, Exception {

        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO HISTORICO(CODIGO, DESCRICAO, TIPO) "
                    + "VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setLong(1, h.getCodigo());
                preparedStatement.setString(2, h.getDescricao());
                preparedStatement.setString(3, h.getTipo());

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

    public List<Historico> pesquisarHistorico(String string) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            System.out.println(string);
            String stringSQL = "SELECT CODIGO, DESCRICAO, TIPO FROM HISTORICO WHERE " + string;
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Historico> historicos = new ArrayList<>();
            while (resultSet.next()) {

                Historico h = new Historico();
                h.setCodigo(resultSet.getInt(1));
                h.setDescricao(resultSet.getString(2));
                h.setTipo(resultSet.getString(3));

                historicos.add(h);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return historicos;
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw ex;
        }

    }

    public void excluir(Historico get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
