package onetoone;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import classwork.FulltimeDoctor;
import classwork.ParttimeDoctor;



public class fetch {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Employee.class)
		.addAnnotatedClass(Car.class)
		.addAnnotatedClass(Address.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Scanner sc = new Scanner(System.in);

		System.out.println("Input id of dr: ");
		int id = sc.nextInt();
		Employee e = session.get(Employee.class, id);
		
		if(e == null)
		{
			System.out.println("No one with ths id");
		}
		else
		{
			Car c= e.getEmp_car();
			Address a =e.getEmp_adrs();
			
			System.out.println("Employee with id:"+e.getEmp_id());
			System.out.println("Name:"+e.getEmp_name());
			System.out.println("Salary"+e.getEmp_salary());
			System.out.println("Designation"+e.getEmp_desg());
			System.out.println("Car registration no.:"+c.getReg_num());
			System.out.println("Car name:"+c.getCar_name());
			System.out.println("Car maker:"+c.getCar_maker());
			System.out.println("House no:"+a.getHouse_num());
			System.out.println("Street no:"+a.getAdrs_street());
			System.out.println("City:"+a.getAdrs_city());
		}
		
		session.close();
		factory.close();
	}

}
