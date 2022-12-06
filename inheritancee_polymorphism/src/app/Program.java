package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static void main (String args[]) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products:");
		int prodNum = sc.nextInt();
		
		List<Product> products = new ArrayList<>();
		
		for (int i=1; i<=prodNum; i++) {
			System.out.println("Product #" +i+ " data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char answer = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			
			
			if (answer == 'i') {
				System.out.print("Price: ");
				double productPrice = sc.nextDouble();
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				
				products.add(new ImportedProduct(productName, productPrice, fee));
		}
			
			else if (answer == 'u') {
				System.out.print("Price: ");
				double productPrice = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				
				
				products.add(new UsedProduct(productName, productPrice, date));
			}
			else {
				System.out.print("Price: ");
				double productPrice = sc.nextDouble();
				products.add(new Product(productName, productPrice));
			}
			
			
	}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product p : products) {
			System.out.println(p.priceTag());
			}
		
		sc.close();
		
	
}}
