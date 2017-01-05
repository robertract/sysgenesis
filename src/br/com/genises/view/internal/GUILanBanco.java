/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import br.com.genises.dao.DaoLancamentoBanco;
import br.com.genises.dao.DaoPagar;
import br.com.genises.dao.DaoUsuarioLista;
import br.com.genises.model.Banco;
import br.com.genises.model.Fornecedor;
import br.com.genises.model.LancamentoBanco;
import br.com.genises.model.Pagar;
import br.com.genises.model.PlanoConta;
import br.com.genises.negocio.BLancamentoBanco;
import br.com.genises.negocio.BPagar;
import br.com.genises.view.GUIPrincipal;
import br.com.genises.view.exception.NegocioException;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
import br.com.genises.view.util.tablemodel.BancoLancamentoTableModel;
import br.com.genises.view.util.tablemodel.PagarTableModel;
import br.com.genises.view.util.tablemodel.Tabela;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static tools.devnull.trugger.scan.ClassScan.scan;

/**
 *
 * @author Tiago
 */
public class GUILanBanco extends javax.swing.JInternalFrame {

    private String campoPesquisa = "";
    private List<String> camposPadrao;
    private String tipoCampo = "";
    private LancamentoBanco p = new LancamentoBanco();

    public GUILanBanco() {
        p = new LancamentoBanco();
        p.setBanco(new Banco());
        
        carregaPadrao();

        tmLancamento = new BancoLancamentoTableModel(camposPadrao);

        tmLancamento.adiciona(p);
        lancamentos = new ArrayList<>();

        initComponents();
        formataTabela(LancamentoBanco.class);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tLancamento = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txNomePesquisa = new javax.swing.JLabel();
        tfPesquisa = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema Gênises -  Contas a Pagar");

        tLancamento.setModel(tmLancamento);
        tLancamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tLancamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tLancamento);

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

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/excluir icone_vectorized.png"))); // NOI18N
        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Agrupar");

