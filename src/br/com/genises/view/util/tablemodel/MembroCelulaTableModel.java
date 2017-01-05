/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import br.com.genises.model.Membro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrador
 */
public class MembroCelulaTableModel extends AbstractTableModel{
    private List<Membro> lista;
    private List<String> listaCampos;
    private String[] colunas = new String[]{"Id", "Nome", "CPF"};

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

    public MembroCelulaTableModel(List<String> campos) {
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

        Membro membro = lista.get(linha);

        switch (coluna) {
            case 0:
                return membro.getId();
            case 1:
                return membro.getNome();
            case 2:
                return membro.getCpf();
            
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

    public List<Membro> getLista() {
        return lista;
    }

    public void setLista(List<Membro> lista) {
        this.lista = lista;
    }
}
