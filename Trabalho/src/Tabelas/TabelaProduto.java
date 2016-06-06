package Tabelas;

import dao.DAO_Generalizado;
import java.util.ArrayList;
import model.Produto;

/**
 *
 * @author Shelmo
 */
public class TabelaProduto extends BaseTabela
{

    private final ArrayList<Produto> listaProduto;

    public TabelaProduto()
    {
        super();
        listaProduto = DAO_Generalizado.getList("from Produto");
        TabelaProduto();
    }

    private void TabelaProduto()
    {
        try
        {
            String[] nomeColunas =
            {
                "Categoria", "Nome", "Valor (R$)", "Descrição"
            };
            getModelo().setColumnIdentifiers(nomeColunas);
            getModelo().setNumRows(0);
            if (!listaProduto.isEmpty())
            {
                listaProduto.stream().forEach((Produto p)
                        -> 
                        {
                            getModelo().addRow(new Object[]
                            {
                                p.getCategoria().getNomeCategoria(), p.getNomeProduto(), valor(p.getValorProduto()), p.getDescricaoProduto()
                            });
                });
            }

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
        Produto p = (Produto) object;
        listaProduto.add(p);
        getModelo().addRow(new Object[]
        {
            p.getCategoria().getNomeCategoria(), p.getNomeProduto(), valor(p.getValorProduto()), p.getDescricaoProduto()
        });
        System.out.println(getModelo().getValueAt(0, 1));
    }

    @Override
    public void Remove(int select)
    {
        listaProduto.remove(select);
        getModelo().removeRow(select);
    }

    @Override
    public void update(Object object, int select)
    {
        Produto p = (Produto) object;
        listaProduto.set(select, p);
        getModelo().removeRow(select);
        getModelo().insertRow(select, new Object[]
        {
            p.getCategoria(), p.getNomeProduto(), valor(p.getValorProduto()), p.getDescricaoProduto()
        });
    }

    @Override
    public ArrayList<Produto> getLista()
    {
        return listaProduto;
    }
}
