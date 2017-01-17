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
public class MembrasiaTableModel extends AbstractTableModel {

    private List<Membro> lista;
    private List<String> listaCampos;

    public List<String> getListaCampos() {
        return listaCampos;
    }

    public void setListaCampos(List<String> listaCampos) {
        this.listaCampos = listaCampos;
//        List<Usuario> u = new ArrayList<Usuario>();
//        u = lista;
//        clear();
//        adicionaList(u);
        fireTableStructureChanged();
    }

    public MembrasiaTableModel(List<String> campos) {
        lista = new ArrayList<>();
        this.listaCampos = campos;
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
//        int colunas = 0;
//
//        for (Method metodo : Usuario.class.getDeclaredMethods()) {
//            if (metodo.isAnnotationPresent(Tabela.class)) {
//                colunas++;
//            }
//        }
        return listaCampos.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        //  for (String a : listaCampos) {
        //  for (int i = 0; i < listaCampos.size(); i++) {
        try {
            Object objeto = lista.get(linha);
            for (Method metodo : Membro.class.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.nome().equals(getColumnName(coluna))) {
                        return metodo.invoke(objeto);
                    }
                }
            }
        } catch (Exception e) {
            return "Erro";
        }
        return "";
//        }
//        return "";

    }

    @Override
    public String getColumnName(int coluna) {
//        
//        for (Method metodo : Usuario.class.getDeclaredMethods()) {
//            if (metodo.isAnnotationPresent(Tabela.class)) {
//                Tabela anotacao = metodo.getAnnotation(Tabela.class);
//                if (anotacao.posicao() == coluna) {
//                    return anotacao.nome();
//                }
//            }
//        }
        int col = 0;
        for (String a : listaCampos) {
            if (col == coluna) {
                return a;
            }
            col++;
        }

        return "";
    }

    public void clear() {

        lista.clear();

        fireTableDataChanged();

    }

    public List<Membro> getLista() {
        return lista;
    }

    public void setLista(List<Membro> lista) {
        this.lista = lista;
    }

}
