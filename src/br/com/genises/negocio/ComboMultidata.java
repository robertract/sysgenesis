/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.genises.negocio;

public class ComboMultidata {

    private long valor;
    private String texto;

    public ComboMultidata(long id, String nome) {
        this.valor = id;
        this.texto = nome;
    }

    public long getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return texto;
    }
}
