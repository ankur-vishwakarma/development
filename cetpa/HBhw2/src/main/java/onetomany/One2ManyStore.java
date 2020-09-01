package onetomany;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class One2ManyStore 
{
	public static void main(String[] args) 
	{
	Configuration cfg = new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Department.class).addAnnotatedClass
	(Teacher.class);
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	
	// create few teacher
	Teacher teacher1 = new Teacher(1, "Om", "Php");
	Teacher teacher2 = new Teacher(2, "Vipul", "DS");
	Teacher teacher3 = new Teacher(3, "Ankur", "C++");
	Teacher teacher4 = new Teacher(4, "Vini", "Network");
	Teacher teacher5 = new Teacher(5, "Rohit", "MPC");
	
	// create some sets to store teachers
	HashSet<Teacher> setForCs = new HashSet<Teacher>();
	HashSet<Teacher> setForEe = new HashSet<Teacher>();
	
	// store teachers inside set 1 by 1
	setForCs.add(teacher1);
	setForCs.add(teacher2);
	setForCs.add(teacher3);
	
	setForEe.add(teacher4);
	setForEe.add(teacher5);
	
	// create some departments
	Department department1 = new 
			Department("CSE", "OM", "9999999999", setForCs);
	
	Department department2 = new 
			Department("EE", "Vini", "5555555555", setForEe);
	
	// start TX
	Transaction tx = session.beginTransaction();
	
	// save depts and then commit tx
	session.save(department1);
	session.save(department2);
	
	tx.commit();
	
	// close session and its factory
	session.close();
	factory.close();
	
	System.out.println("OK");

	}
}