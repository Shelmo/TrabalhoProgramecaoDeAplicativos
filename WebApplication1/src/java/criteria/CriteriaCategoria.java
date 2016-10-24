package criteria;

import model.Categoria;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class CriteriaCategoria
{
    public static Criteria listarCategorias(String filter)
    {
        Criteria criteria = Hibernate.getSession().createCriteria(Categoria.class);
        criteria.add(Restrictions.ilike("nomeCategoria", "%" + filter + "%"));
        return criteria;
    }
}
