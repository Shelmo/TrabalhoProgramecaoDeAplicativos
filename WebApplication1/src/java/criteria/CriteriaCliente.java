/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criteria;

import model.Cliente;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class CriteriaCliente
{
    public static Criteria listaClientes(String filter)
    {
        Criteria criteria = Hibernate.getSession().createCriteria(Cliente.class);
        criteria.add(Restrictions.ilike("nomeCliente", "%" + filter + "%"));
        return criteria;
    }
}
