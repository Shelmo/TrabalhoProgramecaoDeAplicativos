package Tabelas;

import dao.DAO_Generalizado;
import java.util.ArrayList;
import java.util.List;
import model.ItensPedido;
import model.Pedido;

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

    public void carregarTabela(List<ItensPedido> itensPedidosList)
    {
        if (!itensPedidosList.isEmpty())
        {
            itensPedidosList.stream().forEach((ip)
                    -> 
                    {
                        getModelo().addRow(new Object[]
                        {
                            ip.getProduto().getCategoria().getNomeCategoria(), ip.getProduto().getNomeProduto(),
                            ip.getQuantidade(), valor(ip.getProduto().getValorProduto()), valor((ip.getQuantidade() * ip.getProduto().getValorProduto()))
                        });
            });
        }
    }

    @Override
    public void Add(Object object)
    {
        ItensPedido ip = (ItensPedido) object;
        int i = 0;
        for (ItensPedido ipd : listaItensPedido)
        {
            if (ipd.getProduto().equals(ip.getProduto()))
            {
                ip.setQuantidade(ip.getQuantidade() + ipd.getQuantidade());
                listaItensPedido.set(i, ip);
                getModelo().setValueAt(ip.getQuantidade(), i, 2);
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
