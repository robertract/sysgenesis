/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Celula;
import br.com.genises.model.Cidade;
import br.com.genises.model.Membro;
import br.com.genises.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class DaoCelula extends Dao {

    public void gravar(Celula c) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO CELULA (BAIRRO, CEP, DIA, ENDERECO, "
                    + "HORA, NOME, CIDADE, UF, ID_LIDER, ID_ANFITRIAO, "
                    + "ID_LIDER_TREINAMENTO, ID_SUPERVISOR) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, c.getBairro());
                preparedStatement.setString(2, c.getCep());
                preparedStatement.setString(3, c.getDia());
                preparedStatement.setString(4, c.getEndereco());
                preparedStatement.setString(5, c.getHora());
                preparedStatement.setString(6, c.getNome());
                preparedStatement.setString(7, c.getCidade().getCidade());
                preparedStatement.setString(8, c.getCidade().getUf());
                preparedStatement.setLong(9, c.getLider().getId());
                preparedStatement.setLong(10, c.getAnfitriao().getId());
                preparedStatement.setLong(11, c.getLiderTreinamemto().getId());
                preparedStatement.setLong(12, c.getSupervisor().getId());

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

    public void update(Celula c) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE CELULA SET BAIRRO = ?, CEP = ?, DIA = ?, ENDERECO = ?, "
                    + "HORA = ?, NOME = ?, CIDADE = ?, UF = ?, ID_LIDER = ?, ID_ANFITRIAO = ?, "
                    + "ID_LIDER_TREINAMENTO = ?, ID_SUPERVISOR = ? WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, c.getBairro());
                preparedStatement.setString(2, c.getCep());
                preparedStatement.setString(3, c.getDia());
                preparedStatement.setString(4, c.getEndereco());
                preparedStatement.setString(5, c.getHora());
                preparedStatement.setString(6, c.getNome());
                preparedStatement.setString(7, c.getCidade().getCidade());
                preparedStatement.setString(8, c.getCidade().getUf());
                preparedStatement.setLong(9, c.getLider().getId());
                preparedStatement.setLong(10, c.getAnfitriao().getId());
                preparedStatement.setLong(11, c.getLiderTreinamemto().getId());
                preparedStatement.setLong(12, c.getSupervisor().getId());
                preparedStatement.setLong(13, c.getId());

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

    public List<Celula> pesquisaCelula(String pesquisar) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT C.NOME AS NOME_CELULA, C.ENDERECO, C.BAIRRO, C.CEP, C.DIA, C.HORA, C.ID AS ID_CELULA,\n"
                    + "C.uf, C.cidade, C.id_lider, C.id_lider_treinamento, C.id_supervisor, C.id_anfitriao,\n"
                    + "LI.nome AS NOME_LIDER, LI.telefone, LI.celular,\n"
                    + "LT.nome AS NOME_LIDER_TREINAMENTO, LT.telefone, LT.celular,\n"
                    + "S.nome AS NOME_SUPERVISOR, S.telefone, S.celular,\n"
                    + "A.nome AS NOME_ANFITRIAO, A.telefone, A.celular\n"
                    + "FROM CELULA C, membros LI, MEMBROS LT, MEMBROS S, MEMBROS A\n"
                    + "WHERE S.ID = C.id_supervisor AND A.id = C.id_anfitriao\n"
                    + "AND LT.id = C.id_lider_treinamento AND LI.id = C.id_lider\n"
                    + "AND C.NOME LIKE ? ORDER BY C.NOME";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, pesquisar);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Celula> celulas = new ArrayList<>();
            while (resultSet.next()) {
                Membro li = new Membro();
                Membro lt = new Membro();
                Membro s = new Membro();
                Membro a = new Membro();
                Cidade ci = new Cidade();
                Celula celula = new Celula();
                celula.setNome(resultSet.getString(1));
                celula.setEndereco(resultSet.getString(2));
                celula.setBairro(resultSet.getString(3));
                celula.setCep(resultSet.getString(4));
                celula.setDia(resultSet.getString(5));
                celula.setHora(resultSet.getString(6));
                celula.setId(resultSet.getLong(7));
                ci.setUf(resultSet.getString(8));
                ci.setCidade(resultSet.getString(9));
                li.setId(resultSet.getLong(10));
                lt.setId(resultSet.getLong(11));
                s.setId(resultSet.getLong(12));
                a.setId(resultSet.getLong(13));
                li.setNome(resultSet.getString(14));
                li.setTelefone(resultSet.getString(15));
                li.setCelular(resultSet.getString(16));
                lt.setNome(resultSet.getString(17));
                lt.setTelefone(resultSet.getString(18));
                lt.setCelular(resultSet.getString(19));
                s.setNome(resultSet.getString(20));
                s.setTelefone(resultSet.getString(21));
                s.setCelular(resultSet.getString(22));
                a.setNome(resultSet.getString(23));
                a.setTelefone(resultSet.getString(24));
                a.setCelular(resultSet.getString(25));
                celula.setLider(li);
                celula.setLiderTreinamemto(lt);
                celula.setSupervisor(s);
                celula.setAnfitriao(a);
                celula.setCidade(ci);

                celulas.add(celula);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return celulas;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw ex;
        }

    }

    public List<Celula> listarCelulas() throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT ID, NOME FROM CELULA ORDER BY NOME";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Celula> celulas = new ArrayList<>();
            while (resultSet.next()) {
                Celula celula = new Celula();
                celula.setId(resultSet.getLong(1));
                celula.setNome(resultSet.getString(2));

                celulas.add(celula);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return celulas;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw ex;
        }

    }

    public List<Membro> pesquisarMembros(long id) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT CM.ID_CELULA, CM.ID_MEMBRO, M.ID, M.NOME, M.CPF, "
                    + "C.ID FROM celula_membro CM, CELULA C, MEMBROS M \n"
                    + "WHERE CM.id_celula = c.id AND CM.id_membro = M.id AND C.id = ?";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Membro> membros = new ArrayList<>();
            while (resultSet.next()) {
                Membro m = new Membro();
                m.setId(resultSet.getLong(3));
                m.setNome(resultSet.getString(4));
                m.setCpf(resultSet.getString(5));

                membros.add(m);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return membros;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            throw ex;
        }

    }

    public void gravarMembro(Membro membroSelecionado, Celula celulaSelecionada) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO CELULA_MEMBRO (ID_MEMBRO, ID_CELULA) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setLong(1, membroSelecionado.getId());
                preparedStatement.setLong(2, celulaSelecionada.getId());

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

    public boolean verificaExistencia(Celula celulaV) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            String stringSQL = "SELECT NOME FROM CELULA WHERE NOME = ?";
//            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, celulaV.getNome());

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
