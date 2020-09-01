package com.cetpa.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class insert 
{
	public static void main(String[] args) 
	{
	// lets create object of configuration
	Configuration cfg = new Configuration();
	
	// lets creaed cfg.xml file
//	cfg.configure();
	
	// lets specify the name of class that has annotaions
	cfg.addAnnotatedClass(Book.class);
	
	// get object of session-factory
	SessionFactory fact = cfg.buildSessionFactory();
	
	// get object of session
	Session session = fact.openSession();
	
	Book bk=new Book();
	
	bk.setIsbn(300);
	bk.setPrice(400);
	bk.setTopic("got");
	bk.setAuthor("martin");
	bk.setPublisher("hbo");
	// save this object
	session.save(bk);
	
	// start a transaction for this session and commit it
	session.beginTransaction().commit();
	
	session.close();
	// close the factory
	fact.close();
}
}