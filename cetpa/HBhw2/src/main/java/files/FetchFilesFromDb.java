package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchFilesFromDb 
{
	public static void main(String[] args) 
	throws Throwable
	{
		Session session = new Configuration().configure()
		.addAnnotatedClass(MyFileInfo.class)
		.buildSessionFactory().openSession();

		Query <MyFileInfo> query=session.createQuery("from MyFileInfo");
		
		List<MyFileInfo> ls=query.list();
		
		int index = 1;
		String str = "";
		
		for(MyFileInfo m: ls) {
			String name = m.getFileName();
			System.out.println(index+":"+name);
			str = str + name + ",";
			index++;
		}
		
		String[] fileNames = str.split(",");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the index of file to be fetched: ");
		int i = scanner.nextInt();
		
		MyFileInfo info = session.get(MyFileInfo.class, fileNames[i-1]);
		
		if(info != null)
		{
		// lets create a file 
		FileOutputStream fo = new FileOutputStream
				("D:\\assignment\\FETCHED\\"+info.getFileName());
		
		// fetch file data from the object info and store
		// that data inside the file (in one go)
		fo.write(info.getFileData());	
		System.out.println("Data fetched at D:\\\\assignment\\\\FETCHED");
		}
		else
		{
			System.out.println("Please enter valid index");
		}
		
		session.close();
		session.getSessionFactory().close();
	}
}