/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Cidade;
import br.com.genises.model.Membro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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

    public List<Membro> pesquisarMembrosGUI(String pesquisar) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT MEMBRO.ID, MEMBRO.NOME, MEMBRO.TELEFONE, MEMBRO.CELULAR, MEMBRO.CPF "
                    + "FROM MEMBROS MEMBRO WHERE " + pesquisar + " ORDER BY NOME";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
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

    public void excluir(Membro get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Membro pesquisaCompleta(Membro membro) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT ID, NOME, ENDERECO, BAIRRO, CEP, "
                    + "UF, CIDADE, TELEFONE, CELULAR, EMAIL, CPF, RG,"
                    + "PAI, MAE, DATA_NASCIMENTO, ESTADO_CIVIL, BATISMO_AGUAS, "
                    + "MINISTRO, CARGO1, LIDER_CELULA, LIDER_TREINAMENTO, "
                    + "ANFITRIAO_CELULA, PERTENCE_CELULA, DISCIPULADO, NOME_DISCIPULADOR, "
                    + "OBS, CARGO2, CARGO3 FROM MEMBROS WHERE ID = ?";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            preparedStatement.setLong(1, membro.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            Membro m = new Membro();
            while (resultSet.next()) {
                Cidade cidade = new Cidade();
                m.setId(resultSet.getInt("ID"));
                m.setNome(resultSet.getString("NOME"));
                m.setEndereco(resultSet.getString("ENDERECO"));
                m.setBairro(resultSet.getString("BAIRRO"));
                m.setCep(resultSet.getString("CEP"));
                cidade.setCidade(resultSet.getString("CIDADE"));
                cidade.setUf(resultSet.getString("UF"));
                m.setTelefone(resultSet.getString("TELEFONE"));
                m.setCelular(resultSet.getString("CELULAR"));
                m.setEmail(resultSet.getString("EMAIL"));
                m.setCpf(resultSet.getString("CPF"));
                m.setRg(resultSet.getString("RG"));
                m.setPai(resultSet.getString("PAI"));
                m.setMae(resultSet.getString("MAE"));

//                String dataNascimento = resultSet.getString("DATA_NASCIMENTO");
//                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                java.util.Date dataNascimentoForm;
//                dataNascimentoForm = formato.parse(dataNascimento);
                m.setNascimento(resultSet.getDate("DATA_NASCIMENTO"));

                m.setEstadoCivil(resultSet.getString("ESTADO_CIVIL"));

//                String dataBatismo = resultSet.getString("BATISMO_AGUAS");
//                java.util.Date dataBatismoForm;
//                dataBatismoForm = formato.parse(dataBatismo);
                m.setBatismoAgua(resultSet.getDate("BATISMO_AGUAS"));
                m.setNomeMinistro(resultSet.getString("MINISTRO"));
                m.setCargo1(resultSet.getString("CARGO1"));
                m.setLiderCelula(resultSet.getBoolean("LIDER_CELULA"));

                m.setLidertreinamento(resultSet.getBoolean("LIDER_TREINAMENTO"));
                m.setAnfitriao(resultSet.getBoolean("ANFITRIAO_CELULA"));
                m.setCelula(resultSet.getBoolean("PERTENCE_CELULA"));
                m.setDiscipulado(resultSet.getBoolean("DISCIPULADO"));
                m.setNomeDiscipulador(resultSet.getString("NOME_DISCIPULADOR"));
                m.setObs(resultSet.getString("OBS"));
                m.setCargo2(resultSet.getString("CARGO2"));
                m.setCargo3(resultSet.getString("CARGO3"));
                m.setCidade(cidade);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return m;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }

    }

    public void update(Membro m) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "UPDATE MEMBROS SET NOME = ?, ENDERECO = ?, BAIRRO = ?, CEP = ?, "
                    + "UF = ?, CIDADE  = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?, CPF = ?, RG = ?, ORGAO_EMISSOR = ?, "
                    + "UF_RG = ?, PAI = ?, MAE = ?, DATA_NASCIMENTO = ?, LOCAL_NASCIMENTO = ?, UF_NASCIMENTO = ?, "
                    + "ESTADO_CIVIL = ?, NOME_CONJUGUE = ?, FILHOS = ?, BATISMO_AGUAS = ?, "
                    + "MINISTRO = ?, VEIO_OUTRA_IGREJA = ?, NOME_OUTRA_IGREJA = ?, CARGO1 = ?, LIDER_CELULA = ?, "
                    + "LIDER_TREINAMENTO = ?, ANFITRIAO_CELULA = ?, ANFITRIAO_ONDE = ?, PERTENCE_CELULA = ?, "
                    + "DISCIPULADO = ?, NOME_DISCIPULADOR = ?, OBS = ?, CARGO2 = ?, CARGO3 = ? WHERE ID = ?";

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
                preparedStatement.setLong(37, m.getId());

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
