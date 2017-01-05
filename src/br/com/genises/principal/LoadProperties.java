/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.principal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author Tiago
 */
public class LoadProperties {

    // Classe java.util.Properties responsável por armazenar valores
    // (chave e valor) ambos do tipo String.
    private static Properties defaultProps = null;

    // Local do arquivo mensagens.properties
  //  String localProperties = "teste.properties";

    /**
     * Construtor da Classe LoadProperties
     */
    public LoadProperties() throws Exception {
        try {
            defaultProps = new Properties();

            // Aqui utilizamos um ClassLoader para carregar nosso arquivo
            // de propriedades.
            //       FileInputStream file = new FileInputStream("C:\\Users\\Tiago\\Documents\\NetBeansProjects\\Teste-properties\\src\\teste\\properties\\teste.properties");
            //    FileInputStream file = new FileInputStream("./teste.properties");
            InputStream is = LoadProperties.class.getResourceAsStream("/versao.properties");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

       //     FileReader fileReader = new FileReader("src\\teste\\teste.properties");
            // Lê os dados do arquivo de propriedade
            defaultProps.load(reader);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    /**
     * Recupera o valor da propriedade informada.
     *
     * @param Propriedade Caminho informado para recuperar seu Endereço.
     * @return Endereço do caminho.
     */
    public String getPropriedade(String Propriedade) {
        return defaultProps.getProperty(Propriedade);
    }
}
