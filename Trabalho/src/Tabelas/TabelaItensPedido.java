package Tabelas;

import java.util.ArrayList;
import model.ItensPedido;

/**
 *
 * @author Shelmo
 */
public class TabelaItensPedido extends BaseTabela
{

    private final ArrayList<ItensPedido> listaItensPedido;

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
        listaItensPedido.remove(select);
        getModelo().removeRow(select);
    }

    @Override
    public void update(Object object, int select)
    {
        /*Não utilizada nessa Classe*/
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
