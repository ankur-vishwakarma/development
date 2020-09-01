package classwork;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class fetch {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Doctor.class)
		.addAnnotatedClass(FulltimeDoctor.class)
		.addAnnotatedClass(ParttimeDoctor.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Scanner sc = new Scanner(System.in);

		System.out.println("Input id of dr: ");
		int id = sc.nextInt();
		Doctor e = session.get(Doctor.class, id);
		
		if(e == null)
		{
			System.out.println("No one with ths id");
		}
		else
		{
			//System.out.println(e.gettype_of_doctor());
			if(e.gettype_of_doctor().equals("FulltimeDoctor")) {
				FulltimeDoctor f=(FulltimeDoctor) e;
				System.out.println("Fulltime doctor with Id: "+f.getId());
				System.out.println("Name: "+f.getName());
				System.out.println("Specialization: "+f.getSpecialization());
				System.out.println("Experience: "+f.getExp());
				System.out.println("Salary: "+f.getSalary());			
			}
			else {
				ParttimeDoctor f=(ParttimeDoctor) e;
				System.out.println("Parttime doctor with Id: "+f.getId());
				System.out.println("Name: "+f.getName());
				System.out.println("Specialization: "+f.getSpecialization());
				System.out.println("Experience: "+f.getExp());
				System.out.println("Visits: "+f.getVisits());
				System.out.println("cost per Visit: "+f.getCostPerVisit());
			}
		}
		
		session.close();
		factory.close();
	}

}
