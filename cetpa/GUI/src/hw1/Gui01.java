package hw1;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui01 extends JFrame // step#1
{	
	JButton btn;
	
	public void setGUI() // step#2
	{
		// create a frame
	//	super.setSize(700, 200);
		super.setBounds(100, 100, 700, 600);
	
		// specify the title for frame
		super.setTitle("Hamara-Frame");
		
		// set the frame as non-resizable
		super.setResizable(false);
		
		//////////////////////////////////
		// create object of component
		btn = new JButton("click me sfv sd  sdf  f");
		
		// set dimension of component
		btn.setBounds(100, 100, 100, 30);
		
		// add the component to the frame
		super.add(btn);
		
		//////////////////////////////////
		// set the layout of frame to null
		super.setLayout(null);
		
		// show the frame on screen
		super.setVisible(true);
		
		// close the application when we close the frame
		super.setDefaultCloseOperation(3);
	}
	
	public static void main(String[] args) // step#3
	{
		Gui01 obj = new Gui01();
		obj.setGUI();
	}
}