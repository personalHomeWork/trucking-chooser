package com.trucking.truckingchooser.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trucking.truckingchooser.entity.Truck;
import com.trucking.truckingchooser.entity.Orders;
import com.trucking.truckingchooser.services.TruckOrderService;

@RestController
@RequestMapping("truckorder")
public class TruckOrderController {
	@Autowired
	TruckOrderService orderTruckService;
	
	@GetMapping("/listAllTruck")
	public String listAllTruck(ModelMap model)
	{
		return orderTruckService.listAllTruck();
	}
	
	@GetMapping("/listAllOrder")
	public String listAllOrder()
	{
		return orderTruckService.listAllOrder();
	}
	
	@PostMapping("/addTruck")
	public ResponseEntity<Object> addTruck(@Valid @RequestBody Truck truck) {
		Truck savedTruck = orderTruckService.addTruck(truck);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTruck.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PostMapping("/addOrder")
	public ResponseEntity<Object> addOrder(@Valid @RequestBody Orders order) {
		Orders savedOrder = orderTruckService.addOrder(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrder.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getTruckById/{id}")
	public String getTruckById(@PathVariable(value="id") long id){
		return orderTruckService.GetTruck(id);
	}
	
	@GetMapping("/getOrderById/{id}")
	public String getOrderById(@PathVariable(value="id") long id){
		return orderTruckService.GetOrder(id);
	}
	
	@PutMapping("/updateTruck/{id}")
	public String updateTruck(@PathVariable(value="id")long id, 
			@Valid @RequestBody Truck detailTruck){
		return orderTruckService.updateTruck(id, detailTruck);
	}

	@PutMapping("/updateOrder/{id}")
	public String updateOrder(@PathVariable(value="id")long id, 
			@Valid @RequestBody Orders detailOrder){
		return orderTruckService.updateOrder(id, detailOrder);
	}
	
	@PutMapping("/pairing/{id_truck}/{id_order}")
	public String pairing(@PathVariable(value="id_truck") long id_truck, @PathVariable(value="id_order") long id_order) {
		return orderTruckService.pairing(id_truck, id_order);
	}

	@PutMapping("/depairing/{id_truck}/{id_order}")
	public String depairing(@PathVariable(value="id_truck") long id_truck, @PathVariable(value="id_order") long id_order) {
			return orderTruckService.depairing(id_truck, id_order);
	}
}
