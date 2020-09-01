package classwork;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SingleTableStratStore 
{
	public static void main(String[] args) 
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(Doctor.class)
		.addAnnotatedClass(FulltimeDoctor.class)
		.addAnnotatedClass(ParttimeDoctor.class);
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		//
		Transaction tx = session.beginTransaction();
		
		FulltimeDoctor doctor1 = new FulltimeDoctor();
		doctor1.setId(1);
		doctor1.setName("Smriti");
		doctor1.setSpecialization("Jigar | Nazar");
		doctor1.setExp(7.6f);
		doctor1.setSalary(3450.0f);
		
		ParttimeDoctor doctor2 = new ParttimeDoctor();
		doctor2.setId(2);
		doctor2.setName("Vini");
		doctor2.setSpecialization("Suar ke dil");
		doctor2.setExp(2.6f);
		doctor2.setVisits(5);
		doctor2.setCostPerVisit(14);
				
		session.save(doctor1);
		session.save(doctor2);

		tx.commit();
		
		System.out.println("OK");
		//
		session.close();
		factory.close();
	}
}