package classwork;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="parttime_doc")
public class ParttimeDoctor extends Doctor {
	private int visits, costPerVisit;

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getCostPerVisit() {
		return costPerVisit;
	}

	public void setCostPerVisit(int costPerVisit) {
		this.costPerVisit = costPerVisit;
	}

}
