package Mascaras;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Shelmo
 */
public class Mascaras
{
    public static MaskFormatter MascaraData()
    {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
        }
        
        return mask;
    }
    
    public static MaskFormatter MascaraTelefone()
    {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("(##)####-####");
        } catch (ParseException ex) {
        }
        mask.setPlaceholderCharacter('_');
        return mask;
    }
    
    public static MaskFormatter MascaraCPF()
    {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("###.###.###-##");
        } catch (ParseException ex) {
        }
        mask.setPlaceholderCharacter('_');
        return mask;
    }
    
    public static MaskFormatter MascaraCEP()
    {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##.###-###");
        } catch (ParseException ex) {
        }
        mask.setPlaceholderCharacter('_');
        return mask;
    }
}
