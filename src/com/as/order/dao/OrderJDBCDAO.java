package com.as.order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.as.order.vo.Order;

@Repository
public class OrderJDBCDAO implements OrderDAOIntf {

	@Override
	public void processOrder(Order order) {

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("INSERT INTO `order` (itemcount, order_total, card, person_name, shipping_address) VALUES (?,?,?,?,?)");
		pStmt = dbConn
		.prepareStatement("INSERT INTO `order`(itemcount, order_total, card, person_name, shipping_address) "
		+ "VALUES (?,?,?,?,?)");
		pStmt.setInt(1, order.getItemCount());
		pStmt.setDouble(2, order.getOrderTotal());
		pStmt.setString(3, order.getCard());
		pStmt.setString(4, order.getPersonName());
		pStmt.setString(5, order.getShippingAddress());		
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}
	     	}catch (SQLException sqle) {
		   sqle.printStackTrace();
		   //throw sqle;
		}catch(Exception e) {
		   e.printStackTrace();
		   //throw e;
		}
	     finally {
		try {
			pStmt.close();
			dbConn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	     }
		return;
	}
	
	

	public static Connection getConnection() throws Exception{
			Connection dbConn = null;
	    try{
			String url = "jdbc:mysql://localhost:3306/test";
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection(url, "root", "root");
		}
	     catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	return dbConn;
	}
	

}
