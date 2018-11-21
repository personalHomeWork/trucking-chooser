package com.trucking.truckingchooser.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trucking.truckingchooser.entity.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long>{

}
