/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.principal;

import br.com.genises.model.Version;
import br.com.genises.view.GUIAbertura;
import br.com.genises.view.GUILogin;
import br.com.genises.view.util.mensages.JOptionPaneUtil;
import java.awt.Dimension;

/**
 *
 * @author Tiago
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        try {
            LoadProperties loadProperties = new LoadProperties();

            //  Pega os valores de cada propriedade informando as respectivas chaves.
            String versao = loadProperties.getPropriedade("versaoAtual");
            String data = loadProperties.getPropriedade("dataLancamento");
            Version versaoAtual = new Version();
            versaoAtual.setVersaoAtual(versao);
            versaoAtual.setDataLancamento(data);

            GUIAbertura guiAbetura = new GUIAbertura(versaoAtual);

            Dimension paneSize = guiAbetura.getSize();
            Dimension screenSize = guiAbetura.getToolkit().getScreenSize();
            guiAbetura.setLocation((screenSize.width - paneSize.width) / 2, (screenSize.height - paneSize.height) / 2);
            guiAbetura.setVisible(true);
        } catch (Throwable ex) {

            JOptionPaneUtil.messageError("ERRO FATAL - O PROGRAMA SERÁ FECHADO!" + ex.getMessage());
            System.exit(0);
        }

    }
}
