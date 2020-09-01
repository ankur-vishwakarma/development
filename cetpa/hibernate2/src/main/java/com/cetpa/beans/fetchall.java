package com.cetpa.beans;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.*;


public class fetchall {

	public static void main(String[] args) {
		
		String hql="from Book";
		
		Configuration cfg = new Configuration();
		
		// read hibernate.cfg.xml file and initialize object of session-factory
		//NEVER RUN CONFIGURE METHOD IF U R USING HIBERNATE.PROPERTIES
		//cfg.configure();
		
		// specify the class which is "entity"
		cfg.addAnnotatedClass(Book.class);
		
		// get object of session-factory
		SessionFactory factory = cfg.buildSessionFactory();
		
		// get object of session from the session-factory
		Session session = factory.openSession();
		
	    Query <Book> query=session.createQuery(hql);
	    
	    
	   List<Book> ls=query.list();
	   
	   
	   for(Book book:ls) {
		   System.out.println("id="+book.getIsbn());
		   System.out.println("Topic="+book.getTopic());
		   System.out.println("Author="+book.getAuthor());
//		   System.out.println("id="+book.getIsbn());
//		   System.out.println("id="+book.getIsbn());
		   System.out.println();
	   }
	   session.close();
		// close the factory
		factory.close();

	}

}
