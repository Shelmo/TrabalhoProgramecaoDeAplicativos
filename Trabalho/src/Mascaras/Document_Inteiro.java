/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mascaras;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Shelmo
 */
public class Document_Inteiro extends PlainDocument
{

    private int maxlength;

    @Override
    public void insertString(int offs, String str, AttributeSet a)
    {
        try
        {
            Integer.parseInt(str);
        }
        catch (NumberFormatException ex)
        {
            str = "";
        }
        try
        {
            super.insertString(offs, str, a);
        }
        catch (BadLocationException ex){}

    }

}
