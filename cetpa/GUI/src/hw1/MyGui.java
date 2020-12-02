package hw1;

import javax.swing.JFrame;

public class MyGui extends JFrame // step#1
{	
	public void setGUI() // step#2
	{
		// create a frame
	//	super.setSize(700, 200);
		super.setBounds(100, 100, 700, 600);
	
		// specify the title for frame
		super.setTitle("Hamara-Frame");
		
		// set the frame as non-resizable
		super.setResizable(false);
		
		// show the frame on screen
		super.setVisible(true);
		
		// close the application when we close the frame
		super.setDefaultCloseOperation(3);
	}
	
	public static void main(String[] args) // step#3
	{
		MyGui obj = new MyGui();
		obj.setGUI();
	}
}