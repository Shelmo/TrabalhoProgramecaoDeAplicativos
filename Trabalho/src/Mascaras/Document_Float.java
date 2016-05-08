/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mascaras;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Shelmo
 */
public class Document_Float extends PlainDocument 
{
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
    {
        String texto = getText(0, getLength());
        if(texto.length() < 16)
        {
            remove(0, getLength());
            StringBuffer strBuf = new StringBuffer(texto.replaceAll(",", "")
                    + str);
            if(strBuf.length() < 3)
                strBuf.insert(0, ",");
            else
                strBuf.insert(strBuf.length() - 2, ",");
            super.insertString(0, strBuf.toString(), a);
        }
    }
}
