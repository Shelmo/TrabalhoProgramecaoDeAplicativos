package Telas.TelaPrincipal;

import Tabelas.MontarTabelas;
import Tabelas.TabelaCategoria;
import Telas.JFrame_Base;
import Telas.Modal;
import Telas.TelaCategoria.JFrame_AlterarCategoria;
import Telas.TelaCategoria.JFrame_LocalizarCategoria;
import Telas.TelaCategoria.JFrame_NovaCategoria;
import Telas.TelaCategoria.JFrame_RemoverCategoria;
import Telas.TelaCliente.JFrame_AlterarCliente;
import Telas.TelaCliente.JFrame_LocalizarCliente;
import Telas.TelaCliente.JFrame_NovoCliente;
import Telas.TelaCliente.JFrame_RemoverCliente;
import Telas.TelaPedido.JFrame_NovoPedido;
import Telas.TelaProduto.JFrame_AlterarProduto;
import Telas.TelaProduto.JFrame_LocalizarProduto;
import Telas.TelaProduto.JFrame_NovoProduto;
import Telas.TelaProduto.JFrame_RemoverProduto;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class JFrame_Principal extends JFrame_Base
{
    private boolean CategoriaSelecionado;
    private boolean ProdutoSelecionado;
    private boolean ClienteSelecionado;
    private boolean PedidoSelecionado;
    
    private final int CATEGORIA = 0;
    private final int PRODUTO = 1;
    private final int CLIENTE = 2;
    private final int PEDIDO = 3;
    
    private JButton jButton_Categoria;
    private JButton jButton_Produto;
    private JButton jButton_Cliente;
    private JButton jButton_Pedido;
    private JButton jButton_Add;
    private JButton jButton_Remove;
    private JButton jButton_Update;
    private JButton jButton_Search;
    private JButton jButton_Close;
    
    private JScrollPane jScrollPane_BaseTabela;
    
    private JTable JTableAtual;
    private ArrayList arrayList;
    
    private JMenuBar jMenuBar;
    
    private JMenu jMenu_Categoria;
    private JMenu jMenu_Produto;
    private JMenu jMenu_Cliente;
    private JMenu jMenu_Sobre;
    
    private JMenuItem jMenuItem_NovaCategoria;
    private JMenuItem jMenuItem_LocalizarCategoria;
    private JMenuItem jMenuItem_NovoProduto;
    private JMenuItem jMenuItem_LocalizarProduto;
    private JMenuItem jMenuItem_NovoCliente;
    private JMenuItem jMenuItem_LocalizarCliente;
    
    public JFrame_Principal()
    {
        super("src\\Imagens\\TelaPrincipal.jpg");
        Componentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void Componentes()
    {
        //Criar componentes
        jButton_Categoria = new JButton();
        jButton_Produto = new JButton();
        jButton_Cliente = new JButton();
        jButton_Pedido = new JButton();
        jButton_Add = new JButton();
        jButton_Close = new JButton();
        jButton_Remove = new JButton();
        jButton_Search = new JButton();
        jButton_Update = new JButton();
        
        jMenuBar = new JMenuBar();
        jMenu_Categoria = new JMenu();
        jMenu_Cliente = new JMenu();
        jMenu_Produto = new JMenu();
        jMenu_Sobre = new JMenu();
        jMenuItem_LocalizarCategoria = new JMenuItem();
        jMenuItem_LocalizarCliente = new JMenuItem();
        jMenuItem_LocalizarProduto = new JMenuItem();
        jMenuItem_NovaCategoria = new JMenuItem();
        jMenuItem_NovoCliente = new JMenuItem();
        jMenuItem_NovoProduto = new JMenuItem();
        
        //Icone de Botões
        Icon icone = new ImageIcon("src\\Imagens\\IconeCategoria.png");
        jButton_Categoria.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\IconeProdutos.png");
        jButton_Produto.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\IconeCliente.png");
        jButton_Cliente.setIcon(icone);
        icone = new ImageIcon("src\\Imagens\\IconePedidos.png");
        jButton_Pedido.setIcon(icone);
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
        
        //Texto e formatações
        jMenu_Categoria.setText("Categorias");
        jMenu_Produto.setText("Produtos");
        jMenu_Cliente.setText("Clientes");
        jMenu_Sobre.setText("Sobre");
        jMenuItem_NovaCategoria.setText("Nova Categoria");
        jMenuItem_LocalizarCategoria.setText("Localizar Categoria");
        jMenuItem_NovoProduto.setText("Novo Produto");
        jMenuItem_LocalizarProduto.setText("Localizar Produto");
        jMenuItem_NovoCliente.setText("Novo Cliente");
        jMenuItem_LocalizarCliente.setText("Localizar Cliente");
        
        jMenu_Categoria.add(jMenuItem_NovaCategoria);
        jMenu_Categoria.add(jMenuItem_LocalizarCategoria);
        jMenu_Produto.add(jMenuItem_NovoProduto);
        jMenu_Produto.add(jMenuItem_LocalizarProduto);
        jMenu_Cliente.add(jMenuItem_NovoCliente);
        jMenu_Cliente.add(jMenuItem_LocalizarCliente);
        
        jMenuBar.add(jMenu_Categoria);
        jMenuBar.add(jMenu_Produto);
        jMenuBar.add(jMenu_Cliente);
        jMenuBar.add(jMenu_Sobre);
        
        //Componentes não mostrados
        getjLabel_Titulo().setVisible(false);
        getjButton_Confirmar().setVisible(false);
        VisibilidadeBotoes(false);
        
        //Painel Norte
        getjPanel_NORTH_WEST().add(jMenuBar);
        getjPanel_NORTH_CENTER().add(jButton_Categoria);
        getjPanel_NORTH_CENTER().add(jButton_Produto);
        getjPanel_NORTH_CENTER().add(jButton_Cliente);
        getjPanel_NORTH_CENTER().add(jButton_Pedido);
        
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
                TrocaTela(CATEGORIA);
            }
        });
        
        //Botão Produtos
        jButton_Produto.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TrocaTela(PRODUTO);
            }
        });
        
        //Botão Cliente
        jButton_Cliente.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TrocaTela(CLIENTE);
            }
        });
        
        //Botão Pedido
        jButton_Pedido.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                TrocaTela(PEDIDO);
            }
        });
        
        //Botão Adicionar
        jButton_Add.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if(CategoriaSelecionado)
                    Modal(new JFrame_NovaCategoria((TabelaCategoria) JTableAtual));
                if(ProdutoSelecionado)
                    Modal(new JFrame_NovoProduto());
                if(ClienteSelecionado)
                    Modal(new JFrame_NovoCliente());
                if(PedidoSelecionado)
                    Modal(new JFrame_NovoPedido());
                
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
//        tabela.addMouseListener(new java.awt.event.MouseAdapter()
//        {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt)
//            {
//                if(evt.getClickCount() == 2)
//                {
//                    if(CategoriaSelecionado)
//                        Alterar(CATEGORIA);
//                    if(ProdutoSelecionado)
//                        Alterar(PRODUTO);
//                    if(ClienteSelecionado)
//                        Alterar(CLIENTE);
//                }
//            }
//        });
        
        //MenuBar
        //MenuSobre
        jMenu_Sobre.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                JOptionPane.showMessageDialog(getjPanel_CENTER(), "Teabalho de Programação de Aplicativos\n"
                        + "Acadêmico: Shelmo Lucas Baches", "Sobre", 3);
            }
        });
        //MenuCategoria
        jMenu_Categoria.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                TrocaTela(CATEGORIA);
            }
        });
        jMenuItem_NovaCategoria.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Modal(new JFrame_NovaCategoria((TabelaCategoria) JTableAtual));
            }
        });
        jMenuItem_LocalizarCategoria.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Localizar(CATEGORIA);
            }
        });
        
        //MenuProduto
        jMenu_Produto.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                TrocaTela(PRODUTO);
            }
        });
        jMenuItem_NovoProduto.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Modal(new JFrame_NovoProduto());
            }
        });
        jMenuItem_LocalizarProduto.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Localizar(PRODUTO);
            }
        });
        //MenuCliente
        jMenu_Cliente.addMouseListener(new java.awt.event.MouseAdapter()
        {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                TrocaTela(CLIENTE);
            }
        });
        jMenuItem_NovoCliente.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Modal(new JFrame_NovoCliente());
            }
        });
        jMenuItem_LocalizarCliente.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                Localizar(CLIENTE);
            }
        });
    }
    
    private void TrocaTela(int constante)
    {
        if(constante == CATEGORIA)
            MontarJPanelCentral(CATEGORIA);
        if(constante == PRODUTO)
            MontarJPanelCentral(PRODUTO);
        if(constante == CLIENTE)
            MontarJPanelCentral(CLIENTE);
        if(constante == PEDIDO)
            MontarJPanelCentral(PEDIDO);
    }
    
    private int SelecionarTabela(boolean mostrar)
    {
        int select = JTableAtual.getSelectedRow();
        if (select == -1 && mostrar)
            JOptionPane.showMessageDialog(null, "Nunhum campo selecionado!", "Erro!", 2);
        
        return select;
    }
    
    private void Remover(int constante)
    {
        int select = SelecionarTabela(false);
        
        if(constante == CATEGORIA)
            Modal(new JFrame_RemoverCategoria(select, (Categoria) arrayList.get(select), (TabelaCategoria) JTableAtual));
        
        if(constante == PRODUTO)
            Modal(new JFrame_RemoverProduto(select, MontarTabelas.getListaProduto().get(select)));
        
        if(constante == CLIENTE)
            Modal(new JFrame_RemoverCliente(select, MontarTabelas.getListaCliente().get(select)));
    }
    
    private void Alterar(int constante)
    {
        int select = SelecionarTabela(false);
        
        if(constante == CATEGORIA)
            Modal(new JFrame_AlterarCategoria(select, (Categoria) arrayList.get(select), (TabelaCategoria) JTableAtual));
        
        if(constante == PRODUTO)
            Modal(new JFrame_AlterarProduto(select, MontarTabelas.getListaProduto().get(select)));
        
        if(constante == CLIENTE)
            Modal(new JFrame_AlterarCliente(select, MontarTabelas.getListaCliente().get(select)));
    }
    
    private void Localizar(int constante)
    {
        int select = SelecionarTabela(false);
        if(constante == CATEGORIA)
            Modal(new JFrame_LocalizarCategoria(select, (TabelaCategoria) JTableAtual));
        
        if(constante == PRODUTO)
            Modal(new JFrame_LocalizarProduto(select));
        
        if(constante == CLIENTE)
            Modal(new JFrame_LocalizarCliente(select));
    }
    
    private void MontarJPanelCentral(int constante)
    {
        MontarTabelas.SelecionarTabela(constante);
        if(jScrollPane_BaseTabela != null)
            LimparTela();
        VisibilidadeBotoes(true);
        TelaSelecionada(constante);
        if(constante == CATEGORIA)
        {
            TabelaCategoria tabelaCategoria = new TabelaCategoria();
            arrayList = tabelaCategoria.getLista();
            JTableAtual = tabelaCategoria;
        }

        jScrollPane_BaseTabela = new JScrollPane(JTableAtual);
        
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
        PedidoSelecionado = false;
        
        if(constante == CATEGORIA)
            CategoriaSelecionado = true;
        
        if(constante == PRODUTO)
            ProdutoSelecionado = true;
        
        if(constante == CLIENTE)
            ClienteSelecionado = true;
        
        if(constante == PEDIDO)
            PedidoSelecionado = true;
    }
    
    private void Modal(JFrame jFrame)
    {
        Modal.showAsModal(jFrame, this);
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
