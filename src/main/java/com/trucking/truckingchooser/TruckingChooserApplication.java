package com.trucking.truckingchooser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.trucking")
@SpringBootApplication
public class TruckingChooserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckingChooserApplication.class, args);
	}
}
