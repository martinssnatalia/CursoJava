package entities;

public class Company extends TaxPayer {
	private Integer numberOfEmployees; 
	
	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, int numberOfEmployees2) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees2;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double tax() {
		double total;
		if (numberOfEmployees > 20) {
			total = getAnualIncome() * 0.14;
		}
		else {
			total = getAnualIncome() * 0.16;
		}
		return total;
	}
	
	
	
}
