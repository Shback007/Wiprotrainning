package day12.ecommerce;

import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class Ecommerce implements Serializable{
	private int customerId;
	private String customerName;
	private String shippingAddress;
	
	private ArrayList<String> orders = new ArrayList<>();
	private ArrayList<String> invoices = new ArrayList<>();
	
	Ecommerce(int customerId, String customerName, String shippingAddress){
		this.customerId = customerId;
		this.customerName = customerName;
		this.shippingAddress = shippingAddress;
	}
	public void placeOrder(String product, int quantity, double price) {
		double total = quantity * price;
		if(price <= 0) {
	        orders.add("Invalid Price for " + product);
	        return;
		}else {
			orders.add(
					"Product: "+product+
					"| Quantity: "+quantity+
					"| Total: "+total);
			invoices.add(
					"Invoice Generated for: " +product+
					"| Amount: "+total);
		}
	}
	
	public void showDetials() {
		System.out.println("Customer ID: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Shipping Address: " + shippingAddress);
        
        System.out.println("\nOrders:");
        

        for(String order : orders) {
            System.out.println(order);
        }
        
        System.out.println("\nInvoices:");
        
        for(String invoice : invoices) {
            System.out.println(invoice);
        }
	}
	
	
}
