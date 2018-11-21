package com.trucking.truckingchooser.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String orders;
	
	public Orders() {
	}

	public Orders(String orders) {
		super();
		this.orders = orders;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinTable(name = "tructorder", 
	joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "truck_id", referencedColumnName = "id"))
	private Truck truck;
	
	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	@Override
	public String toString() {
		String result = String.format(
	            "{"+'"'+"id"+'"'+":"+'"'+"%d"+'"'+", "+'"'+"orders"+'"'+":"+'"'+"%s"+'"'+", "+'"'+"truck"+'"'+":[",
	            this.id, this.orders);
		if (truck != null) {
    		result += String.format(
            		"{"+'"'+"id"+'"'+":"+'"'+"%d"+'"'+", "+'"'+"nopol"+'"'+":"+'"'+"%s"+'"'+"}",
            		truck.getId(), truck.getNopol());
    	}
		    
	    return result+"]}";
	}
}
