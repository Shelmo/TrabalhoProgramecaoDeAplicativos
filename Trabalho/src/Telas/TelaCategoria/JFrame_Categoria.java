package Telas.TelaCategoria;

import Telas.JFrame_Base;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Categoria extends JFrame_Base
{
    private JLabel jLabel_Nome;
    private JLabel jLabel_ErroNome;
    private JTextField jTextField_Nome;
    
    public JFrame_Categoria(String image)
    {
        super(image);
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar componentes
        jLabel_Nome = new JLabel();
        jLabel_ErroNome = new JLabel();
        jTextField_Nome = new JTextField(40);
        
        //Texto e formatações
        jLabel_Nome.setText("(*) Nome:");
        jLabel_ErroNome.setForeground(Color.red);
        jTextField_Nome.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        
        //Posicionar Componentes
        getGBC().fill = GridBagConstraints.BOTH;
        
        //Linha 0
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getjPanel_CENTER().add(jLabel_Nome, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextField_Nome, getGBC());
        
        //Linha 1
        getGBC().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroNome, getGBC());
    }
    
    public boolean Verificacoes()
    {
        if(jTextField_Nome.getText().isEmpty())
        {
            jLabel_ErroNome.setText("O campo Nome é obrigatório!");
            return false;
        }
        
        return true;
    }
    
    public void LimparjLabel_Erro()
    {
        jLabel_ErroNome.setText(null);
    }
    
    public void LimparCampos()
    {
        jTextField_Nome.setText(null);
    }

    public JTextField getjTextField_Nome()
    {
        return jTextField_Nome;
    }
}
