/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criteria;

import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class CriteriaProduto
{
    public static int FILTRO_CATEGORIA = 0;
    public static int FILTRO_PRODUTO = 1;
    
    public static Criteria listarProdutos(String filter, int select)
    {
        Criteria criteria = Hibernate.getSession().createCriteria(Produto.class);

        if (select == FILTRO_CATEGORIA)
        {
            Criteria cr = criteria.createCriteria("categoria");
            cr.add(Restrictions.like("nomeCategoria", "%" + filter + "%"));
        }
        if (select == FILTRO_PRODUTO)
        {
            criteria.add(Restrictions.like("nomeProduto", "%" + filter + "%"));
        }

        return criteria;
    }
}
