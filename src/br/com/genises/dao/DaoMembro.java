/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Membro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rober
 */
public class DaoMembro extends Dao {

    public boolean verificaExistencia(String cpf) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT  ID FROM MEMBROS WHERE CPF = ?";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, cpf);
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

    public void gravar(Membro m) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO MEMBROS (NOME, ENDERECO, BAIRRO, CEP, "
                    + "UF, CIDADE, TELEFONE, CELULAR, EMAIL, CPF, RG, ORGAO_EMISSOR, "
                    + "UF_RG, PAI, MAE, DATA_NASCIMENTO, LOCAL_NASCIMENTO, UF_NASCIMENTO, "
                    + "ESTADO_CIVIL, NOME_CONJUGUE, FILHOS, BATISMO_AGUAS, "
                    + "MINISTRO, VEIO_OUTRA_IGREJA, NOME_OUTRA_IGREJA, CARGO1, LIDER_CELULA, "
                    + "LIDER_TREINAMENTO, ANFITRIAO_CELULA, ANFITRIAO_ONDE, PERTENCE_CELULA, "
                    + "DISCIPULADO, NOME_DISCIPULADOR, OBS, CARGO2, CARGO3)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setString(1, m.getNome());
                preparedStatement.setString(2, m.getEndereco());
                preparedStatement.setString(3, m.getBairro());
                preparedStatement.setString(4, m.getCep());
                preparedStatement.setString(5, m.getCidade().getUf());
                preparedStatement.setString(6, m.getCidade().getCidade());
                preparedStatement.setString(7, m.getTelefone());
                preparedStatement.setString(8, m.getCelular());
                preparedStatement.setString(9, m.getEmail());
                preparedStatement.setString(10, m.getCpf());
                preparedStatement.setString(11, m.getRg());
                preparedStatement.setString(12, m.getOrgaoEmissor());
                preparedStatement.setString(13, m.getUfRg());
                preparedStatement.setString(14, m.getPai());
                preparedStatement.setString(15, m.getMae());

                java.util.Date utilDateNasc = m.getNascimento();
                java.sql.Date sqlDateNasc = new java.sql.Date(utilDateNasc.getTime());
                preparedStatement.setDate(16, sqlDateNasc);

                preparedStatement.setString(17, m.getNaturalDe());
                preparedStatement.setString(18, m.getUfNascimento());
                preparedStatement.setString(19, m.getEstadoCivil());

                preparedStatement.setString(20, m.getConjugue());
                preparedStatement.setString(21, m.getFilhos());

                java.util.Date utilDateBat = m.getBatismoAgua();
                java.sql.Date sqlDateBat = new java.sql.Date(utilDateBat.getTime());
                preparedStatement.setDate(22, sqlDateBat);

                preparedStatement.setString(23, m.getNomeMinistro());
                preparedStatement.setBoolean(24, m.isOutraIgreja());
                preparedStatement.setString(25, m.getNomeIgreja());
                preparedStatement.setString(26, m.getCargo1());
                preparedStatement.setBoolean(27, m.isLiderCelula());
                preparedStatement.setBoolean(28, m.isLidertreinamento());
                preparedStatement.setBoolean(29, m.isAnfitriao());
                preparedStatement.setString(30, m.getAnfitriaoOnde());
                preparedStatement.setBoolean(31, m.isCelula());
                preparedStatement.setBoolean(32, m.isDiscipulado());
                preparedStatement.setString(33, m.getNomeDiscipulador());
                preparedStatement.setString(34, m.getObs());
                preparedStatement.setString(35, m.getCargo2());
                preparedStatement.setString(36, m.getCargo3());

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

    public List<Membro> pesquisarMembros(String pesquisar) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT ID, NOME, TELEFONE, CELULAR, CPF FROM MEMBROS WHERE NOME LIKE ? ORDER BY NOME";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setString(1, "%" + pesquisar + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Membro> membros = new ArrayList<Membro>();

            while (resultSet.next()) {
                Membro m = new Membro();

                m.setId(resultSet.getInt("ID"));
                m.setNome(resultSet.getString("NOME"));
                m.setTelefone(resultSet.getString("TELEFONE"));
                m.setCelular(resultSet.getString("CELULAR"));
                m.setCpf(resultSet.getString("CPF"));
                membros.add(m);

            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return membros;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
