package Tabelas;

import dao.DAO_Generalizado;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.Cliente;

/**
 *
 * @author Shelmo
 */
public class TabelaCliente extends BaseTabela
{

    private final ArrayList<Cliente> listaCliente;

    public TabelaCliente()
    {
        super();
        listaCliente = DAO_Generalizado.getList("from Cliente", -1);
        TabelaCategoria();
    }

    private void TabelaCategoria()
    {
        try
        {
            String[] nomeColunas =
            {
                "Nome", "CPF", "Data de Nascimento", "Cidade", "Bairro", "Logradouro",
                "Número", "Complemento", "CEP", "Telefone", "Celular", "E-mail"
            };
            getModelo().setColumnIdentifiers(nomeColunas);
            getModelo().setNumRows(0);
            if (!listaCliente.isEmpty())
            {
                listaCliente.stream().forEach((Cliente c)
                        -> 
                        {
                            getModelo().addRow(new Object[]
                            {
                                c.getNomeCliente(), c.getCpfCliente(), Data(c.getDataNascimentoCliente()), c.getCidadeCliente(), c.getBairroCliente(),
                                c.getLogradouroCliente(), c.getNumeroCliente(), c.getComplementoCliente(), c.getCepCliente(), c.getFoneCliente(), c.getCelularCliente(),
                                c.getEmailCliente()
                            });
                });
            }

        }
        catch (Exception ex)
        {
        }
    }

    private String Data(Date data)
    {
        String format = null;
        if (data != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            format = sdf.format(data);
        }
        return format;
    }

    @Override
    public void Add(Object object)
    {
        Cliente c = (Cliente) object;
        listaCliente.add(c);
        getModelo().addRow(new Object[]
        {
            c.getNomeCliente(), c.getCpfCliente(), Data(c.getDataNascimentoCliente()), c.getCidadeCliente(), c.getBairroCliente(),
            c.getLogradouroCliente(), c.getNumeroCliente(), c.getComplementoCliente(), c.getCepCliente(), c.getFoneCliente(), c.getCelularCliente(),
            c.getEmailCliente()
        });
    }

    @Override
    public void Remove(int select)
    {
        listaCliente.remove(select);
        getModelo().removeRow(select);
    }

    @Override
    public void update(Object object, int select)
    {
        Cliente c = (Cliente) object;
        listaCliente.set(select, c);
        getModelo().removeRow(select);
        getModelo().insertRow(select, new Object[]
        {
            c.getNomeCliente(), c.getCpfCliente(), Data(c.getDataNascimentoCliente()), c.getCidadeCliente(), c.getBairroCliente(),
            c.getLogradouroCliente(), c.getNumeroCliente(), c.getComplementoCliente(), c.getCepCliente(), c.getFoneCliente(), c.getCelularCliente(),
            c.getEmailCliente()
        });
    }

    @Override
    public ArrayList<Cliente> getLista()
    {
        return listaCliente;
    }
}
