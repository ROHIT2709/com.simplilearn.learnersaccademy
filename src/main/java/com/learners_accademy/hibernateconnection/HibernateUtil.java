package com.learners_accademy.hibernateconnection;

import com.learners_accademy.entities.Classes;
import com.learners_accademy.entities.Students;
import com.learners_accademy.entities.Subjects;
import com.learners_accademy.entities.Teachers;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; 

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {
		

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			    .addAnnotatedClass(Students.class)
				.addAnnotatedClass(Classes.class)
				
			
			.addAnnotatedClass(Teachers.class)  .addAnnotatedClass(Subjects.class)/* */
			 
				
				.buildSessionFactory();
		return sessionFactory;
	}

}