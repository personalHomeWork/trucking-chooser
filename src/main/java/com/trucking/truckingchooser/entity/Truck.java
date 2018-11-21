package com.trucking.truckingchooser.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="truck")
public class Truck {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	private String nopol;
	
	public Truck() {
		
	}
	public Truck(String nopol) {
	
		super();
		this.nopol = nopol;
	}
	public Truck(String nopol,Set<Orders> orders) {
		super();
		this.nopol = nopol;
		this.orders = orders;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNopol() {
		return nopol;
	}
	public void setNopol(String nopol) {
		this.nopol = nopol;
	}


	@OneToMany(mappedBy = "truck")
	private Set<Orders> orders;
	
	
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {		
		String result = String.format(
	            "{"+'"'+"id"+'"'+":"+'"'+"%d"+'"'+", "+'"'+"nopol"+'"'+":"+'"'+"%s"+'"'+", "+'"'+"orders"+'"'+":[",
	            this.id, this.nopol);
		int ordersCount = orders.size();
		int i=0;
    	if (orders != null) {
	        for(Orders ordersLoop : orders) {
	            if(i<ordersCount-1) {
	        	result += String.format(
	            		"{"+'"'+"id"+'"'+":"+'"'+"%d"+'"'+", "+'"'+"orders"+'"'+":"+'"'+"%s"+'"'+"},",
	            		ordersLoop.getId(), ordersLoop.getOrders());
	            }
	            else {
	            	result += String.format(
	                		"{"+'"'+"id"+'"'+":"+'"'+"%d"+'"'+", "+'"'+"orders"+'"'+":"+'"'+"%s"+'"'+"}",
	                		ordersLoop.getId(), ordersLoop.getOrders());
	            }
	            i++;
	        }
    	}
		    
	    return result+"]}";
	}
}
