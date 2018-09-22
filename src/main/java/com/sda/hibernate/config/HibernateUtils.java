package com.sda.hibernate.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {


        private static SessionFactory sf = new Configuration().configure().buildSessionFactory();

        private static Session session = sf.openSession();

    }


