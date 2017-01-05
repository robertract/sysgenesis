package br.com.genises.dao;

import br.com.genises.principal.LoadProperties;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Robert Frederico
 */
abstract class Dao {

    static Connection connection = null;
    private final String classForName = "org.firebirdsql.jdbc.FBDriver";
    private final String usuario = "SYSDBA";
    private final String senha = "masterkey";

    public Connection getConnection() throws SQLException, Exception {
//        if (Dao.connection == null) {
        Dao.connection = conecta();
//            return Dao.connection;
//        } else {
//            if (Dao.connection.isClosed()) {
//                return Dao.connection;
//            } else {
        conecta();
        return Dao.connection;
//            }
//        }
    }

    private Connection conecta() {
        try {
            Class.forName(classForName);
            //25.82.237.65/3050:C:\\datages.gdb
            Connection connection = DriverManager.getConnection("jdbc:firebirdsql:" + buscaConfiguracao(), usuario, senha);
            return connection;//10.1.1.3/3050:C:\\DATAGES.gdb
        } catch (SQLException sql) {
            throw new RuntimeException("PROBLEMA FISICO NO BANCO DE DADOS!!!" + sql.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("PROBLEMA NÃO INESPERADO NO SERVIDOR DE BANCO DE DADOS CENTRAL!!!" + e.getMessage());
        }
    }

    private String buscaConfiguracao() {
        try {
            String data = null;

            FileReader fileReader = new FileReader("C://genesis//config.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            //  reader.readLine();
            data = reader.readLine();
            fileReader.close();
            reader.close();
            return data.trim();
        } catch (Exception ex) {
            throw new RuntimeException("PROBLEMA AO CARREGAR CONFIGURAÇÕES!");
        }
    }

}
