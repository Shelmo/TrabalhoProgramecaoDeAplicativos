package Telas.TelaPedido;

import Tabelas.TabelaCliente;
import Tabelas.TabelaItensPedido;
import Tabelas.TabelaProduto;
import Telas.JFrame_Base;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

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
    private JLabel jLabel_Quantidade;
    private JLabel jLabel_ErroCliente;
    private JLabel jLabel_ErroMesa;
    private JLabel jLabel_ErroProduto;
    
    private JComboBox jComboBox_Cliente;
    private JComboBox jComboBox_Mesa;
    private JComboBox jComboBox_Produto;
    
    private JButton jButton_Add;
    private JButton jButton_Remove;
    private JButton jButton_Search;
    private JButton jButton_FecharPedido;
    private JButton jButton_Filter;
    
    private JSpinner jSpinner_Quantidade;
    
    private JScrollPane jScrollPane_TabelaItensPedido;
    
    private TabelaItensPedido tabelaItensPedido;
    
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
        jLabel_Quantidade = new JLabel();
        
        
        jLabel_ErroCliente = new JLabel();
        jLabel_ErroMesa = new JLabel();
        jLabel_ErroProduto = new JLabel();
        
        jComboBox_Cliente = new JComboBox();
        jComboBox_Mesa = new JComboBox();
        jComboBox_Produto = new JComboBox();
        
        jButton_Add = new JButton();
        jButton_Remove = new JButton();
        jButton_Search = new JButton();
        jButton_FecharPedido = new JButton();
        jButton_Filter = new JButton();
        
        jSpinner_Quantidade = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        
        tabelaItensPedido = new TabelaItensPedido();
        
        jScrollPane_TabelaItensPedido = new JScrollPane(tabelaItensPedido);
        
        //Icone de Botões
        Icon icone = new ImageIcon("src\\Imagens\\ItensAdd.png");
        jButton_Add.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\ItensRemove.png");
        jButton_Remove.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\ItensSearch.png");
        jButton_Search.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\ItensFilter.png");
        jButton_Filter.setIcon(icone);
        
        //Texto e formatações
        jButton_FecharPedido.setText("Fechar Pedido");
        jLabel_Cliente.setText("(*)Cliente:");
        jLabel_Itens.setText("(*)Itens");
        jLabel_Mesa.setText("(*)Mesa: ");
        jLabel_Produto.setText("Produto:");
        jLabel_Quantidade.setText("Quantidade:");
        jLabel_ErroCliente.setForeground(Color.red);
        jLabel_ErroMesa.setForeground(Color.red);
        jLabel_ErroProduto.setForeground(Color.red);
        jLabel_Itens.setFont(new java.awt.Font("Tahoma", 1, 18));
        JSpinner.NumberEditor jsEditor = (JSpinner.NumberEditor)jSpinner_Quantidade.getEditor();
        DefaultFormatter formatter = (DefaultFormatter) jsEditor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        jButton_FecharPedido.setFont(new java.awt.Font("Tahoma", 1, 13));
        
        //Carregar ComboBox
        jComboBox_Cliente.addItem("---SELECIONE---");
        jComboBox_Mesa.addItem("---SELECIONE---");
        jComboBox_Produto.addItem("---SELECIONE---");
        
        new TabelaProduto().getLista().stream().forEach((p) ->
        {
            jComboBox_Produto.addItem(p);
        });
        new TabelaCliente().getLista().stream().forEach((c) ->
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
        getGBC().fill = GridBagConstraints.NONE;
        getGBC().gridx = 0;
        getGBC().gridy = 5;
        getGBC().gridwidth = 1;
        getjPanel_CENTER().add(jLabel_Produto, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jComboBox_Produto, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jLabel_Quantidade, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jSpinner_Quantidade, getGBC());
        getGBC().gridx = 4;
        getGBC().anchor = GridBagConstraints.NORTHWEST;
        getjPanel_CENTER().add(jButton_Add, getGBC());
        
        //Linha 6
        getGBC().gridx = 1;
        getGBC().gridy = 6;
        getGBC().gridwidth = 3;
        getjPanel_CENTER().add(jLabel_ErroProduto, getGBC());
        
        //Linha 7
        getGBC().gridx = 0;
        getGBC().gridy = 7;
        getGBC().gridwidth = 1;
        getjPanel_CENTER().add(jButton_Remove, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jButton_Search, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jButton_Filter, getGBC());
        
        //Linha 8
        getGBC().fill = GridBagConstraints.BOTH;
        getGBC().gridx = 0;
        getGBC().gridy = 8;
        getGBC().weightx = 1;
        getGBC().weighty = 1; 
        getGBC().gridwidth = GridBagConstraints.REMAINDER;
        getGBC().gridheight = GridBagConstraints.REMAINDER;  
        getjPanel_CENTER().add(jScrollPane_TabelaItensPedido, getGBC());
        
        jButton_Filter.addActionListener((java.awt.event.ActionEvent evt)
                -> 
                {
                    Telas.Modal.showAsModal(new JFrame_FiltroItensPedido(tabelaItensPedido), this);
        });
    }
    
    public boolean VerificarProduto()
    {
        if(jComboBox_Produto.getSelectedIndex() == 0)
        {
            jLabel_ErroProduto.setText("O campo Produto é obrigatório!");
            return false;
        }
        
        return true;
    }
    
    public boolean Verificacoes()
    {
        boolean retorno = true;
        
        if(jComboBox_Cliente.getSelectedIndex() == 0)
        {
            jLabel_ErroCliente.setText("O Campo Cliente é obrigatório!");
            retorno = false;
        }
        
        if(jComboBox_Mesa.getSelectedIndex() == 0)
        {
            jLabel_ErroMesa.setText("O Campo Mesa é obrigatório!");
            retorno = false;
        }
        
        if(tabelaItensPedido.getLista().isEmpty())
        {
            jLabel_ErroProduto.setText("Nenhum item foi associado ao pedido!");
            retorno = false;
        }
        
        return retorno;
    }
    
    public void LimparErros()
    {
        jLabel_ErroCliente.setText(null);
        jLabel_ErroMesa.setText(null);
        jLabel_ErroProduto.setText(null);
    }
    
    public void LimparCampos()
    {
        jComboBox_Cliente.setSelectedIndex(0);
        jComboBox_Mesa.setSelectedIndex(0);
        jComboBox_Produto.setSelectedIndex(0);
        tabelaItensPedido.getLista().clear();
    }

    public JComboBox getjComboBox_Cliente()
    {
        return jComboBox_Cliente;
    }

    public JComboBox getjComboBox_Mesa()
    {
        return jComboBox_Mesa;
    }

    public JComboBox getjComboBox_Produto()
    {
        return jComboBox_Produto;
    }

    public JButton getjButton_Add()
    {
        return jButton_Add;
    }

    public JButton getjButton_Remove()
    {
        return jButton_Remove;
    }

    public JButton getjButton_Search()
    {
        return jButton_Search;
    }

    public JSpinner getjSpinner_Quantidade()
    {
        return jSpinner_Quantidade;
    }

    public JButton getjButton_FecharPedido()
    {
        return jButton_FecharPedido;
    }

    public JLabel getjLabel_Produto()
    {
        return jLabel_Produto;
    }

    public JLabel getjLabel_Quantidade()
    {
        return jLabel_Quantidade;
    }

    public TabelaItensPedido getTabelaItensPedido()
    {
        return tabelaItensPedido;
    }
}
