package com.packt.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends org.springframework.data.repository.CrudRepository<Car, Long> {

	List<Car> findByBrandAndModel(String brand, String model);
	
	List<Car> findByBrandOrColor(String brand, String color);
	
	List<Car> findByBrandOrderByYear(String brand);
	
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(String brand);
	
	@Query("select c from Car c where c.brand like ?1")
	List<Car> findByBrandEndsWith(String brand);
	
	List<Car> findByColor(String color);
	
	List<Car> findByYear(int year);
	
}
