package manytomany;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Many2ManyStore 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class).addAnnotatedClass
		(Course.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// create some courses
		Course course1 = new Course
				("c101","6 weeks", "c and html",3000);
		Course course2 = new Course
				("c102","8 weeks", "c++, java",5000);
		Course course3 = new Course
				("c103","12 weeks", "java ee, dbms",10000);
		
		
		// create some set to store courses
		HashSet<Course> set1 = new HashSet<Course>();
		HashSet<Course> set2 = new HashSet<Course>();
		HashSet<Course> set3 = new HashSet<Course>();

		// store courses inside set 1 by 1
		set1.add(course1); set1.add(course3);
		set2.add(course2); set2.add(course3);
		set3.add(course1); set3.add(course3); set3.add(course2);
		
		// create some students and associate courses
		Student student1 = new Student
				("s101","Manish","man@ish.com",set1);		
		Student student2 = new Student
				("s102","Ankur","an@kur.com",set2);
		Student student3 = new Student
				("s103","Hasan","hasan@smarty.com",set3);
		
		// start TX
		Transaction tx = session.beginTransaction();
		
		// save students
		session.save(student1);
		session.save(student2);
		session.save(student3);

		tx.commit();
		
		session.close();
		factory.close();
		
		System.out.println("OK");
	}
}


















