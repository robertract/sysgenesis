/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.UsuarioLista;
import br.com.genises.model.UsuarioListaItens;
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
public class DaoUsuarioLista extends Dao {

    public List<UsuarioLista> pesquisaListaUsuario(long usuario, String classe) throws Exception {

        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.NOME, a.USUARIO, a.PADRAO, a.CLASS FROM USUARIO_LISTA a"
                    + " where a.USUARIO = ? and a.CLASS=?";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setLong(1, usuario);
            preparedStatement.setString(2, classe);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UsuarioLista> listas = new ArrayList<>();
            while (resultSet.next()) {
                UsuarioLista u = new UsuarioLista();
                u.setId(resultSet.getLong(1));
                u.setNome(resultSet.getString(2));
                u.setPadrao(resultSet.getBoolean(4));
                u.setClasse(resultSet.getString(5));
                listas.add(u);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return listas;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public void salvaLista(UsuarioLista u) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO USUARIO_LISTA (NOME, USUARIO, PADRAO, CLASS) VALUES "
                    + "(?,?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, u.getNome());
            preparedStatement.setLong(2, u.getUsuario().getId());
            preparedStatement.setBoolean(3, u.getPadrao());

            preparedStatement.setString(4, u.getClasse());

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();
            long id = buscaUltimo();
            for (UsuarioListaItens a : u.getItens()) {
                adicionaItem(a, id);
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    private long buscaUltimo() throws Exception {

        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT max(a.ID) FROM USUARIO_LISTA a";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return 0;

    }

    private void adicionaItem(UsuarioListaItens a, long id) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO USUARIO_LISTA_ITENS (LISTA, CAMPO, TAMANHO) values"
                    + "(?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, a.getCampo());
            preparedStatement.setInt(3, a.getTamanho());

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();
        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }

    }

    public List<String> verificaPadrao(String classe, Long id) throws Exception {

        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.ID, a.NOME, a.USUARIO, a.PADRAO, a.CLASS FROM USUARIO_LISTA a"
                    + " where a.USUARIO = ? and a.CLASS=? and a.padrao='Y'";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, classe);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                return listasCamposListaPadrao(resultSet.getLong(1));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return null;

    }

    public List<String> listasCamposListaPadrao(Long id) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT a.campo FROM USUARIO_LISTA_ITENS a where a.lista=?";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> listas = new ArrayList<>();
            while (resultSet.next()) {

                listas.add(resultSet.getString(1));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return listas;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public void atualizaPadrao(long id, boolean b) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE USUARIO_LISTA SET PADRAO = ? WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setBoolean(1, b);
                preparedStatement.setLong(2, id);
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

    public void excluir(long lista) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "delete from USUARIO_LISTA WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setLong(1, lista);
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
