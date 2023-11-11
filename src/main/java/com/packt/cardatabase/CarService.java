package com.packt.cardatabase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.persistence.CarRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CarService {
	@Autowired
	private CarRepository crepository;
	
	public List<Car> findAll(){
		return (List<Car>) crepository.findAll();
	}
	
	//Refactoring method
	private void validation(final Car entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}
		
		if(entity.getId() == 0L) {
			log.warn("Unknow user.");
			throw new RuntimeException("Unknow user.");
		}
	}
}
