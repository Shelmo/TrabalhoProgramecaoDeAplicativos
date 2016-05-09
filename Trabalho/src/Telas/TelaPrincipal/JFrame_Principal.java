package Telas.TelaPrincipal;

import Tabelas.MontarTabelas;
import Telas.JFrame_Base;
import Telas.TelaCategoria.JFrame_AlterarCategoria;
import Telas.TelaCategoria.JFrame_LocalizarCategoria;
import Telas.TelaCategoria.JFrame_NovaCategoria;
import Telas.TelaCategoria.JFrame_RemoverCategoria;
import Telas.TelaCliente.JFrame_AlterarCliente;
import Telas.TelaCliente.JFrame_Cliente;
import Telas.TelaCliente.JFrame_LocalizarCliente;
import Telas.TelaCliente.JFrame_NovoCliente;
import Telas.TelaCliente.JFrame_RemoverCliente;
import Telas.TelaProduto.JFrame_AlterarProduto;
import Telas.TelaProduto.JFrame_LocalizarProduto;
import Telas.TelaProduto.JFrame_NovoProduto;
import Telas.TelaProduto.JFrame_RemoverProduto;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Shelmo
 */
public class JFrame_Principal extends JFrame_Base
{
    private boolean CategoriaSelecionado;
    private boolean ProdutoSelecionado;
    private boolean ClienteSelecionado;
    
    private final int CATEGORIA = 0;
    private final int PRODUTO = 1;
    private final int CLIENTE = 2;
    
    private JButton jButton_Categoria;
    private JButton jButton_Produto;
    private JButton jButton_Cliente;
    private JButton jButton_Add;
    private JButton jButton_Remove;
    private JButton jButton_Update;
    private JButton jButton_Search;
    private JButton jButton_Close;
    
    private JScrollPane jScrollPane_BaseTabela;
    
    private MontarTabelas tabela;
    
