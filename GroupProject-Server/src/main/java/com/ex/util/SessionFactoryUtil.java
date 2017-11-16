package com.ex.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/*
 *  Very important steps
 */
public class SessionFactoryUtil {
    private static SessionFactory sf;

    static {
        //create the configuration object
        Configuration config = new Configuration() {};
        //pass our hibernate.cfg.xml to the Configuration Object
        config.configure("hibernate.cfg.xml");

        //Register the configuration as a standard service
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        //build our session factory
        sf = config.buildSessionFactory(serviceRegistry);
    }

    public static Session getSession() {
        return sf.openSession();
    }
}
