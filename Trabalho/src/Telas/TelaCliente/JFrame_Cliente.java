/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas.TelaCliente;

import Telas.JFrame_Base;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Shelmo
 */
public class JFrame_Cliente extends JFrame_Base
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
    
    public JFrame_Cliente()
    {
        super(null);
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar componentes
        jLabel_Nome = new JLabel();
    }
    

    @Override
    public void Confirmar(){}
    
}
