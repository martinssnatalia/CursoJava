package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of tax payers: ");
		int payersNum = sc.nextInt();

		List<TaxPayer> taxPayers = new ArrayList<>();

		for (int i = 1; i <= payersNum; i++) {
			System.out.println("Tax payer # " + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char payerType = sc.next().charAt(0);
			sc.nextLine();
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Anual Income: ");
				Double anualIncome = sc.nextDouble();
				
				if (payerType == 'i') {
				System.out.print("Health Expenditures: ");
				Double healthExpenditures = sc.nextDouble();

				taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
			} 
				else if (payerType == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();

				taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}

		System.out.println();
		System.out.println("TAXES PAID: ");
		double sum = 0.0;
		for (TaxPayer payers : taxPayers) {
			System.out.println(payers.getName() + ": $ " + String.format("%.2f", payers.tax()));
			sum += payers.tax();
		}

		
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f",sum));
		sc.close();
	}
}
