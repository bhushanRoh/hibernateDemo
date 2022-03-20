package com.bhus.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhus.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory= new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		
		// create Session
		
		Session session=  factory.getCurrentSession();
		
		try {
			Student student= new Student("Bhushan", " Rohankar","@Gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			System.out.println("Saved Student Object With Name= "+student.getFirstName());
		}finally {
			factory.close();
		}

	}

}
