package com.microcare.springbootmicrocare;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnection1 {
	@Autowired
	DataSource dataSource;
	
	 
    private static final String updateord ="update Orders set Status=? where order_id=?";
   private static final String deleteord ="delete from Orders where status=?";
    
   
   public int insertOrder(Order ord) {
   	
   	int result=0;
try {
	String instord="insert into Orders values((select max(Order_id)+1 from Orders),"
   		+ "customer_id,status,salesman_id,Order_date)";
   
	
	if(ord!=null) {
		instord =instord.replace("salesman_id", "'" +ord.getSalesman_id()+"'")
		.replace("status", "'"+ord.getStatus()+"'")
		.replace("customer_id","'"+ord.getCustomer_id()+"'")
	      .replace("Order_date","sysdate");
		  
		System.out.println(instord);
		
			Statement stmt =  dataSource.getConnection().createStatement();
		result =stmt.executeUpdate(instord);
			
	}
			
} catch (SQLException e) {
	e.printStackTrace();
}	
		return result;
   	
   }
   
   
   
   public int updateord(Order ord) {
   	int result=0;
try {
           
			PreparedStatement preparestmt =  dataSource.getConnection().prepareStatement(updateord);
			
			preparestmt.setString(1, ord.getStatus());
			
			
			preparestmt.setInt(3, ord.getOrder_id());
				
				 result =preparestmt.executeUpdate();
			
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
return result;
   	
   	
   	
   }
   
   
   
   
   
   
   public int deleteord(String status) {
   	int result=0;
   	try {
   				PreparedStatement preparestmt =  dataSource.getConnection().prepareStatement(deleteord);
   				preparestmt.setString(1, status);
   			    result =preparestmt.executeUpdate();
   			} catch (SQLException e) {
   				e.printStackTrace();
   			}
   	return result;
   	    	
   	
   	
   }
   
    
  	public Order getOrder(int orde_id) {
  		
  		Order ord =new Order();
  		
  		try {
              
  			Statement stmt = dataSource.getConnection().createStatement();
  		ResultSet rs1 =stmt.executeQuery("select * from Orders where Order_id="+orde_id);			
  			while(rs1.next()) {
  				ord.setOrder_id(rs1.getInt("Order_id"));
  				ord.setCustomer_id(rs1.getInt("customer_id"));
  				ord.setStatus(rs1.getString("status"));
  				ord.setSalesman_id(rs1.getInt("Salesman_id"));
  				ord.setOrder_date(rs1.getDate("Order_date").toLocalDate());
  				
  				
  			}
  		
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  return ord;
  	}
  	 
    public List<Order> getOrders(){
    	List<Order> orders = new ArrayList<Order>();
          Order ord;
		
		try {
            
			Statement stmt = dataSource.getConnection().createStatement();
		ResultSet rs1 =stmt.executeQuery("select * from Orders");			
			while(rs1.next()) {
				ord=new Order();
				ord.setOrder_id(rs1.getInt("Order_id"));
  				ord.setCustomer_id(rs1.getInt("customer_id"));
  				ord.setStatus(rs1.getString("status"));
  				ord.setSalesman_id(rs1.getInt("Salesman_id"));
  				ord.setOrder_date(rs1.getDate("Order_date").toLocalDate());
  				orders.add(ord);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
return orders;
    	
    	
    }
  	
    
   
    
    

   
    
}
