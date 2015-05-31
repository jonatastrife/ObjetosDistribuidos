package com.mkyong;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import orderpac.Order;
 
@ManagedBean(name="order")
@SessionScoped
public class OrderBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList<Order> orderList = 
		new ArrayList<Order>(Arrays.asList(
		
		new Order("A0001", "Intel CPU", 
				new BigDecimal("700.00"), 1),
		new Order("A0002", "Harddisk 10TB", 
				new BigDecimal("500.00"), 2),
		new Order("A0003", "Dell Laptop", 
				new BigDecimal("11600.00"), 8),
		new Order("A0004", "Samsung LCD", 
				new BigDecimal("5200.00"), 3),
		new Order("A0005", "A4Tech Mouse", 
				new BigDecimal("100.00"), 10)
	));
	 
	public ArrayList<Order> getOrderList() {
 
		return orderList;
 
	}
	
	public String saveAction() {
	    
		//get all existing value but set "editable" to false 
		for (Order order : orderList){
			order.setEditable(false);
		}
		
		//return to current page
		return null;
		
	}
	
	public String editAction(Order order) {
	    
		order.setEditable(true);
		return null;
	}
 
}