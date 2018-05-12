package dao;

import java.lang.annotation.Target;

import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil{
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
			
		
		try{
		
			if (sessionFactory == null) {
				Configuration configuration = new Configuration().configure();
				ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
				registry.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				/*
				Configuration configuration = new Configuration().configure();
				ServiceRegistry serviceRegistry = new
				ServiceRegistryBuilder().applySettings( configuration.getProperties()).buildServiceRegistry();
				SchemaExport schemaExport = new SchemaExport(serviceRegistry,configuration );
				schemaExport.create(org.hibernate.tool.hbm2ddl.Target.EXPORT);*/
			}
		} catch (HibernateException he) {
			System.err.println("ERROR en la inicialización de la SessionFactory: " + he);
		throw new ExceptionInInitializerError(he);
		}
		return sessionFactory;
	}
}