    public JFrame_Principal()
    {
        super("");
        Componentes();
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void Componentes()
    {
        //Criar componentes
        jButton_Categoria = new JButton();
        jButton_Produto = new JButton();
        jButton_Cliente = new JButton();
        jButton_Add = new JButton();
        jButton_Close = new JButton();
        jButton_Remove = new JButton();
        jButton_Search = new JButton();
        jButton_Update = new JButton();
        
        tabela = new MontarTabelas();
        
        //Icone de Botões
        Icon icone = new ImageIcon("src\\Imagens\\IconeCategoria.png");
        jButton_Categoria.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\IconeProdutos.png");
        jButton_Produto.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\IconeCliente.png");
        jButton_Cliente.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\IconeSair.png");
        getjButton_Voltar().setText(null);
        getjButton_Voltar().setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\add.png");
        jButton_Add.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\close.png");
        jButton_Close.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\remove.png");
        jButton_Remove.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\search.png");
        jButton_Search.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\update.png");
        jButton_Update.setIcon(icone);
        
        //Componentes não mostrados
        getjLabel_Titulo().setVisible(false);
        getjButton_Confirmar().setVisible(false);
        VisibilidadeBotoes(false);
        
        //Painel Norte
        getjPanel_NORTH().add(jButton_Categoria);
        getjPanel_NORTH().add(jButton_Produto);
        getjPanel_NORTH().add(jButton_Cliente);
        
        //Painel Central
        getGBC().fill = GridBagConstraints.NONE;
        getGBC().anchor = GridBagConstraints.NORTHEAST;
        getGBC().insets = new Insets(10, 10, 10, 10);
        
        //Linha 0
        getGBC().gridwidth = 1;
        getGBC().gridheight = 1;
        getGBC().weightx = 0;
        getGBC().weighty = 0;
        getGBC().gridx = 0;
        getGBC().gridy = 0;
        getjPanel_CENTER().add(jButton_Add, getGBC());
        getGBC().gridx = 1;
        getjPanel_CENTER().add(jButton_Remove, getGBC());
        getGBC().gridx = 2;
        getjPanel_CENTER().add(jButton_Update, getGBC());
        getGBC().gridx = 3;
        getjPanel_CENTER().add(jButton_Search, getGBC());
        getGBC().gridx = 4;
        getjPanel_CENTER().add(jButton_Close, getGBC());
        
        //Ações de botões
        //Botão Categoria
        jButton_Categoria.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MontarJPanelCentral(CATEGORIA);
            }
        });
        
        //Botão Produtos
        jButton_Produto.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MontarJPanelCentral(PRODUTO);
            }
        });
        
        //Botão Cliente
        jButton_Cliente.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MontarJPanelCentral(CLIENTE);
            }
        });
        
        //Botão Adicionar
        jButton_Add.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(CategoriaSelecionado)
                    new JFrame_NovaCategoria();
                if(ProdutoSelecionado)
                    new JFrame_NovoProduto();
                if(ClienteSelecionado)
                    new JFrame_NovoCliente();
            }
        });
        
        //Botão Remover
        jButton_Remove.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(CategoriaSelecionado)
                    Remover(CATEGORIA);
                if(ProdutoSelecionado)
                    Remover(PRODUTO);
                if(ClienteSelecionado)
                    Remover(CLIENTE);
            }
        });
        
        //Botão Alterar
        jButton_Update.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(CategoriaSelecionado)
                    Alterar(CATEGORIA);
                if(ProdutoSelecionado)
                    Alterar(PRODUTO);
                if(ClienteSelecionado)
                    Alterar(CLIENTE);
            }
        });
        
        //Botão Pesquisar
        jButton_Search.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(CategoriaSelecionado)
                    Localizar(CATEGORIA);
                if(ProdutoSelecionado)
                    Localizar(PRODUTO);
                if(ClienteSelecionado)
                    Localizar(CLIENTE);
            }
        });
        
        //Botão Close
        jButton_Close.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                LimparTela();
            }
        });
        
        //Mouse Clicked
        MontarTabelas.getjTable_Tabelas().addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                if(evt.getClickCount() == 2)
                {
                    if(CategoriaSelecionado)
                        Alterar(CATEGORIA);
                    if(ProdutoSelecionado)
                        Alterar(PRODUTO);
                    if(ClienteSelecionado)
                        Alterar(CLIENTE);
                }
            }
        });
    }
    
    private int SelecionarTabela(boolean mostrar)
    {
        int select = MontarTabelas.getjTable_Tabelas().getSelectedRow();
        if (select == -1 && mostrar)
            JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
        
        return select;
    }
    
    private void Remover(int constante)
    {
        int select = SelecionarTabela(true);
        
        if(select == -1)
            return;
        
        if(constante == CATEGORIA)
            new JFrame_RemoverCategoria(select, MontarTabelas.getListaCategoria().get(select));
        
        if(constante == PRODUTO)
            new JFrame_RemoverProduto(select, MontarTabelas.getListaProduto().get(select));
        
        if(constante == CLIENTE)
            new JFrame_RemoverCliente(select, MontarTabelas.getListaCliente().get(select));
    }
    
    private void Alterar(int constante)
    {
        int select = SelecionarTabela(true);
        
        if(select == -1)
            return;
        
        if(constante == CATEGORIA)
            new JFrame_AlterarCategoria(select, MontarTabelas.getListaCategoria().get(select));
        
        if(constante == PRODUTO)
            new JFrame_AlterarProduto(select, MontarTabelas.getListaProduto().get(select));
        
        if(constante == CLIENTE)
            new JFrame_AlterarCliente(select, MontarTabelas.getListaCliente().get(select));
    }
    
    private void Localizar(int constante)
    {
        int select = SelecionarTabela(false);
        if(constante == CATEGORIA)
            new JFrame_LocalizarCategoria(select);
        
        if(constante == PRODUTO)
            new JFrame_LocalizarProduto(select);
        
        if(constante == CLIENTE)
            new JFrame_LocalizarCliente(select);
    }
    
    private void MontarJPanelCentral(int constante)
    {
        MontarTabelas.SelecionarTabela(constante);
        if(jScrollPane_BaseTabela != null)
            LimparTela();
        VisibilidadeBotoes(true);
        TelaSelecionada(constante);
        jScrollPane_BaseTabela = new JScrollPane(MontarTabelas.getjTable_Tabelas());
        
        //Linha 1
        getGBC().gridy = 1;
        getGBC().gridx = 0;
        getGBC().fill = GridBagConstraints.BOTH;
        getGBC().weightx = 1;  
        getGBC().gridwidth = GridBagConstraints.REMAINDER;
        getGBC().weighty = 1;  
        getGBC().gridheight = GridBagConstraints.REMAINDER;  
        getjPanel_CENTER().add(jScrollPane_BaseTabela, getGBC());
    }
    
    private void VisibilidadeBotoes(boolean visivel)
    {
        jButton_Add.setVisible(visivel);
        jButton_Close.setVisible(visivel);
        jButton_Remove.setVisible(visivel);
        jButton_Search.setVisible(visivel);
        jButton_Update.setVisible(visivel);
    }
    
    private void LimparTela()
    {
        TelaSelecionada(-1);
        VisibilidadeBotoes(false);
        jScrollPane_BaseTabela.setVisible(false);
    }
    
    private void TelaSelecionada(int constante)
    {
        CategoriaSelecionado = false;
        ProdutoSelecionado = false;
        ClienteSelecionado = false;
        
        if(constante == 0)
            CategoriaSelecionado = true;
        
        if(constante == 1)
            ProdutoSelecionado = true;
        
        if(constante == 2)
            ClienteSelecionado = true;
    }
    
    @Override
    public void Confirmar(){/*Não utilizada para classe principal*/}
    
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new JFrame_Principal();
            }
        });
    }
}
