/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Robert Frederico
 */
public class DaoCidade extends Dao {

    public List<Cidade> buscaCidade(String uf) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT CODIGOIBGE, CIDADE, UF FROM CIDADE WHERE UF = ? ORDER BY CIDADE";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, uf);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Cidade> cidades = new ArrayList<Cidade>();

            while (resultSet.next()) {
                Cidade cidade = new Cidade();

                cidade.setCodigoIbge(resultSet.getString(1));
                cidade.setCidade(resultSet.getString(2).trim());
                cidade.setUf(resultSet.getString(3));
                cidades.add(cidade);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return cidades;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
