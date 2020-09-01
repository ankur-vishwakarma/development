package onetomany;

import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class index {

	public static void update(){
		
		Scanner sc=new Scanner(System.in);
		Scanner c=new Scanner(System.in);
		System.out.println("Enter department name");
		String d=sc.nextLine();
		System.out.println("Enter teacher id");
		int id=c.nextInt();
		System.out.println("Enter teacher name");
		String n=sc.nextLine();
		System.out.println("Enter teacher subject");
		String sub=sc.nextLine();
		
		Teacher teacher1 = new Teacher(id, n, sub);
		
		
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Department.class)
		.addAnnotatedClass(Teacher.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

	
		Department e = session.get(Department.class, d);
		
		if(e == null)
		{
			System.out.println("No departmnt with ths name");
		}
		else
		{
			Set<Teacher> st=e.getDept_teacher();
			st.add(teacher1);
			
			if(d.equalsIgnoreCase("cse")) {
				e.setDept_name("CSE");
				e.setDept_hod("OM");
				e.setDept_hod_mobile("9999999999");
				e.setDept_teacher(st);
			}
			else if(d.equalsIgnoreCase("eee")) {
				e.setDept_name("EE");
				e.setDept_hod("Vini");
				e.setDept_hod_mobile("5555555555");
				e.setDept_teacher(st);
			}
			Transaction tx = session.beginTransaction();
			
			session.save(e);
			tx.commit();
		}
		session.close();
		factory.close();
		System.out.println("saved");
	}
public static void showbyid(String n) {
	
	Configuration configuration = new Configuration();
	configuration.configure();
	configuration.addAnnotatedClass(Department.class)
	.addAnnotatedClass(Teacher.class);
	
	SessionFactory factory = configuration.buildSessionFactory();
	Session session = factory.openSession();


	Department e = session.get(Department.class, n);
	
	if(e == null)
	{
		System.out.println("No departmnt with ths name");
	}
	else
	{
		System.out.println("Dept name:"+e.getDept_name());
		System.out.println("dept hod:"+e.getDept_hod());
		System.out.println("dept hod mobile no:"+e.getDept_hod_mobile());
		System.out.println();
		Set<Teacher> st=e.getDept_teacher();
		System.out.println("Teachers of ths dept");
		for(Teacher x: st) {
			System.out.println("Teacher id:"+x.getTeacher_id());
			System.out.println("teacher name:"+x.getTeacher_name());
			System.out.println("teacher subject:"+x.getTeacher_subject());
			System.out.println();
		}
	}
		

	session.close();
	factory.close();
}
	public static void main(String[] args) {
		System.out.println("MENU\n1.Show all\n2.Show by dept\n3.Update\nEnter ur choice:");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		if(i==1) {
			showbyid("CSE");
			showbyid("EE");
		}
		else if(i==2) {
			Scanner s=new Scanner(System.in);
			System.out.println("enter department");
			String k=s.nextLine();
			showbyid(k);
		}
		else if(i==3) update();		
		else System.out.println("enter valid choice");

	}

}
