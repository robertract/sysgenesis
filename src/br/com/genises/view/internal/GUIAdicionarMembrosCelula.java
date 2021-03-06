/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import br.com.genises.model.Celula;
import br.com.genises.model.Membro;
import br.com.genises.negocio.BCelula;
import br.com.genises.negocio.BMembro;
import br.com.genises.negocio.ComboMultidata;
import br.com.genises.view.exception.NegocioException;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
import br.com.genises.view.util.tablemodel.CelulasTableModel;
import br.com.genises.view.util.tablemodel.MembroCelulaTableModel;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class GUIAdicionarMembrosCelula extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIAdicionarMembrosCelula
     */
    private String campoPesquisa = "";
    private List<String> camposPadrao;
    private String tipoCampo = "";
    private MembroCelulaTableModel tmMembros;
    Membro membroSelecionado = new Membro();
    Celula celula = new Celula();

    public GUIAdicionarMembrosCelula() throws Exception {

        tmMembros = new MembroCelulaTableModel(camposPadrao);
        initComponents();
        carregarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbCelula = new javax.swing.JComboBox<String>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMembros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfMembro = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Sistema Gênises - Adicionar Membros");

        jLabel1.setText("Nome:");

        cbCelula.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));

        jButton1.setText("Carregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tMembros.setModel(tmMembros);
        jScrollPane1.setViewportView(tMembros);

        jLabel2.setText("Membro:");

        tfMembro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMembroKeyReleased(evt);
            }
        });

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/limpar_vectorized_1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCelula, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbCelula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfMembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        carregarTabela();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfMembroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMembroKeyReleased

        if (tfMembro.getText().equals("")) {

        } else {
            try {
                GUIPesquisaMembrosCelula guipesquisamembros = new GUIPesquisaMembrosCelula(this, tfMembro.getText());
                tfMembro.setText(null);
                guipesquisamembros.setVisible(true);

            } catch (Exception ex) {
                Logger.getLogger(GUICadastroCelula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_tfMembroKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (membroSelecionado.getId() == 0 || celula.getId() == 0) {

        } else {
            try {
                int existe = 0; // 0 se não existir, 1 se existir
                for (Membro membro : membros) {
                    if (membro.getId() == membroSelecionado.getId()) {
                        existe = 1;
                    } else {

                    }
                }

                if (existe == 1) {
                    JOptionPane.showMessageDialog(this, "O membro selecionado já pertence a esta celula!");
                    tfMembro.requestFocus();
                } else {
                    BCelula bCelula = new BCelula();
                    bCelula.gravarMembro(membroSelecionado, celula);
                    carregarTabela();
                    membroSelecionado = new Membro();
                    tfMembro.setText(null);
                }

            } catch (Exception ex) {
                Logger.getLogger(GUIAdicionarMembrosCelula.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tfMembro.setText(null);
        membroSelecionado = new Membro();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbCelula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMembros;
    private javax.swing.JTextField tfMembro;
    // End of variables declaration//GEN-END:variables
    BCelula bCelula = new BCelula();
    private GUIPesquisaMembrosCelula guipesquisamembros;

    private void carregarCombo() throws Exception {
        try {
            List<Celula> celulas = new ArrayList<>();

            celulas = bCelula.listarCelulas();

            DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbCelula.getModel();

            for (int linha = 0; linha < celulas.size(); linha++) {
                //pegando a categoria da lista
                Celula categoria = celulas.get(linha);
                //adicionando a categoria no combo
                comboModel.addElement(categoria);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Não existem celulas cadastradas!");
            this.dispose();
        }
    }
    List<Membro> membros = new ArrayList<>();

    private void pesquisarMembros(long id) throws Exception {

        membros = bCelula.pesquisarMembros(id);

        carregarGrid(membros);

    }

    void setarMembro(Membro membro) {
        tfMembro.setText(membro.getNome());
    }

    private void carregarGrid(List<Membro> membros) {
        try {
            tmMembros.clear();

            if (membros.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A Celula selecionada ainda não possui membros!");
            } else {
                tmMembros.adicionaList(membros);
            }
        } catch (NegocioException ex) {
            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
            //   ex.printStackTrace();
//            Celula celula = new Celula();
//            tmCelulas.adiciona(celula);
        }

    }

    private void carregarTabela() {
        try {
            //pegando o objeto selecionado no combo
            celula = (Celula) cbCelula.getSelectedItem();
            //mostrando o nome da categoria em um dialogo

            pesquisarMembros(celula.getId());

        } catch (Exception ex) {
            Logger.getLogger(GUIAdicionarMembrosCelula.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
