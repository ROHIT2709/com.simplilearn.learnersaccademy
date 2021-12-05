package com.learners_accademy.util; 



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.learners_accademy.entities.*;


public class HibernateUtil {

	public static SessionFactory buildSessionFactory() {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Students.class)
				.addAnnotatedClass(Classes.class)
				
				  .addAnnotatedClass(Teachers.class) .addAnnotatedClass(Subjects.class)
				 
				.buildSessionFactory();
		return sessionFactory;
	}
}
