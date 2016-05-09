package Mascaras;

import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public class Mascaras
{
    public static char NULO = '\0';
    
    public static JFormattedTextField setFormat(String mascara, char caractereReposicao)
    {
        JFormattedTextField jFormattedTextField = new JFormattedTextField();
        try
        {
            MaskFormatter mask = new MaskFormatter(mascara);
            if(caractereReposicao != '\0')
                mask.setPlaceholderCharacter(caractereReposicao);
            jFormattedTextField.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc){}
        
        return jFormattedTextField;
    }
    
    public static JFormattedTextField setFormat(JFormattedTextField jFormattedTextField,
            String mascara, char caractereReposicao)
    {
        try
        {
            MaskFormatter mask = new MaskFormatter(mascara);
            if(caractereReposicao != '\0')
                mask.setPlaceholderCharacter(caractereReposicao);
            jFormattedTextField.setFormatterFactory(new DefaultFormatterFactory(mask));
        }
        catch (ParseException exc){}
        
        return jFormattedTextField;
    }
}
