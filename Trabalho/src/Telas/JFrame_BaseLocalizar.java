package Telas;

import Mascaras.Document_CaracteresLimitados;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_BaseLocalizar extends JFrame_Base
{
    private JLabel jLabel_Localizar;
    private JLabel jLabel_ErroLocalizar;
    private JFormattedTextField jFormattedTextField_Localizar;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox_PesquisarAcima;
    private JCheckBox jCheckBox_PesquisarAbaixo;
    
    public JFrame_BaseLocalizar(String image)
    {
        super(image);
        Componentes();
    }
    
    public void Componentes()
    {
        //Criar componentes
        jLabel_Localizar = new JLabel();
        jLabel_ErroLocalizar = new JLabel();
        jFormattedTextField_Localizar = new JFormattedTextField();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jCheckBox_PesquisarAbaixo = new JCheckBox();
        jCheckBox_PesquisarAcima = new JCheckBox();
        
        //Textos
        getjLabel_Titulo().setText("Localizar");
        getjButton_Confirmar().setText("Localizar");
        jLabel_Localizar.setText("(*) Localizar");
        getjLabel_Aviso().setText("(*) Campos obrigatórios!");
        jCheckBox_PesquisarAbaixo.setText("Localizar Abaixo");
        jCheckBox_PesquisarAcima.setText("Localizar Acima");
        
        //Personalizar Textos
        jFormattedTextField_Localizar.setDocument(new Document_CaracteresLimitados(255));
        jLabel_ErroLocalizar.setForeground(Color.red);
        
        //Line 0
        getGBC().fill = GridBagConstraints.BOTH;
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getjPanel_CENTER().add(jLabel_Localizar, getGBC());
        getGBC().gridx = 1;
        getGBC().gridwidth = 3;
        getjPanel_CENTER().add(jFormattedTextField_Localizar, getGBC());
        
        //Line 1
        getGBC().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroLocalizar, getGBC());
        
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
        jCheckBox1.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox1.setSelected(true);
                if(jCheckBox1.isSelected())
                {
                    jCheckBox2.setSelected(false);
                    jCheckBox3.setSelected(false);
                }
                AcaoJCheckBox1();
            }
        });
        
        //CheckBox2
        jCheckBox2.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox2.setSelected(true);
                if(jCheckBox2.isSelected())
                {
                    jCheckBox1.setSelected(false);
                    jCheckBox3.setSelected(false);
                }
                AcaoJCheckBox2();
            }
        });
        
        //CheckBox3
        jCheckBox3.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox3.setSelected(true);
                if(jCheckBox3.isSelected())
                {
                    jCheckBox1.setSelected(false);
                    jCheckBox2.setSelected(false);
                }
                AcaoJCheckBox3();
            }
        });
        
        //CheckBox Localizar Abaixo
        jCheckBox_PesquisarAbaixo.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox_PesquisarAbaixo.setSelected(true);
                if(jCheckBox_PesquisarAbaixo.isSelected())
                    jCheckBox_PesquisarAcima.setSelected(false);
            }
        });
        
        //CheckBox Localizar Acima
        jCheckBox_PesquisarAcima.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCheckBox_PesquisarAcima.setSelected(true);
                if(jCheckBox_PesquisarAcima.isSelected())
                    jCheckBox_PesquisarAbaixo.setSelected(false);
            }
        });
    }
    
    public boolean Verificaoes()
    {
        if(jFormattedTextField_Localizar.getText().isEmpty())
        {
            jLabel_ErroLocalizar.setText("O campo Localizar deve ser preenchido!");
            return false;
        }
        
        return true;
    }

    public JLabel getjLabel_ErroLocalizar()
    {
        return jLabel_ErroLocalizar;
    }

    public JFormattedTextField getjFormattedTextField_Localizar()
    {
        return jFormattedTextField_Localizar;
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

    public void setjFormattedTextField_Localizar(JFormattedTextField jFormattedTextField_Localizar)
    {
        this.jFormattedTextField_Localizar = jFormattedTextField_Localizar;
    }
    
    public abstract void AcaoJCheckBox1();
    
    public abstract void AcaoJCheckBox2();
    
    public abstract void AcaoJCheckBox3();
}
