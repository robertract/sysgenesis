/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.util.validacoes;

/**
 *
 * @author Robert Frederico
 */
public abstract class ValidarCNPJ {
       
    public static boolean isCNPJ(String CNPJ) {
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
        CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
        CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
        CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
        CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
       (CNPJ.length() != 14)){
       return(false);
    }
    
     
       int soma = 0, aux, dig;  
       String cnpj_calc = CNPJ.substring(0,12);  
  
       if ( CNPJ.length() != 14 )  
         return false;  
  
       char[] chr_cnpj = CNPJ.toCharArray();  
  
       /* Primeira parte */  
       for( int i = 0; i < 4; i++ )  
         if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )  
           soma += (chr_cnpj[i] - 48 ) * (6 - (i + 1)) ;  
       for( int i = 0; i < 8; i++ )  
         if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )  
           soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;  
       dig = 11 - (soma % 11);  
  
       cnpj_calc += ( dig == 10 || dig == 11 ) ?  
                      "0" : Integer.toString(dig);  
  
       /* Segunda parte */  
       soma = 0;  
       for ( int i = 0; i < 5; i++ )  
         if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )  
           soma += (chr_cnpj[i] - 48 ) * (7 - (i + 1)) ;  
       for ( int i = 0; i < 8; i++ )  
         if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )  
           soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;  
       dig = 11 - (soma % 11);  
       cnpj_calc += ( dig == 10 || dig == 11 ) ?  
                      "0" : Integer.toString(dig);  
  
       return CNPJ.equals(cnpj_calc);  
    }  
  
    
}
