package Telas.TelaPedido;

import Tabelas.MontarTabelas;
import Telas.JFrame_Base;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public abstract class JFrame_Pedido extends JFrame_Base
{
    private JLabel jLabel_Cliente;
    private JLabel jLabel_Mesa;
    private JLabel jLabel_Itens;
    private JLabel jLabel_Produto;
    private JLabel jLabel_ErroCliente;
    private JLabel jLabel_ErroMesa;
    private JLabel jLabel_ErroProduto;
    
    private JComboBox jComboBox_Cliente;
    private JComboBox jComboBox_Mesa;
    private JComboBox jComboBox_Produto;
    
    private JButton jButton_Add;
    private JButton jButton_Remove;
    private JButton jButton_Search;
    
    private JScrollPane jScrollPane_TabelaItensPedido;
    
    public JFrame_Pedido(String image)
    {
        super(image);
        setSize(800, 600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Componentes();
    }
    
    public void Componentes()
    {
        //Criar Componentes
        jLabel_Cliente = new JLabel();
        jLabel_Itens = new JLabel();
        jLabel_Mesa = new JLabel();
        jLabel_Produto = new JLabel();
        
        jLabel_ErroCliente = new JLabel();
        jLabel_ErroMesa = new JLabel();
        jLabel_ErroProduto = new JLabel();
        
        jComboBox_Cliente = new JComboBox();
        jComboBox_Mesa = new JComboBox();
        jComboBox_Produto = new JComboBox();
        
        jButton_Add = new JButton();
        jButton_Remove = new JButton();
        jButton_Search = new JButton();
        jScrollPane_TabelaItensPedido = new JScrollPane(MontarTabelas.TabelaItensPedidos());
        
        //Icone de Botões
        Icon icone = new ImageIcon("src\\Imagens\\ItensAdd.png");
        jButton_Add.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\ItensRemove.png");
        jButton_Remove.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\ItensSearch.png");
        jButton_Search.setIcon(icone);
        
        //Texto e formatações
        jLabel_Cliente.setText("(*)Cliente:");
        jLabel_Itens.setText("(*)Itens");
        jLabel_Mesa.setText("(*)Mesa: ");
        jLabel_Produto.setText("Produto:");
        jLabel_ErroCliente.setForeground(Color.red);
        jLabel_ErroMesa.setForeground(Color.red);
        jLabel_ErroProduto.setForeground(Color.red);
        jLabel_Itens.setFont(new java.awt.Font("Tahoma", 1, 18));
        
        //Carregar ComboBox
        jComboBox_Cliente.addItem("---SELECIONE---");
        jComboBox_Mesa.addItem("---SELECIONE---");
        jComboBox_Produto.addItem("---SELECIONE---");
        MontarTabelas.getListaProduto().stream().forEach((p) ->
        {
            jComboBox_Produto.addItem(p);
        });
        MontarTabelas.getListaCliente().stream().forEach((c) ->
        {
            jComboBox_Cliente.addItem(c);
        });
        for(int i = 1;i<16;i++)
            jComboBox_Mesa.addItem("Mesa "+ i);
        
        //Painel Central
        getGBC().fill = GridBagConstraints.BOTH;
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getGBC().insets = new Insets(3, 3, 3, 3);
        
        //Linha 0
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getjPanel_CENTER().add(jLabel_Cliente, getGBC());
        getGBC().gridx = 1;
        getGBC().gridwidth = 2;
        getjPanel_CENTER().add(jComboBox_Cliente, getGBC());
        
        //Linha 1
        getGBC().gridy = 1;
        getjPanel_CENTER().add(jLabel_ErroCliente, getGBC());
        
        //Linha 2
        getGBC().gridx = 0;
        getGBC().gridy = 2;
        getGBC().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Mesa, getGBC());
        getGBC().gridx = 1;
        getGBC().gridwidth = 2;
        getjPanel_CENTER().add(jComboBox_Mesa, getGBC());
        
        //Linha 3
        getGBC().gridy = 3;
        getjPanel_CENTER().add(jLabel_ErroMesa, getGBC());
        
        //Linha 4
        getGBC().fill = GridBagConstraints.NONE;
        getGBC().anchor = GridBagConstraints.CENTER;
        getGBC().gridx = 0;
        getGBC().gridy = 4;
        getGBC().gridwidth = GridBagConstraints.REMAINDER;
        getjPanel_CENTER().add(jLabel_Itens, getGBC());
        
        //Linha 5
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getGBC().gridx = 0;
        getGBC().gridy = 5;
        getGBC().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Produto, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jComboBox_Produto, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jButton_Add, getGBC());
        
        //Linha 6
        getGBC().gridx = 1;
        getGBC().gridy = 6;
        getjPanel_CENTER().add(jLabel_ErroProduto, getGBC());
        
        //Linha 7
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getGBC().gridx = 0;
        getGBC().gridy = 7;
        getjPanel_CENTER().add(jButton_Remove, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jButton_Search, getGBC());
        
        //Linha 8
        getGBC().fill = GridBagConstraints.BOTH;
        getGBC().gridx = 0;
        getGBC().gridy = 8;
        getGBC().weightx = 1;
        getGBC().weighty = 1; 
        getGBC().gridwidth = GridBagConstraints.REMAINDER;
        getGBC().gridheight = GridBagConstraints.REMAINDER;  
        getjPanel_CENTER().add(jScrollPane_TabelaItensPedido, getGBC());
    }
}
