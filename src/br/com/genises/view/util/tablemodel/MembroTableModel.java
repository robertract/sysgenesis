/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import br.com.genises.model.Membro;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago
 */
public class MembroTableModel extends AbstractTableModel {

    private List<Membro> lista;

    public MembroTableModel() {
        lista = new ArrayList<>();
    }

    public void adiciona(Membro object) {
        lista.add(object);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void adicionaList(List<Membro> objects) {
        this.lista = objects;
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        int colunas = 0;
        for (Method metodo : Membro.class.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Tabela.class)) {
                colunas++;
            }
        }
        return colunas;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        try {
            Object objeto = lista.get(linha);
            for (Method metodo : Membro.class.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.posicao() == coluna) {
                        return metodo.invoke(objeto);
                    }
                }
            }
        } catch (Exception e) {
            return "Erro";
        }
        return "";
    }

    @Override
    public String getColumnName(int coluna) {
        for (Method metodo : Membro.class.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Tabela.class)) {
                Tabela anotacao = metodo.getAnnotation(Tabela.class);
                if (anotacao.posicao() == coluna) {
                    return anotacao.nome();
                }
            }
        }
        return "";
    }

    public void clear() {
        lista.clear();
        fireTableDataChanged();
    }
}
