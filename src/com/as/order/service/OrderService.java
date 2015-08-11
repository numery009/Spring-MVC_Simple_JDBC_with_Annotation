package com.as.order.service;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.as.order.dao.OrderDAOIntf;
import com.as.order.vo.Order;

@Service
public class OrderService implements OrderServiceIntf {
	@Autowired
	OrderDAOIntf orderDAO=null; 
	@Override
	public void processOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.processOrder(order);
	}
	public OrderDAOIntf getOrderDAO() {
		return orderDAO;
	}
	public void setOrderDAO(OrderDAOIntf orderDAO) {
		this.orderDAO = orderDAO;
	}
}