        jButton6.setText("Campos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/imprimir_vectorized.png"))); // NOI18N
        jButton7.setText("Imprimir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/lista icone_vectorized.png"))); // NOI18N
        jButton8.setText("Lista");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(txNomePesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txNomePesquisa))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if ((guiCadastroLancamento == null) || (!guiCadastroLancamento.isVisible())) {
                guiCadastroLancamento = new GUICadastroLancamento();
                this.getParent().add(guiCadastroLancamento);
                Dimension paneSize = guiCadastroLancamento.getSize();
                Dimension screenSize = guiCadastroLancamento.getToolkit().getScreenSize();
                guiCadastroLancamento.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiCadastroLancamento.setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
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

    private void tLancamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tLancamentoMouseClicked

        try {
            String nomeColuna = tmLancamento.getColumnName(tLancamento.getSelectedColumn());

            for (Method metodo : LancamentoBanco.class.getDeclaredMethods()) {
                // System.out.println(tUsuario.getSelectedColumn());
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.tipoAtributo().equals("object")) {
                        Object obje = metodo.invoke(p);
                        List<Class> classes = scan().classes().deep().in("br.com.genises.model");
                        //System.out.println(obje);
                        for (Class c : classes) {
                            if (c.equals(obje.getClass())) {
                                System.out.println(c.getClass() + " São objetos iguais " + c);
                                for (Method metodoInterno : c.getDeclaredMethods()) {
                                    if (metodoInterno.isAnnotationPresent(Tabela.class)) {
                                        Tabela anotacaoInterno = metodoInterno.getAnnotation(Tabela.class);
                                        if (anotacaoInterno.visivelOutraTela() == true) {
                                            if (anotacaoInterno.nomeOutraTela().equals(nomeColuna)) {
                                                campoPesquisa = anotacaoInterno.nomePesquisa();
                                                txNomePesquisa.setText(anotacaoInterno.nomeOutraTela() + " :");
                                                tipoCampo = anotacaoInterno.tipoAtributo();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if (anotacao.nome().equals(nomeColuna)) {
                        campoPesquisa = anotacao.nomePesquisa();
                        txNomePesquisa.setText(anotacao.nome() + " :");
                        tipoCampo = anotacao.tipoAtributo();
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPaneUtil.messageInformation("SELECIONE UMA COLUNA!");
        }
    }//GEN-LAST:event_tLancamentoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tmLancamento.clear();

        LancamentoBanco u = new LancamentoBanco();
        lancamentos.add(u);
        tmLancamento.adicionaList(lancamentos);
        tfPesquisa.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            LancamentoBanco l = new LancamentoBanco();
            Banco b = new Banco();
            l.setBanco(b);
            GUICampos g = new GUICampos(l, this);
            g.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GUILanBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        GUIListas gui = new GUIListas(this, tmLancamento.getListaCampos());
        gui.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pesquisar();
        //   tmUsuario.adicionaList(daoUsuario.pesquisaFiltro());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        List<Object> listObjects = new ArrayList<>();
        for (LancamentoBanco u : tmLancamento.getLista()) {
            listObjects.add(u);
        }

        GUIImprimir g = new GUIImprimir(this, listObjects, tmLancamento.getListaCampos());
        g.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int linhaSeleciona = tLancamento.getSelectedRow();
            if (linhaSeleciona == -1) {
                throw new NegocioException("Selecione um registro!");
            }
            DaoLancamentoBanco dao = new DaoLancamentoBanco();
            dao.excluir(tmLancamento.getLista().get(linhaSeleciona));
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
            int linhaSeleciona = tLancamento.getSelectedRow();
            if (linhaSeleciona == -1) {
                throw new NegocioException("Selecione um Registro!");
            }
            if ((guiCadastroLancamento == null) || (!guiCadastroLancamento.isVisible())) {

                //  guiCadastroLancamento = new GUICadastroPagar(tmPagar.getLista().get(linhaSeleciona), this);
                this.getParent().add(guiCadastroLancamento);
                Dimension paneSize = guiCadastroLancamento.getSize();
                Dimension screenSize = guiCadastroLancamento.getToolkit().getScreenSize();
                guiCadastroLancamento.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiCadastroLancamento.setVisible(true);

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
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tLancamento;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JLabel txNomePesquisa;
    // End of variables declaration//GEN-END:variables
    private BancoLancamentoTableModel tmLancamento;
    private BLancamentoBanco bPagar = new BLancamentoBanco();
    private List<LancamentoBanco> lancamentos;
    private GUICadastroLancamento guiCadastroLancamento;

    public void atualizaTabela(List<String> colunas) {
        lancamentos = tmLancamento.getLista();
        tmLancamento.setListaCampos(colunas);
        formataTabela(LancamentoBanco.class);
    }

    private void carregaPadrao() {
        try {
            camposPadrao = new ArrayList<String>();
            DaoUsuarioLista dao = new DaoUsuarioLista();
            camposPadrao = dao.verificaPadrao("Pagar.class", GUIPrincipal.usuarioLogado.getId());
            if (camposPadrao == null) {
                camposPadrao = new ArrayList<String>();

                for (Method metodo : Pagar.class.getDeclaredMethods()) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (metodo.isAnnotationPresent(Tabela.class)) {
                        if (anotacao.tipoAtributo().equals("object")) {
                            Object obje = metodo.invoke(p);
                            List<Class> classes = scan().classes().deep().in("br.com.genises.model");
                            System.out.println(obje);
                            for (Class c : classes) {
                                if (c.equals(obje.getClass())) {
                                    System.out.println(c.getClass() + " São objetos iguais " + c);
                                    for (Method metodoInterno : c.getDeclaredMethods()) {
                                        if (metodoInterno.isAnnotationPresent(Tabela.class)) {
                                            Tabela anotacaoInterno = metodoInterno.getAnnotation(Tabela.class);
                                            if (anotacaoInterno.visivelOutraTela() == true) {
                                                camposPadrao.add(anotacaoInterno.nomeOutraTela());
                                            }
                                        }
                                    }
                                }
                            }

                        } else {
                            camposPadrao.add(anotacao.nome());
                        }
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void pesquisar() {
        try {
            if (tipoCampo.equals("")) {
                throw new NegocioException("Selecione uma coluna!");
            }

            tmLancamento.clear();
            DaoLancamentoBanco dao = new DaoLancamentoBanco();

            String filtro = "";
            if (tipoCampo.equals("string")) {
                filtro = campoPesquisa + " like " + "'%" + tfPesquisa.getText() + "%'";
            }
            if (tipoCampo.equals("numero")) {
                filtro = campoPesquisa + " = " + tfPesquisa.getText();
            }
            if (tipoCampo.equals("object")) {
                //  filtro = 
            }
            List<LancamentoBanco> lancamentos = dao.pesquisaFiltro(filtro);
            if (lancamentos.isEmpty()) {
                LancamentoBanco l = new LancamentoBanco();
                tmLancamento.adiciona(l);
            } else {
                tmLancamento.adicionaList(lancamentos);
            }
        } catch (NegocioException ex) {
            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
            LancamentoBanco l = new LancamentoBanco();
            tmLancamento.adiciona(l);
        }
    }

    public void renovaPesquisa() {
        tmLancamento.clear();
        pesquisar();
    }

    public void formataTabela(Class classe) {
        try {
            tLancamento.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int numeroColunas = tmLancamento.getColumnCount();
            int numero = 0;
            //System.out.println(numeroColunas);
            while (numeroColunas != numero) {
                for (Method metodo : Pagar.class.getDeclaredMethods()) {
                    if (metodo.isAnnotationPresent(Tabela.class)) {
                        Tabela anotacao = metodo.getAnnotation(Tabela.class);
                        if (anotacao.tipoAtributo().equals("object")) {
                            tLancamento.getColumnModel().getColumn(numero).setPreferredWidth(130);
                        } else if (anotacao.nome().equals(tmLancamento.getColumnName(numero))) {
                            tLancamento.getColumnModel().getColumn(numero).setPreferredWidth(anotacao.tamanho());
                        }
                    }
                }

                numero++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
