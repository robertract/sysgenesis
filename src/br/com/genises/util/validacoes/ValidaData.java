/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.util.validacoes;

import br.com.genises.view.exception.NegocioException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Tiago
 */
public abstract class ValidaData {

    public static boolean isValidDate(String inDate) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static boolean dataMaiorSistema(String data) {
        Calendar dataSistema = Calendar.getInstance();
        dataSistema.set(Calendar.HOUR, 0);
        dataSistema.set(Calendar.MINUTE, 0);
        dataSistema.set(Calendar.SECOND, 0);
        dataSistema.set(Calendar.MILLISECOND, 0);

        String dataInformada = data;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInf = null;
        try {
            dataInf = dateFormat.parse(dataInformada);
        } catch (ParseException ex) {
        }
        if (dataInf.before(dataSistema.getTime())) {
            //System.out.println("Data menor que a data do sistema");
            return false;
        } else {
            //System.out.println("Data maior ou igual a data do sistema");
            return true;
        }

    }

    public static boolean dataVerificaMaiorIdade(String data) {

        String dataNascimento = data;
        int idade2 = 0;
        Date dtNasc;
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
        if(data.trim().length() < 10){
            throw new NegocioException("Data incorreta!");
        }
        try {
            dtNasc = dateFormat.parse(dataNascimento);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NegocioException("Data incorreta!");
        }
        long idadeMilisegundo = System.currentTimeMillis() - dtNasc.getTime();
        Long idade = (((((idadeMilisegundo / 1000) / 60) / 60) / 24) / 365);
        idade2 = (idade.intValue());
        if (idade < 18) {
            return true;
        } else {
            return false;
        }

    }
}
