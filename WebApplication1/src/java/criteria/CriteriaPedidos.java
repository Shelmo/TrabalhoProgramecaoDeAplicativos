package criteria;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import model.Pedido;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class CriteriaPedidos
{

    public static int FILTRO_CLIENTE = 0;
    public static int FILTRO_MESA = 1;
    public static int FILTRO_DATA = 2;

    public static Criteria listarPedidos(String filter, int select)
    {
        Criteria criteria = Hibernate.getSession().createCriteria(Pedido.class);

        if (select == FILTRO_CLIENTE)
        {
            Criteria cr = criteria.createCriteria("cliente");
            cr.add(Restrictions.like("nomeCliente", "%" + filter + "%"));
        }
        if (select == FILTRO_MESA)
        {
            criteria.add(Restrictions.like("mesa", "%" + filter + "%"));
        }
        if (select == FILTRO_DATA)
        {
            if(filter.equals("Data Invalida! Utilize o formato dd/MM/aaaa"))
            {
                return criteria;
            }
            String[] datas = filter.split(Pattern.quote("ate"));

            if (datas != null)
            {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println(datas[0].substring(0, 2));
                
                if (datas.length < 2)
                {

                    try
                    {
                        java.sql.Date data = new java.sql.Date(format.parse(datas[0]).getTime());
                        criteria.add(Restrictions.like("dataCadastro", data));
                    }
                    catch (ParseException ex)
                    {
                        System.err.println("Erro! Data inválida!");
                    }
                }
                else
                {
                    try
                    {
                        java.sql.Date menor = new java.sql.Date(format.parse(datas[0]).getTime());
                        java.sql.Date maior = new java.sql.Date(format.parse(datas[1]).getTime());
                        criteria.add(Restrictions.between("dataCadastro", menor, maior));
                    }
                    catch (ParseException ex)
                    {
                        System.err.println("Erro! Data inválida!");
                    }
                }
            }
        }

        return criteria;
    }
}
