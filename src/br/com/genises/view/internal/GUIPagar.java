/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.internal;

import br.com.genises.dao.DaoPagar;
import br.com.genises.dao.DaoUsuarioLista;
import br.com.genises.model.Fornecedor;
import br.com.genises.model.Pagar;
import br.com.genises.model.PlanoConta;
import br.com.genises.negocio.BPagar;
import br.com.genises.view.GUIPrincipal;
import br.com.genises.view.exception.NegocioException;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
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
public class GUIPagar extends javax.swing.JInternalFrame {

    private String campoPesquisa = "";
    private List<String> camposPadrao;
    private String tipoCampo = "";
    private Pagar p;

    public GUIPagar() {
        p = new Pagar();
        PlanoConta pl = new PlanoConta();
        Fornecedor f = new Fornecedor();
        p.setPlano(pl);
        p.setFornecedor(f);
        carregaPadrao();

        tmPagar = new PagarTableModel(camposPadrao);

        tmPagar.adiciona(p);
        pagamentos = new ArrayList<>();

        initComponents();
        formataTabela(Pagar.class);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tPagar = new javax.swing.JTable();
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

        tPagar.setModel(tmPagar       );
        tPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPagarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPagar);

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
                        .addGap(0, 30, Short.MAX_VALUE)
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
            if ((guiCadastroPagar == null) || (!guiCadastroPagar.isVisible())) {
                guiCadastroPagar = new GUICadastroPagar();
                this.getParent().add(guiCadastroPagar);
                Dimension paneSize = guiCadastroPagar.getSize();
                Dimension screenSize = guiCadastroPagar.getToolkit().getScreenSize();
                guiCadastroPagar.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiCadastroPagar.setVisible(true);
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

    private void tPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPagarMouseClicked

        try {
            String nomeColuna = tmPagar.getColumnName(tPagar.getSelectedColumn());

            for (Method metodo : Pagar.class.getDeclaredMethods()) {
                // System.out.println(tUsuario.getSelectedColumn());
                if (metodo.isAnnotationPresent(Tabela.class)) {
                    Tabela anotacao = metodo.getAnnotation(Tabela.class);
                    if (anotacao.tipoAtributo().equals("object")) {
                        Object obje = metodo.invoke(p);
                        List<Class> classes = scan().classes().deep().in("br.com.genises.model");
                        // System.out.println(obje);
                        for (Class c : classes) {
                            if (c.equals(obje.getClass())) {
                                //     System.out.println(c.getClass() + " São objetos iguais " + c);
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
    }//GEN-LAST:event_tPagarMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tmPagar.clear();

        Pagar u = new Pagar();
        pagamentos.add(u);
        tmPagar.adicionaList(pagamentos);
        tfPesquisa.setText("");

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            PlanoConta a = new PlanoConta();
            Fornecedor fornecedor = new Fornecedor();
            Pagar p = new Pagar();
            p.setPlano(a);
            p.setFornecedor(fornecedor);
            GUICampos g = new GUICampos(p, this);
            g.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(GUIPagar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        GUIListas gui = new GUIListas(this, tmPagar.getListaCampos());
        gui.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        pesquisar();
        //   tmUsuario.adicionaList(daoUsuario.pesquisaFiltro());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        List<Object> listObjects = new ArrayList<>();
        for (Pagar u : tmPagar.getLista()) {
            listObjects.add(u);
        }

        GUIImprimir g = new GUIImprimir(this, listObjects, tmPagar.getListaCampos());
        g.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            int linhaSeleciona = tPagar.getSelectedRow();
            if (linhaSeleciona == -1) {
                throw new NegocioException("Selecione um registro!");
            }
            DaoPagar dao = new DaoPagar();
            dao.excluir(tmPagar.getLista().get(linhaSeleciona));
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
            int linhaSeleciona = tPagar.getSelectedRow();
            if (linhaSeleciona == -1) {
                throw new NegocioException("Selecione um Registro!");
            }
            if ((guiCadastroPagar == null) || (!guiCadastroPagar.isVisible())) {

//                guiCadastroPagar = new GUICadastroPagar(tmPagar.getLista().get(linhaSeleciona), this);
                this.getParent().add(guiCadastroPagar);
                Dimension paneSize = guiCadastroPagar.getSize();
                Dimension screenSize = guiCadastroPagar.getToolkit().getScreenSize();
                guiCadastroPagar.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiCadastroPagar.setVisible(true);

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
    private javax.swing.JTable tPagar;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JLabel txNomePesquisa;
    // End of variables declaration//GEN-END:variables
    private PagarTableModel tmPagar;
    private BPagar bPagar = new BPagar();
    private List<Pagar> pagamentos;
    private GUICadastroPagar guiCadastroPagar;

    public void atualizaTabela(List<String> colunas) {
        pagamentos = tmPagar.getLista();
        tmPagar.setListaCampos(colunas);
        formataTabela(Pagar.class);
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

            tmPagar.clear();
            DaoPagar daoPagar = new DaoPagar();

            String filtro = "";
            if (tipoCampo.equals("string")) {
                filtro = campoPesquisa + " like " + "'%" + tfPesquisa.getText() + "%'";
            }
            if (tipoCampo.equals("numero")) {
                filtro = campoPesquisa + " = " + tfPesquisa.getText();
            }
            if (tipoCampo.equals("object")) {
                filtro = campoPesquisa + "=" + tfPesquisa.getText();
            }
            List<Pagar> pagamentos = daoPagar.pesquisaFiltro(filtro);
           // System.out.println("Retornou: "+ pagamentos.size());
            if (pagamentos.isEmpty()) {
                Pagar pagar = new Pagar();
                tmPagar.adiciona(pagar);
            } else {
                tmPagar.adicionaList(pagamentos);
            }
        } catch (NegocioException ex) {
            JOptionPaneUtil.messageInformation(ex.getMessage());
        } catch (Exception ex) {
               ex.printStackTrace();
            Pagar pagar = new Pagar();
            tmPagar.adiciona(pagar);
        }
    }

    public void renovaPesquisa() {
        tmPagar.clear();
        pesquisar();
    }

    public void formataTabela(Class classe) {
        try {
            tPagar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            int numeroColunas = tmPagar.getColumnCount();
            int numero = 0;
            System.out.println(numeroColunas);
            while (numeroColunas != numero) {
                for (Method metodo : Pagar.class.getDeclaredMethods()) {
                    if (metodo.isAnnotationPresent(Tabela.class)) {
                        Tabela anotacao = metodo.getAnnotation(Tabela.class);
                        if (anotacao.tipoAtributo().equals("object")) {
                            tPagar.getColumnModel().getColumn(numero).setPreferredWidth(130);
                        } else if (anotacao.nome().equals(tmPagar.getColumnName(numero))) {
                            tPagar.getColumnModel().getColumn(numero).setPreferredWidth(anotacao.tamanho());
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
