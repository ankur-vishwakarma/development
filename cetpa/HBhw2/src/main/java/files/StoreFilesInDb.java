package files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreFilesInDb 
{
	public static void main(String[] args) 
	throws Throwable
	{
		Session session = new Configuration().configure()
		.addAnnotatedClass(MyFileInfo.class)
		.buildSessionFactory().openSession();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a path for file: ");
		String path = scanner.nextLine();
		
		File file = new File(path);
		
		// check if path is correct
		if(file.exists())
		{
			// check if path is of a file
			if(file.isFile())
			{
				// create object of MyFileInfo class
				MyFileInfo obj = new MyFileInfo();
				
				// fetch then store file name
				obj.setFileName(file.getName());
				
				// fetch file size (downcast it) and store
				obj.setFileSize((int)file.length());
				
				// open this file in read mode
				FileInputStream fi = new FileInputStream(file);
				
				// lets get how many bytes can be read from the file
				int filesize = fi.available();
				
				// create an array of byte to store data of file
				byte[] array = new byte[filesize];
				
				// fetch data from the file and store it inside
				// array of byte
				fi.read(array);
				
				// store the data of array inside the obj
				obj.setFileData(array);
				
				// start TX
				Transaction tx = session.beginTransaction();
				
				// save the object obj
				session.save(obj);
				
				// commit TX
				tx.commit();
				
				// close session and factory
				session.close();
				session.getSessionFactory().close();
				
				System.out.println("Ok");
			}
			else
			{
				System.out.println("Directory cant be stored");
			}
		}
		else
		{
			System.out.println("path is incorrect");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}