package day12.fooddelivery;

import java.io.*;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FoodDelivery implements Serializable {

    private String restaurantName;
    private String customerName;

    private ArrayList<String> orders = new ArrayList<>();

    private ArrayList<String> deliveryLogs = new ArrayList<>();
            
    FoodDelivery(String restaurantName,String customerName){
    	this.restaurantName = restaurantName;
        this.customerName = customerName;
    }

    public void placeOrder(String item,int quantity,double price) {
        if(item == null || item.trim().isEmpty()) {
            orders.add("Invalid Item Entered");
            return;
        }
        if(quantity <= 0) {
            orders.add("Invalid Quantity for " + item);
            return;
        }
        if(price <= 0) {
            orders.add("Invalid Price for " + item);                 
            return;
        }
        double total = quantity * price;
        orders.add(
                "Item: " + item +
                " | Quantity: " + quantity +
                " | Unit Price: " + price +
                " | Total Bill: " + total);
        deliveryLogs.add(
                item + " Out For Delivery");

        deliveryLogs.add(
                item + " Delivered Successfully");
    }
    


    public void showDetails() {
        System.out.println("Restaurant Name: " + restaurantName);              
        System.out.println("Customer Name: " + customerName);               
        System.out.println("\nOrders:");
        for(String o : orders) {
            System.out.println(o);
        }
        System.out.println("\nDelivery Logs:");
        for(String d : deliveryLogs) {
            System.out.println(d);
        }
    }
}