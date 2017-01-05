/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.dao;

import br.com.genises.model.Fornecedor;
import br.com.genises.model.Pagar;
import br.com.genises.model.PlanoConta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago
 */
public class DaoPagar extends Dao {

    public List<Pagar> pesquisaFiltro(String filtro) throws Exception {
        Connection connection = (Connection) super.getConnection();
        try {
            //String stringSQL = "SELECT * FROM CLIENTE_FISICO WHERE nome LIKE ? ORDER BY nome";
            String stringSQL = "SELECT pagar.ID, pagar.CONTA, pagar.DATA, pagar.VENCIMENTO, pagar.VALOR, pagar.JUROS, pagar.DESCONTOS,"
                    + " pagar.DATA_PAGAMENTO, pagar.VALOR_PAGO, pagar.SITUACAO, pagar.HISTORICO, pagar.ID_PLANO_CONTA,"
                    + " pagar.VALOR_TOTAL, plano_conta.CLASSIFICACAO, fornecedor.id, fornecedor.nome  FROM PAGAR pagar , PLANO_CONTA plano_conta, FORNECEDOR fornecedor "
                    + "where pagar.ID_PLANO_CONTA=plano_conta.ID and pagar.ID_FORNECEDOR=fornecedor.ID and " + filtro;
            System.out.println(stringSQL);
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Pagar> contas = new ArrayList<>();
            while (resultSet.next()) {
                Pagar pagar = new Pagar();
                pagar.setId(resultSet.getLong(1));
                pagar.setConta(resultSet.getString(2));
                pagar.setData(resultSet.getDate(3).toLocalDate());
                pagar.setVencimento(resultSet.getDate(4).toLocalDate());
                pagar.setValor(resultSet.getBigDecimal(5));
                pagar.setJuros(resultSet.getBigDecimal(6));
                pagar.setDescontos(resultSet.getBigDecimal(7));
                if (resultSet.getDate(8) != null) {
                    pagar.setDataPagamento(resultSet.getDate(8).toLocalDate());
                }
                pagar.setValorPago(resultSet.getBigDecimal(9));
                pagar.setSituacao(resultSet.getString(10));
                pagar.setHistorico(resultSet.getString(11));
                PlanoConta plano = new PlanoConta();
                plano.setId(resultSet.getLong(12));
                pagar.setValorTotal(resultSet.getBigDecimal(13));
                plano.setClassificacao(resultSet.getString(14));
                Fornecedor f = new Fornecedor();
                f.setId(resultSet.getLong(15));
                f.setNome(resultSet.getString(16));
                pagar.setFornecedor(f);
                pagar.setPlano(plano);

                contas.add(pagar);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return contas;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void excluir(Pagar pagar) throws Exception {
        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "delete from PAGAR WHERE ID = ?";

            try (PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL)) {

                preparedStatement.setLong(1, pagar.getId());
                preparedStatement.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            ex.printStackTrace();
            throw new Exception("REGISTRO NÃO PODERÁ SER APAGADO!!");
        }

    }

    public void salvar(Pagar pagar) throws Exception {

        java.sql.Connection connection = super.getConnection();
        try {
            connection.setAutoCommit(false);
            String stringSQL = "INSERT INTO PAGAR (CONTA, DATA, "
                    + "VENCIMENTO, VALOR, JUROS, DESCONTOS, DATA_PAGAMENTO, "
                    + "VALOR_PAGO, SITUACAO, HISTORICO, ID_PLANO_CONTA, ID_FORNECEDOR) "
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(stringSQL);

            preparedStatement.setString(1, pagar.getConta());
            preparedStatement.setDate(2, Date.valueOf(pagar.getData()));
            preparedStatement.setDate(3, Date.valueOf(pagar.getVencimento()));
            preparedStatement.setBigDecimal(4, pagar.getValor());
            preparedStatement.setBigDecimal(5, pagar.getJuros());
            preparedStatement.setBigDecimal(6, pagar.getDescontos());
            try {
                preparedStatement.setDate(7, Date.valueOf(pagar.getDataPagamento()));
            } catch (Exception e) {
                preparedStatement.setDate(7, null);
            }
            preparedStatement.setBigDecimal(8, pagar.getValorPago());
            preparedStatement.setString(9, pagar.getSituacao());
            preparedStatement.setString(10, pagar.getHistorico());
            try {
                preparedStatement.setLong(11, pagar.getPlano().getId());
            } catch (Exception e) {
                preparedStatement.setNull(11, 0);
            }
            preparedStatement.setLong(12, pagar.getFornecedor().getId());
            preparedStatement.executeUpdate();

            connection.commit();
            connection.close();

        } catch (Exception ex) {
            connection.rollback();
            connection.close();
            throw ex;
        }
    }

}
