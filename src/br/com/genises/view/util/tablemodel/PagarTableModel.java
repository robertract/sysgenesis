/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import br.com.genises.model.Pagar;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import static tools.devnull.trugger.scan.ClassScan.scan;

/**
 *
 * @author Tiago
 */
public class PagarTableModel extends AbstractTableModel {

    private List<Pagar> lista;
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

    public PagarTableModel(List<String> campos) {
        lista = new ArrayList<>();
        this.listaCampos = campos;
    }

    public void adiciona(Pagar object) {
        try{
        lista.add(object);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
        }catch(Throwable e){
            e.printStackTrace();
        }
    }

    public void adicionaList(List<Pagar> objects) {
        this.lista = objects;
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        try {
            for (Method metodo : Pagar.class.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.nome().equals(getColumnName(columnIndex))) {
                        if (anotacao.tipoAtributo().equals("boolean")) {
                            return true;

                        }
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        try {
            for (Method metodo : Pagar.class.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.nome().equals(getColumnName(columnIndex))) {
                        if (anotacao.tipoAtributo().equals("boolean")) {
                            return Boolean.class;

                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        return String.class;
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
            for (Method metodo : Pagar.class.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);

                    if (anotacao.tipoAtributo().equals("object")) {
                        Object obje = metodo.invoke(objeto);
                        List<Class> classes = scan().classes().deep().in("br.com.genises.model");
                        //   System.out.println(obje);
                        for (Class c : classes) {
                            if (c.equals(obje.getClass())) {
                                //        System.out.println(c.getClass() + "São objetos iguais" + c);

                                for (Method metodoInterno : c.getDeclaredMethods()) {
                                    if (metodoInterno.isAnnotationPresent(Tabela.class)) {
                                        Tabela anotacaoInterno = metodoInterno.getAnnotation(Tabela.class);
                                        if (anotacaoInterno.visivelOutraTela() == true) {
                                            if (anotacaoInterno.nomeOutraTela().equals(getColumnName(coluna))) {
                                                return metodoInterno.invoke(obje);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    } else if (anotacao.nome().equals(getColumnName(coluna))) {
                        return metodo.invoke(objeto);
                    }
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
            return " ";
        }
        return "";
//        }
//        return "";

    }

    @Override
    public String getColumnName(int coluna) {

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

    public List<Pagar> getLista() {
        return lista;
    }

    public void setLista(List<Pagar> lista) {
        this.lista = lista;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            for (Method metodo : Pagar.class.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.nome().equals(getColumnName(columnIndex))) {
                        if (anotacao.tipoAtributo().equals("boolean")) {
                            //System.out.println("Passou 1");
                            Pagar p = new Pagar();
                            Boolean a = (Boolean) metodo.invoke(lista.get(rowIndex));

                            for (Field fld : p.getClass().getDeclaredFields()) {
                                //System.out.println("Passou 2");
                               // System.out.println("a " + a);
                                if (fld.getName().equals("selecionado")) {
                                    fld.setAccessible(true);
                                    if (a == true) {
                                        //System.out.println("Passou 3");
                                        fld.set(lista.get(rowIndex), false);
                                    } else {
                                        //System.out.println("Passou 4");
                                        fld.set(lista.get(rowIndex), true);
                                    }
                                }

                            }

                        }
                    }
                }
            }
        } catch (Exception e) {

        }

        //System.out.println(m.getNome());
    }
}
