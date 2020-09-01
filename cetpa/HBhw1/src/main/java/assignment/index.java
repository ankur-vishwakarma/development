package assignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class index {
	
public static void insert(int n,int k) {
Configuration cfg = new Configuration();
	
	cfg.configure();
	
	cfg.addAnnotatedClass(employee.class);
	
	SessionFactory fact = cfg.buildSessionFactory();
	
	Session session = fact.openSession();
	
	employee e=new employee();
	
	Scanner sc=new Scanner(System.in);
	Scanner s=new Scanner(System.in);
	
	int id,salary;
	String name,post,tech;
	float exp;
	if(n==1) {
		System.out.println("enter id:");
		id=sc.nextInt();
		System.out.println("enter name:");
		name=s.nextLine();
		System.out.println("enter designation:");
		post=s.nextLine();
		System.out.println("enter salary:");
	    salary=sc.nextInt();
		System.out.println("enter experience:");
		exp=sc.nextFloat();
		System.out.println("enter tech:");
		tech=s.nextLine();
		
		e.setId(id);
		e.setName(name);
		e.setPost(post);
		e.setSalary(salary);
		e.setExp(exp);
		e.setTech(tech);
		
		session.save(e);
	}
	else {
		id=k;
		System.out.println("enter updated name:");
		name=s.nextLine();
		System.out.println("enter updated designation:");
		post=s.nextLine();
		System.out.println("enter updated salary:");
		salary=sc.nextInt();
		System.out.println("enter updated experience:");
		exp=sc.nextFloat();
		System.out.println("enter updated tech:");
		tech=s.nextLine();
		
		e.setId(id);
		e.setName(name);
		e.setPost(post);
		e.setSalary(salary);
		e.setExp(exp);
		e.setTech(tech);
		
		session.update(e);
	}
	
	
	
	session.beginTransaction().commit();
	
	session.close();
	// close the factory
	fact.close();
}

public static void showbyid(int n) {
		Configuration cfg = new Configuration();
		
		cfg.configure();
		
		cfg.addAnnotatedClass(employee.class);
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		if(n==1) System.out.println("Input id of employee: ");
		else System.out.println("Input id of employee you want to update: ");
		
		int id = sc.nextInt();
		employee e = session.get(employee.class, id);
		
		if(e == null)
		{
			System.out.println("No one with ths id");
		}
		else
		{
			if(n==1) {
				System.out.println("Employee with Id: "+e.getId());
				System.out.println("Name: "+e.getName());
				System.out.println("Designation: "+e.getPost());
				System.out.println("Salary: "+e.getSalary());
				System.out.println("Experience: "+e.getExp());
				System.out.println("Tech: "+e.getTech());
			}
			else {

				Scanner s = new Scanner(System.in);
				System.out.println("Employee with Id: "+e.getId());
				System.out.println("Current Name("+e.getName()+")");
				System.out.println("Current Designation("+e.getPost()+")");
				System.out.println("Current Salary("+e.getSalary()+")");
				System.out.println("Current Experience("+e.getExp()+")");
				System.out.println("Current Tech("+e.getTech()+")");
				insert(2,id);
			}
		}
		
		session.close();
		factory.close();
}
public static void showall(int n) {
	String hql;
	int a=0,b=0;
	if(n==1) hql="from employee";
	else {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter lower bound");
		 a=sc.nextInt();
		System.out.println("Enter upper bound");
		b=sc.nextInt();
		hql="from employee where salary>="+a+" and salary<="+b;
		
	}
	
	Configuration cfg = new Configuration();
	
	cfg.configure();
	
	cfg.addAnnotatedClass(employee.class);
	
	SessionFactory factory = cfg.buildSessionFactory();
	
	Session session = factory.openSession();
	
    Query <employee> query=session.createQuery(hql);
    
   List<employee> ls=query.list();

   int flag=0;
   if(n==2) System.out.println("Employees with salary in between "+a+"INR and "+b+"INR are:");
   for(employee e:ls) {
	   System.out.println("Id: "+e.getId());
	   System.out.println("Name: "+e.getName());
	   System.out.println("Designation: "+e.getPost());
		System.out.println("Salary: "+e.getSalary());
		System.out.println("Experience: "+e.getExp());
		System.out.println("Tech: "+e.getTech());
	   System.out.println();
	   flag=1;
   }
   if(flag!=1) System.out.println("no one exists in ths salary range");
   session.close();
	factory.close();
}
public static void dlte() {
	showall(1);
	System.out.println("Enter the id of employee u wnt to dlte");
	Scanner sc=new Scanner(System.in);
	int i=sc.nextInt();
	Configuration cfg = new Configuration();
    cfg.configure(); 

    SessionFactory factory = cfg.buildSessionFactory();
    Session session = factory.openSession();

    //M1employee e= new employee();
    //e.setId(i);    
    // session.delete(e);

	//M2employee e = session.get(employee.class, i);
   // session.delete(e);
    
    
    //M3Query q = session.createQuery("delete employee where id = "+i);
    //q.executeUpdate();
    
	session.beginTransaction().commit();

    session.close();
    factory.close();
}

	public static void main(String[] args) {
		System.out.println("##MENU##\n"+"1.Add Employee\n"+"2.Find Employee\n"+
	    "3.Update Employee\n"+"4.Delete Employee");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter ur choice:");
		int i=sc.nextInt();
		if(i==1) insert(1,0);
		else if(i==2) {
			System.out.println("##SUBMENU##\n"+"1.Find Employee by id\n"+"2.Show all\n"
		+"3.Find Employee in salary range\n");
			System.out.println("enter ur option:");
			int l=sc.nextInt();
			if(l==1) showbyid(1);
			else if(l==2) showall(1);
			else if(l==3) showall(2);
			else System.out.println("invalid option");
		}
		else if(i==3) showbyid(2);
		else if(i==4) dlte();
		else System.out.println("invalid option");
	}

}
