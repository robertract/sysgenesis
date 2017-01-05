/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import br.com.genises.dao.DaoUsuarioLista;
import br.com.genises.model.UsuarioLista;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago
 */
public class ListaTableModel extends AbstractTableModel {

    // Lista de Sócios a serem exibidos na tabela
    private List<UsuarioLista> linhas;

    // Cria um SocioTableModel sem nenhuma linha
    public ListaTableModel() {
        linhas = new ArrayList<UsuarioLista>();
    }

    // Cria um SocioTableModel contendo a lista recebida por parâmetro
    public ListaTableModel(List<UsuarioLista> listaDeLista) {
        linhas = new ArrayList<UsuarioLista>(listaDeLista);
    }

    // Array com os nomes das colunas.
    private String[] colunas = new String[]{"LISTA", "PADRÃO"};

// Constantes representando o índice das colunas
    private static final int LISTA = 0;
    private static final int PADRAO = 1;

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case LISTA:
                return String.class;
            case PADRAO:
                return Boolean.class;

            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.

        UsuarioLista lista = linhas.get(rowIndex);

        switch (columnIndex) {
            //case NOME:
            //    return socio.getNome();
            case LISTA:
                return lista.getNome();
            case PADRAO:
                return lista.getPadrao();

            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        switch (columnIndex) {

            case LISTA:
                break;
            case PADRAO:
                break;

            default:
                throw new IndexOutOfBoundsException("column Index out of bounds");
        }

        //fireTableCellUpdated(rowIndex, columnIndex);
        fireTableCellUpdated(rowIndex, columnIndex + 1);// Notifica a atualização da célula

    }

    //movimentando lista
    // Retorna o sócio referente a linha especificada
    public UsuarioLista getLista(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    //retorna todos os produtos da lista
    public List<UsuarioLista> getListas() {
        return linhas;
    }

// Adiciona o sócio especificado ao modelo
    public void addLista(UsuarioLista produto) {
        // Adiciona o registro.
        linhas.add(produto);

        // Pega a quantidade de registros e subtrai 1 para
        // achar o último índice. A subtração é necessária
        // porque os índices começam em zero.
        int ultimoIndice = getRowCount() - 1;

        // Notifica a mudança.
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

// Remove o sócio da linha especificada.
    public void removeLista(int indiceLinha) {
        // Remove o registro.
        linhas.remove(indiceLinha);

        // Notifica a mudança.
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

// Adiciona uma lista de sócios no final da lista.
    public void addListaDelista(List<UsuarioLista> listas) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();

        // Adiciona os registros.
        linhas.addAll(listas);

        // Notifica a mudança.
        fireTableRowsInserted(indice, indice + listas.size());
    }

// Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();

        // Notifica a mudança.
        fireTableDataChanged();
    }

    public void tornaPadrao(int linhaSelecionada) throws Exception {
        DaoUsuarioLista dao = new DaoUsuarioLista();
        int a = 0;
        for (UsuarioLista u : linhas) {
            if (u.getPadrao() == true) {

                linhas.get(a).setPadrao(false);
                dao.atualizaPadrao(linhas.get(a).getId(), false);

            }
            a++;
        }
        linhas.get(linhaSelecionada).setPadrao(true);
        dao.atualizaPadrao(linhas.get(linhaSelecionada).getId(), true);
        fireTableDataChanged();
    }
}
