/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import br.com.genises.model.Celula;
import br.com.genises.model.Usuario;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Tiago
 */
public class CelulasTableModel extends AbstractTableModel {

    private List<Celula> lista;
    private List<String> listaCampos;
    private String[] colunas = new String[]{"Nome", "Lider", "Dia", "Hora"};

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

    public CelulasTableModel(List<String> campos) {
        lista = new ArrayList<>();
        this.listaCampos = campos;
    }

    public void adiciona(Celula object) {
        lista.add(object);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void adicionaList(List<Celula> objects) {
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
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        //  for (String a : listaCampos) {
        //  for (int i = 0; i < listaCampos.size(); i++) {
//        try {
//            Object objeto = lista.get(linha);
//            for (Method metodo : Celula.class.getDeclaredMethods()) {
//                if (metodo.isAnnotationPresent(Tabela.class)) {
//                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
//                    if (anotacao.nome().equals(getColumnName(coluna))) {
//                        return metodo.invoke(objeto);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            return "Erro";
//        }
//        return "";
//        }
//        return "";

        Celula celula = lista.get(linha);

        switch (coluna) {
            case 0:
                return celula.getNome();
            case 1:
                return celula.getLider().getNome();
            case 2:
                return celula.getDia();
            case 3:
                return celula.getHora();
            default:
                // Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

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
//        int col = 0;
//        for (String a : listaCampos) {
//            if (col == coluna) {
//                return a;
//            }
//            col++;
//        }

        return colunas[coluna];
    }

    public void clear() {

        lista.clear();

        fireTableDataChanged();

    }

    public List<Celula> getLista() {
        return lista;
    }

    public void setLista(List<Celula> lista) {
        this.lista = lista;
    }

}
