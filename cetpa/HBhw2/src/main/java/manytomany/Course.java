package manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course 
{
	private String course_id, course_duration,
	course_subjects;
	private int course_fee;

	@Id
	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(String course_duration) {
		this.course_duration = course_duration;
	}

	public int getCourse_fee() {
		return course_fee;
	}

	public void setCourse_fee(int course_fee) {
		this.course_fee = course_fee;
	}

	public Course() {
	}

		public Course(String course_id, String course_duration, String course_subjects, int course_fee) {
		super();
		this.course_id = course_id;
		this.course_duration = course_duration;
		this.course_subjects = course_subjects;
		this.course_fee = course_fee;
	}

	public String getCourse_subjects() {
		return course_subjects;
	}

	public void setCourse_subjects(String course_subjects) {
		this.course_subjects = course_subjects;
	}

}