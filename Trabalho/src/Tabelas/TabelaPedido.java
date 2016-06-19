package Tabelas;

import dao.DAO_Generalizado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Pedido;

/**
 *
 * @author Shelmo
 */
public class TabelaPedido extends BaseTabela
{
    
    private final ArrayList<Pedido> listaPedido;
    
    public TabelaPedido()
    {
        super();
        listaPedido = DAO_Generalizado.getList("from Pedido");
        TabelaCategoria();
    }
    
    private void TabelaCategoria()
    {
        try
        {
            String[] nomeColunas =
            {
                "Cliente", "Data", "Mesa"
            };
            getModelo().setColumnIdentifiers(nomeColunas);
            getModelo().setNumRows(0);
            if (!listaPedido.isEmpty())
            {
                listaPedido.stream().forEach((p)
                        -> 
                        {
                            if (p.getSituacao().equals("A"))
                            {
                                getModelo().addRow(new Object[]
                                {
                                    p.getCliente().getNomeCliente(), Data(p.getDataCadastro()), p.getMesa()
                                });
                            }
                            else
                            {
                                getModelo().addRow(new Object[]
                                {
                                    p.getCliente().getNomeCliente(), Data(p.getDataFechamento()), p.getMesa()
                                });
                            }
                });
            }
            
        }
        catch (Exception ex)
        {
        }
    }
    
    private String Data(Date date)
    {
        String format = null;
        if (date != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            format = sdf.format(date);
        }
        return format;
    }
    
    @Override
    public void Add(Object object)
    {
        Pedido p = (Pedido) object;
        listaPedido.add((Pedido) object);
        getModelo().addRow(new Object[]
        {
            p.getCliente().getNomeCliente(), Data(p.getDataCadastro()), p.getMesa()
        });
    }
    
    @Override
    public void Remove(int select)
    {
        listaPedido.remove(select);
        getModelo().removeRow(select);
    }
    
    @Override
    public void update(Object object, int select)
    {
        Pedido p = (Pedido) object;
        listaPedido.set(select, (Pedido) object);
        getModelo().removeRow(select);
        getModelo().addRow(new Object[]
        {
            p.getCliente(), Data(p.getDataCadastro()), p.getMesa()
        });
    }
    
    @Override
    public void rebuild(ArrayList arrayList)
    {
        listaPedido.clear();
        getModelo().getDataVector().removeAllElements();
        arrayList.stream().forEach((object) ->
        {
            Add(object);
        });
    }
    
    @Override
    public ArrayList<Pedido> getLista()
    {
        return listaPedido;
    }
}
