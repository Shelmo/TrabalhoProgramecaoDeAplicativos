package Telas;

import Mascaras.Document_CaracteresLimitados;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_BaseFiltros extends JFrame_Base
{
    private JLabel jLabel_LocalizarFiltrar;
    private JLabel jLabel_ErroLocalizarFiltrar;
    private JFormattedTextField jFormattedTextField_LocalizarFiltrar;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox_PesquisarAcima;
    private JCheckBox jCheckBox_PesquisarAbaixo;
    
    
    public JFrame_BaseFiltros(String image)
    {
        super(image);
        Componentes();
    }
    
    public void Componentes()
    {
        //Criar componentes
        jLabel_LocalizarFiltrar = new JLabel();
        jLabel_ErroLocalizarFiltrar = new JLabel();
        jFormattedTextField_LocalizarFiltrar = new JFormattedTextField();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jCheckBox_PesquisarAbaixo = new JCheckBox();
        jCheckBox_PesquisarAcima = new JCheckBox();
        
        //Personalizar Textos
        jFormattedTextField_LocalizarFiltrar.setDocument(new Document_CaracteresLimitados(255));
        jLabel_ErroLocalizarFiltrar.setForeground(Color.red);
        
        //Line 0
        getGBC().fill = GridBagConstraints.BOTH;
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getjPanel_CENTER().add(jLabel_LocalizarFiltrar, getGBC());
        getGBC().gridx = 1;
        getGBC().gridwidth = GridBagConstraints.REMAINDER;
        getjPanel_CENTER().add(jFormattedTextField_LocalizarFiltrar, getGBC());
        
        //Line 1
        getGBC().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroLocalizarFiltrar, getGBC());
        
        //Line 2
        getGBC().gridwidth = 1;
        getGBC().gridx = 1;
        getGBC().gridy = 2;
        getjPanel_CENTER().add(jCheckBox1, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jCheckBox2, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jCheckBox3, getGBC());
        
        //Line 3
        getGBC().gridx = 1;
        getGBC().gridy = 3;
        getjPanel_CENTER().add(jCheckBox_PesquisarAbaixo, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jCheckBox_PesquisarAcima, getGBC());
        
        
        //Marcar CheckBox Padrao
        jCheckBox1.setSelected(true);
        jCheckBox_PesquisarAbaixo.setSelected(true);
        
        //Ações Componentes
        //CheckBox1
        jCheckBox1.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            jCheckBox1.setSelected(true);
            if(jCheckBox1.isSelected())
            {
                jCheckBox2.setSelected(false);
                jCheckBox3.setSelected(false);
            }
            AcaoJCheckBox1();
        });
        
        //CheckBox2
        jCheckBox2.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            jCheckBox2.setSelected(true);
            if(jCheckBox2.isSelected())
            {
                jCheckBox1.setSelected(false);
                jCheckBox3.setSelected(false);
            }
            AcaoJCheckBox2();
        });
        
        //CheckBox3
        jCheckBox3.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            jCheckBox3.setSelected(true);
            if(jCheckBox3.isSelected())
            {
                jCheckBox1.setSelected(false);
                jCheckBox2.setSelected(false);
            }
            AcaoJCheckBox3();
        });
        
        //CheckBox Localizar Abaixo
        jCheckBox_PesquisarAbaixo.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            jCheckBox_PesquisarAbaixo.setSelected(true);
            if(jCheckBox_PesquisarAbaixo.isSelected())
                jCheckBox_PesquisarAcima.setSelected(false);
        });
        
        //CheckBox Localizar Acima
        jCheckBox_PesquisarAcima.addActionListener((java.awt.event.ActionEvent evt) ->
        {
            jCheckBox_PesquisarAcima.setSelected(true);
            if(jCheckBox_PesquisarAcima.isSelected())
                jCheckBox_PesquisarAbaixo.setSelected(false);
        });
    }
    
    public boolean Verificaoes()
    {
        if(jFormattedTextField_LocalizarFiltrar.getText().isEmpty())
        {
            jLabel_ErroLocalizarFiltrar.setText("O campo Localizar deve ser preenchido!");
            return false;
        }
        
        return true;
    }

    public JLabel getjLabel_ErroLocalizarFiltrar()
    {
        return jLabel_ErroLocalizarFiltrar;
    }

    public JFormattedTextField getjFormattedTextField_LocalizarFiltrar()
    {
        return jFormattedTextField_LocalizarFiltrar;
    }

    public JCheckBox getjCheckBox1()
    {
        return jCheckBox1;
    }

    public JCheckBox getjCheckBox2()
    {
        return jCheckBox2;
    }

    public JCheckBox getjCheckBox3()
    {
        return jCheckBox3;
    }
    
    public JCheckBox getjCheckBox_PesquisarAcima()
    {
        return jCheckBox_PesquisarAcima;
    }

    public JCheckBox getjCheckBox_PesquisarAbaixo()
    {
        return jCheckBox_PesquisarAbaixo;
    }

    public void setjFormattedTextField_LocalizarFiltrar(JFormattedTextField jFormattedTextField_LocalizarFiltrar)
    {
        this.jFormattedTextField_LocalizarFiltrar = jFormattedTextField_LocalizarFiltrar;
    }

    public JLabel getjLabel_LocalizarFiltrar()
    {
        return jLabel_LocalizarFiltrar;
    }
    
    public abstract void AcaoJCheckBox1();
    
    public abstract void AcaoJCheckBox2();
    
    public abstract void AcaoJCheckBox3();
}
