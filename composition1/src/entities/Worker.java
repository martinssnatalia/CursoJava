package entities;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>(); //list because one employee can have more than one contract
	
	public Worker() {}

	//sempre que tiver uma composição "tem muitos" não colocar no construtor, apenas iniciar a lista vazia. Por isso a lista contracts não entra no construtor cheio.
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/*public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	} 
	deve ser apagado porque de forma alguma pode permitir que a lista seja trocada por outra. Esse método recebe como parametro uma lista e atribui essa nova lista a variavel contracts
	
	No lugar do metodo set, GERALMENTE são implementados os métodos add e remove. 
	*/
	
	public void addContract (HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract (HourContract contract) {
		contracts.remove(contract);
	}
	
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar date = Calendar.getInstance();
		for (HourContract c: contracts) {
			date.setTime(c.getDate());
			int contract_year = date.get(Calendar.YEAR);
			int contract_month = 1 + date.get(Calendar.MONTH); //mes com Calendar começa no 0 
			if (year == contract_year && month == contract_month) {
				sum += c.totalValue(); 
			}
		}
		return sum;
	}
}
