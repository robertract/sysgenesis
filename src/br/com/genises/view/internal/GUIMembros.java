/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import br.com.genises.dao.DaoMembro;
import br.com.genises.dao.DaoUsuarioLista;
import br.com.genises.model.Membro;
import br.com.genises.negocio.BMembro;
import br.com.genises.util.validacoes.UpperCaseDocument;
import br.com.genises.view.GUIPrincipal;
import br.com.genises.view.exception.NegocioException;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
import br.com.genises.view.util.tablemodel.BancoTableModel;
import br.com.genises.view.util.tablemodel.MembrasiaTableModel;
import br.com.genises.view.util.tablemodel.Tabela;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class GUIMembros extends javax.swing.JInternalFrame {

    private String campoPesquisa = "";
    private List<String> camposPadrao;
    private String tipoCampo = "";

    public GUIMembros() {
        carregaPadrao();

        tmMembro = new MembrasiaTableModel(camposPadrao);

        Membro u = new Membro();
        tmMembro.adiciona(u);
        membros = new ArrayList<>();

        initComponents();
        tfPesquisa.setDocument(new UpperCaseDocument());
        formataTabela(Membro.class);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tMembro = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txNomePesquisa = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema Gênises - Membros");

        tMembro.setModel(tmMembro);
        tMembro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMembroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMembro);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/cadastrar_vectorized.png"))); // NOI18N
        jButton1.setText("Novo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txNomePesquisa.setText("Pesquisar:");

        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/limpar_vectorized_1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/editar_vectorized.png"))); // NOI18N
        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/excluir_vectorized.png"))); // NOI18N
        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/imprimir_vectorized.png"))); // NOI18N
        jButton7.setText("Imprimir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/pesquisar lupa_vectorized.png"))); // NOI18N
        jButton9.setText("Pesquisa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(txNomePesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txNomePesquisa)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton7))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((guicadastro == null) || (!guicadastro.isVisible())) {
            guicadastro = new GUICadastroMembrasia();
            this.getParent().add(guicadastro);
            Dimension paneSize = guicadastro.getSize();
            Dimension screenSize = guicadastro.getToolkit().getScreenSize();
            guicadastro.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
            guicadastro.setVisible(true);
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                pesquisar();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void tMembroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMembroMouseClicked
        String nomeColuna = tmMembro.getColumnName(tMembro.getSelectedColumn());

        for (Method metodo : Membro.class.getDeclaredMethods()) {
            System.out.println(tMembro.getSelectedColumn());
            if (metodo.isAnnotationPresent(Tabela.class)) {
                Tabela anotacao = metodo.getAnnotation(Tabela.class);
                if (anotacao.nome().equals(nomeColuna)) {
                    campoPesquisa = anotacao.nomePesquisa();
                    txNomePesquisa.setText(anotacao.nome() + " :");
                    tipoCampo = anotacao.tipoAtributo();

                }
            }
        }
    }//GEN-LAST:event_tMembroMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tmMembro.clear();
//        int a = 0;
//        while (a < 15000) {
        Membro u = new Membro();
//            u.setEmail("EMAIL" + a);
//            u.setId(1l);
//            u.setNomeUsuario("NOME USUARIO" + a);
//            u.setUsuario("USUARIO" + a);
        membros.add(u);
//            a++;
////        }
        tmMembro.adicionaList(membros);
        tfPesquisa.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void carregaPadrao() {
        try {
            camposPadrao = new ArrayList<String>();
            DaoUsuarioLista dao = new DaoUsuarioLista();
            camposPadrao = dao.verificaPadrao("Fornecedor.class", GUIPrincipal.usuarioLogado.getId());
            if (camposPadrao == null) {
                camposPadrao = new ArrayList<String>();

                for (Method metodo : Membro.class.getDeclaredMethods()) {
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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pesquisar();
        //   tmUsuario.adicionaList(daoUsuario.pesquisaFiltro());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        List<Object> listObjects = new ArrayList<>();
        for (Membro u : tmMembro.getLista()) {
            listObjects.add(u);
        }

        GUIImprimir g = new GUIImprimir(this, listObjects, tmMembro.getListaCampos());
        g.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int linhaSeleciona = tMembro.getSelectedRow();
            if (linhaSeleciona == -1) {
                throw new NegocioException("Selecione um Banco!");
            }
            DaoMembro dao = new DaoMembro();
            dao.excluir(tmMembro.getLista().get(linhaSeleciona));
            JOptionPaneUtil.messageInformation("Excluido com sucesso!");
            renovaPesquisa();
        } catch (NegocioException ex) {
            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
            JOptionPaneUtil.messageError(ex.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            int linhaSeleciona = tMembro.getSelectedRow();
            if (linhaSeleciona == -1) {
                throw new NegocioException("Selecione um banco!");
            }
            if ((guialtera == null) || (!guialtera.isVisible())) {

                guialtera = new GUIAlteraMembrasia(tmMembro.getLista().get(linhaSeleciona), this);
                this.getParent().add(guialtera);
                Dimension paneSize = guialtera.getSize();
                Dimension screenSize = guialtera.getToolkit().getScreenSize();
                guialtera.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guialtera.setVisible(true);

            }

        } catch (NegocioException ex) {
            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
            JOptionPaneUtil.messageError(ex.getMessage());
        }

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMembro;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JLabel txNomePesquisa;
    // End of variables declaration//GEN-END:variables
    private GUICadastroMembrasia guicadastro;
    private GUIAlteraMembrasia guialtera;
    private MembrasiaTableModel tmMembro;
    private BMembro bMembro = new BMembro();
    private List<Membro> membros;

    public void atualizaTabela(List<String> colunas) {
        membros = tmMembro.getLista();
        tmMembro.setListaCampos(colunas);
        formataTabela(Membro.class);
    }

    private void pesquisar() {
        try {
            if (tipoCampo.equals("")) {
                throw new NegocioException("Selecione uma coluna!");
            }

            tmMembro.clear();
            BMembro bB = new BMembro();

            String filtro = "";
            if (tipoCampo.equals("string")) {
                filtro = campoPesquisa + " like " + "'%" + tfPesquisa.getText() + "%'";
            }
            if (tipoCampo.equals("numero")) {
                filtro = campoPesquisa + " = " + tfPesquisa.getText();
            }

            List<Membro> membros = bMembro.pesquisaMembros(filtro);
            if (membros.isEmpty()) {
                Membro ban = new Membro();
                tmMembro.adiciona(ban);
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado!");
            } else {
                tmMembro.adicionaList(membros);
            }
        } catch (NegocioException ex) {
            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
            //   ex.printStackTrace();
            Membro banco = new Membro();
            tmMembro.adiciona(banco);
        }
    }

    public void renovaPesquisa() {
        tmMembro.clear();
        pesquisar();
    }

    public void formataTabela(Class classe) {
        tMembro.setAutoResizeMode(tMembro.AUTO_RESIZE_OFF);
        int numeroColunas = tmMembro.getColumnCount();
        int numero = 0;
        while (numeroColunas != numero) {
            for (Method metodo : classe.getDeclaredMethods()) {
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.nome().equals(tmMembro.getColumnName(numero))) {
                        tMembro.getColumnModel().getColumn(numero).setPreferredWidth(anotacao.tamanho());
                    }
                }
            }

            numero++;
        }

    }
}
