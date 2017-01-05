/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cidade;
import br.com.genises.model.Igreja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Robert Frederico
 */
public class DaoIgreja extends Dao {

    public Igreja pesquisaIgreja() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.BAIRRO, a.CELULAR, a.CEP, a.CNAE, "
                    + "a.CNPJ, a.DATA_INICIO, a.EMAIL, a.ENDERECO, a.NOME, "
                    + "a.REGISTRO_CARTORIO, a.TELEFONE, a.CIDADE, a.UF FROM IGREJA a";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Igreja i = new Igreja();
            Cidade cidade = new Cidade();

            if (resultSet.next()) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
                Calendar jData = new GregorianCalendar();

                i.setId(resultSet.getInt(1));
                i.setBairro(resultSet.getString(2));
                i.setCelular(resultSet.getString(3));
                i.setCep(resultSet.getString(4));
                i.setCnae(resultSet.getString(5));
                i.setCnpj(resultSet.getString(6));

                Date dataInicio = resultSet.getDate(7);
                i.setDataInicio(dataInicio);

                i.setEmail(resultSet.getString(8));
                i.setEndereco(resultSet.getString(9));
                i.setNome(resultSet.getString(10));
                i.setRegistroCartorio(resultSet.getString(11));
                i.setTelefone(resultSet.getString(12));
                cidade.setCidade(resultSet.getString(13));
                cidade.setUf(resultSet.getString(14));
                i.setCidade(cidade);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public void gravar(Igreja i) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO IGREJA (BAIRRO, CELULAR, CEP, CNAE,"
                    + "CNPJ, DATA_INICIO, EMAIL, ENDERECO, NOME,"
                    + "REGISTRO_CARTORIO, TELEFONE, CIDADE, UF) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, i.getBairro());
                preparedStatement.setString(2, i.getCelular());
                preparedStatement.setString(3, i.getCep());
                preparedStatement.setString(4, i.getCnae());
                preparedStatement.setString(5, i.getCnpj());

                java.util.Date utilDate = i.getDataInicio();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                preparedStatement.setDate(6, sqlDate);

                preparedStatement.setString(7, i.getEmail());

                preparedStatement.setString(8, i.getEndereco());
                preparedStatement.setString(9, i.getNome());
                preparedStatement.setString(10, i.getRegistroCartorio());
                preparedStatement.setString(11, i.getTelefone());
                preparedStatement.setString(12, i.getCidade().getCidade());
                preparedStatement.setString(13, i.getCidade().getUf());

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

    public void alterar(Igreja i) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE IGREJA SET BAIRRO = ?, CELULAR = ?, CEP = ?, CNAE = ?,"
                    + "CNPJ = ?, DATA_INICIO = ?, EMAIL = ?, ENDERECO = ?, NOME = ?,"
                    + "REGISTRO_CARTORIO = ?, TELEFONE = ?, CIDADE = ?, UF = ? WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, i.getBairro());
                preparedStatement.setString(2, i.getCelular());
                preparedStatement.setString(3, i.getCep());
                preparedStatement.setString(4, i.getCnae());
                preparedStatement.setString(5, i.getCnpj());

                java.util.Date utilDate = i.getDataInicio();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                preparedStatement.setDate(6, sqlDate);

                preparedStatement.setString(7, i.getEmail());

                preparedStatement.setString(8, i.getEndereco());
                preparedStatement.setString(9, i.getNome());
                preparedStatement.setString(10, i.getRegistroCartorio());
                preparedStatement.setString(11, i.getTelefone());
                preparedStatement.setString(12, i.getCidade().getCidade());
                preparedStatement.setString(13, i.getCidade().getUf());
                preparedStatement.setLong(14, i.getId());

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
