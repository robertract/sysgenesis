/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cidade;
import br.com.genises.model.Contador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author rober
 */
public class DaoContador extends Dao {

    public Contador pesquisaContador() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.BAIRRO, a.CELULAR, a.CEP, a.CPF, "
                    + "a.CRC, a.EMAIL, a.EMISSAOCRC, "
                    + "a.ENDERECO, a.NOME, a.RG, a.TELEFONE, "
                    + "a.UFCRC, a.CIDADE, a.UF FROM CONTADOR a";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contador contador = new Contador();
            Cidade cidade = new Cidade();

            if (resultSet.next()) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
                Calendar jData = new GregorianCalendar();

                contador.setId(resultSet.getInt(1));
                contador.setBairro(resultSet.getString(2));
                contador.setCelular(resultSet.getString(3));
                contador.setCep(resultSet.getString(4));
                contador.setCpf(resultSet.getString(5));
                contador.setCrc(resultSet.getString(6));

                contador.setEmail(resultSet.getString(7));

                Date dataEmissaoCrc = resultSet.getDate(8);
                contador.setEmissaoCrc(dataEmissaoCrc);

                contador.setEndereco(resultSet.getString(9));
                contador.setNome(resultSet.getString(10));
                contador.setRg(resultSet.getString(11));
                contador.setTelefone(resultSet.getString(12));
                contador.setUfCrc(resultSet.getString(13));
                cidade.setCidade(resultSet.getString(14));
                cidade.setUf(resultSet.getString(15));
                contador.setCidade(cidade);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return contador;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public void gravar(Contador c) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO CONTADOR (BAIRRO, CELULAR, CEP, CPF, "
                    + "CRC, EMAIL, EMISSAOCRC, ENDERECO, NOME, RG, TELEFONE, UFCRC, CIDADE, UF)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, c.getBairro());
                preparedStatement.setString(2, c.getCelular());
                preparedStatement.setString(3, c.getCep());
                preparedStatement.setString(4, c.getCpf());
                preparedStatement.setString(5, c.getCrc());
                preparedStatement.setString(6, c.getEmail());

                java.util.Date utilDate = c.getEmissaoCrc();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                preparedStatement.setDate(7, sqlDate);
//                Date dataEmissaoCrc = c.getEmissaoCrc().getTime();
//                preparedStatement.setDate(8, new java.sql.Date(dataEmissaoCrc.getTime()));
                preparedStatement.setString(8, c.getEndereco());
                preparedStatement.setString(9, c.getNome());
                preparedStatement.setString(10, c.getRg());
                preparedStatement.setString(11, c.getTelefone());
                preparedStatement.setString(12, c.getUfCrc());
                preparedStatement.setString(13, c.getCidade().getCidade());
                preparedStatement.setString(14, c.getCidade().getUf());
                preparedStatement.setString(15, c.getRg());

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

    public void alterar(Contador c) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE CONTADOR SET BAIRRO = ?, CELULAR = ?, CEP = ?, CPF = ?, "
                    + "CRC = ?, EMAIL = ?, EMISSAOCRC = ?,"
                    + "ENDERECO = ?, NOME = ?, RG = ?, TELEFONE = ?, UFCRC = ?,CIDADE = ?, UF = ?"
                    + " WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, c.getBairro());
                preparedStatement.setString(2, c.getCelular());
                preparedStatement.setString(3, c.getCep());
                preparedStatement.setString(4, c.getCpf());
                preparedStatement.setString(5, c.getCrc());

                preparedStatement.setString(6, c.getEmail());
                java.util.Date utilDate = c.getEmissaoCrc();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                preparedStatement.setDate(7, sqlDate);

//                Date dataEmissaoCrc = c.getEmissaoCrc().getTime();
//                preparedStatement.setDate(8, new java.sql.Date(dataEmissaoCrc.getTime()));
                preparedStatement.setString(8, c.getEndereco());
                preparedStatement.setString(9, c.getNome());
                preparedStatement.setString(10, c.getRg());
                preparedStatement.setString(11, c.getTelefone());
                preparedStatement.setString(12, c.getUfCrc());
                preparedStatement.setString(13, c.getCidade().getCidade());
                preparedStatement.setString(14, c.getCidade().getUf());
                preparedStatement.setLong(15, c.getId());

                preparedStatement.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            connection.rollback();
            connection.close();
            throw ex;
        }

    }

}
