package Tabelas;

import dao.DAO_Generalizado;
import java.util.ArrayList;
import model.Categoria;

/**
 *
 * @author Shelmo
 */
public class TabelaCategoria extends BaseTabela
{

    private final ArrayList<Categoria> listaCategoria;

    public TabelaCategoria()
    {
        super();
        listaCategoria = DAO_Generalizado.getList("from Categoria");
        TabelaCategoria();
    }

    private void TabelaCategoria()
    {
        try
        {
            String[] nomeColunas =
            {
                "Categorias"
            };
            getModelo().setColumnIdentifiers(nomeColunas);
            getModelo().setNumRows(0);
            if (!listaCategoria.isEmpty())
            {
                listaCategoria.stream().forEach((Categoria c)
                        -> 
                        {
                            getModelo().addRow(new Object[]
                            {
                                c.getNomeCategoria()
                            });
                });
            }

        }
        catch (Exception ex)
        {
        }
    }

    @Override
    public void Add(Object object)
    {
        listaCategoria.add((Categoria) object);
        getModelo().addRow(new Object[]
        {
            ((Categoria) object).getNomeCategoria()
        });
    }

    @Override
    public void Remove(int select)
    {
        listaCategoria.remove(select);
        getModelo().removeRow(select);
    }

    @Override
    public void update(Object object, int select)
    {
        listaCategoria.set(select, (Categoria) object);
        getModelo().removeRow(select);
        getModelo().insertRow(select, new Object[]
        {
            ((Categoria) object).getNomeCategoria()
        });
    }
    
    @Override
    public void rebuild(ArrayList arrayList)
    {
        listaCategoria.clear();
        getModelo().getDataVector().removeAllElements();
        arrayList.stream().forEach((object) ->
        {
            Add(object);
        });
    }

    @Override
    public ArrayList<Categoria> getLista()
    {
        return listaCategoria;
    }

}
