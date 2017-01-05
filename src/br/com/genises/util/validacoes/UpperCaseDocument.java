package br.com.genises.util.validacoes;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UpperCaseDocument extends PlainDocument {

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        super.insertString(offs, str.toUpperCase(), a);
    }
}
