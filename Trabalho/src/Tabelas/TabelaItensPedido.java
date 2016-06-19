package Tabelas;

import java.util.ArrayList;
import model.ItensPedido;

/**
 *
 * @author Shelmo
 */
public class TabelaItensPedido extends BaseTabela
{

    private ArrayList<ItensPedido> listaItensPedido;

    public TabelaItensPedido()
    {
        super();
        listaItensPedido = new ArrayList();
        TabelaCategoria();
    }

    private void TabelaCategoria()
    {
        try
        {
            String[] nomeColunas =
            {
                "Categoria", "Produtos", "Quantidade", "Valor unitário", "Valor Total"
            };
            getModelo().setColumnIdentifiers(nomeColunas);
            getModelo().setNumRows(0);
        }
        catch (Exception ex)
        {
        }
    }

    private String valor(double value)
    {
        return String.valueOf(String.format("%.2f", value)).replace(".", ",");
    }

    @Override
    public void Add(Object object)
    {
        ItensPedido ip = (ItensPedido) object;
        int i = 0;
        for (ItensPedido ipd : listaItensPedido)
        {
            if (ipd.getProduto().getNomeProduto().equals(ip.getProduto().getNomeProduto()))
            {
                ip.setQuantidade(ip.getQuantidade() + ipd.getQuantidade());
                listaItensPedido.set(i, ip);
                getModelo().setValueAt(ip.getQuantidade(), i, 2);
                getModelo().setValueAt(valor((ip.getQuantidade() * ip.getProduto().getValorProduto())), i, 4);
                return;
            }
            i++;
        }
        
        listaItensPedido.add(ip);
        getModelo().addRow(new Object[]
        {
            ip.getProduto().getCategoria().getNomeCategoria(), ip.getProduto().getNomeProduto(),
            ip.getQuantidade(), valor(ip.getProduto().getValorProduto()), valor((ip.getQuantidade() * ip.getProduto().getValorProduto()))
        });
    }

    @Override
    public void Remove(int select)
    {
        if(listaItensPedido.get(select).getQuantidade() != 1)
        {
            listaItensPedido.get(select).setQuantidade(listaItensPedido.get(select).getQuantidade()-1);
            getModelo().setValueAt(listaItensPedido.get(select).getQuantidade(), select, 2);
        }
        else
        {
            listaItensPedido.remove(select);
            getModelo().removeRow(select);
        }
    }

    @Override
    public void update(Object object, int select)
    {
        /*Não utilizada nessa Classe*/
    }
    
    @Override
    public void rebuild(ArrayList arrayList)
    {
        listaItensPedido.clear();
        getModelo().getDataVector().removeAllElements();
        arrayList.stream().forEach((object) ->
        {
            Add(object);
        });
    }

    public void clearTable()
    {
        listaItensPedido.clear();
        TabelaCategoria();
    }

    @Override
    public ArrayList<ItensPedido> getLista()
    {
        return listaItensPedido;
    }
}
