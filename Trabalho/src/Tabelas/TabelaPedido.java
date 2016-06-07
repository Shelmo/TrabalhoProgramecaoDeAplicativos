package Tabelas;

import dao.DAO_Generalizado;
import java.util.ArrayList;
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
        listaPedido = DAO_Generalizado.getList("from Pedido", -1);
        TabelaCategoria();
    }
    
    private void TabelaCategoria()
    {
        try
        {
            String[] nomeColunas = {"Cliente", "Data", "Mesa"};
            getModelo().setColumnIdentifiers(nomeColunas);
            getModelo().setNumRows(0);
            if (!listaPedido.isEmpty())
            {
                listaPedido.stream().forEach((p) ->
                {
                    getModelo().addRow(new Object[]{p.getCliente(), p.getDataCadastro(), p.getMesa()});
                });
            }
            
        }
        catch(Exception ex){}
    }
    
    @Override
    public void Add(Object object)
    {
        Pedido p = (Pedido) object;
        listaPedido.add((Pedido) object);
        getModelo().addRow(new Object[]{p.getCliente(), p.getDataCadastro(), p.getMesa()});
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
        getModelo().addRow(new Object[]{p.getCliente(), p.getDataCadastro(), p.getMesa()});
    }

    @Override
    public ArrayList<Pedido> getLista()
    {
        return  listaPedido;
    }
}
