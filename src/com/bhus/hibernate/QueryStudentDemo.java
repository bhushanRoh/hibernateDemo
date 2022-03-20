package com.bhus.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhus.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration()
				               .configure("hibernate.cfg.xml")
				               .addAnnotatedClass(Student.class)
				               .buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		
		List<Student> student= session.createQuery("from Student").getResultList();
		
		List<Student> studentlist= session
				.createQuery("from Student s where s.lastName='Roh'")
				.getResultList();
		
		session.getTransaction().commit();
		System.out.println(student.size());
		
		System.out.println(student);
		System.out.println(studentlist);
		
		factory.close();
	}

}
