/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cidade;
import br.com.genises.model.ResponsavelLegal;
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
public class DaoResponsavel extends Dao {

    public ResponsavelLegal pesquisaResponsavel() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.BAIRRO, a.CELULAR, a.CEP, a.CPF, "
                    + "a.EMISSAO_RG, a.EMAIL,"
                    + "a.ENDERCO, a.NOME, a.ORGAO_EMISSOR, a.RG, a.TELEFONE, "
                    + "a.UF_RG, a.CIDADE, a.UF FROM RESPONSAVEL a";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResponsavelLegal r = new ResponsavelLegal();
            Cidade cidade = new Cidade();

            if (resultSet.next()) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
                Calendar jData = new GregorianCalendar();

                r.setId(resultSet.getInt(1));
                r.setBairro(resultSet.getString(2));
                r.setCelular(resultSet.getString(3));
                r.setCep(resultSet.getString(4));
                r.setCpf(resultSet.getString(5));

                Date dataEmissao = resultSet.getDate(6);

                jData.setTime(dataEmissao);
                r.setEmissaoRg(jData);

                r.setEmail(resultSet.getString(7));

                r.setEndereco(resultSet.getString(8));
                r.setNome(resultSet.getString(9));
                r.setOrgaoEmissor(resultSet.getString(10));
                r.setRg(resultSet.getString(11));
                r.setTelefone(resultSet.getString(12));
                r.setUfRg(resultSet.getString(13));
                cidade.setCidade(resultSet.getString(14));
                cidade.setUf(resultSet.getString(15));
                r.setCidade(cidade);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return r;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public void gravar(ResponsavelLegal r) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO RESPONSAVEL (BAIRRO, CELULAR, CEP, CPF, "
                    + "EMISSAO_RG, EMAIL,"
                    + "ENDERCO, NOME, ORGAO_EMISSOR, RG, TELEFONE, UF_RG, CIDADE, UF) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, r.getBairro());
                preparedStatement.setString(2, r.getCelular());
                preparedStatement.setString(3, r.getCep());
                preparedStatement.setString(4, r.getCpf());

                Date dataEmissao = r.getEmissaoRg().getTime();
                preparedStatement.setDate(5, new java.sql.Date(dataEmissao.getTime()));

                preparedStatement.setString(6, r.getEmail());

                preparedStatement.setString(7, r.getEndereco());
                preparedStatement.setString(8, r.getNome());
                preparedStatement.setString(9, r.getOrgaoEmissor());
                preparedStatement.setString(10, r.getRg());
                preparedStatement.setString(11, r.getTelefone());
                preparedStatement.setString(12, r.getUfRg());
                preparedStatement.setString(13, r.getCidade().getCidade());
                preparedStatement.setString(14, r.getCidade().getUf());

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

    public void alterar(ResponsavelLegal r) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE RESPONSAVEL SET BAIRRO = ?, CELULAR = ?, CEP = ?, CPF = ?, "
                    + "EMISSAO_RG = ?, EMAIL = ?,"
                    + "ENDERCO = ?, NOME = ?, ORGAO_EMISSOR = ?, RG = ?, TELEFONE = ?, UF_RG = ?, CIDADE = ?, UF = ?"
                    + " WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, r.getBairro());
                preparedStatement.setString(2, r.getCelular());
                preparedStatement.setString(3, r.getCep());
                preparedStatement.setString(4, r.getCpf());

                Date dataEmissao = r.getEmissaoRg().getTime();
                preparedStatement.setDate(5, new java.sql.Date(dataEmissao.getTime()));

                preparedStatement.setString(6, r.getEmail());

                preparedStatement.setString(7, r.getEndereco());
                preparedStatement.setString(8, r.getNome());
                preparedStatement.setString(9, r.getOrgaoEmissor());
                preparedStatement.setString(10, r.getRg());
                preparedStatement.setString(11, r.getTelefone());
                preparedStatement.setString(12, r.getUfRg());
                preparedStatement.setString(13, r.getCidade().getCidade());
                preparedStatement.setString(14, r.getCidade().getUf());
                preparedStatement.setLong(15, r.getId());

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
