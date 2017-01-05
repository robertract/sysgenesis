/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Usuario;
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
public class DaoUsuario extends Dao {

    public Usuario pesquisaUsuario(String usuario) throws Exception {

        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT  a.NOME, a.SENHA, a.USUARIO,a.ID FROM USUARIO a where a.USUARIO = ?";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, usuario);
            ResultSet resultSet = preparedStatement.executeQuery();
            Usuario user = new Usuario();
            while (resultSet.next()) {

                user.setNomeUsuario(resultSet.getString(1));
                user.setSenha(resultSet.getString(2));
                user.setUsuario(resultSet.getString(3));
                user.setId(resultSet.getLong(4));

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public List<Usuario> pesquisaFiltro(String filtro) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT  NOME, SENHA, USUARIO, ID, EMAIL FROM USUARIO  where " + filtro;
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Usuario> users = new ArrayList<>();
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setNomeUsuario(resultSet.getString(1));
                user.setSenha(resultSet.getString(2));
                user.setUsuario(resultSet.getString(3));
                user.setId(resultSet.getLong(4));
                user.setEmail(resultSet.getString(5));
                users.add(user);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return users;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void salva(Usuario u) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO USUARIO (EMAIL, NOME, SENHA, USUARIO) VALUES "
                    + "(?,?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, u.getEmail());
            preparedStatement.setString(2, u.getNomeUsuario());
            preparedStatement.setString(3, u.getSenha());
            preparedStatement.setString(4, u.getUsuario());

            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }

    }

    public void atualiza(Usuario usuario) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE USUARIO SET EMAIL = ? , NOME = ?,SENHA=?, USUARIO=? WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, usuario.getEmail());
                preparedStatement.setString(2, usuario.getNomeUsuario());
                preparedStatement.setString(3, usuario.getSenha());
                preparedStatement.setString(4, usuario.getUsuario());
                preparedStatement.setLong(5, usuario.getId());
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

    public void excluir(Usuario usuario) throws SQLException, Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "delete from USUARIO WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setLong(1, usuario.getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            ex.printStackTrace();
            throw new Exception("USUARIO USADO EM OUTRO CADASTRO, E NÃO PODERÁ SER APAGADO!!");
        }
    }

    public boolean verificaExistencia(Usuario usuarioV) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT USUARIO FROM USUARIO WHERE USUARIO = ?";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, usuarioV.getUsuario());

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
}
