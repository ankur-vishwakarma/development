package manytomany;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class index {
public static Session getses() {
	Configuration cfg = new Configuration();
	cfg.configure();
	cfg.addAnnotatedClass(Student.class).addAnnotatedClass
	(Course.class);
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	return session;
}
public static void enquiry() {
	Session session = getses();
	Scanner s=new Scanner(System.in);
	Scanner sc=new Scanner(System.in);
	System.out.println("OPtions:\n1.To add course\n2.tO exit");
	int i=s.nextInt();
	int fee=0,dur=0;
	while(i!=2){
		System.out.println("Enter course id");
		String id=sc.nextLine();
		Course e = session.get(Course.class, id);
		if(e == null)
		{
			System.out.println("No course with ths id");
		}
		else {
			String d=e.getCourse_duration();
			int f=e.getCourse_fee();
			int value = Integer.parseInt(d.replaceAll("[^0-9]", ""));
			dur+=value;
			fee+=f;
		}
    	System.out.println("OPtions:\n1.To further add course\n2.tO exit");
    	i=s.nextInt();
    }
	System.out.println("Total Fees for given courses is:"+fee);
	System.out.println("Minimum time for given courses is:"+dur);
	session.close();
	//factory.close();
	//System.out.println("saved");
}

public static void getcourses() {
	Session session=getses();
	Scanner s=new Scanner(System.in);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Student id");
	String id=sc.nextLine();
	Student e = session.get(Student.class, id);
	if(e == null)
	{
		System.out.println("No student with ths id");
	}
	else {
		Set<Course> st=e.getCourses();
		System.out.println("Courses taken by student with id "+id+" are:");
		for(Course c: st) {
			System.out.println(c.getCourse_id());
		}
	}
}

public static int total() {
	Session session=getses();
	String hql="from Student";
	@SuppressWarnings("unchecked")
	Query <Student> query=session.createQuery(hql);
	List<Student> ls=query.list();
	return ls.size();
}

public static void getbycourse() {
	Session session=getses();
	String hql="from Student";
	@SuppressWarnings("unchecked")
	Query <Student> query=session.createQuery(hql);
	List<Student> ls=query.list();
	Scanner s=new Scanner(System.in);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter course id");
	String id=sc.nextLine();
	   int count=0;
	   System.out.println("Students enrolled for course with id "+id+" are:");
	   for(Student k:ls) {
				Set<Course> st=k.getCourses();
				for(Course c: st) {
					if(c.getCourse_id().equalsIgnoreCase(id)) {
						System.out.println(k.getStudent_id());
						count++;
					}
				}
	   }
	   System.out.println("hence total students enrolled are:"+count);
	   session.close();
	   }

public static void addcourse() {
	Scanner sc=new Scanner(System.in);
	Scanner c=new Scanner(System.in);
	System.out.println("Enter course id");
	String id=sc.nextLine();
	System.out.println("Enter course duration");
	String n=sc.nextLine();
	System.out.println("Enter course fee");
	int d=c.nextInt();
	System.out.println("Enter course subjects");
	String sub=sc.nextLine();
	
	Course course1 = new Course(id,n,sub,d);
	
	Session session = getses();

	
		Transaction tx = session.beginTransaction();
		
		session.save(course1);
		tx.commit();
		session.close();
		System.out.println("saved");
	}

public static void addstudent() {
	Session session=getses();
	Scanner s=new Scanner(System.in);
	Scanner sc=new Scanner(System.in);
	System.out.println("WELCOME TO REGISTRATION PORTAL\nEnter name:");
	String n=sc.nextLine();
	System.out.println("Enter email:");
	String e=sc.nextLine();
	int k=101+total();
	String uid="s"+k;
	System.out.println("Your id is:"+uid+"\nPlz note ths for future reference");
	
	String hql="from Course";
	//@SuppressWarnings("unchecked")
	Query <Course> query=session.createQuery(hql);
	List<Course> ls=query.list();
	System.out.println("courses available:\n");
	for(Course c: ls) {
		System.out.println("id: "+c.getCourse_id());
		System.out.println("subjects in course: "+c.getCourse_subjects());
	}
	System.out.println("Enter id of courses u want to enroll");
	int i=2;
	HashSet<Course> set1 = new HashSet<Course>();
	do {
		System.out.println("---Options---\n1.Add course\n2.press whn u r done\nEnter ur choice");
		i=s.nextInt();
		if(i==1) {
			System.out.println("Enter valid course id plz:");
			String id=sc.nextLine();
			Course course=session.get(Course.class, id);
			set1.add(course);
			System.out.println("course added to cart\n");
		}
	}while(i!=2);
	Student student1 = new Student(uid,n,e,set1);
	Transaction tx = session.beginTransaction();
	session.save(student1);

	tx.commit();
	
	session.close();
	System.out.println("You r now registered.");
}

@SuppressWarnings("null")
public static void delete(int i) {
	Session session=getses();
	//DELETE COURSE
	if(i==1) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id of course u wanna delete:");
		String id=s.nextLine();
		Course c=session.get(Course.class, id);
        Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
		String hql="from Student";
		@SuppressWarnings("unchecked")
		Query <Student> query=session.createQuery(hql);
		List<Student> ls=query.list();
		Set<Course> st1=null;
		 for(Student k:ls) {
				Set<Course> st=k.getCourses();
				for(Course cl: st) {
					// System.out.println("jADGDLha1111");
					if(cl.getCourse_id().equals(id)) {
						System.out.println("jADGDLha");
						for(Course cll: st) {
							if(cll.getCourse_id().equalsIgnoreCase(id)) {
								int o=0;
								System.out.println(cll.getCourse_id());
							}
							else {
								st1.add(cll);
							}
						}
						for(Course cll: st) {
								System.out.println(cll.getCourse_id());
							}
					}
				}
	   }
		System.out.println("Course Deleted");
	}
	session.close();
}

	public static void main(String[] args) {
		System.out.println("####MENU####\n1.Enquiry about fees n duration\n2.Add courses\n"+
	"3.New registration\n4.Check enrolled courses of a student\n5.Check students in a course\n"+
				"6.Check total students in institute\n7.Delete Course\n\nEnter ur choice:");
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		if(i==1) enquiry();
		else if(i==2) addcourse();
		else if(i==3) addstudent();
		else if(i==4) getcourses();
		else if(i==5) getbycourse();
		else if(i==6) System.out.println("Total students in institute are: "+total());
		else if(i==7) delete(1);
		else System.out.println("Invalid option");
	}
}
