/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import br.com.genises.model.Membro;
import br.com.genises.negocio.BMembro;
import br.com.genises.util.validacoes.UpperCaseDocument;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rober
 */
public class GUIPesquisaMembrosAlterar extends javax.swing.JDialog {

    /**
     * Creates new form GUIPesquisaMembros
     */
    String membroP;
    JInternalFrame principal;
    List<Membro> membros = new ArrayList<>();
    DefaultTableModel tmPesquisar = new DefaultTableModel(null,
            new String[]{"Nome", "CPF", "Telefone", "Celular"}) {
                public boolean isCellEditable(int row, int col) {
                    return false;
                }
            };

    public GUIPesquisaMembrosAlterar(JInternalFrame jInternalFrame, String membro, String txt) throws Exception {
        initComponents();
        principal = jInternalFrame;
        membroP = membro;
        tfPesquisar.setDocument(new UpperCaseDocument());
        tfPesquisar.setText(txt);
        pesquisar();
        setLocationRelativeTo(null);

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
        tfPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPesquisar = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pesquisar:");

        tfPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisarKeyReleased(evt);
            }
        });

        tPesquisar.setModel(tmPesquisar);
        tPesquisar.setToolTipText("");
        jScrollPane1.setViewportView(tPesquisar);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/login_vectorized_vectorized.png"))); // NOI18N
        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/sair_vectorized_vectorized.png"))); // NOI18N
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisar)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(178, 178, 178))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarKeyPressed
        try {
            pesquisar();
        } catch (Exception ex) {
            Logger.getLogger(GUIFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfPesquisarKeyPressed

    private void tfPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (membros.size() == 1) {
                tPesquisar.addRowSelectionInterval(0, 0);
                selecionar();
            } else {

            }
        }


    }//GEN-LAST:event_tfPesquisarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selecionar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    private void selecionar() {
        if (membroP.equals("anfitriao")) {
            GUIAlteraCelula c = (GUIAlteraCelula) principal;
            Membro membro = null;
            membro = this.getMembro();
            c.membroAnfitriao = membro;
            c.setarAnfitriao(membro);
            this.dispose();
        }

        if (membroP.equals("lider")) {
            GUIAlteraCelula c = (GUIAlteraCelula) principal;
            Membro membro = null;
            membro = this.getMembro();
            c.lider = membro;
            c.setarLider(membro);
            this.dispose();
        }

        if (membroP.equals("lider treinamento")) {
            GUIAlteraCelula c = (GUIAlteraCelula) principal;
            Membro membro = null;
            membro = this.getMembro();
            c.liderTreinamento = membro;
            c.setarLiderTreinamento(membro);
            this.dispose();
        }

        if (membroP.equals("supervisor")) {
            GUIAlteraCelula c = (GUIAlteraCelula) principal;
            Membro membro = null;
            membro = this.getMembro();
            c.supervisor = membro;
            c.setarSupervisor(membro);
            this.dispose();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPesquisar;
    private javax.swing.JTextField tfPesquisar;
    // End of variables declaration//GEN-END:variables

    private void pesquisar() throws Exception {
        Membro m = new Membro();
        BMembro bMembro = new BMembro();

        membros = bMembro.pesquisarMembros(tfPesquisar.getText());

        mostraLista(membros);
    }

    private Membro getMembro() {
        Membro m = null;
        int linhaSelecionada = tPesquisar.getSelectedRow();
        if (linhaSelecionada < 0) {
            JOptionPane.showMessageDialog(null, "Nenhum membro selecionado!");
        }
        m = (Membro) this.membros.get(linhaSelecionada);
        return m;

    }

    private void mostraLista(List<Membro> membros) {
        while (tmPesquisar.getRowCount() > 0) {
            tmPesquisar.removeRow(0);
        }
        if (membros.size() == 0) {
        } else {
            String[] linha = new String[]{null, null, null, null};
            for (int i = 0; i < membros.size(); i++) {
                tmPesquisar.addRow(linha);
                tmPesquisar.setValueAt(membros.get(i).getNome(), i, 0);
                tmPesquisar.setValueAt(membros.get(i).getCpf(), i, 1);
                tmPesquisar.setValueAt(membros.get(i).getTelefone(), i, 2);
                tmPesquisar.setValueAt(membros.get(i).getCelular(), i, 3);

            }
        }

    }
}
