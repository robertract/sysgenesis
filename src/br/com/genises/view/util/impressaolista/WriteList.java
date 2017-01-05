/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.impressaolista;

import br.com.genises.view.util.mensages.JOptionPaneUtil;
import br.com.genises.view.util.tablemodel.Tabela;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tiago
 */
public class WriteList {

    private List<Object> objetos;
    private List<String> campos;
    private String tipo;

    public WriteList(List<Object> objetos, List<String> campos, String tipo) {
        this.objetos = objetos;
        this.campos = campos;
        this.tipo = tipo;
    }

    public void gerar() {
        try {
            File file;
            if (tipo.equals("html")) {
                file = new File("c:/genesis/G_Relatorio.html");
                if (file.exists()) {
                    file.delete();
                }
//            //Cria o arquivo:  
                file.createNewFile();
                FileWriter writerHtml = new FileWriter(file, true);
                PrintWriter printWriterHtml = new PrintWriter(writerHtml, true);
                printWriterHtml.println("<html><head><meta charset=\"utf-8\"></head><body>");
                printWriterHtml.println("<table  border=\"1\">");
                printWriterHtml.print("<tr>");
                for (String a : campos) {
                    printWriterHtml.print("<th>" + a + "</th>");
                }
                printWriterHtml.print(" <tr>");
                printWriterHtml.print(" <tr>");
                for (Object o : objetos) {
                    for (String a : campos) {
                        for (Method metodo : o.getClass().getDeclaredMethods()) {
                            if (metodo.isAnnotationPresent(Tabela.class)) {
                                Tabela anotacao = metodo.getAnnotation(Tabela.class);
                                if (anotacao.nome().equals(a)) {
                                    printWriterHtml.print("<th>" + metodo.invoke(o) + "</th>");
                                }
                            }
                        }

                    }
                    printWriterHtml.print(" <tr>");
                }

                printWriterHtml.println("<html><body>");
                printWriterHtml.close();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            Runtime.getRuntime().exec("cmd /c " + "c:/genesis/G_Relatorio.html");
        } catch (IOException ex) {
            JOptionPaneUtil.messageError("Erro ao abrir Relatórios - " + ex.getMessage());
        }

//        if(tipo.equals("txt")){
//            File fileLog;
//            FileWriter writer;
//            PrintWriter printWriter;
//            fileLog = new File("c:/" + mes + "produtos.txt");
//            if (fileLog.exists()) {
//                fileLog.delete();
//            }
//        }
    }

}
