/**
 * 
 */
package com.db.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiberDBUtil {

	private static String CONFIG_FILE_LOCATION = "/com/cfg/hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory;
    private static String configFile = CONFIG_FILE_LOCATION;
    
    static {
        try {
            configuration.configure(configFile);
             sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    private HiberDBUtil() {
    }

    /**
     * Returns the ThreadLocal Session instance. Lazy initialize the
     * <code>SessionFactory</code> if needed.
     * 
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session =sessionFactory.openSession();
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * Rebuild hibernate session factory
     * 
     */
    public static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }

    /**
     * Close the single hibernate session instance.
     * 
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

    /**
     * return session factory
     * 
     */
    public static org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * return session factory
     * 
     * session factory will be rebuilded in the next call
     */
    public static void setConfigFile(String configFile) {
        HiberDBUtil.configFile = configFile;
        sessionFactory = null;
    }

    /**
     * return hibernate configuration
     * 
     */
    public static Configuration getConfiguration() {
        return configuration;
    }
    
    /**
     * close sessionFactory
     * 
     */
    public static void closeSessionFactory() {
    	 if (sessionFactory != null) {
    		 sessionFactory.close();
         }
    }
}
