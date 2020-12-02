package hw2;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import javax.swing.*;

public class albumimplement extends JFrame implements ActionListener{
	JLabel show,dir,fn,fs;
	JButton start,home,pre,next;
	JTextField o,t,th;
	static int count=0;
	
	public void iv() 
  {
		super.setBounds(100, 50, 850, 650);
		super.setResizable(false);
		super.setTitle("My First Image Viewer");
		
		show=new JLabel("WELCOME");
		show.setBounds(50, 50, 300, 300);
		super.add(show);
		
		Font font = new Font("roman", Font.TYPE1_FONT, 50);
		show.setFont(font);
		show.setForeground(Color.cyan);
		
		dir=new JLabel("Directory:");
		dir.setBounds(450, 100, 100, 30);
		super.add(dir);
		
		o = new JTextField();
		o.setBounds(560, 100, 200, 30);
		super.add(o);
		
		fn=new JLabel("Filename:");
		fn.setBounds(450, 140, 100, 30);
		super.add(fn);
		
		t = new JTextField();
		t.setBounds(560, 140, 200, 30);
		super.add(t);
		
		fs=new JLabel("Filesize:");
		fs.setBounds(450, 180, 100, 30);
		super.add(fs);
		
		th = new JTextField();
		th.setBounds(560, 180, 200, 30);
		super.add(th);
		
		start = new JButton("START");
		start.setBounds(560, 220, 100, 30);
		super.add(start);
		start.addActionListener(this);
				
		pre = new JButton();
		pre.setBounds(100, 400, 100, 100);
		super.add(pre);
        ImageIcon icon = new ImageIcon("C:\\Users\\Ankur\\Downloads\\b.png");
		pre.setIcon(icon);
		pre.addActionListener(this);
		
		home = new JButton();
		home.setBounds(375, 400, 100, 100);
		super.add(home);
        ImageIcon icon1 = new ImageIcon("C:\\Users\\Ankur\\Downloads\\h.png");
		home.setIcon(icon1);
		home.addActionListener(this);
		
		next = new JButton();
		next.setBounds(650, 400, 100, 100);
		super.add(next);
        ImageIcon icon2 = new ImageIcon("C:\\Users\\Ankur\\Downloads\\f.png");
		next.setIcon(icon2);
		next.addActionListener(this);	
		
		super.setLayout(null); // 3
		super.setVisible(true); // 2
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public static void main(String[] args) {
		albumimplement a=new albumimplement();
		a.iv();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String x = o.getText();
		File file = new File(x);
		File[] listOfFiles= file.listFiles();
					
		if(e.getSource()==start) {
			ImageIcon icon = new ImageIcon(x+"\\\\"+listOfFiles[0].getName());
			show.setIcon(icon);
			t.setText(listOfFiles[0].getName());
			String size=listOfFiles[0].length()+" bytes";
			th.setText(size);
			count=0;
		}
		else if(e.getSource()==home) {
			ImageIcon icon = new ImageIcon(x+"\\\\"+listOfFiles[0].getName());
			show.setIcon(icon);
			t.setText(listOfFiles[0].getName());
			String size=listOfFiles[0].length()+" bytes";
			th.setText(size);
			count=0;
		}
		else if(e.getSource()==pre) {
			if(count!=0) {
				count--;
				ImageIcon icon = new ImageIcon(x+"\\\\"+listOfFiles[count].getName());
				show.setIcon(icon);
				t.setText(listOfFiles[count].getName());
				String size=listOfFiles[count].length()+" bytes";
				th.setText(size);
			}
		}
		else if(e.getSource()==next){
			if(albumimplement.count!=(listOfFiles.length-1)) {
				count++;
				ImageIcon icon = new ImageIcon(x+"\\\\"+listOfFiles[count].getName());
				show.setIcon(icon);
				t.setText(listOfFiles[count].getName());
				String size=listOfFiles[count].length()+" bytes";
				th.setText(size);
			}
		}
	}

}
