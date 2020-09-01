package onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	private String house_num;
	private String adrs_street, adrs_city;

	@Id
	public String getHouse_num() {
		return house_num;
	}

	public void setHouse_num(String house_num) {
		this.house_num = house_num;
	}

	public String getAdrs_street() {
		return adrs_street;
	}

	public void setAdrs_street(String adrs_street) {
		this.adrs_street = adrs_street;
	}

	public String getAdrs_city() {
		return adrs_city;
	}

	public void setAdrs_city(String adrs_city) {
		this.adrs_city = adrs_city;
	}

	public Address() {
	}

	public Address(String house_num, String adrs_street, String adrs_city) {
		super();
		this.house_num = house_num;
		this.adrs_street = adrs_street;
		this.adrs_city = adrs_city;
	}	
}