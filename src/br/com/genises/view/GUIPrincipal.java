package br.com.genises.view;

import br.com.genises.negocio.BContador;
import br.com.genises.model.Contador;
import br.com.genises.model.Igreja;
import br.com.genises.model.ResponsavelLegal;
import br.com.genises.model.Usuario;
import br.com.genises.negocio.BIgreja;
import br.com.genises.negocio.BResponsavel;
import br.com.genises.view.internal.GUIAjudaSobre;
import br.com.genises.view.internal.GUIBanco;
import br.com.genises.view.internal.GUICadastroContador;
import br.com.genises.view.internal.GUICadastroIgreja;
import br.com.genises.view.internal.GUICadastroMembrasia;
import br.com.genises.view.internal.GUICadastroResponsavel;
import br.com.genises.view.internal.GUICaixa;
import br.com.genises.view.internal.GUICelulas;
import br.com.genises.view.internal.GUICheque;
import br.com.genises.view.internal.GUIFornecedor;
import br.com.genises.view.internal.GUIHistorico;
import br.com.genises.view.internal.GUIManutencaoCelulas;
import br.com.genises.view.internal.GUIMembros;
import br.com.genises.view.internal.GUIPagar;
import br.com.genises.view.internal.GUIPlanoConta;
import br.com.genises.view.internal.GUIUsuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author Tiago
 */
public class GUIPrincipal extends javax.swing.JFrame {

    public static Usuario usuarioLogado;

