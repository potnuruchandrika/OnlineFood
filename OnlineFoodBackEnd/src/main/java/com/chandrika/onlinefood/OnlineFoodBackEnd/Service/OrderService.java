package com.chandrika.onlinefood.OnlineFoodBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandrika.onlinefood.OnlineFoodBackEnd.Entity.Order;
import com.chandrika.onlinefood.OnlineFoodBackEnd.Repository.OrderRepo;

@Service

public class OrderService {
	
	@Autowired
	OrderRepo orderrepo;
	
	public String placeOrder(Order order) {
	orderrepo.save(order);
	return order.getOrderId() + "Order Placed Successfull";
}
	
	public List<Order> GetOrderHistory(Integer id){
		List<Order> order = orderrepo.findByUserId(id);
		return order;
	}
	
	public List<Order> GetResOrders(Integer id){
		List<Order> order = orderrepo.findByResId(id);
		return order;
	}
}
