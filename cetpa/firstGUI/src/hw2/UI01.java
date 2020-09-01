package hw2;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UI01 extends JFrame
{
	JLabel l;	
	JButton b;
	
	public void setup()
	{
		super.setBounds(100, 50, 700, 650);
		super.setResizable(false);
		
		l = new JLabel("\u0906\u092e");
		l.setBounds(100, 100, 200, 100);
		super.add(l);
		
		b = new JButton("....");
		b.setBounds(310, 100, 300, 300);
		super.add(b);
		
		// create object of Font class
		// using param-cnst
		// 1. font-name
		// 2. type 
		// 3. size
		Font font = new Font("Roman", Font.PLAIN, 50);
		
		// lets apply the font to label
		l.setFont(font);
		
		// lets apply the color for label
		l.setForeground(Color.red);
		
		// create object of image-icon class and pass
		// the path of image inside the cnst
		ImageIcon icon = new ImageIcon("d:\\pic\\a.jpg");
		
		// apply the icon with the button
		b.setIcon(icon);
		super.setLayout(null); // 3
		super.setVisible(true); // 2
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // last
	}
	
	public static void main(String[] args) 
	{
		UI01 u = new UI01();
		u.setup();
	}
}
