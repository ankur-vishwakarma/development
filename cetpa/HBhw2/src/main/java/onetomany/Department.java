package onetomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department 
{
	private String dept_name, dept_hod, dept_hod_mobile;
	Set<Teacher> dept_teacher;
	
	@Id
	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_hod() {
		return dept_hod;
	}

	public void setDept_hod(String dept_hod) {
		this.dept_hod = dept_hod;
	}

	public String getDept_hod_mobile() {
		return dept_hod_mobile;
	}

	public void setDept_hod_mobile(String dept_hod_mobile) {
		this.dept_hod_mobile = dept_hod_mobile;
	}

	public Department() {
	}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="department_name")
	public Set<Teacher> getDept_teacher() {
		return dept_teacher;
	}

	public void setDept_teacher(Set<Teacher> dept_teacher) {
		this.dept_teacher = dept_teacher;
	}

	public Department(String dept_name, String dept_hod, String dept_hod_mobile, Set<Teacher> dept_teacher) {
		super();
		this.dept_name = dept_name;
		this.dept_hod = dept_hod;
		this.dept_hod_mobile = dept_hod_mobile;
		this.dept_teacher = dept_teacher;
	}
	
}