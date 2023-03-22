package com.microcare.springbootmicrocare;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {

	@Autowired
	DatabaseConnection1 db1;
	
	 @GetMapping("/Order/{id}")
	 public Order getOrder(@PathVariable int id) {
	    return db1.getOrder(id);
	  }
	 
	 @GetMapping("/orders")
	 public List<Order> getOrder(){
	    return db1.getOrders();
	  }
	 
	 
	 @PostMapping("/order")
	 public int createOrders(@RequestBody Order ord) {
	 		 System.out.println(ord.toString());
	 		return db1.insertOrder(ord);
	 	 }

	 

	 @DeleteMapping("/order/{status}")
	 public int deleteord(@PathVariable String status) {
	 		 return db1.deleteord(status);
	 	 }
	 
	 @PutMapping("/order")
	 public int updateord(@RequestBody Order ord) {
	 		 System.out.println(ord.toString());
	 		return db1.updateord(ord);
	 	 }
}

