package com.as.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.as.order.service.OrderService;
import com.as.order.vo.Order;


@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService=null; 


	@RequestMapping(value="/orderentry")
	public ModelAndView orderEntry
	(@ModelAttribute("orderForm") Order order){
		return new ModelAndView("order");	
	}
	
	@RequestMapping(value="/processorder", 
			method=RequestMethod.POST)
	public String processOrder(@ModelAttribute Order order){
		// step1
		System.out.println(order.getOrderTotal());
		// step2
		orderService.processOrder(order);
		// step3
		return "redirect:jsp/orderconfirmation.jsp";	
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}



}
