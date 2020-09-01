package onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee 
{
	private int emp_id, emp_salary;
	private String emp_name, emp_desg;
	private Car emp_car; // HAS-A
	private Address emp_adrs; // HAS-A

	@Id
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_desg() {
		return emp_desg;
	}

	public void setEmp_desg(String emp_desg) {
		this.emp_desg = emp_desg;
	}

	// lets do 1 to one mapping before getter
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="emp_car_id",unique=true)
	public Car getEmp_car() {
		return emp_car;
	}

	public void setEmp_car(Car emp_car) {
		this.emp_car = emp_car;
	}

	// lets do 1 to one mapping before getter
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="emp_adrs_id",unique=true)
	public Address getEmp_adrs() {
		return emp_adrs;
	}

	public void setEmp_adrs(Address emp_adrs) {
		this.emp_adrs = emp_adrs;
	}

	public Employee() {
	}

	public Employee(int emp_id, int emp_salary, String emp_name, String emp_desg, Car emp_car, Address emp_adrs) {
		super();
		this.emp_id = emp_id;
		this.emp_salary = emp_salary;
		this.emp_name = emp_name;
		this.emp_desg = emp_desg;
		this.emp_car = emp_car;
		this.emp_adrs = emp_adrs;
	}	
}