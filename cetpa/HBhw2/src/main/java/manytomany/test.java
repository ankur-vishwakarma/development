/*package manytomany;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class test {
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
	
	
	
	public static void getbycourse() {
		Session session=getses();
		String hql="from Student";
		Query <Student> query=session.createQuery(hql);
		List<Student> ls=query.list();
		   System.out.println("asna");
		Scanner s=new Scanner(System.in);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter course id");
		String id=sc.nextLine();
		   int count=0;
		   System.out.println("Students enrolled for course with id "+id+"are:");
		   for(Student k:ls) {
					Set<Course> st=k.getCourses();
					for(Course c: st) {
						if(c.getCourse_id().equalsIgnoreCase(id)) {
							k.getStudent_id();
							count++;
						}
					}
		   }
		   System.out.println("hence total students enrolled are:"+count);
		   session.close();
		   }
//jskgks
	
	else if(i==2) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter id of student u wanna remove:");
		String id=s.nextLine();
		Student c=session.get(Student.class, id);
        Transaction tx = session.beginTransaction();
		session.delete(c);
		tx.commit();
		System.out.println("Student removed from database");
}
*/