    public GUIPrincipal(Usuario usuario) throws Throwable {
//        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        initComponents();
        this.usuarioLogado = usuario;
        URL url = this.getClass().getResource("/br/com/genises/util/imagens/icon.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        deleteMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SySGênesis - Desenvolvendo Soluções, Criando Oportunidades");

        desktopPane.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/igreja_vectorized.png"))); // NOI18N
        jButton1.setText("Cadastro da Igreja");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton1);
        jButton1.setBounds(30, 30, 150, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/responsavel_vectorized.png"))); // NOI18N
        jButton2.setText("Responsável Legal");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton2);
        jButton2.setBounds(30, 80, 150, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/ramo_vectorized.png"))); // NOI18N
        jButton3.setText("Atividade Principal");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.add(jButton3);
        jButton3.setBounds(30, 130, 150, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/liderança_vectorized.png"))); // NOI18N
        jButton4.setText("Trilho - Liderança");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.add(jButton4);
        jButton4.setBounds(30, 480, 150, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/contador_vectorized.png"))); // NOI18N
        jButton5.setText("Contador");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton5);
        jButton5.setBounds(30, 180, 150, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/membros_vectorized.png"))); // NOI18N
        jButton6.setText("Membrasia");
        jButton6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton6);
        jButton6.setBounds(30, 230, 150, 40);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/celulas_vectorized.png"))); // NOI18N
        jButton7.setText("Cadastro de Celulas");
        jButton7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton7);
        jButton7.setBounds(30, 280, 150, 40);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/celulas multiplicadas_vectorized.png"))); // NOI18N
        jButton8.setText("Manutenção de Celulas");
        jButton8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton8);
        jButton8.setBounds(30, 330, 150, 40);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/plano de contas_vectorized.png"))); // NOI18N
        jButton9.setText("Plano de Contas");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        desktopPane.add(jButton9);
        jButton9.setBounds(30, 380, 150, 40);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/historico_vectorized.png"))); // NOI18N
        jButton10.setText("Historicos");
        jButton10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton10);
        jButton10.setBounds(30, 430, 150, 40);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/sobre_vectorized.png"))); // NOI18N
        jButton11.setText("Sobre - Ajuda");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton11);
        jButton11.setBounds(30, 530, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/genises/util/imagens/ARTE  ICONE.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(20, -40, 1110, 650);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastro");

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Usuários");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        jMenuItem1.setText("Bancos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuItem4.setText("Fornecedor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem4);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Financeiro");

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Caixa");
        deleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(deleteMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Pagar ");
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        jMenuItem2.setText("Cheques");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem2);

        jMenuItem3.setText("Plano de Conta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem3);

        jMenuItem5.setText("Lançamento Banco");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem5);

        menuBar.add(editMenu);

        jMenu1.setText("Relatorios");

        jMenu2.setText("Financeiro");

        jMenu3.setText("Pagar");
        jMenu2.add(jMenu3);

        jMenu4.setText("Caixa");
        jMenu2.add(jMenu4);

        jMenu5.setText("Plano de Conta");
        jMenu2.add(jMenu5);

        jMenu6.setText("Cheque");
        jMenu2.add(jMenu6);

        jMenu7.setText("Bancos");
        jMenu2.add(jMenu7);

        jMenu1.add(jMenu2);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed

        if ((guiUsuario == null) || (!guiUsuario.isVisible())) {
            try {
                guiUsuario = new GUIUsuario();
                desktopPane.add(guiUsuario);
                Dimension paneSize = guiUsuario.getSize();
                Dimension screenSize = guiUsuario.getToolkit().getScreenSize();
                guiUsuario.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiUsuario.setVisible(true);
            } catch (Exception ex) {
                //   Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            Igreja igreja = new Igreja();
            BIgreja bIgreja = new BIgreja();
            igreja = bIgreja.pesquisaIgreja();

            if ((guiIgreja == null) || (!guiIgreja.isVisible())) {
                try {
                    guiIgreja = new GUICadastroIgreja(igreja);
                    desktopPane.add(guiIgreja);
                    Dimension paneSize = guiIgreja.getSize();
                    Dimension screenSize = guiIgreja.getToolkit().getScreenSize();
                    guiIgreja.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                    guiIgreja.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        try {
            Contador contador = new Contador();
            BContador bContador = new BContador();
            contador = bContador.pesquisaContador();

            if ((guiContador == null) || (!guiContador.isVisible())) {
                try {
                    guiContador = new GUICadastroContador(contador);
                    desktopPane.add(guiContador);
                    Dimension paneSize = guiContador.getSize();
                    Dimension screenSize = guiContador.getToolkit().getScreenSize();
                    guiContador.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                    guiContador.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            ResponsavelLegal responsavelLegal = new ResponsavelLegal();
            BResponsavel bResponsavel = new BResponsavel();
            responsavelLegal = bResponsavel.pesquisaResponsavel();

            if ((guiResponsavel == null) || (!guiResponsavel.isVisible())) {
                try {
                    guiResponsavel = new GUICadastroResponsavel(responsavelLegal);
                    desktopPane.add(guiResponsavel);
                    Dimension paneSize = guiResponsavel.getSize();
                    Dimension screenSize = guiResponsavel.getToolkit().getScreenSize();
                    guiResponsavel.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                    guiResponsavel.setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

// TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        GUIAjudaSobre guiajuda = new GUIAjudaSobre();
        if ((guiajuda == null) || (!guiajuda.isVisible())) {
            try {
                desktopPane.add(guiajuda);
                Dimension paneSize = guiajuda.getSize();
                Dimension screenSize = guiajuda.getToolkit().getScreenSize();
                guiajuda.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiajuda.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        if ((guiCelula == null) || (!guiCelula.isVisible())) {
            try {
                guiCelula = new GUICelulas();
                desktopPane.add(guiCelula);
                Dimension paneSize = guiCelula.getSize();
                Dimension screenSize = guiCelula.getToolkit().getScreenSize();
                guiCelula.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiCelula.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if ((guiMembrasia == null) || (!guiMembrasia.isVisible())) {
            try {
                guiMembrasia = new GUIMembros();
                desktopPane.add(guiMembrasia);
                Dimension paneSize = guiMembrasia.getSize();
                Dimension screenSize = guiMembrasia.getToolkit().getScreenSize();
                guiMembrasia.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiMembrasia.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if ((guimanutencaocelulas == null) || (!guimanutencaocelulas.isVisible())) {
            try {
                guimanutencaocelulas = new GUIManutencaoCelulas();
                desktopPane.add(guimanutencaocelulas);
                Dimension paneSize = guimanutencaocelulas.getSize();
                Dimension screenSize = guimanutencaocelulas.getToolkit().getScreenSize();
                guimanutencaocelulas.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guimanutencaocelulas.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if ((guihistorico == null) || (!guihistorico.isVisible())) {
            try {
                guihistorico = new GUIHistorico();
                desktopPane.add(guihistorico);
                Dimension paneSize = guihistorico.getSize();
                Dimension screenSize = guihistorico.getToolkit().getScreenSize();
                guihistorico.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guihistorico.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        if ((guibanco == null) || (!guibanco.isVisible())) {
            try {
                guibanco = new GUIBanco();
                desktopPane.add(guibanco);
                Dimension paneSize = guibanco.getSize();
                Dimension screenSize = guibanco.getToolkit().getScreenSize();
                guibanco.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guibanco.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if ((guicheque == null) || (!guicheque.isVisible())) {
            try {
                guicheque = new GUICheque();
                desktopPane.add(guicheque);
                Dimension paneSize = guicheque.getSize();
                Dimension screenSize = guicheque.getToolkit().getScreenSize();
                guicheque.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guicheque.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        if ((guiPlanoConta == null) || (!guiPlanoConta.isVisible())) {
            try {
                guiPlanoConta = new GUIPlanoConta();
                desktopPane.add(guiPlanoConta);
                Dimension paneSize = guiPlanoConta.getSize();
                Dimension screenSize = guiPlanoConta.getToolkit().getScreenSize();
                guiPlanoConta.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiPlanoConta.setVisible(true);
            } catch (Exception ex) {
                //   Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        if ((guiFornecedor == null) || (!guiFornecedor.isVisible())) {
            try {
                guiFornecedor = new GUIFornecedor();
                desktopPane.add(guiFornecedor);
                Dimension paneSize = guiFornecedor.getSize();
                Dimension screenSize = guiFornecedor.getToolkit().getScreenSize();
                guiFornecedor.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiFornecedor.setVisible(true);
            } catch (Exception ex) {
                //   Logger.getLogger(GUIPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        if ((gUIPagar == null) || (!gUIPagar.isVisible())) {
            try {
                gUIPagar = new GUIPagar();
                desktopPane.add(gUIPagar);
                Dimension paneSize = gUIPagar.getSize();
                Dimension screenSize = gUIPagar.getToolkit().getScreenSize();
                gUIPagar.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                gUIPagar.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void deleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMenuItemActionPerformed
    if ((guiCaixa == null) || (!guiCaixa.isVisible())) {
            try {
                guiCaixa = new GUICaixa();
                desktopPane.add(guiCaixa);
                Dimension paneSize = guiCaixa.getSize();
                Dimension screenSize = guiCaixa.getToolkit().getScreenSize();
                guiCaixa.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
                guiCaixa.setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
    }//GEN-LAST:event_deleteMenuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem saveAsMenuItem;
    // End of variables declaration//GEN-END:variables
    private GUICadastroContador guiContador;
    private GUICadastroResponsavel guiResponsavel;
    private GUICadastroIgreja guiIgreja;
    private GUICelulas guiCelula;
    private GUIMembros guiMembrasia;
    private GUIUsuario guiUsuario;
    private GUIManutencaoCelulas guimanutencaocelulas;
    private GUIHistorico guihistorico;
    private GUIBanco guibanco;
    private GUICheque guicheque;
    private GUIPlanoConta guiPlanoConta;
    private GUIFornecedor guiFornecedor;
    private GUIPagar gUIPagar;
    private GUICaixa guiCaixa;
}
