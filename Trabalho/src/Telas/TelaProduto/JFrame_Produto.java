package Telas.TelaProduto;

import Tabelas.MontarTabelas;
import Telas.JFrame_Base;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Produto extends JFrame_Base
{
    private JLabel jLabel_Categoria;
    private JLabel jLabel_Nome;
    private JLabel jLabel_Valor;
    private JLabel jLabel_Descricao;
    private JLabel jLabel_ErroCategoria;
    private JLabel jLabel_ErroNome;
    private JLabel jLabel_ErroValor;
    
    private JComboBox jComboBox_Categoria;
    
    private JTextField jTextField_Nome;
    private JTextField jTextField_Valor;
    
    private JTextArea jTextArea_Descricao;
    
    public JFrame_Produto()
    {
        super("src\\Imagens\\TelaProduto.jpg");
        Componentes();
    }
    
    private void Componentes()
    {
        //Criar Componentes
        jLabel_Categoria = new JLabel();
        jLabel_Descricao = new JLabel();
        jLabel_ErroCategoria = new JLabel();
        jLabel_ErroNome = new JLabel();
        jLabel_ErroValor = new JLabel();
        jLabel_Nome = new JLabel();
        jLabel_Valor = new JLabel();
        
        jComboBox_Categoria = new JComboBox();
        jTextField_Nome = new JTextField(40);
        jTextField_Valor = new JTextField(7);
        jTextArea_Descricao = new JTextArea();
        
        //Texto e formatações
        jLabel_Categoria.setText("(*) Categoria:");
        jLabel_Descricao.setText("Descrição:");
        jLabel_Nome.setText("(*) Nome:");
        jLabel_Valor.setText("(*) Valor: R$");
        jLabel_ErroCategoria.setForeground(Color.red);
        jLabel_ErroNome.setForeground(Color.red);
        jLabel_ErroValor.setForeground(Color.red);
        jTextArea_Descricao.setRows(6);
        jTextArea_Descricao.setColumns(40);
        jTextField_Nome.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        jTextField_Valor.setDocument(new Mascaras.Document_Float());
        jTextArea_Descricao.setDocument(new Mascaras.Document_CaracteresLimitados(255));
        
        //Carregar ComboBox
        jComboBox_Categoria.addItem("---SELECIONE---");
        for(Categoria c : MontarTabelas.getListaCategoria())
            jComboBox_Categoria.addItem(c);
        
        //Posicionar Componentes
        getGBC().fill = GridBagConstraints.NONE;
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        
        //Linha 0
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getjPanel_CENTER().add(jLabel_Categoria, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jComboBox_Categoria, getGBC());
        
        //Linha 1
        getGBC().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroCategoria, getGBC());
        
        //Linha 2
        getGBC().gridx = 0;
        getGBC().gridy = 2;
        getjPanel_CENTER().add(jLabel_Nome, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextField_Nome, getGBC());
        
        //Linha 3
        getGBC().gridy = 3;
        getjPanel_CENTER().add(jLabel_ErroNome, getGBC());
        
        //Linha 4
        getGBC().gridx = 0;
        getGBC().gridy = 4;
        getjPanel_CENTER().add(jLabel_Valor, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextField_Valor, getGBC());
        
        //Linha 5
        getGBC().gridy = 5;
        getjPanel_CENTER().add(jLabel_ErroValor, getGBC());
        
        //Linha 6
        getGBC().gridx = 0;
        getGBC().gridy = 6;
        getjPanel_CENTER().add(jLabel_Descricao, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jTextArea_Descricao, getGBC());
    }
    
    protected boolean Verificaoes()
    {
        boolean retorno = true;
        
        if(jTextField_Nome.getText().isEmpty())
        {
            jLabel_ErroNome.setText("O campo Nome é obrigatório!");
            retorno = false;
        }
        
        if(jTextField_Valor.getText().isEmpty())
        {
            jLabel_ErroValor.setText("O campo Valor é obrigatório!");
            retorno = false;
        }
        
        if(jComboBox_Categoria.getSelectedIndex() == 0)
        {
            jLabel_ErroCategoria.setText("Selecione uma Categoria!");
            retorno = false;
        }
        
        return retorno;
    }
    
    protected void LimparErros()
    {
        jLabel_ErroCategoria.setText(null);
        jLabel_ErroNome.setText(null);
        jLabel_ErroValor.setText(null);
    }
    
    protected void LimparCampos()
    {
        jTextArea_Descricao.setText(null);
        jTextField_Nome.setText(null);
        jTextField_Valor.setText(null);
        jComboBox_Categoria.setSelectedIndex(0);
    }

    public JComboBox getjComboBox_Categoria()
    {
        return jComboBox_Categoria;
    }

    public JTextField getjTextField_Nome()
    {
        return jTextField_Nome;
    }

    public JTextArea getjTextArea_Descricao()
    {
        return jTextArea_Descricao;
    }

    public JTextField getjTextField_Valor()
    {
        return jTextField_Valor;
    }
}