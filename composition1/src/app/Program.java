package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name:");
		String departmentName = sc.nextLine();
		
		System.out.println("Worker Data:");
		System.out.print("Name:");
		String workerName = sc.nextLine();
		System.out.print("Level:");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary:");
		double workerBaseSalary = sc.nextDouble();
		
		//WorkerLevel é do tipo enum e o dado recebido pelo teclado é do tipo string, por isso é necessária a conversão. 
		//Departmento é uma composição de objetos e por isso deve ser instanciado um novo objeto do tipo Department com o nome do objeto digitado.
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker?");
		int contractsNum = sc.nextInt();
		
		for (int i = 1; i<= contractsNum; i++) {
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY):");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour:");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours):");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate,valuePerHour, hours);
			
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY):");
		//outra forma de extrair mes e ano a partir de uma string:
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear +": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}
	
}
