package entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}
	
	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public double tax() {
		double total = 0;
		if (getAnualIncome() < 20000 && getHealthExpenditures() > 0 ) {
			total = (getAnualIncome() * 0.15) - (getHealthExpenditures() * 0.5);
		}
		else if (getAnualIncome() < 20000) {
			total = (getAnualIncome() * 0.15);
		}
		
		else if (getAnualIncome() >= 20000 && getHealthExpenditures() > 0) {
			total = (getAnualIncome() * 0.25) - (getHealthExpenditures() * 0.5);
		}
		else if (getAnualIncome() >= 20000) {
			total = getAnualIncome() * 0.25;
		}
		return total; 
		
		//Another possibility: 
		
		/*if (getAnualIncome() < 20000.0) {
			total = getAnualIncome() * 0.15;
		}
		else {
			total = getAnualIncome() * 0.25;
		}
		total -= getHealthExpenditures() * 0.5;
		if (total < 0.0) {
			total = 0.0;
		}
		return total; */ 
		
	}

}
