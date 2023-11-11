package com.packt.cardatabase;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.dto.CarDTO;
import com.packt.cardatabase.persistence.CarRepository;
import com.packt.cardatabase.persistence.OwnerRepository;
import com.packt.cardatabase.persistence.UserRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = 
			LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarService cservice;
	
	@Autowired
	private OwnerRepository orepository;
	
	@Autowired
	private UserRepository urpository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		// logger.info("Application started");
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Owner owner1 = new Owner("John","Johnson");
		//Owner owner2 = new Owner("Mary","Robison");
		//orepository.saveAll(Arrays.asList(owner1, owner2));
		
		//repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1));
		//repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		//repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0211", 2020, 39000, owner2));
		
		List<Car> carEntites = cservice.findAll();
		List<CarDTO> carDtos = carEntites.stream().map(CarDTO::new).collect(Collectors.toList());
		
		for(CarDTO car : carDtos) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
		
		// username:user, password:user
		//urpository.save(new User("user", "$2y$10$W8okcVgP7n4dScIBb0MMxuxtjoI0ipuat0iJp/nUawetv7RiqvUoy", "USER"));
		// username:admin, password:admin
		//urpository.save(new User("admin", "$2y$10$LzuS2O5mJ36zrp6gIHquQObWmXUY2k9.fStZpJdlOnRy8mDEaqBZi", "ADMIN"));
	}

}
