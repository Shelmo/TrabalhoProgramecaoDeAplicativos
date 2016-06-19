package dao;

import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Hibernate;

/**
 *
 * @author Shelmo
 */
public class DAO_Generalizado
{
    public static int SALVAR = 0;
    public static int ATUALIZAR = 1;
    
    public static Serializable incluirAlterar(Object o, int constante)
    {
        Session session;
        Transaction transaction;
        Serializable serializable = null;
        
        try
        {
            session = Hibernate.getSession();
            transaction = session.beginTransaction();
            if(constante == SALVAR)
                serializable = session.save(o);
            if(constante == ATUALIZAR)
                session.update(o);
            transaction.commit();
            Hibernate.CloseSession();
            return serializable;
        }
        catch (HibernateException e)
        {
            System.out.println("Erro: " + e.getMessage());
            return serializable;
	}
    }
    
    public static void remover(Object o)
    {
        Session session;
        Transaction transaction;
        
        try
        {
            session = Hibernate.getSession();
            transaction = session.beginTransaction();
            session.delete(o);
            transaction.commit();
            Hibernate.CloseSession();
        }
        catch (HibernateException e)
        {
            System.out.println("Erro: " + e.getMessage());
	}
    }
    
    public static ArrayList getList(String hql)
    {
        Session sessao;
        Transaction transaction;
        Query consulta;
        ArrayList resultado;

        try
        {
            sessao = Hibernate.getSession();
            transaction = sessao.beginTransaction();
            consulta = sessao.createQuery(hql);
            resultado = (ArrayList) consulta.list();
            transaction.commit();
            Hibernate.CloseSession();
            return resultado;
        }
        catch (HibernateException e)
        {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }
    }
    
    public static ArrayList getList(Criteria criteria)
    {
        ArrayList resultado;
        
        resultado = (ArrayList) criteria.list();
        
        return resultado;
    }
}
