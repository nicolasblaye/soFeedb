package fr.sofeed.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtils {

	private static final SessionFactory sessionFactory;
    	static {
    		Configuration conf = new Configuration();
    		conf.configure("hibernate.cfg.xml");
    		sessionFactory = conf.buildSessionFactory();
    	}

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
}
