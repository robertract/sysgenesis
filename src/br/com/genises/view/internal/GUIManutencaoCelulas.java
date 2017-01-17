/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrador
 */
public class GUIManutencaoCelulas extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIManutencaoCelulas
     */
    public GUIManutencaoCelulas() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Sistema Gênises - Manutenção de Celulas");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/cadastrar_vectorized.png"))); // NOI18N
        jButton1.setText("Adicionar Membros");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/celulas multiplicadas_vectorized.png"))); // NOI18N
        jButton2.setText("Multiplicar Celulas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/fechar_vectorized_1.png"))); // NOI18N
        jButton3.setText("Fechar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/remover verctor.png"))); // NOI18N
        jButton4.setText("Remover Membros");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if ((adicionarmembros == null) || (!adicionarmembros.isVisible())) {
            try {
                adicionarmembros = new GUIAdicionarMembrosCelula();
                this.getParent().add(adicionarmembros);
                Dimension paneSize = adicionarmembros.getSize();
                Dimension screenSize = adicionarmembros.getToolkit().getScreenSize();
                adicionarmembros.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                adicionarmembros.setVisible(true);
            } // TODO add your handling code here:
            catch (Exception ex) {
                Logger.getLogger(GUIManutencaoCelulas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if ((multiplicarcelulas == null) || (!multiplicarcelulas.isVisible())) {
            try {
                multiplicarcelulas = new GUIMultiplicacaoCelulas();
                this.getParent().add(multiplicarcelulas);
                Dimension paneSize = multiplicarcelulas.getSize();
                Dimension screenSize = multiplicarcelulas.getToolkit().getScreenSize();
                multiplicarcelulas.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                multiplicarcelulas.setVisible(true);
            } // TODO add your handling code here:
            catch (Exception ex) {
                Logger.getLogger(GUIManutencaoCelulas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if ((remove == null) || (!remove.isVisible())) {
            try {
                remove = new GUIRemoveMembros();
                this.getParent().add(remove);
                Dimension paneSize = remove.getSize();
                Dimension screenSize = remove.getToolkit().getScreenSize();
                remove.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                remove.setVisible(true);
            } // TODO add your handling code here:
            catch (Exception ex) {
                Logger.getLogger(GUIManutencaoCelulas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
    private GUIAdicionarMembrosCelula adicionarmembros;
    private GUIMultiplicacaoCelulas multiplicarcelulas;
    private GUIRemoveMembros remove;
}
