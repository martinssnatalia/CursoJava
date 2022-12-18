package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Employee> employeesList = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int numberOfEmployees = sc.nextInt();
		
		for (int i= 1; i <=numberOfEmployees; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)? ");
			char answer = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String employeeName = sc.nextLine();
			System.out.print("Hours: ");
			int employeeHours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			
			if (answer == 'y') {
				System.out.print("Additional charge: ");
				double addCharge = sc.nextDouble();	
				
				Employee outEmployee = new OutsourcedEmployee(employeeName, employeeHours, valuePerHour, addCharge);
				
				employeesList.add(outEmployee);
			}
			else {
				Employee employee = new Employee(employeeName, employeeHours, valuePerHour);
				
				employeesList.add(employee);
				
			}
		}
		
		System.out.println();
		System.out.println("PAYMENTS: \n");
		for (Employee emp : employeesList) {
			System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()));
		}
		
		
		sc.close();
	}

}
