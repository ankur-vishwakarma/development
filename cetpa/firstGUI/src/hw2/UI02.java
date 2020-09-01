package hw2;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UI02 extends JFrame implements ActionListener
{
	JButton b;
	JTextArea area;
	JScrollPane pane;
	
	public void setup()
	{
		super.setBounds(100, 50, 700, 650);
		super.setResizable(false);
		
		area = new JTextArea();
		pane = new JScrollPane(area);
		pane.setBounds(100, 49, 550, 450);
		super.add(pane);
		
		// create a font
		Font font = new Font("roman", Font.ITALIC, 25);
		area.setFont(font);
		area.setForeground(Color.blue);
		
		b = new JButton("click");
		b.setBounds(100, 510, 100, 30);
		super.add(b);
		
		b.addActionListener(this);
		
		super.setLayout(null); // 3
		super.setVisible(true); // 2
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // last
	}
	
	public static void main(String[] args) 
	{
		UI02 u = new UI02();
		u.setup();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if(e.getSource() == b)
		{
		// create object of file-dialog using
		// param-cnst
		FileDialog dialog = new FileDialog
				(this, "Lets open a file", FileDialog.LOAD);
		
		// lets show the file-dialog on screen
		dialog.setVisible(true);
		
		// lets fetch the name of selected file
		String fileName = dialog.getFile();
		
		// lets fetch the location of file
		String directory = dialog.getDirectory();
		
		String fullPath = directory + fileName;
		
		// denote this path using file class
		File file = new File(fullPath);
		
		// open this file in read mode
		FileInputStream fi = new FileInputStream(file);
		
		// create object of scanner to fetch data from the file
		Scanner sc = new Scanner(fi);
		
		// in this string we will store the file data
		String str = "";
		
		while(sc.hasNext())
		{
			// fetch a line from the file
			// and combine it with str
			str = str + sc.nextLine() +"\n";
		}
		
		// store the data of str inside text-area
		area.setText(str);
		}
		}
		catch(Exception ee)
		{
			
		}
		}
	}
	