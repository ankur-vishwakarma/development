package hw2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class FetchFileDataUsingScannerClass 
{
	public static void main(String[] args) 
	throws Exception
	{
	String path = "d:\\billu.txt";
	
	// denote this path using file class
	File file = new File(path);
	
	// lets open the file in read mode
	FileInputStream fi = new FileInputStream(file);

	// create object of scanner to fetch data from the file
	Scanner sc = new Scanner(fi);

	while(sc.hasNext())
	{
		String str = sc.nextLine();
		System.out.println(str);
	}
	
	}
}











