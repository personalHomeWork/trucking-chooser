package com.trucking.truckingchooser.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trucking.truckingchooser.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

}
