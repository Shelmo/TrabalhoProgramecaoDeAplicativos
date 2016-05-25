package Tabelas;

import dao.DAO_Generalizado;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Cliente;
import model.ItensPedido;
import model.Pedido;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class MontarTabelas extends JTable
{
    private static ArrayList<Categoria> ListaCategoria;
    private static ArrayList<Produto> ListaProdutos;
    private static ArrayList<Cliente> ListaCliente;
    private static ArrayList<Pedido> ListaPedido;
    private static ArrayList<ItensPedido> ListaItensPedidos;
    private static DefaultTableModel model;
    
    public MontarTabelas()
    {
        MontarTabelas.ListaCategoria = (ArrayList<Categoria>) DAO_Generalizado.getList("from Categoria");
        MontarTabelas.ListaProdutos = (ArrayList<Produto>) DAO_Generalizado.getList("from Produto");
        MontarTabelas.ListaCliente = (ArrayList<Cliente>) DAO_Generalizado.getList("from Cliente");
        MontarTabelas.ListaPedido = (ArrayList<Pedido>) DAO_Generalizado.getList("from Pedido");
        getTableHeader().setReorderingAllowed(false);
        setModel(new javax.swing.table.DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex)
            {
                return false;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                this.setHorizontalAlignment(CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
        model = (DefaultTableModel) getModel();
    }
    
    private static void TabelaCategoria()
    {
        try
        {
            String[] nomeColunas = {"Categorias"};
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaCategoria.isEmpty())
            {
                ListaCategoria.stream().forEach((c) ->
                {
                    model.addRow(new Object[]{c.getNomeCategoria()});
                });
            }
        }
        catch(Exception ex){}
    }
    
    private static void TabelaProdutos()
    {
        try
        {
            String[] nomeColunas = {"Categoria", "Nome", "Valor (R$)", "Descrição"};
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaProdutos.isEmpty())
            {
                ListaProdutos.stream().forEach((p) ->
                {
                    String valor = String.valueOf(String.format("%.2f", p.getValorProduto())).replace(".", ",");
                    model.addRow(new Object[]{p.getCategoria(), p.getNomeProduto(), valor, p.getDescricaoProduto()});
                });
            }
        }
        catch(Exception ex){}
    }
    
    private static void TabelaClientes()
    {
        try
        {
            String[] nomeColunas = {"Nome", "CPF", "Data de Nascimento", "Cidade", "Bairro", "Logradouro",
                "Número", "Complemento", "CEP", "Telefone", "Celular", "E-mail"};
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaCliente.isEmpty())
            {
                ListaCliente.stream().forEach((c) ->
                {
                    String format = null;
                    if(c.getDataNascimentoCliente() != null)
                    {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        format = sdf.format(c.getDataNascimentoCliente());
                    }
                    
                    model.addRow(new Object[]{c.getNomeCliente(), c.getCpfCliente(), format, c.getCidadeCliente(), c.getBairroCliente(),
                        c.getLogradouroCliente(), c.getNumeroCliente(), c.getComplementoCliente(), c.getCepCliente(), c.getFoneCliente(), c.getCelularCliente(),
                        c.getEmailCliente()});
                });
            }
        }
        catch(Exception ex){}
    }
    
    private static void TabelaPedidos()
    {
        try
        {
            String[] nomeColunas = {"Cliente", "Data", "Mesa"};
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaPedido.isEmpty())
            {
                ListaPedido.stream().forEach((p) ->
                {
                    model.addRow(new Object[]{p.getCliente(), p.getDataCadastro(), p.getMesa()});
                });
            }
        }
        catch(Exception ex){}
    }
    
    public static void TabelaItensPedidos()
    {
        try
        {
            String[] nomeColunas = {"Categoria", "Produtos", "Quantidade", "Valor unitário", "Valor Total"};
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
        }
        catch(Exception ex){}
        
    }
    
    public static void SelecionarTabela(int constante)
    {
        if(constante == 0)
            TabelaCategoria();
        if(constante == 1)
            TabelaProdutos();
        if(constante == 2)
            TabelaClientes();
        if(constante == 3)
            TabelaPedidos();
    }
    
    public boolean SelecionarLinhaTabela(int inicio, int coluna, String Pesquisa, boolean pesquisarAbaixo)
    {
        if(pesquisarAbaixo)
            inicio++;
        else
            inicio--;
        
        for(int i = inicio;getModel().getRowCount() > i;)
        {
            if (i < 0)
                break;

            if (Pesquisa.equalsIgnoreCase((String) getValueAt(i, coluna)))
            {
                setRowSelectionInterval(i, i);
                return true;
            }

            if (pesquisarAbaixo)
                i++;
            else
                i--;
        }
        
        return false;
    }
    
    public static void addCategoria(Categoria categoria)
    {
        ListaCategoria.add(categoria);
        model.addRow(new Object[]{categoria.getNomeCategoria()});
    }
    
    public static void addProduto(Produto produto)
    {
        ListaProdutos.add(produto);
        String valor = String.valueOf(String.format("%.2f", produto.getValorProduto())).replace(".", ",");
        model.addRow(new Object[]{produto.getCategoria(), produto.getNomeProduto(), valor, produto.getDescricaoProduto()});
    }
    
    public static void addCliente(Cliente cliente)
    {
        ListaCliente.add(cliente);
        String format = null;
        if (cliente.getDataNascimentoCliente() != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            format = sdf.format(cliente.getDataNascimentoCliente());
        }

        model.addRow(new Object[]
        {
            cliente.getNomeCliente(), cliente.getCpfCliente(), format, cliente.getCidadeCliente(), cliente.getBairroCliente(),
            cliente.getLogradouroCliente(), cliente.getNumeroCliente(), cliente.getComplementoCliente(), cliente.getCepCliente(),
            cliente.getFoneCliente(), cliente.getCelularCliente(), cliente.getEmailCliente()
        });
    }
    
    public static void addPedido(Pedido pedido)
    {
        ListaPedido.add(pedido);
    }
    
    public static void addItemPedido(ItensPedido itensPedido)
    {
        if(MontarTabelas.ListaItensPedidos == null)
        {
            ListaItensPedidos = new ArrayList<>();
        }
        ListaItensPedidos.add(itensPedido);
        model.addRow(new Object[]{itensPedido.getProduto().getCategoria(), itensPedido.getProduto(), itensPedido.getQuantidade(),
            itensPedido.getProduto().getValorProduto(), (itensPedido.getProduto().getValorProduto()*itensPedido.getQuantidade())});
    }
    
    public static void removeCategoria(int select)
    {
        ListaCategoria.remove(select);
        TabelaCategoria();
    }
    
    public static void removeProduto(int select)
    {
        ListaProdutos.remove(select);
        TabelaProdutos();
    }
    
    public static void removeCliente(int select)
    {
        ListaCliente.remove(select);
        TabelaClientes();
    }
    
    public static void removePedido(int select)
    {
        ListaPedido.remove(select);
        TabelaPedidos();
    }
    
    public static void updateCategoria(Categoria categoria, int select)
    {
        ListaCategoria.set(select, categoria);
        TabelaCategoria();
    }
    
    public static void updateProduto(int select, Produto produto)
    {
        ListaProdutos.set(select, produto);
        TabelaProdutos();
    }
    
    public static void updateCliente(int select, Cliente cliente)
    {
        ListaCliente.set(select, cliente);
        TabelaClientes();
    }
    
    public static void updatePedido(int select, Pedido pedido)
    {
        ListaPedido.set(select, pedido);
        TabelaPedidos();;
    }

    public static ArrayList<Categoria> getListaCategoria()
    {
        return ListaCategoria;
    }
    
    public static ArrayList<Produto> getListaProduto()
    {
        return ListaProdutos;
    }

    public static ArrayList<Cliente> getListaCliente()
    {
        return ListaCliente;
    }

    public static ArrayList<Pedido> getListaPedido()
    {
        return ListaPedido;
    }
    
    public static ArrayList<ItensPedido> getListaItensPedidos()
    {
        return ListaItensPedidos;
    }
}
