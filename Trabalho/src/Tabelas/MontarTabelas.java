package Tabelas;

import dao.DAO_Generalizado;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Cliente;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class MontarTabelas
{
    private static JTable jTable_Tabelas;
    private static ArrayList<Categoria> ListaCategoria;
    private static ArrayList<Produto> ListaProdutos;
    private static ArrayList<Cliente> ListaCliente;
    
    public MontarTabelas()
    {
        MontarTabelas.jTable_Tabelas = new JTable();
        MontarTabelas.ListaCategoria = (ArrayList<Categoria>) DAO_Generalizado.getList("from Categoria");
        MontarTabelas.ListaProdutos = (ArrayList<Produto>) DAO_Generalizado.getList("from Produto");
        MontarTabelas.ListaCliente = (ArrayList<Cliente>) DAO_Generalizado.getList("from Cliente");
        MontarTabelas.jTable_Tabelas.getTableHeader().setReorderingAllowed(false);
        MontarTabelas.jTable_Tabelas.setModel(new javax.swing.table.DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int rowIndex, int mColIndex)
            {
                return false;
            }
        });
        MontarTabelas.jTable_Tabelas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
        {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
            {
                this.setHorizontalAlignment(CENTER);
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            }
        });
    }
    
    private static void TabelaCategoria()
    {
        try
        {
            jTable_Tabelas.removeAll();
            String[] nomeColunas = {"Categorias"};
            DefaultTableModel model = (DefaultTableModel) jTable_Tabelas.getModel();
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaCategoria.isEmpty())
            {
                for (Categoria c : ListaCategoria)
                {
                    model.addRow(new Object[]{c.getNomeCategoria()});
                }
            }
        }
        catch(Exception ex){}
    }
    
    private static void TabelaProdutos()
    {
        try
        {
            jTable_Tabelas.removeAll();
            String[] nomeColunas = {"Categoria", "Nome", "Valor (R$)", "Descrição"};
            DefaultTableModel model = (DefaultTableModel) jTable_Tabelas.getModel();
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaProdutos.isEmpty())
            {
                for (Produto p : ListaProdutos)
                {
                    String valor = String.valueOf(String.format("%.2f", p.getValorProduto())).replace(".", ",");
                    model.addRow(new Object[]{p.getCategoria(), p.getNomeProduto(), valor, p.getDescricaoProduto()});
                }
            }
        }
        catch(Exception ex){}
    }
    
    private static void TabelaClientes()
    {
        try
        {
            jTable_Tabelas.removeAll();
            String[] nomeColunas = {"Nome", "CPF", "Data de Nascimento", "Cidade", "Bairro", "Logradouro",
                "Número", "Complemento", "CEP", "Telefone", "Celular", "E-mail"};
            DefaultTableModel model = (DefaultTableModel) jTable_Tabelas.getModel();
            model.setColumnIdentifiers(nomeColunas);
            model.setNumRows(0);
            if (!ListaCliente.isEmpty())
            {
                for (Cliente c : ListaCliente)
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
                }
            }
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
    }
    
    public static boolean SelecionarLinhaTabela(int inicio, int coluna, String Pesquisa, boolean pesquisarAbaixo)
    {
        if(pesquisarAbaixo)
            inicio++;
        else
            inicio--;
        
        for(int i = inicio;MontarTabelas.getjTable_Tabelas().getModel().getRowCount() > i;)
        {
            if (i < 0)
                break;

            if (Pesquisa.equalsIgnoreCase((String) MontarTabelas.getjTable_Tabelas().getValueAt(i, coluna)))
            {
                MontarTabelas.getjTable_Tabelas().setRowSelectionInterval(i, i);
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
        TabelaCategoria();
    }
    
    public static void addProduto(Produto produto)
    {
        ListaProdutos.add(produto);
        TabelaProdutos();
    }
    
    public static void addCliente(Cliente cliente)
    {
        ListaCliente.add(cliente);
        TabelaClientes();
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

    public static JTable getjTable_Tabelas()
    {
        return jTable_Tabelas;
    }
}
