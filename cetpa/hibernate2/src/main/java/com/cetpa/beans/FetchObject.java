package com.cetpa.beans;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchObject 
{
	public static void main(String[] args) 
	{
	// create object of configuration
	Configuration cfg = new Configuration();
	
//	// read hibernate.cfg.xml file and initialize object of session-factory
//	cfg.configure();
	
	// specify the class which is "entity"
	cfg.addAnnotatedClass(Book.class);
	
	// get object of session-factory
	SessionFactory factory = cfg.buildSessionFactory();
	
	// get object of session from the session-factory
	Session session = factory.openSession();
	
	// create object of scanner to take input from keyboard
	Scanner sc = new Scanner(System.in);
	
	// get isbn (bole toh primary-key of book) from keyboard
	System.out.print("Input isbn of book: ");
	int book_isbn = sc.nextInt();
	
	// * lets fetch object using get() method of session
	// * in get() method we need to pass two arguments
	// first argument will be the class (whose object need to fetch)
	// second argument will be the primary-key for that object
	// * get() method will return null if primary-key is wrong
	// otherwise it will return the object associated with that primary-key 
	// here get() will return the object of Book associated with given book_isbn
	Book book = session.get(Book.class, book_isbn);
	
	// check if book has null or not (if primary-key is wrong book will have null)
	if(book == null)
	{
		System.out.println("No data found");
	}
	else
	{
		// fetch the data from the object "book" using getter methods
		// and show it
		System.out.println("Book-Details associated with Isbn "+book_isbn);
		System.out.println("Topic="+book.getTopic());
		System.out.println("Author="+book.getAuthor());
		System.out.println("Price="+book.getPrice()+" INR");
		System.out.println("Publisher="+book.getPublisher());
	}
	
	// close the session and session-factory
	session.close();
	factory.close();
	}
}