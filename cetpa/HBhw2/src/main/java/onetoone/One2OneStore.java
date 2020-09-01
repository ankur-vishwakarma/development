package onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class One2OneStore 
{
	public static void main(String[] args) 
	{
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Employee.class)
		.addAnnotatedClass(Address.class).
		addAnnotatedClass(Car.class);
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// create an address
		Address address = new Address
				("Lane#6", "Jamia Nagar", "New Delhi");
		
		// create a car
		Car car = new Car("Up-16-Tr-4564", "Swift", "Maruti");
		
		// create an employee
		Employee employee = new Employee
				(1001, 17750, "Ankur", "Developer", 
						car, address);
		
		// start TX
		Transaction tx = session.beginTransaction();
		
		// save the object of employee only (since cascade=all)
		// is there all the objects associated with employee
		// will be saved
		session.save(employee);
		
		// commit TX and close the resources
		tx.commit();
		session.close();
		factory.close();
		
		System.out.println("OK");
		}
}