/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.view.util.mensages;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiago
 */
public class JOptionPaneUtil {

    public static void messageError(String mensagem) {
        JFrame parent = new JFrame();
        JOptionPane optionPane = new JOptionPane(mensagem, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(parent, "Genêsis - Error");
        dialog.setVisible(true);

    }

    public static void messageInformation(String mensagem) {
        JFrame parent = new JFrame();
        JOptionPane optionPane = new JOptionPane(mensagem, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(parent, "Genêsis - Informação");
        dialog.setVisible(true);
    }

    public static void messagePlain(String mensagem) {
        JFrame parent = new JFrame();
        JOptionPane optionPane = new JOptionPane(mensagem, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
        JDialog dialog = optionPane.createDialog(parent, "Genêsis - aviso");
        dialog.setVisible(true);
    }

}
