/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cidade;
import br.com.genises.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class DaoFornecedor extends Dao {

    public List<Fornecedor> pesquisaFiltro(String filtro) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT  ID, NOME, CPF_CNPJ, IE, ENDERECO, NUMERO, "
                    + "COMPLEMENTO, BAIRRO, OBS, CIDADE FROM FORNECEDOR  WHERE " + filtro;
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            while (resultSet.next()) {
                Fornecedor f = new Fornecedor();
                Cidade cid = new Cidade();
                f.setId(resultSet.getLong(1));
                f.setNome(resultSet.getString(2));
                f.setCnpjCpf(resultSet.getString(3));
                f.setIe(resultSet.getString(4));
                f.setEndereco(resultSet.getString(5));
                f.setNumero(resultSet.getString(6));
                f.setComplemento(resultSet.getString(7));
                f.setBairro(resultSet.getString(8));
                f.setObservacao(resultSet.getString(9));
                cid.setCidade(resultSet.getString(10));
                f.setCidade(cid);

                fornecedores.add(f);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println(fornecedores.size());
            return fornecedores;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }

    }

    public void excluir(Fornecedor f) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "delete from fornecedores where id=?";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, f.getNome());
            

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }
    }

    public void save(Fornecedor f) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO FORNECEDOR (NOME, CPF_CNPJ, IE, ENDERECO, "
                    + "NUMERO, COMPLEMENTO, BAIRRO, OBS, ID_CIDADE) VALUES "
                    + "(?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, f.getNome());
            preparedStatement.setString(2, f.getCnpjCpf());
            preparedStatement.setString(3, f.getIe());
            preparedStatement.setString(4, f.getEndereco());
            preparedStatement.setString(5, f.getNumero());
            preparedStatement.setString(6, f.getComplemento());
            preparedStatement.setString(7, f.getBairro());
            preparedStatement.setString(8, f.getObservacao());
            preparedStatement.setString(9, f.getCidade().getCodigoIbge());

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }
    }

    public void update(Fornecedor fornecedor) {
        
    }

    public boolean verificaCpfCnpj(String text) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT  ID FROM FORNECEDOR WHERE CPF_CNPJ = ?";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, text);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public List<Fornecedor> list() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.NOME from fornecedor a";
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            while (resultSet.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(resultSet.getLong(1));
                f.setNome(resultSet.getString(2));
                fornecedores.add(f);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return fornecedores;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
