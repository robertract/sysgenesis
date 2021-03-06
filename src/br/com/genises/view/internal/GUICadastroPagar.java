/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package br.com.genises.view.internal;

import br.com.genises.dao.DaoFornecedor;
import br.com.genises.dao.DaoPlanoConta;
import br.com.genises.model.Fornecedor;
import br.com.genises.model.Pagar;
import br.com.genises.model.PlanoConta;
import br.com.genises.negocio.BPagar;
import br.com.genises.view.exception.NegocioException;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
import br.com.genises.view.util.number.JNumberFormatField;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author rober
 */
public class GUICadastroPagar extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUICadastroContas
     */
    private Pagar pagar;

    public GUICadastroPagar() {
        initComponents();
        tfNLancamento.setEnabled(false);
        carregaPlanoConta();
        carregaFornecedor();

    }

    public GUICadastroPagar(Pagar pagar) {
        initComponents();
        tfNLancamento.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNLancamento = new javax.swing.JTextField();
        tfContaLancamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfSituacao = new javax.swing.JTextField();
        tfHistorico = new javax.swing.JTextField();
        tfDataPagamento = new javax.swing.JFormattedTextField();
        tfValorPago = new JNumberFormatField(decFormat);
        bGravar = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbPlanoConta = new javax.swing.JComboBox();
        tfData = new javax.swing.JFormattedTextField();
        tfVencimento = new javax.swing.JFormattedTextField();
        tfValorPrincipal = new JNumberFormatField(decFormat);
        tfJurosMulta = new JNumberFormatField(decFormat);
        tfDescontos = new JNumberFormatField(decFormat);
        tfValorPagar = new JNumberFormatField(decFormat);
        jPanel4 = new javax.swing.JPanel();
        cbFornecedor = new javax.swing.JComboBox();

        jTextField1.setText("jTextField1");

        setClosable(true);
        setTitle("Sistema Gênises - Cadastro de Contas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Contas a Pagar"));
        jPanel1.setToolTipText("");

        jLabel1.setText("N° Lanc.:");

        jLabel2.setText("Conta:");

        jLabel3.setText("Data:");

        jLabel4.setText("Vencimento:");

        tfContaLancamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfContaLancamentoActionPerformed(evt);
            }
        });

        jLabel5.setText("Valor Principal:");

        jLabel6.setText("Juros/Multas:");

        jLabel7.setText("Descontos:");

        jLabel8.setText("Valor a Pagar:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Baixa da Despesa"));

        jLabel10.setText("Data Pagt.:");

        jLabel11.setText("Valor Pago:");

        jLabel12.setText("Situação:");

        jLabel14.setText("Historico:");

        tfSituacao.setEnabled(false);

        try {
            tfDataPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSituacao)
                    .addComponent(tfHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(tfDataPagamento)
                    .addComponent(tfValorPago))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(tfDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(26, 26, 26))
        );

        bGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/salvar icone_vectorized.png"))); // NOI18N
        bGravar.setText("Gravar");
        bGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGravarActionPerformed(evt);
            }
        });

        bLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/limpar_vectorized_1.png"))); // NOI18N
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        bCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/fechar_vectorized_1.png"))); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Plano de Conta"));

        cbPlanoConta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPlanoConta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbPlanoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        try {
            tfData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Fornecedor"));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        cbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione..." }));
        cbFornecedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFornecedorItemStateChanged(evt);
            }
        });
        cbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFornecedorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbFornecedorMousePressed(evt);
            }
        });
        cbFornecedor.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cbFornecedorInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFornecedorActionPerformed(evt);
            }
        });
        cbFornecedor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbFornecedorPropertyChange(evt);
            }
        });
        cbFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbFornecedorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNLancamento, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(tfContaLancamento)
                            .addComponent(tfData)
                            .addComponent(tfVencimento)
                            .addComponent(tfValorPrincipal)
                            .addComponent(tfJurosMulta)
                            .addComponent(tfDescontos)
                            .addComponent(tfValorPagar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addComponent(bGravar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar)
                        .addGap(167, 167, 167))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfNLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfContaLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfValorPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfJurosMulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDescontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bGravar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bCancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGravarActionPerformed
        try {
            if (tfContaLancamento.getText().trim().equals("")) {
                throw new NegocioException("DIGITE A CONTA!");
            }
            if (tfData.getText().trim().equals("")) {
                throw new NegocioException("DIGITE A CONTA!");
            }
            if (tfVencimento.getText().trim().equals("")) {
                throw new NegocioException("DIGITE O VENCIMENTO!");
            }
            if (tfValorPagar.getText().trim().equals("")) {
                throw new NegocioException("DIGITE O VALOR!");
            }
            if (cbFornecedor.getSelectedItem().equals("Selecione...")) {
                throw new NegocioException("Selecione o Fornecedor!");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //LocalDate date = LocalDate.parse("2005-nov-12", formatter);
            Pagar pagar = new Pagar();

            pagar.setConta(tfContaLancamento.getText());
            pagar.setData(LocalDate.parse(tfData.getText(), formatter));
            pagar.setVencimento(LocalDate.parse(tfVencimento.getText(), formatter));
            pagar.setValor(new BigDecimal(tfValorPrincipal.getText().replace(",", ".")));
            pagar.setJuros(new BigDecimal(tfJurosMulta.getText().replace(",", ".")));
            pagar.setDescontos(new BigDecimal(tfDescontos.getText().replace(",", ".")));
            pagar.setValorTotal(new BigDecimal(tfValorPagar.getText().replace(",", ".")));
            pagar.setDataPagamento(LocalDate.parse(tfDataPagamento.getText(), formatter));
            pagar.setValorPago(new BigDecimal(tfValorPago.getText().replace(",", ".")));
            //pagar.setSituacao(tfSituacao.getText());
            pagar.setHistorico(tfHistorico.getText());

            if (!cbPlanoConta.getSelectedItem().equals("Selecione...")) {
                pagar.setPlano((PlanoConta) cbPlanoConta.getSelectedItem());
            }
            pagar.setFornecedor((Fornecedor) cbFornecedor.getSelectedItem());

            BPagar bPagar = new BPagar();
            bPagar.salvar(pagar);
            JOptionPaneUtil.messageInformation("CADASTRADO COM SUCESSO!");
            limpar();
        } catch (NegocioException e) {
            JOptionPaneUtil.messageInformation(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPaneUtil.messageError(e.getMessage());
        }
    }//GEN-LAST:event_bGravarActionPerformed

    private void tfContaLancamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfContaLancamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfContaLancamentoActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        limpar();
    }//GEN-LAST:event_bLimparActionPerformed

    private void cbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFornecedorActionPerformed

    }//GEN-LAST:event_cbFornecedorActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked

    private void cbFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbFornecedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFornecedorKeyPressed

    private void cbFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFornecedorMouseClicked

    }//GEN-LAST:event_cbFornecedorMouseClicked

    private void cbFornecedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFornecedorMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFornecedorMousePressed

    private void cbFornecedorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbFornecedorPropertyChange

    }//GEN-LAST:event_cbFornecedorPropertyChange

    private void cbFornecedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFornecedorItemStateChanged

    }//GEN-LAST:event_cbFornecedorItemStateChanged

    private void cbFornecedorInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cbFornecedorInputMethodTextChanged

    }//GEN-LAST:event_cbFornecedorInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGravar;
    private javax.swing.JButton bLimpar;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JComboBox cbPlanoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField tfContaLancamento;
    private javax.swing.JFormattedTextField tfData;
    private javax.swing.JFormattedTextField tfDataPagamento;
    private javax.swing.JTextField tfDescontos;
    private javax.swing.JTextField tfHistorico;
    private javax.swing.JTextField tfJurosMulta;
    private javax.swing.JTextField tfNLancamento;
    private javax.swing.JTextField tfSituacao;
    private javax.swing.JTextField tfValorPagar;
    private javax.swing.JTextField tfValorPago;
    private javax.swing.JTextField tfValorPrincipal;
    private javax.swing.JFormattedTextField tfVencimento;
    // End of variables declaration//GEN-END:variables

    DecimalFormat decFormat = new java.text.DecimalFormat("#,###,##0.00");

    private void carregaPlanoConta() {
        try {

            DaoPlanoConta dao = new DaoPlanoConta();
            List<PlanoConta> planos = dao.list();
            DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbPlanoConta.getModel();
            for (PlanoConta plano : planos) {
                comboModel.addElement(plano);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPaneUtil.messageError(ex.getMessage() + " ERRO AO CARREGAR PLANOS DE CONTA");
        }
    }

    private void carregaFornecedor() {
        try {
            DaoFornecedor dao = new DaoFornecedor();
            List<Fornecedor> fornecedores = dao.list();
            DefaultComboBoxModel comboModel = (DefaultComboBoxModel) cbFornecedor.getModel();
            for (Fornecedor fornecedor : fornecedores) {
                comboModel.addElement(fornecedor);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPaneUtil.messageError(ex.getMessage() + " ERRO AO CARREGAR FORNECEDORES!");
        }
    }

    private void limpar() {

        tfContaLancamento.setText("");
        tfData.setText("");
        tfDataPagamento.setText("");
        tfDescontos.setText("");
        tfHistorico.setText("");
        tfJurosMulta.setText("");
        tfNLancamento.setText("");
        tfSituacao.setText("");
        tfValorPagar.setText("");
        tfValorPago.setText("");
        tfValorPrincipal.setText("");
        tfVencimento.setText("");
        cbPlanoConta.setSelectedItem("Selecione...");
        cbFornecedor.setSelectedItem("Selecione...");
    }

}
