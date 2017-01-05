/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import br.com.genises.dao.DaoBanco;
import br.com.genises.dao.DaoFornecedor;
import br.com.genises.dao.DaoHistorico;
import br.com.genises.dao.DaoUsuario;
import br.com.genises.dao.DaoUsuarioLista;
import br.com.genises.model.Banco;
import br.com.genises.model.Fornecedor;
import br.com.genises.model.Historico;
import br.com.genises.model.Usuario;
import br.com.genises.negocio.BBanco;
import br.com.genises.negocio.BFornecedor;
import br.com.genises.negocio.BHistorico;
import br.com.genises.negocio.BUsuario;
import br.com.genises.view.GUIPrincipal;
import br.com.genises.view.exception.NegocioException;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
import br.com.genises.view.util.tablemodel.BancoTableModel;
import br.com.genises.view.util.tablemodel.FornecedorTableModel;
import br.com.genises.view.util.tablemodel.HistoricoTableModel;
import br.com.genises.view.util.tablemodel.Tabela;
import br.com.genises.view.util.tablemodel.UsuarioTableModel;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class GUIHistoricoLista extends javax.swing.JInternalFrame {

    private String campoPesquisa = "";
    private List<String> camposPadrao;
    private String tipoCampo = "";
    JInternalFrame principal;

    public GUIHistoricoLista(JInternalFrame jframe) {
        carregaPadrao();

        tmHistoricoTableModel = new HistoricoTableModel(camposPadrao);

        Historico u = new Historico();
        tmHistoricoTableModel.adiciona(u);
        historicos = new ArrayList<>();
        principal = jframe;
        initComponents();
        formataTabela(Historico.class);
        pesquisar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tHistorico = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema Gênises - Historicos");

        tHistorico.setModel(tmHistoricoTableModel);
        tHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tHistorico);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/login_vectorized_vectorized.png"))); // NOI18N
        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/sair_vectorized_vectorized.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tHistoricoMouseClicked
//        String nomeColuna = tmHistoricoTableModel.getColumnName(tHistorico.getSelectedColumn());
//
//        for (Method metodo : Historico.class.getDeclaredMethods()) {
//            // System.out.println(tUsuario.getSelectedColumn());
//            if (metodo.isAnnotationPresent(Tabela.class)) {
//                Tabela anotacao = metodo.getAnnotation(Tabela.class);
//                if (anotacao.nome().equals(nomeColuna)) {
//                    campoPesquisa = anotacao.nomePesquisa();
//                    txNomePesquisa.setText(anotacao.nome() + " :");
//                    tipoCampo = anotacao.tipoAtributo();
//
//                }
//            }
//        }
    }//GEN-LAST:event_tHistoricoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selecionar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    private void selecionar() {

        GUICadastroCheque c = (GUICadastroCheque) principal;
        Historico historico = null;

        int linhaSeleciona = tHistorico.getSelectedRow();
        if (linhaSeleciona == -1) {
            throw new NegocioException("Selecione um historico!");
        } else {
            historico = tmHistoricoTableModel.getLista().get(linhaSeleciona);
            c.h = historico;
            c.setarHistorico(historico);
            this.dispose();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tHistorico;
    // End of variables declaration//GEN-END:variables
    private GUICadastroHistorico guicadastro;
    private HistoricoTableModel tmHistoricoTableModel;
    private BHistorico bHistorico = new BHistorico();
    private List<Historico> historicos;

    public void atualizaTabela(List<String> colunas) {
        historicos = tmHistoricoTableModel.getLista();
        tmHistoricoTableModel.setListaCampos(colunas);
        formataTabela(Historico.class);
    }

    private void carregaPadrao() {
        try {
            camposPadrao = new ArrayList<String>();
            DaoUsuarioLista dao = new DaoUsuarioLista();
            camposPadrao = dao.verificaPadrao("Historico.class", GUIPrincipal.usuarioLogado.getId());
            if (camposPadrao == null) {
                camposPadrao = new ArrayList<String>();

                for (Method metodo : Historico.class.getDeclaredMethods()) {
                    if (metodo.isAnnotationPresent(Tabela.class)) {
                        Tabela anotacao = metodo.getAnnotation(Tabela.class);
                        camposPadrao.add(anotacao.nome());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisar() {
        try {

            String filtro = "";
            filtro = "descricao" + " like " + "'%%'";

            List<Historico> historicos = bHistorico.pesquisaHistorico(filtro);
            if (historicos.isEmpty()) {
                Historico his = new Historico();
                tmHistoricoTableModel.adiciona(his);
            } else {
                tmHistoricoTableModel.adicionaList(historicos);
            }
        } catch (NegocioException ex) {

            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
            //   ex.printStackTrace();
            Historico his = new Historico();
            tmHistoricoTableModel.adiciona(his);
        }
    }

    public void renovaPesquisa() {
        tmHistoricoTableModel.clear();
        pesquisar();
    }

    public void formataTabela(Class classe) {
        tHistorico.setAutoResizeMode(tHistorico.AUTO_RESIZE_OFF);
        int numeroColunas = tmHistoricoTableModel.getColumnCount();
        int numero = 0;
        while (numeroColunas != numero) {
            for (Method metodo : classe.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.nome().equals(tmHistoricoTableModel.getColumnName(numero))) {
                        tHistorico.getColumnModel().getColumn(numero).setPreferredWidth(anotacao.tamanho());
                    }
                }
            }

            numero++;
        }

    }

}
