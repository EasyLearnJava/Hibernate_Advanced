package com.easylearnjava.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.easylearnjava.exception.ServiceException;

public class HibernateUtil {

	private static final String CONFIG_FILE_LOCATION = "hibernate-cfg.xml";

	public static Session getSession() throws ServiceException {

		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			Configuration cfg = new Configuration();
			cfg.configure(CONFIG_FILE_LOCATION);
			
			ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
					.applySettings(cfg.getProperties());
			
			sessionFactory = cfg.buildSessionFactory(serviceRegistryBuilder
					.buildServiceRegistry());
			
			// sessionFactory = cfg.buildSessionFactory(); //deprecated
		} catch (HibernateException he) {
			throw new ServiceException(
					"Unable to build HibernateSessionFactory", he);
		}

		try {
			session = sessionFactory.openSession();
			return session;
		} catch (HibernateException e) {
			throw new ServiceException("Unable to open a HibernateSession");
		}
	}

	public static void closeSession(Session session) {
		if (session != null) {
			try {
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}