package com.frst;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) 
	{
	// lets create object of configuration
	Configuration cfg = new Configuration();
	
	// lets creaed cfg.xml file
//	cfg.configure();
	
	// lets specify the name of class that has annotaions
	cfg.addAnnotatedClass(Person.class);
	
	// get object of session-factory
	SessionFactory fact = cfg.buildSessionFactory();
	
	// get object of session
	Session session = fact.openSession();
	
	// create object of person
	Person person = new Person();
	
	// store data inside person
	person.setId(1);
	person.setName("Hasan");
	person.setAge(17.0f);
	person.setCity("New Delhi");
	
	// save this object
	session.save(person);
	
	// start a transaction for this session and commit it
	session.beginTransaction().commit();
	
	session.close();
	// close the factory
	fact.close();
}
}