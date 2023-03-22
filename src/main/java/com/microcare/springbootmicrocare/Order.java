package com.microcare.springbootmicrocare;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Order {

	private int order_id;
	private  int Customer_id;
	private String status;
	private int salesman_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate order_date;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", Customer_id=" + Customer_id + ", status=" + status + ", salesman_id="
				+ salesman_id + ", order_date=" + order_date + "]";
	}
	
	
}