package onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="car")
public class Car 
{
	private String reg_num;
	private String car_name, car_maker;

	@Id
	public String getReg_num() {
		return reg_num;
	}

	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}

	public String getCar_name() {
		return car_name;
	}

	public void setCar_name(String car_name) {
		this.car_name = car_name;
	}

	public String getCar_maker() {
		return car_maker;
	}

	public void setCar_maker(String car_maker) {
		this.car_maker = car_maker;
	}

	public Car(String reg_num, String car_name, String car_maker) {
		super();
		this.reg_num = reg_num;
		this.car_name = car_name;
		this.car_maker = car_maker;
	}

	public Car() {
	}
}