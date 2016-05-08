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
public class Document_CaracteresLimitados extends PlainDocument
{
    private int tamanhoMax;
         
    public Document_CaracteresLimitados(int tamanhoMax)
    {
        this.tamanhoMax = tamanhoMax;
    }
    public void insertString(int offset, String str, AttributeSet attr)
    {
        if (str.isEmpty())
            return;

        String stringAntiga;
        try
        {
            stringAntiga = getText(0, getLength());

            int tamanhoNovo = stringAntiga.length() + str.length();

            if (tamanhoNovo <= tamanhoMax)
                super.insertString(offset, str, attr);
            else
                super.insertString(offset, "", attr);
        }
        catch (BadLocationException ex){}
    }
}

