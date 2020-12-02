package hw2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class FetchFileDataUsingScannerClassPart2 
{
	public static void main(String[] args) 
	throws Exception
	{
	String path = "d:\\barber.txt";
	
	// denote this path using file class
	File file = new File(path);
	
	// lets open the file in read mode
	FileInputStream fi = new FileInputStream(file);

	// create object of scanner to fetch data from the file
	Scanner sc = new Scanner(fi);

	int i = 1;
	while(sc.hasNext())
	{
		// check if data after the pointer is int
		if(sc.hasNextInt())
		{
			// fecth that int data
			int var = sc.nextInt();
			System.out.println(var);
		}
		else
		{
			// move the pointer to the next data
			String str = sc.next();
		}
	}
	
	}
}











