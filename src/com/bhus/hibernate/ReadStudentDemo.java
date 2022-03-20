package com.bhus.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bhus.hibernate.entity.Student;

public class ReadStudentDemo {
	public static void main(String[] args) {
		
		
		SessionFactory factory= new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		
		Session session= factory.getCurrentSession();
		
		Student student= new Student("Bhus","Roh","@Gmail");
		Student student1= new Student("Atharva","Gaiki","@Gmail");

		Student student2= new Student("Gaurav","Yam","@Gmail");
		Student student3= new Student("Akshat","mahes","@Gmail");
		
		session.beginTransaction();
		session.save(student);
		session.save(student1);

		session.save(student2);
		session.save(student3);
		
		session.getTransaction().commit();
		
		session=factory.getCurrentSession();
		session.beginTransaction();

		Student myStudent = session.get(Student.class,student.getId());
		System.out.println(myStudent);
		session.getTransaction().commit();
		
		factory.close();
		

	}

}
