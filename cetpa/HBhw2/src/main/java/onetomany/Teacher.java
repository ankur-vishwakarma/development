package onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher 
{
	private int teacher_id;
	private String teacher_name, teacher_subject;

	@Id
	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getTeacher_subject() {
		return teacher_subject;
	}

	public void setTeacher_subject(String teacher_subject) {
		this.teacher_subject = teacher_subject;
	}

	public Teacher() {
	}

	public Teacher(int teacher_id, String teacher_name, String teacher_subject) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_name = teacher_name;
		this.teacher_subject = teacher_subject;
	}
}