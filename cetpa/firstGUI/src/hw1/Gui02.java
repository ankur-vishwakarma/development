package hw1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui02 extends JFrame implements ActionListener
{	
	JLabel l1, l2, l3,l4;
	JButton b1, b2,b3,b4,b5,b6,b7,b8;
	JTextField tf,tf1;
	JTextField pf;
	JTextArea area;	
	JScrollPane pane;
	
	public void setGUI() 
	{
		super.setBounds(100, 100, 700, 600);
		super.setResizable(false);
		super.setTitle("Calculator");
		//
		l1 = new JLabel("Number1"); //NAME CN BE GIVEN HERE IN PARAMETERS
		l1.setBounds(140, 60, 100, 30);
		super.add(l1);
		
		tf = new JTextField();
		tf.setBounds(210, 60, 200, 25);
		super.add(tf);

		l2 = new JLabel("Number2");
		l2.setBounds(140, 100, 100, 30);
		super.add(l2);
		
		pf = new JTextField();
		pf.setBounds(210, 100, 200, 25);
		super.add(pf);

		l3 = new JLabel("Operation");
		l3.setBounds(140, 140, 100, 30);
		super.add(l3);
		
		area = new JTextArea();
		pane = new JScrollPane(area);
		pane.setBounds(210, 140, 300,25);
		super.add(pane);
		
		l4 = new JLabel("Result");
		l4.setBounds(140, 180, 100, 30);
		super.add(l4);
		
		tf1 = new JTextField();
		tf1.setBounds(210, 180, 200, 25);
		super.add(tf1);
		
		b1 = new JButton("Add");
		b1.setBounds(210,220, 100, 30);
		super.add(b1);
		b1.addActionListener(this);

		b2 = new JButton("Substract");
		b2.setBounds(320, 220, 100, 30);
		super.add(b2);
		b2.addActionListener(this);

		b3 = new JButton("Multiply");
		b3.setBounds(430, 220, 100, 30);
		super.add(b3);
		b3.addActionListener(this);

		b4 = new JButton("Divide");
		b4.setBounds(540, 220, 100, 30);
		super.add(b4);
		b4.addActionListener(this);

		b5 = new JButton("concat");
		b5.setBounds(210, 260, 100, 30);
		super.add(b5);
		b5.addActionListener(this);

		b6 = new JButton("max");
		b6.setBounds(320, 260, 100, 30);
		super.add(b6);
		b6.addActionListener(this);

		b7 = new JButton("min");
		b7.setBounds(430, 260, 100, 30);
		super.add(b7);
		b7.addActionListener(this);

		b8 = new JButton("Reset");
		b8.setBounds(540, 260, 100, 30);
		super.add(b8);
		b8.addActionListener(this);
		
		
		//
		super.setLayout(null); // 3rd last
		super.setVisible(true); // 2nd last statement
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // last
	}
	
	public static void main(String[] args) 
	{
		Gui02 obj = new Gui02();
		obj.setGUI();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == b1)
		{
			int x = Integer.parseInt(tf.getText());
			int y = Integer.parseInt(pf.getText());
			int z = x + y;
			String k=""+z;
			area.setText("THIS IS ADDITION");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b2)
		{
			int x = Integer.parseInt(tf.getText());
			int y = Integer.parseInt(pf.getText());
			int z = x - y;
			String k=""+z;
			area.setText("THIS IS SUBSTRACTION");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b3)
		{
			int x = Integer.parseInt(tf.getText());
			int y = Integer.parseInt(pf.getText());
			int z = x * y;
			String k=""+z;
			area.setText("THIS IS MULTIPLICATION");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b4)
		{
			float x = Float.parseFloat(tf.getText());
			float y = Float.parseFloat(pf.getText());
			float z = x / y;
			String k=""+z;
			area.setText("THIS IS DIVISION");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b6)
		{
			int x = Integer.parseInt(tf.getText());
			int y = Integer.parseInt(pf.getText());
			int z;
			if(x>y) z=x;
			else z=y;
			String k=""+z;
			area.setText("SEARCHING MAXIMUM");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b7)
		{
			int x = Integer.parseInt(tf.getText());
			int y = Integer.parseInt(pf.getText());
			int z=0;
			if(x<y) z=x;
			else z=y;
			String k=""+z;
			area.setText("SEARCHING MINIMUM");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b5)
		{
			String x = tf.getText();
			String y = pf.getText();
			String k=x+y;
			area.setText("THIS IS CONCATENATION");
			tf1.setText(k);
			
		}
		else if(e.getSource() == b8)
		{
			tf.setText("");
			pf.setText("");
			tf1.setText("");
			area.setText("");	
		}
	}	
}