package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();
	

	public Order() {}

	public Order(Date moment, OrderStatus status, Client client) {
		
		this.moment = moment;
		this.status = status;
		this.client = client;
	}


	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	//metodo set da lista "items" removido porque não é o objetivo permitir a adição de uma nova lista e sim a adiçao e remocao de itens de uma só lista, instanciada vazia no incio.
	//metodo get da lista "items" apagado por questões e encapsulamento, proteção da lista. Dessa forma, só é possivel manipular a lista pelos metodos de adicao e remocao. 
	
	public void addItem (OrderItem item) {
		items.add(item);
	}
	
	public void removeItem (OrderItem item) {
		items.remove(item);
	}
	//Exemplo de delegação de responsabilidade, cada classe tem sua responsabilidade (a classe OrderItem é responsavel por calcular o subtotal de cada item e a classe order por pegar esses subtotais e calcular o total do pedido): 
	public double total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
	 StringBuilder sb = new StringBuilder();
	 sb.append("ORDER SUMMARY \n");
	 sb.append("Order moment: ");
	 sb.append(sdf.format(moment)+ "\n");
	 sb.append("Order status: ");
	 sb.append(status  + "\n");
	 sb.append("Client: ");
	 sb.append(client + "\n");
	 sb.append("Order items: \n");
	 for (OrderItem item : items) {
			sb.append(item.toString() + "\n");
		}
	 sb.append("Total price: $");
	 sb.append(String.format("%.2f",total()));
	 
	 
	return sb.toString();
	 
	}
	
	
	
	  
}
