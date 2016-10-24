package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Shelmo
 */
public class Hibernate
{
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    private static SessionFactory ConfigurarSessao()
    {
        Configuration configuration = new Configuration().configure();

        
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        return sessionFactory;
    }
    
    public static Session getSession()
    {
        return ConfigurarSessao().openSession();
    }
    
    public static void CloseSession()
    {
        if(sessionFactory != null)
            sessionFactory.close();
        
        if(serviceRegistry != null)
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}
