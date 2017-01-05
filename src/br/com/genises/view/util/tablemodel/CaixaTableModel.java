/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.tablemodel;

import br.com.genises.model.Caixa;
import br.com.genises.model.Pagar;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import static tools.devnull.trugger.scan.ClassScan.scan;


/**
 *
 * @author Tiago
 */
public class CaixaTableModel extends AbstractTableModel {

    private List<Caixa> lista;
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

    public CaixaTableModel(List<String> campos) {
        lista = new ArrayList<>();
        this.listaCampos = campos;
    }

    public void adiciona(Caixa object) {
        lista.add(object);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void adicionaList(List<Caixa> objects) {
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
            for (Method metodo : Caixa.class.getDeclaredMethods()) {
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

                    } else {

                        if (anotacao.nome().equals(getColumnName(coluna))) {
                            return metodo.invoke(objeto);
                        }

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

    public List<Caixa> getLista() {
        return lista;
    }

    public void setLista(List<Caixa> lista) {
        this.lista = lista;
    }

}
