/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.TelaCliente;

import Telas.JFrame_Base;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Cliente extends JFrame_Base
{
    private JLabel jLabel_Nome;
    private JLabel jLabel_CPF;
    private JLabel jLabel_DataNasc;
    private JLabel jLabel_Cidade;
    private JLabel jLabel_Bairro;
    private JLabel jLabel_Logradouro;
    private JLabel jLabel_Numero;
    private JLabel jLabel_Complemento;
    private JLabel jLabel_CEP;
    private JLabel jLabel_Fone;
    private JLabel jLabel_Celular;
    private JLabel jLabel_Email;
    private JLabel jLabel_ErroNome;
    private JLabel jLabel_ErroCPF;
    private JLabel jLabel_DadosPessoais;
    private JLabel jLabel_Endereco;
    private JLabel jLabel_Contados;
    
    private JTextField jTextField_Nome;
    private JTextField jTextField_Cidade;
    private JTextField jTextField_Bairro;
    private JTextField jTextField_Logradouro;
    private JTextField jTextField_Complemento;
    private JTextField jTextField_Email;
    private JTextField jTextField_Numero;
    
    private JFormattedTextField jFormattedTextField_CPF;
    private JFormattedTextField jFormattedTextField_DataNasc;
    private JFormattedTextField jFormattedTextField_CEP;
    private JFormattedTextField jFormattedTextField_Fone;
    private JFormattedTextField jFormattedTextField_Celular;
    
    private JSeparator jSeparator_DadosPessoais_Endereco;
    private JSeparator jSeparator_Endereco_Contatos;
    
    public JFrame_Cliente(String image)
    {
        super(image);
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar componentes
        jLabel_Bairro = new JLabel();
        jLabel_CEP = new JLabel();
        jLabel_CPF = new JLabel();
        jLabel_Celular = new JLabel();
        jLabel_Cidade = new JLabel();
        jLabel_Complemento = new JLabel();
        jLabel_DataNasc = new JLabel();
        jLabel_Email = new JLabel();
        jLabel_Fone = new JLabel();
        jLabel_Logradouro = new JLabel();
        jLabel_Nome = new JLabel();
        jLabel_Numero = new JLabel();
        jLabel_ErroNome = new JLabel();
        jLabel_ErroCPF = new JLabel();
        jLabel_DadosPessoais = new JLabel();
        jLabel_Endereco = new JLabel();
        jLabel_Contados = new JLabel();
        
        jTextField_Bairro = new JTextField(15);
        jTextField_Cidade = new JTextField(15);
        jTextField_Complemento = new JTextField(15);
        jTextField_Email = new JTextField(41);
        jTextField_Logradouro = new JTextField(15);
        jTextField_Nome = new JTextField(41);
        jTextField_Numero = new JTextField(15);
        
        jFormattedTextField_CEP = Mascaras.Mascaras.setFormat("##.###-###", '_');
        jFormattedTextField_CPF = Mascaras.Mascaras.setFormat("###.###.###-##", '_');
        jFormattedTextField_Celular = Mascaras.Mascaras.setFormat("(##)####-####", '_');
        jFormattedTextField_DataNasc = Mascaras.Mascaras.setFormat("##/##/####", '_');
        jFormattedTextField_Fone = Mascaras.Mascaras.setFormat("(##)####-####", '_');
        
        jSeparator_DadosPessoais_Endereco = new JSeparator();
        jSeparator_Endereco_Contatos = new JSeparator();
        
        jSeparator_DadosPessoais_Endereco.setPreferredSize(new Dimension(570, 10));
        jSeparator_Endereco_Contatos.setPreferredSize(new Dimension(570, 10));

        
        //Texto e formatações
        jLabel_Nome.setText("(*) Nome:");
        jLabel_CPF.setText("(*) CPF:");
        jLabel_DataNasc.setText("Data de Nascimento:");
        jLabel_Cidade.setText("Cidade:");
        jLabel_Bairro.setText("Bairro:");
        jLabel_Logradouro.setText("Logradouro:");
        jLabel_Numero.setText("Número:");
        jLabel_Complemento.setText("Complemento:");
        jLabel_CEP.setText("CEP:");
        jLabel_Fone.setText("Telefone");
        jLabel_Celular.setText("Celular:");
        jLabel_Email.setText("E-mail:");
        jLabel_DadosPessoais.setText("Dados Pessoais");
        jLabel_Endereco.setText("Endereço");
        jLabel_Contados.setText("Contatos");
        jLabel_ErroCPF.setForeground(Color.red);
        jLabel_ErroNome.setForeground(Color.red);
        jLabel_DadosPessoais.setFont(new java.awt.Font("Tahoma", 1, 15));
        jLabel_Endereco.setFont(new java.awt.Font("Tahoma", 1, 15));
        jLabel_Contados.setFont(new java.awt.Font("Tahoma", 1, 15));
        jTextField_Nome.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Logradouro.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Email.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Complemento.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Cidade.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Bairro.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Numero.setDocument(new Mascaras.Document_Inteiro());
        
        //Posicionar Componentes
        getGBC().fill = GridBagConstraints.NONE;
        getGBC().anchor = GridBagConstraints.CENTER;
        
        //Linha 0
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getGBC().gridwidth = 4;
        getjPanel_CENTER().add(jLabel_DadosPessoais, getGBC());
        
        //Linha 1
        getGBC().gridy = 1;
        getGBC().gridwidth = 1;
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getjPanel_CENTER().add(jLabel_Nome, getGBC());
        getGBC().gridx = 1;
        getGBC().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Nome, getGBC());
        
        //Linha 2
        getGBC().gridy = 2;
        getjPanel_CENTER().add(jLabel_ErroNome, getGBC());
        
        //Linha 3
        getGBC().gridx = 0;
        getGBC().gridy = 3;
        getGBC().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_CPF, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_CPF, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jLabel_DataNasc, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jFormattedTextField_DataNasc, getGBC());
        
        //Linha 4
        getGBC().gridx = 1;
        getGBC().gridy = 4;
        getjPanel_CENTER().add(jLabel_ErroCPF, getGBC());
        
        //Linha 5
        getGBC().gridx = 0;
        getGBC().gridy = 5;
        getGBC().gridwidth = 4;
        getGBC().anchor = GridBagConstraints.CENTER;
        getjPanel_CENTER().add(jSeparator_DadosPessoais_Endereco, getGBC());
        
        //Linha 6
        getGBC().gridy = 6;
        getjPanel_CENTER().add(jLabel_Endereco, getGBC());
        
        //Linha 7
        getGBC().gridx = 0;
        getGBC().gridy = 7;
        getGBC().gridwidth = 1;
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getjPanel_CENTER().add(jLabel_Cidade, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextField_Cidade, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jLabel_Bairro, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jTextField_Bairro, getGBC());
        
        //Linha 8
        getGBC().gridx = 0;
        getGBC().gridy = 8;
        getjPanel_CENTER().add(jLabel_Logradouro, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextField_Logradouro, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jLabel_Numero, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jTextField_Numero, getGBC());
        
        //Linha 9
        getGBC().gridx = 0;
        getGBC().gridy = 9;
        getjPanel_CENTER().add(jLabel_Complemento, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextField_Complemento, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jLabel_CEP, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jFormattedTextField_CEP, getGBC());
        
        //Linha 10
        getGBC().gridx = 0;
        getGBC().gridy = 10;
        getGBC().gridwidth = 4;
        getGBC().anchor = GridBagConstraints.CENTER;
        getjPanel_CENTER().add(jSeparator_Endereco_Contatos, getGBC());
        
        //Linha 11
        getGBC().gridy = 11;
        getjPanel_CENTER().add(jLabel_Contados, getGBC());
        
        //Linha 12
        getGBC().gridx = 0;
        getGBC().gridy = 12;
        getGBC().gridwidth = 1;
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getjPanel_CENTER().add(jLabel_Fone, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jFormattedTextField_Fone, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jLabel_Celular, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jFormattedTextField_Celular, getGBC());
        
        //Linha 13
        getGBC().gridx = 0;
        getGBC().gridy = 13;
        getjPanel_CENTER().add(jLabel_Email, getGBC());
        getGBC().gridx = 1;
        getGBC().gridwidth = 3;
        getjPanel_CENTER().add(jTextField_Email, getGBC()); 
    }
    
    protected boolean Verificacoes()
    {
        boolean retorno = true;
        
        if(jTextField_Nome.getText().isEmpty())
        {
            jLabel_ErroNome.setText("O campo Nome é obrigatório!");
            retorno = false;
        }
        
        if(jFormattedTextField_CPF.getText().equals("___.___.___-__"))
        {
            jLabel_ErroCPF.setText("O campo CPF é obrigatório!");
            retorno = false;
        }
        
        return retorno;
    }
    
    protected void LimparErros()
    {
        jLabel_ErroNome.setText(null);
        jLabel_ErroCPF.setText(null);
    }
    
    protected void LimparCampos()
    {
        jTextField_Bairro.setText(null);
        jTextField_Cidade.setText(null);
        jTextField_Complemento.setText(null);
        jTextField_Email.setText(null);
        jTextField_Logradouro.setText(null);
        jTextField_Nome.setText(null);
        jTextField_Numero.setText(null);
        jFormattedTextField_CEP.setText(null);
        jFormattedTextField_CPF.setText(null);
        jFormattedTextField_Celular.setText(null);
        jFormattedTextField_DataNasc.setText(null);
        jFormattedTextField_Fone.setText(null);
    }

    public JTextField getjTextField_Nome()
    {
        return jTextField_Nome;
    }

    public JTextField getjTextField_Cidade()
    {
        return jTextField_Cidade;
    }

    public JTextField getjTextField_Bairro()
    {
        return jTextField_Bairro;
    }

    public JTextField getjTextField_Logradouro()
    {
        return jTextField_Logradouro;
    }

    public JTextField getjTextField_Complemento()
    {
        return jTextField_Complemento;
    }

    public JTextField getjTextField_Email()
    {
        return jTextField_Email;
    }

    public JTextField getjTextField_Numero()
    {
        return jTextField_Numero;
    }

    public JFormattedTextField getjFormattedTextField_CPF()
    {
        return jFormattedTextField_CPF;
    }

    public JFormattedTextField getjFormattedTextField_DataNasc()
    {
        return jFormattedTextField_DataNasc;
    }

    public JFormattedTextField getjFormattedTextField_CEP()
    {
        return jFormattedTextField_CEP;
    }

    public JFormattedTextField getjFormattedTextField_Fone()
    {
        return jFormattedTextField_Fone;
    }

    public JFormattedTextField getjFormattedTextField_Celular()
    {
        return jFormattedTextField_Celular;
    }
}
