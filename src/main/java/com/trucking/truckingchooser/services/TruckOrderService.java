package com.trucking.truckingchooser.services;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.trucking.truckingchooser.entity.Orders;
import com.trucking.truckingchooser.entity.Truck;
import com.trucking.truckingchooser.respository.OrderRepository;
import com.trucking.truckingchooser.respository.TruckRepository;

@Component
public class TruckOrderService {
	@Autowired
	private TruckRepository truckRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional
	public String listAllTruck()
	{
		 String result="";
		 long i=0;
		 int sizeOfTruck = truckRepository.findAll().size();
		 for(Truck a :truckRepository.findAll()) {
			 	if(i<sizeOfTruck-1) {
			 		result += a.toString()+",";
			 	}
			 	else {
			 		result += a.toString();
			 	}
			 	i++;
	        }
		return "["+result+"]";
	}
	
	@Transactional
	public String listAllOrder()
	{
		 String result="";
		 int sizeOfOrder = orderRepository.findAll().size();
		 long i=0;
		 for(Orders a :orderRepository.findAll()) {
			 if(i<sizeOfOrder-1) {
			 		result += a.toString()+",";
			 	}
			 	else {
			 		result += a.toString();
			 	}
			 	i++;
	        }
		return "["+result+"]";
	}
	
	@Transactional
	public Truck addTruck(Truck truck) {
		return truckRepository.save(truck);
	}
	
	@Transactional
	public Orders addOrder(Orders order) {
		return orderRepository.save(order);
	}

	@Transactional
	public String GetTruck(long id) {
		Truck truck = truckRepository.findOne(id);
		if(truck == null)
			return "Not Found";
	
		return truck.toString();
	}

	@Transactional
	public String GetOrder(long id) {
		Orders order = orderRepository.findOne(id);
		if(order == null)
			return "Not Found";
	
		return order.toString();
	}
	
	@Transactional
	public String updateTruck(long id,Truck detailTruck) {
	
		Truck truct = truckRepository.findOne(id);
		if(truct == null)
			return "Not Found";
		
		truct.setNopol(detailTruck.getNopol());
		
		Truck updatedTruck = truckRepository.save(truct);
		
		return updatedTruck.toString();
	}
	
	@Transactional
	public String updateOrder(long id,Orders detailOrder) {
		Orders order = orderRepository.findOne(id);
		if(order == null)
			return "Not Found";
		
		order.setOrders(detailOrder.getOrders());
		
		Orders updatedOrder = orderRepository.save(order);
		
		return updatedOrder.toString();
	}
	
	@Transactional
	public String pairing(long id_truck,long id_order) {
		Truck truct = truckRepository.findOne(id_truck);
		Set<Orders> courseStudent = truct.getOrders();
		
		Orders order = orderRepository.findOne(id_order);
		courseStudent.add(order);
		
		truckRepository.save(truct);
		
		Truck tructa = truckRepository.findOne(id_truck);
		
		return tructa.toString();
	}
	
	@Transactional
	public String depairing(long id_truck,long id_order) {
		
		Truck truct = truckRepository.findOne(id_truck);
		Set<Orders> courseStudent = truct.getOrders();
		
		Orders order = orderRepository.findOne(id_order);
		courseStudent.remove(order);
		
		truckRepository.save(truct);
		
		Truck tructa = truckRepository.findOne(id_truck);
		
		return tructa.toString();
	}
}
